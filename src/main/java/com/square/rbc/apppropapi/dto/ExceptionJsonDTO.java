package com.square.rbc.apppropapi.dto;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author equadrado
 *
 */
public class ExceptionJsonDTO {

	private String url;
	private String message;
	private HttpStatus status;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
