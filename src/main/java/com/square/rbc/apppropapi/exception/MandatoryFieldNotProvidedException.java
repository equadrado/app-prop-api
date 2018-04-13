package com.square.rbc.apppropapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author equadrado
 *
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Mandatory field not provided")
public class MandatoryFieldNotProvidedException extends Exception {

	public MandatoryFieldNotProvidedException(String type, String field) {
		super("MandatoryFieldNotProvidedException type=" + type + ", field=" + field);
	}

}
