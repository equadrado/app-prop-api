package com.square.rbc.apppropapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author equadrado
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Object Not Found") // 404
public class ObjectNotFoundException extends Exception {

	public ObjectNotFoundException(String type, String value) {
		super("ObjectNotFoundException type=" + type + " and id=" + value);
	}

}
