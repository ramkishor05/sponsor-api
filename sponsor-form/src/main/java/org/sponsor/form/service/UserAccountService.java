package org.sponsor.form.service;

import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public interface UserAccountService extends AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken>  {

}
