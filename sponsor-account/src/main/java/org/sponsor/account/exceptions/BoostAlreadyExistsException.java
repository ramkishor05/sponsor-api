package org.sponsor.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.CONFLICT)
public class BoostAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BoostAlreadyExistsException() {
		super("Boost already exists");
	}
	
	public BoostAlreadyExistsException(String msg) {
		super(msg);
	}

}
