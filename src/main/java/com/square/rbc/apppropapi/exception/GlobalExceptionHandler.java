package com.square.rbc.apppropapi.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.square.rbc.apppropapi.dto.ExceptionJsonDTO;

/**
 * 
 * @author equadrado
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * Method to log the exception handled by this class 
	 */
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private ExceptionJsonDTO createJSONMessage(HttpServletRequest request, Exception ex, HttpStatus status) {
		logger.error(ex.getMessage());

		ExceptionJsonDTO jsonResponse = new ExceptionJsonDTO();
		jsonResponse.setUrl(request.getRequestURL().toString());
		jsonResponse.setMessage(ex.getMessage());
		jsonResponse.setStatus(status); 

		return jsonResponse;
	}
	
	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex) {
		logger.info("SQLException Occured:: URL=" + request.getRequestURL());
		
		return "database_error";
	}

	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionJsonDTO handleException(HttpServletRequest request, Exception ex) {
		return createJSONMessage(request, ex, HttpStatus.CONFLICT); // should return the status from the CustomException class
	}

}
