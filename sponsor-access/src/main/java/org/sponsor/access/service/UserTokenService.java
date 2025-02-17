package org.sponsor.access.service;

import java.util.Date;

public interface UserTokenService {

	String extractUsername(String token);

	String extractRole(String token);

	Boolean validateToken(String token);

	String generateToken(String username, Long userId,  String role, String serviceType);

	String changeExpiration(String token, Date expiration);

	Date buildExprireationDate();

	String login(String username,Long userId , String authority, String serviceType);

	String logout(String token);

	Object getUserDetailFromToken(String token);

	/**
	 * @param token
	 * @return
	 */
	String extendExpiration(String token);
	
}
