package org.sponsor.resource.filters;


import static org.sponsor.resource.constants.Constants.AUTHORIZATION;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.brijframework.integration.spring.rest.context.ApiTokenContext;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
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
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { 
    	System.out.println("TransactionFilter start");
        HttpServletRequest req = (HttpServletRequest) request;
        TransactionRequest requestWrapper = new TransactionRequest(req);
        requestWrapper.putHeader("Access-Control-Allow-Origin", "*");
		requestWrapper.putHeader("Access-Control-Allow-Headers", "Content-Type");
		requestWrapper.putHeader("Accept", "*");
        String authHeader = req.getHeader(AUTHORIZATION);
		if (StringUtils.isNotEmpty(authHeader)) {
			ApiTokenContext.getContext().setCurrentToken(authHeader);
			String token = authHeader.substring(7);
			if (!ApiTokenContext.validateToken(token)) {
				throw new RuntimeException("Invalid token !!");
			}
			String username = ApiTokenContext.getUsername(token);
			String userRole = ApiTokenContext.getUserRole(token);
			requestWrapper.putHeader(AUTHORIZATION, authHeader);
			if (SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null,
						getGrantedAuthority(userRole));
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
        filterChain.doFilter(requestWrapper, response);
        System.out.println("TransactionFilter end");
    }
    

    private List<GrantedAuthority> getGrantedAuthority(String authority) {
		return Arrays.asList(new GrantedAuthority() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return authority;
			}
		});
	}
}