package org.sponsor.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
public class InvalidParamException extends RuntimeException {

	public static final String INVALID_PARAMS = "Invalid params";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidParamException() {
		super(INVALID_PARAMS);
	}

	public InvalidParamException(String msg) {
		super(msg);
	}

}
