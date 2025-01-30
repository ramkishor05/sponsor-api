package org.sponsor.access.service;

import java.util.List;
import java.util.Optional;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.access.entities.EOUserAccount;
import org.sponsor.access.model.DeviceLoginRequest;
import org.sponsor.access.model.GlobalAuthDataDTO;
import org.sponsor.access.model.GlobalLoginRequest;
import org.sponsor.access.model.GlobalPasswordReset;
import org.sponsor.access.model.GlobalRegisterRequest;
import org.sponsor.access.model.UIUserAccount;
import org.sponsor.access.model.UIUserProfile;
import org.sponsor.access.model.UserDetailResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserAccountService extends UserDetailsService, CrudService<UserDetailResponse, EOUserAccount, Long> {

	GlobalAuthDataDTO register(GlobalRegisterRequest registerRequest);
	
	GlobalAuthDataDTO login(GlobalLoginRequest loginRequest);
	
	Boolean isAlreadyExists(String username);

	UIUserProfile updateUserProfile(UIUserProfile uiUserProfile);
	
	UIUserProfile updateUserProfile(EOUserAccount eoUserAccount, UIUserProfile uiUserProfile);

	UserDetailResponse updateUserAccount(UIUserAccount uiUserAccount);

	UIUserProfile getUserProfile(Long id);

	List<UserDetailResponse> getUsers();

	@Override
	UIUserAccount loadUserByUsername(String username) throws UsernameNotFoundException;

	UIUserAccount resetPassword(GlobalPasswordReset passwordReset);

	UIUserAccount saveOtp(GlobalPasswordReset passwordReset);

	/**
	 * @param authRequest
	 * @return
	 */
	Optional<EOUserAccount> find(GlobalLoginRequest authRequest);

	UIUserAccount getUserDetail(EOUserAccount eoUserAccount);

	UIUserProfile getUserProfile(EOUserAccount currentAccount);

	Boolean passwordUpdateByToken(EOUserAccount currentAccount, DeviceLoginRequest deviceLoginRequest);

	GlobalAuthDataDTO tryLogin(GlobalRegisterRequest loginRequest);

	EOUserAccount doRegister(GlobalRegisterRequest registerRequest);

	EOUserAccount findIfExists(String username);

}