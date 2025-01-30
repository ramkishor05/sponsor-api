package org.sponsor.access.filters;

import static org.sponsor.access.constants.Constants.AUTHORIZATION;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sponsor.access.provider.TokenAuthentication;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(0)
public class AccessTokenFilter extends OncePerRequestFilter {
	
	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(AccessTokenFilter.class);

	private AuthenticationManager authenticationManager;
	
	public AccessTokenFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager=authenticationManager;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info(getClass().getSimpleName()+":: doFilterInternal -started");
		WebRequestWrapper requestWrapper = new WebRequestWrapper(request);
		String authorization = request.getHeader(AUTHORIZATION);
		SecurityContext context = SecurityContextHolder.getContext();
		if(context.getAuthentication()!=null && context.getAuthentication().isAuthenticated()) {
		    log.info(getClass().getSimpleName()+" :: doFilterInternal - Authorization in request");
			filterChain.doFilter(requestWrapper, response);
		    return;
		}
		if(StringUtils.isEmpty(authorization) || authorization.equalsIgnoreCase("null")) {
	      log.info(getClass().getSimpleName()+" :: doFilterInternal - Did not authorization in request");
	      filterChain.doFilter(requestWrapper, response);
	      return;
		}
		TokenAuthentication tokenAuthentication = new TokenAuthentication(authorization);
		SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(tokenAuthentication));
		filterChain.doFilter(requestWrapper, response);
		log.info(getClass().getSimpleName()+":: doFilterInternal -ended");
	}


}