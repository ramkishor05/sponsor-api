package org.sponsor.resource.service;

import org.sponsor.resource.forgin.model.UserAccountModel;
import org.sponsor.resource.forgin.repository.UserClient;
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
			throw new RuntimeException();
		}
		System.out.println("loadUserByUsername: "+(System.currentTimeMillis()-t));
		return findUserLogin;
	}

}
