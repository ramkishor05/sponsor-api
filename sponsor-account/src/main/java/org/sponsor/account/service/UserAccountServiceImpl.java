package org.sponsor.account.service;

import java.util.List;
import java.util.Map;

import org.sponsor.account.exceptions.UserNotFoundException;
import org.sponsor.account.forgin.model.UserAccountModel;
import org.sponsor.account.forgin.repository.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	private UserClient userClient;

	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		long t=System.currentTimeMillis();
		UserAccountModel findUserLogin = userClient.findByToken(token.getPrincipal().toString());
		if (findUserLogin==null) {
			throw new UserNotFoundException();
		}
		System.out.println("loadUserByUsername: "+(System.currentTimeMillis()-t));
		return findUserLogin;
	}

	@Override
	public Object fetchCurrent(Map<String, List<String>> headers) {
		return null;
	}

}
