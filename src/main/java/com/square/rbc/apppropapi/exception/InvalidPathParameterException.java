package com.square.rbc.apppropapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author equadrado
 *
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "invalid Path Parameter") // 406
public class InvalidPathParameterException extends Exception {

	public InvalidPathParameterException(String type) {
		super("InvalidPathParameterException type=" + type);
	}

}
