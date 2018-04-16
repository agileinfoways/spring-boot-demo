package com.claims.manage.rest.jwt.security;






import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class JwtSuccessHandler implements AuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Successfully Authentication");
        
       /* HttpServletResponseWrapper   wrapper= new ResponseWrapper(httpServletResponse, "UTF-8");
        String servletResponse = new String(wrapper.toString());
        //String xmlContent = wrapper.c;
        // A class used for errors
		 String data = "{\n" + 
		 		"    \"status\": \"OK\",\n" + 
		 		"    \"code\": 100,\n" + 
		 		"    \"message\": \""+servletResponse+"\",\n" + 
		 		"    \"data\": []\n" + 
		 		"}";
		  try {
			  
		   	JSONObject json = new JSONObject(data);               	
		    System.out.println(json);
		    httpServletResponse.getWriter().write(json.toString());
		   } catch (Exception ex) {
		       ex.printStackTrace();
		   }*/
        
    }
}
