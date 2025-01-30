package org.sponsor.account.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public interface UserAccountService extends AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken>  {

	Object fetchCurrent(Map<String, List<String>> headers);

}
