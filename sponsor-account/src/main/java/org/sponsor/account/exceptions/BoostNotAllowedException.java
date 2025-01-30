package org.sponsor.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.CONFLICT)
public class BoostNotAllowedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BoostNotAllowedException() {
		super("Boost not allowed, due to insufficient balance");
	}
	
	public BoostNotAllowedException(String msg) {
		super(msg);
	}

}
