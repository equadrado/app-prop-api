package com.square.rbc.apppropapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author equadrado
 *
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "invalid Path Parameter") // 406
public class InvalidTextPropertySizeException extends Exception {

	public InvalidTextPropertySizeException(String type, String name) {
		super("InvalidTextPropertySizeExceptiion type=" + type + " in " + name);
	}

}
