package com.square.rbc.apppropapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author equadrado
 *
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "New Object Can't Be Null") // 406
public class NewObjectMustHaveIdNullException extends Exception {

	public NewObjectMustHaveIdNullException(String type) {
		super("NewObjectMustHaveIdNullException type=" + type);
	}

}
