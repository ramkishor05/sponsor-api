package org.sponsor.access.service;

import static org.sponsor.access.constants.Constants.TOKEN_PREFIX;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.sponsor.access.constants.RecordStatus;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.entities.EOUserToken;
import org.sponsor.access.exceptions.InvalidTokenException;
import org.sponsor.access.mapper.UserDetailMapper;
import org.sponsor.access.model.UserDetailResponse;
import org.sponsor.access.repository.UserAccountRepository;
import org.sponsor.access.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl implements UserTokenService {

	@Autowired
	private UserTokenRepository userTokenRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private UserDetailMapper userDetailMapper;

	@Override
	public String generateToken(String userName, Long userId, String role, String serviceType) {
		Map<String, Object> claims = new HashMap<>();
		return ApiTokenContext.createToken(claims, userName,userId, role, serviceType);
	}

	@Override
	public String changeExpiration(String token, Date expiration) {
		return ApiTokenContext.updateExpiry(token, expiration);
	}
	
	@Override
	public String extendExpiration(String authToken) {
		String token = authToken.startsWith(TOKEN_PREFIX) ? authToken.substring(7) : authToken;
		Optional<EOUserToken> findBySource = userTokenRepository.findBySource(token);
		if (!findBySource.isPresent()) {
			return "";
		}
		EOUserToken eoToken = findBySource.get();
		eoToken.setTarget(ApiTokenContext.extendExpiry(token));
		userTokenRepository.save(eoToken);
		return eoToken.getTarget();
	}

	@Override
	public Boolean validateToken(String authToken) {
		String token = authToken.startsWith(TOKEN_PREFIX) ? authToken.substring(7) : authToken;
		Optional<EOUserToken> findBySource = userTokenRepository.findBySource(token);
		if (!findBySource.isPresent()) {
			return false;
		}
		EOUserToken eoToken = findBySource.get();
		return !ApiTokenContext.isTokenExpired(eoToken.getTarget());
	}

	@Override
	public Date buildExprireationDate() {
		return ApiTokenContext.generateExpriyDate();
	}

	@Override
	public String login(String username, Long userId, String role, String serviceType) {
		String token = generateToken(username, userId, role, serviceType);
		EOUserToken eoToken = new EOUserToken(token, token, serviceType,
				userAccountRepository.findById(userId).orElse(null));
		userTokenRepository.save(eoToken);
		return TOKEN_PREFIX + token;
	}

	@Override
	public String logout(String authToken) {
		String token = authToken.startsWith(TOKEN_PREFIX) ? authToken.substring(7) : authToken;
		Optional<EOUserToken> findBySource = userTokenRepository.findBySource(token);
		if (!findBySource.isPresent()) {
			return "Failed logout";
		}
		EOUserToken eoToken = findBySource.get();
		if(ApiTokenContext.isTokenExpired(eoToken.getTarget())) {
			return "Already logout";
		}
		String target = changeExpiration(token, new Date(System.currentTimeMillis()));
		eoToken.setTarget(target);
		userTokenRepository.save(eoToken);
		return "Sucessfully logout";
	}

	@Override
	public UserDetailResponse getUserDetailFromToken(String authToken) {
		String token = authToken.startsWith(TOKEN_PREFIX) ? authToken.substring(7) : authToken;
		Optional<EOUserToken> findBySource = userTokenRepository.findBySource(token);
		if (!findBySource.isPresent()) {
			throw new InvalidTokenException("Invalid token");
		}
		EOUserToken eoToken = findBySource.get();
		if(ApiTokenContext.isTokenExpired(eoToken.getTarget())) {
			throw new InvalidTokenException("Invalid token");
		}
		String username = this.extractUsername(token);
		Optional<EOUserAccount> findUserLogin = userAccountRepository.findByUsername(username, RecordStatus.ACTIVETED.getStatusIds());
		EOUserAccount eoUserAccount = findUserLogin.orElseThrow(() -> new RuntimeException("Not found!"));
		// userOnBoardingService.initOnBoarding(eoUserAccount);
		UserDetailResponse userDetailResponse= userDetailMapper.mapToDTO(eoUserAccount);
		
		return userDetailResponse;
	}

	@Override
	public String extractUsername(String token) {
		return ApiTokenContext.getUsername(token);
	}

	@Override
	public String extractRole(String token) {
		return ApiTokenContext.getUserRole(token);
	}
}
