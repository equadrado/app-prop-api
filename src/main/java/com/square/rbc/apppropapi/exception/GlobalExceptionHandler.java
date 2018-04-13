package com.square.rbc.apppropapi.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private ExceptionJsonDTO createJSONMessage(HttpServletRequest request, Exception ex) {
		logger.error(ex.getMessage());

		ExceptionJsonDTO response = new ExceptionJsonDTO();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());

		return response;
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
		return createJSONMessage(request, ex);
	}

}
