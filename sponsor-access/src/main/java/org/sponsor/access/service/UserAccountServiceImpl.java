package org.sponsor.access.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.brijframework.integration.spring.rest.crud.mapper.GenericMapper;
import org.brijframework.integration.spring.rest.crud.service.CrudServiceImpl;
import org.brijframework.integration.spring.rest.repository.CustomPredicate;
import org.brijframework.util.lang.StringUtil;
import org.sponsor.access.constants.Authority;
import org.sponsor.access.constants.RecordStatus;
import org.sponsor.access.constants.ServiceType;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.entities.EOUserAccountService;
import org.sponsor.access.entities.EOUserProfile;
import org.sponsor.access.entities.EOUserRole;
import org.sponsor.access.exceptions.UserNotFoundException;
import org.sponsor.access.mapper.UserDetailMapper;
import org.sponsor.access.mapper.UserProfileMapper;
import org.sponsor.access.model.DeviceLoginRequest;
import org.sponsor.access.model.GlobalAuthDataDTO;
import org.sponsor.access.model.GlobalLoginRequest;
import org.sponsor.access.model.GlobalPasswordReset;
import org.sponsor.access.model.GlobalRegisterRequest;
import org.sponsor.access.model.UIUserAccount;
import org.sponsor.access.model.UIUserProfile;
import org.sponsor.access.model.UserDetailResponse;
import org.sponsor.access.repository.UserAccountRepository;
import org.sponsor.access.repository.UserAccountServiceRepository;
import org.sponsor.access.repository.UserProfileRepository;
import org.sponsor.access.repository.UserRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

@Service
public class UserAccountServiceImpl extends CrudServiceImpl<UserDetailResponse, EOUserAccount, Long> implements UserAccountService {
	
	private static final String RECORD_STATE = "recordState";

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private UserDetailMapper userDetailMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserTokenService tokenService;
	
	@Autowired
	private UserProfileMapper userProfileMapper;

	@Autowired
	private UserAccountServiceRepository userAccountServiceRepository;

	@Override
	public JpaRepository<EOUserAccount, Long> getRepository() {
		return userAccountRepository;
	}

	@Override
	public GenericMapper<EOUserAccount, UserDetailResponse> getMapper() {
		return userDetailMapper;
	}
	
	{
		CustomPredicate<EOUserAccount> userRoleId = (type, root, criteriaQuery, criteriaBuilder, filter) -> {
			Subquery<EOUserRole> subquery = criteriaQuery.subquery(EOUserRole.class);
			Root<EOUserRole> fromUserRole = subquery.from(EOUserRole.class);
			subquery.select(fromUserRole)
					.where(criteriaBuilder.equal(fromUserRole.get("id"), Long.valueOf(filter.getColumnValue().toString())));
			Path<Object> userRolePath = root.get("userRole");
			In<Object> userRoleIn = criteriaBuilder.in(userRolePath);
			userRoleIn.value(subquery);
			return userRoleIn;
		};
		
		CustomPredicate<EOUserAccount> userRoleName = (type, root, criteriaQuery, criteriaBuilder, filter) -> {
			Subquery<EOUserRole> subquery = criteriaQuery.subquery(EOUserRole.class);
			Root<EOUserRole> fromUserRole = subquery.from(EOUserRole.class);
			subquery.select(fromUserRole)
					.where(criteriaBuilder.equal(fromUserRole.get("roleName"), filter.getColumnValue().toString()));
			Path<Object> userRolePath = root.get("userRole");
			In<Object> userRoleIn = criteriaBuilder.in(userRolePath);
			userRoleIn.value(subquery);
			return userRoleIn;
		};

		addCustomPredicate("userRoleId", userRoleId);
		addCustomPredicate("userRole.id", userRoleId);
		addCustomPredicate("userRoleName", userRoleName);
		addCustomPredicate("userRole.name", userRoleName);
	}
	
	{
		getCustomSortingMap().put("userRoleId", "userRole.roleName");
	}
	
	@Override
	public UIUserAccount loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<EOUserAccount> findUserLogin = userAccountRepository.findByUsername(username, RecordStatus.ACTIVETED.getStatusIds());
		if (!findUserLogin.isPresent()) {
			throw new UserNotFoundException();
		}
		return getUserDetail(findUserLogin.get());
	}

	@Override
	public  UIUserAccount getUserDetail(EOUserAccount eoUserAccount) {
		UIUserAccount userDetails = userDetailMapper.mapToUI(eoUserAccount);
		userDetails.setAuthorities(getGrantedAuthority(eoUserAccount.getUserRole().getRoleType()));
		return userDetails;
	}
	
	private List<GrantedAuthority> getGrantedAuthority(String authority) {
		return Arrays.asList(new GrantedAuthority() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return authority;
			}
		});
	}
	
	@Override
	public GlobalAuthDataDTO register(GlobalRegisterRequest registerRequest) {
		if(isAlreadyExists(registerRequest.getUsername()) || isAlreadyExists(registerRequest.getRegisteredPhone()) || isAlreadyExists(registerRequest.getRegisteredEmail())) {
			return tryLogin(registerRequest);
		}
		EOUserAccount eoUserAccount = doRegister(registerRequest);
		GlobalAuthDataDTO authDataDTO = new GlobalAuthDataDTO();
		authDataDTO.setUser(userDetailMapper.mapToDetailDTO(eoUserAccount));
		authDataDTO.setToken(tokenService.login(registerRequest.getUsername(), eoUserAccount.getId(), registerRequest.getAuthority().toString(), registerRequest.getServiceType().toString()));
		return authDataDTO;
	}

	@Override
	public EOUserAccount doRegister(GlobalRegisterRequest registerRequest) {
		EOUserAccount findIfExists = findIfExists(registerRequest.getUsername());
		if(findIfExists!=null) {
			return findIfExists;
		}
		EOUserRole eoUserRole = userRoleRepository.findByPosition(registerRequest.getAuthority().getPosition()).orElse(null);
		
		EOUserAccount eoUserAccount=new EOUserAccount();
		eoUserAccount.setUsername(registerRequest.getUsername());
		if(StringUtil.isNotEmpty(registerRequest.getPassword())) {
			eoUserAccount.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		}
		eoUserAccount.setRegisteredMobile(StringUtil.isEmpty(registerRequest.getRegisteredPhone()) ? null : registerRequest.getRegisteredPhone().trim());
		eoUserAccount.setRegisteredEmail(StringUtil.isEmpty(registerRequest.getRegisteredEmail()) ? null : registerRequest.getRegisteredEmail().trim());
		eoUserAccount.setAccountName(registerRequest.getAccountName());
		eoUserAccount.setUserRole(eoUserRole);
		eoUserAccount.setRecordState(RecordStatus.ACTIVETED.getStatus());
		eoUserAccount=userAccountRepository.saveAndFlush(eoUserAccount);
		
		EOUserProfile eoUserProfile=new EOUserProfile();
		eoUserProfile.setFullName(registerRequest.getAccountName());
		eoUserProfile.setUserAccount(eoUserAccount);
		eoUserProfile = userProfileRepository.saveAndFlush(eoUserProfile);
		
		this.initService(eoUserAccount);
		return eoUserAccount;
	}
	
	protected void initService(EOUserAccount eoUserAccount){
		Map<String, EOUserAccountService> userAccountServiceMap = userAccountServiceRepository.findByUserAccountId(eoUserAccount.getId()).stream().collect(Collectors.toMap(EOUserAccountService::getType, Function.identity()));
	
		for(ServiceType serviceType: ServiceType.values()) {
			EOUserAccountService eoUserAccountService = userAccountServiceMap.getOrDefault(serviceType.toString(), new EOUserAccountService(serviceType.toString(), eoUserAccount));
			userAccountServiceRepository.save(eoUserAccountService);
		}
	}
	
	@Override
	public GlobalAuthDataDTO tryLogin(GlobalRegisterRequest loginRequest) {
		if(StringUtil.isEmpty(loginRequest.getUsername())) {
			if(StringUtil.isNotEmpty(loginRequest.getRegisteredEmail())) {
				loginRequest.setUsername(loginRequest.getRegisteredEmail());
				return login(loginRequest);
			}
			if(StringUtil.isNotEmpty(loginRequest.getRegisteredPhone())) {
				loginRequest.setUsername(loginRequest.getRegisteredPhone());
				return login(loginRequest);
			}
		}
		return login(loginRequest);
	}
	
	@Override
	public GlobalAuthDataDTO login(GlobalLoginRequest loginRequest) {
		Optional<EOUserAccount> findUserLogin = userAccountRepository.findByUsername(loginRequest.getUsername(), RecordStatus.ACTIVETED.getStatusIds());
		if (!findUserLogin.isPresent()) {
			throw new UserNotFoundException();
		}
		EOUserAccount eoUserAccount = findUserLogin.get();
		GlobalAuthDataDTO authDataDTO = new GlobalAuthDataDTO();
		authDataDTO.setUser(userDetailMapper.mapToDetailDTO(eoUserAccount));
		authDataDTO.setToken(tokenService.login(loginRequest.getUsername(), eoUserAccount.getId(), eoUserAccount.getUserRole().getRoleName(), loginRequest.getServiceType().toString()));
		return authDataDTO;
	}

	@Override
	public Boolean isAlreadyExists(String username) {
		if(StringUtil.isEmpty(username)) {
			return false;
		}
		return userAccountRepository.findByUsername(username, RecordStatus.ALL.getStatusIds()).isPresent();
	}
	
	@Override
	public EOUserAccount findIfExists(String username) {
		if(StringUtil.isEmpty(username)) {
			return null;
		}
		return userAccountRepository.findByUsername(username, RecordStatus.ALL.getStatusIds()).orElse(null);
	}
	
	@Override
	public  Boolean deleteById(Long uuid) {
		Optional<EOUserAccount> userOptional = userAccountRepository.findById(uuid);
		if(userOptional.isPresent()) {
			EOUserAccount eoUserProfile = userOptional.get();
			eoUserProfile.setRecordState(RecordStatus.DACTIVETED.getStatus());
			userAccountRepository.saveAndFlush(eoUserProfile);
			return true;
		}
		return false;
	}

	@Override
	public UIUserProfile  updateUserProfile(UIUserProfile uiUserProfile) {
		EOUserProfile eoUserProfile=userProfileRepository.findById(uiUserProfile.getId()).orElse(new EOUserProfile());
		BeanUtils.copyProperties(uiUserProfile, eoUserProfile,"id");
		eoUserProfile = userProfileRepository.save(eoUserProfile);
		return uiUserProfile;
	}
	
	@Override
	public UIUserProfile updateUserProfile(EOUserAccount eoUserAccount, UIUserProfile uiUserProfile) {
		EOUserProfile eoUserProfile=userProfileRepository.findByUserAccountId(eoUserAccount.getId()).orElse(new EOUserProfile());
		BeanUtils.copyProperties(uiUserProfile, eoUserProfile,"id");
		eoUserProfile.setUserAccount(eoUserAccount);
		eoUserProfile = userProfileRepository.save(eoUserProfile);
		return userProfileMapper.mapToDTO(eoUserProfile);
	}

	@Override
	public UserDetailResponse updateUserAccount(UIUserAccount uiUserAccount) {
		EOUserAccount eoUserAccount=userAccountRepository.findById(uiUserAccount.getId()).orElse(null);
		//eoUserAccount.setUsername(uiUserAccount.getUsername());
		//eoUserAccount.setPassword(uiUserAccount.getPassword());
		eoUserAccount.setAccountName(uiUserAccount.getAccountName());
		eoUserAccount.setRegisteredMobile(uiUserAccount.getRegisteredPhone());
		eoUserAccount.setRegisteredEmail(uiUserAccount.getRegisteredEmail());
		eoUserAccount=userAccountRepository.save(eoUserAccount);
		return userDetailMapper.mapToDTO(eoUserAccount);
	}
	
	@Override
	public Boolean passwordUpdateByToken(EOUserAccount currentAccount, DeviceLoginRequest deviceLoginRequest) {
		currentAccount.setPassword(passwordEncoder.encode(deviceLoginRequest.getPassword()));
		userAccountRepository.save(currentAccount);
		return true;
	}

	@Override
	public UIUserProfile getUserProfile(Long id) {
		EOUserProfile eoUserProfile=userProfileRepository.findById(id).orElse(null);
		return userProfileMapper.mapToDTO(eoUserProfile);
	}
	
	@Override
	public UIUserProfile getUserProfile(EOUserAccount currentAccount) {
		EOUserProfile eoUserProfile=userProfileRepository.findByUserAccountId(currentAccount.getId()).orElse(new EOUserProfile());
		eoUserProfile = userProfileRepository.save(eoUserProfile);
		eoUserProfile.setUserAccount(currentAccount);
		userAccountRepository.save(currentAccount);
		return userProfileMapper.mapToDTO(eoUserProfile);
	}

	@Override
	public List<UserDetailResponse> getUsers() {
		return postFetch(userAccountRepository.findAll());
	}

	@Override
	public UIUserAccount resetPassword(GlobalPasswordReset passwordReset) {
		String username = passwordReset.getUsername();
		Optional<EOUserAccount> findUserAccount = userAccountRepository.findByUsername(username, RecordStatus.ACTIVETED.getStatusIds());
		if(!findUserAccount.isPresent()) {
			throw new UserNotFoundException(UserNotFoundException.USER_NOT_EXISTS_IN_SYSTEM +" for username :" + username);
		}
		EOUserAccount userAccount = findUserAccount.get();
		if(!passwordReset.getOtp().toString().equals(userAccount.getResetPasswordToken())) {
			System.out.println("Invalid otp");
			throw new UserNotFoundException("Invalid otp " + username);
		}
		Timestamp reset_password_sent_at = userAccount.getResetPasswordSentAt();
		
		if(reset_password_sent_at==null || reset_password_sent_at.after(new Date())) {
			throw new UserNotFoundException("Otp expired " + username);
		}
		userAccount.setPassword(passwordEncoder.encode(passwordReset.getPassword()));
		userAccount.setResetPasswordToken(null);
		userAccount.setResetPasswordSentAt(null);
		userAccountRepository.save(userAccount);
		UIUserAccount userDetails = userDetailMapper.mapToUI(userAccount);
		return userDetails;
	}

	@Override
	public UIUserAccount saveOtp(GlobalPasswordReset passwordReset) {
		Optional<EOUserAccount> findUserAccount = userAccountRepository.findByUsername(passwordReset.getUsername(), RecordStatus.ACTIVETED.getStatusIds());
		if(!findUserAccount.isPresent()) {
			throw new UserNotFoundException(UserNotFoundException.USER_NOT_EXISTS_IN_SYSTEM +" for username :" + passwordReset.getUsername());
		}
		EOUserAccount userAccount = findUserAccount.get();
		userAccount.setResetPasswordToken(passwordReset.getOtp()+"");
		userAccount.setResetPasswordSentAt(new Timestamp(System.currentTimeMillis()));
		userAccountRepository.save(userAccount);
		UIUserAccount userDetails = userDetailMapper.mapToUI(userAccount);
		return userDetails;
	}

	@Override
	public void preFetch(Map<String, List<String>> headers, Map<String, Object> filters) {
		if (filters != null && !filters.containsKey(RECORD_STATE)) {
			filters.put(RECORD_STATE, RecordStatus.ACTIVETED.getStatusIds());
		}
		
		filters.put("userRoleName", Authority.USER.getRoleName());
	}
	
	@Override
	public void postFetch(EOUserAccount findObject, UserDetailResponse dtoObject, Map<String, List<String>> headers,
			Map<String, Object> filters, Map<String, Object> actions) {
	}


	@Override
	public Optional<EOUserAccount> find(GlobalLoginRequest authRequest) {
		return userAccountRepository.findByUsername(authRequest.getUsername(), RecordStatus.ACTIVETED.getStatusIds());
	}

}
