package com.square.rbc.apppropapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author equadrado
 *
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "invalid JSON") // 406
public class InvalidJsonConfigurationFileException extends Exception {

	public InvalidJsonConfigurationFileException() {
		super("InvalidJsonConfigurationFileException");
	}

}
