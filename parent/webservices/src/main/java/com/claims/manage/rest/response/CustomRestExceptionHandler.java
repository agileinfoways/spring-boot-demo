package com.claims.manage.rest.response;




import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.claims.manage.rest.jwt.security.CustomException;



@ControllerAdvice
public class CustomRestExceptionHandler{
	boolean isDebug=false;
	Logger logger =Logger.getLogger(CustomRestExceptionHandler.class);
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> customException(Exception ex) {
		if(isDebug) {
			logger.error(ex);
			ex.printStackTrace();
		}
	    return ApiResponse.<String>generateNegetiveResponse(HttpStatus.OK, 401, ex.getMessage());	
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> customException(CustomException ex) {
		if(isDebug) {
			logger.error(ex);
			ex.printStackTrace();
		}
	    return ApiResponse.<String>generateNegetiveResponse(HttpStatus.OK, 401, ex.getMessage());	
	}*/
}