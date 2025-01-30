package org.sponsor.account.provider;

import org.sponsor.account.service.UserAccountService;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.stereotype.Component;


@Component
@Order(0)
public class TokenAuthenticationProvider extends PreAuthenticatedAuthenticationProvider {
	
	public TokenAuthenticationProvider(UserAccountService userAccountService) {
		setPreAuthenticatedUserDetailsService(userAccountService);
	}
    
}