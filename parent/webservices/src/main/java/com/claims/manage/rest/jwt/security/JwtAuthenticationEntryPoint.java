package com.claims.manage.rest.jwt.security;





import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

    	
    	String msg = "Inlegal access user is not allow to access this link without authorization";
    	String data = "{\n" + 
		 		"    \"status\": \"OK\",\n" + 
		 		"    \"code\": 100,\n" + 
		 		"    \"message\": \""+msg+"\",\n" + 
		 		"    \"data\": []\n" + 
		 		"}";
		  try {
		   	JSONObject json = new JSONObject(data);               	
		    System.out.println(json);
		    httpServletResponse.getWriter().write(json.toString());
		   } catch (Exception ex) {
		       ex.printStackTrace();
		   }
     //   throw new CustomException();
        
    }
}
