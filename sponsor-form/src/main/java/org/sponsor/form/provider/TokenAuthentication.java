package org.sponsor.form.provider;

import java.util.Collection;
import java.util.List;

import org.sponsor.form.forgin.model.UserAccountModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;


public class TokenAuthentication extends PreAuthenticatedAuthenticationToken  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserAccountModel userDetails;
	private final String token;
	private Collection<GrantedAuthority> grantedAuthority;


	public TokenAuthentication(String token) {
		super(token, null);
		this.token = filteredToken(token);
		this.setAuthenticated(true);
	}

	public TokenAuthentication(String token, UserAccountModel userDetails) {
		super(token, null);
		this.token = filteredToken(token);
		this.userDetails = userDetails;
		this.setAuthenticated(true);
	}

	public TokenAuthentication(String token, UserAccountModel userDetails, List<GrantedAuthority> grantedAuthority) {
		super(token, null);
		this.token = filteredToken(token);
		this.userDetails = userDetails;
		this.setAuthenticated(true);
	}

	private String filteredToken(String token) {
		if(token==null) {
			return token;
		}
		return token.startsWith("\"") && token.endsWith("\"")? token.substring(1, token.length()-1): token;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return grantedAuthority;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

	@Override
	public Object getDetails() {
		return userDetails;
	}

	@Override
	public Object getPrincipal() {
		return userDetails;
	}

	@Override
	public String getName() {
		return token;
	}

	public UserAccountModel getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserAccountModel userDetails) {
		this.userDetails = userDetails;
	}

	public String getToken() {
		return token;
	}
}