package org.sponsor.account.filters;

import static org.sponsor.account.constants.Constants.AUTHORIZATION;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sponsor.account.provider.TokenAuthentication;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(0)
public class TransactionFilter extends OncePerRequestFilter {
	
	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(TransactionFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info(getClass().getSimpleName()+":: doFilterInternal -started");
		TransactionRequest requestWrapper = new TransactionRequest(request);
		String apiToken = request.getHeader(AUTHORIZATION);
		SecurityContext context = SecurityContextHolder.getContext();
		if(context.getAuthentication()!=null && context.getAuthentication().isAuthenticated()) {
		    log.info(getClass().getSimpleName()+" :: doFilterInternal - Authorization in request");
			filterChain.doFilter(requestWrapper, response);
		    return;
		}
		if(StringUtils.isEmpty(apiToken) || apiToken.equalsIgnoreCase("null")) {
	      log.info(getClass().getSimpleName()+" :: doFilterInternal - Did not authorization in request");
	      filterChain.doFilter(requestWrapper, response);
	      return;
		}
		ApiTokenContext.getContext().setCurrentToken(apiToken);
		TokenAuthentication tokenAuthentication = new TokenAuthentication(apiToken);
		tokenAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(requestWrapper));
		SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
		filterChain.doFilter(requestWrapper, response);
		log.info(getClass().getSimpleName()+":: doFilterInternal -ended");
	}
}