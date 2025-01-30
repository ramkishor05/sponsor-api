package org.sponsor.access.provider;

import java.util.Optional;

import org.brijframework.integration.spring.rest.context.ApiSecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sponsor.access.constants.Authority;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.exceptions.UnauthorizedAccessException;
import org.sponsor.access.model.DeviceLoginRequest;
import org.sponsor.access.model.GlobalAuthDataDTO;
import org.sponsor.access.model.GlobalLoginRequest;
import org.sponsor.access.model.GlobalPasswordReset;
import org.sponsor.access.model.GlobalRegisterRequest;
import org.sponsor.access.model.UIUserAccount;
import org.sponsor.access.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class BasicAuthenticationProvider extends DaoAuthenticationProvider {
	
	private static final Logger log = LoggerFactory.getLogger(BasicAuthenticationProvider.class);

	@Autowired
	//@Qualifier(PATIENT_USER_SERVICE)
	private UserAccountService userAccountService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void doAfterPropertiesSet() {
		
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info("BasicAuthenticationProvider :: authenticate() started");
		this.setPasswordEncoder(passwordEncoder);
		this.setUserDetailsService(userAccountService);
		log.info("BasicAuthenticationProvider :: authenticate() end");
		return super.authenticate(authentication);
	}
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		super.additionalAuthenticationChecks(userDetails, authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(BasicAuthentication.class);
	}
	
	public UIUserAccount loadUserByUsername(String username, String authority) {
		return userAccountService.loadUserByUsername(username);
	}
	
	public UIUserAccount resetPassword(GlobalPasswordReset passwordReset) {
		return userAccountService.resetPassword(passwordReset);
	}
	
	public UIUserAccount saveOtp(GlobalPasswordReset passwordReset) {
		return userAccountService.saveOtp(passwordReset);
	}

	public GlobalAuthDataDTO register(GlobalRegisterRequest registerRequest) {
		if(registerRequest.getAuthority()==null) {
			registerRequest.setAuthority(Authority.USER);
		}
		return userAccountService.register(registerRequest);
	}

	public GlobalAuthDataDTO userLogin(GlobalLoginRequest authRequest) {
		return userAccountService.login(authRequest);
	}

	/**
	 * @param username
	 * @param userRole
	 * @return
	 */
	public Optional<EOUserAccount> find(GlobalLoginRequest authRequest) {
		return userAccountService.find(authRequest);
	}

	public UIUserAccount getUserDetail() {
		EOUserAccount currentAccount = (EOUserAccount) ApiSecurityContext.getContext().getCurrentAccount();
		if(currentAccount==null) {
			throw new UnauthorizedAccessException();
		}
		return userAccountService.getUserDetail(currentAccount);
	}

	public Boolean passwordUpdateByToken(DeviceLoginRequest deviceLoginRequest) {
		EOUserAccount currentAccount = (EOUserAccount) ApiSecurityContext.getContext().getCurrentAccount();
		if(currentAccount==null) {
			throw new UnauthorizedAccessException();
		}
		return userAccountService.passwordUpdateByToken(currentAccount,deviceLoginRequest);
	}
}