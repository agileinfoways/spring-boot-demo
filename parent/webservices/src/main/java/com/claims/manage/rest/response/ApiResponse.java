package com.claims.manage.rest.response;





import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.claims.manage.common.messages.ConstantMessage;


public class ApiResponse<T>{
 
    private HttpStatus status;
    private Integer code;
    private String message;
    private List<T> data;
    
   
 
    public ApiResponse(HttpStatus status, String message, List<T> sucess) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.setData(sucess);
        this.setCode(1);
    }
    
    public ApiResponse(HttpStatus status,Integer code, String message, List<T> errors,boolean fail) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.setData(errors);
        this.setCode(code);
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	
	public static <H> ResponseEntity<Object> generatePositiveResponse(List<H> save) {
		ApiResponse<H> apiError = new ApiResponse<H>(HttpStatus.OK,ConstantMessage.SUCCESS.getMessage(), save);			
		 return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	public static <H> ResponseEntity<Object> generatePositiveResponse(H save) {
		ApiResponse<H> apiError = new ApiResponse<H>(HttpStatus.OK,ConstantMessage.SUCCESS.getMessage(), Arrays.asList(save));			
		 return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	public static <H> ResponseEntity<Object> generateNegetiveResponse(HttpStatus status,ConstantMessage msg) {
		ApiResponse<H> apiError = new ApiResponse<H>(status,msg.getErrcode(),msg.getMessage().toString(),Collections.EMPTY_LIST,false);			
		 return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	public static <H> ResponseEntity<Object> generateNegetiveResponse(HttpStatus status,Integer code,H save) {
		ApiResponse<H> apiError = new ApiResponse<H>(status,code,save.toString(),Collections.EMPTY_LIST,false);			
		 return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
 
   
}