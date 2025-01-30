package org.sponsor.resource.provider;

import org.sponsor.resource.service.UserAccountService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.stereotype.Component;


@Component
public class TokenAuthenticationProvider extends PreAuthenticatedAuthenticationProvider {
	
	public TokenAuthenticationProvider(UserAccountService userAccountService) {
		setPreAuthenticatedUserDetailsService(userAccountService);
	}

}