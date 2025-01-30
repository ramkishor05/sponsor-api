package org.sponsor.form.provider;

import org.sponsor.form.service.UserAccountService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.stereotype.Component;


@Component
public class TokenAuthenticationProvider extends PreAuthenticatedAuthenticationProvider {
	
	public TokenAuthenticationProvider(UserAccountService userAccountService) {
		setPreAuthenticatedUserDetailsService(userAccountService);
	}

}