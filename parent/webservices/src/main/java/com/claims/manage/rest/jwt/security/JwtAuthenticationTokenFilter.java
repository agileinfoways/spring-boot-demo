package com.claims.manage.rest.jwt.security;





import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.claims.manage.rest.jwt.model.JwtAuthenticationToken;

import io.jsonwebtoken.IncorrectClaimException;
import io.swagger.models.HttpMethod;



public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/rest/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
    	if(!httpServletRequest.getMethod().equals(HttpMethod.OPTIONS.name())) {
        String header = httpServletRequest.getHeader("Authorization");
        
      try {
        if (header == null || !header.startsWith("Token")) {
        		//throw new RuntimeException("TOKEN MIssing");
        	}   

        String authenticationToken = header.substring(6);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
        }catch(IncorrectClaimException e) {
        	 createResponse(response,"JWT Token is expired please create user token");
        }
        catch (Exception e) {
			// TODO: handle exception
        	
        	 createResponse(response,"JWT Token is missing please create user token");
              // JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
             //  return getAuthenticationManager().authenticate(null);
          }
    	}else {
    		
            	response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me,Authorization");
                
            
    	}
        return null;
    }

	private void createResponse(HttpServletResponse response,String msg) {
		response.setContentType("application/json");
		 // A class used for errors
		 String data = "{\n" + 
		 		"    \"status\": \"OK\",\n" + 
		 		"    \"code\": 100,\n" + 
		 		"    \"message\": \""+msg+"\",\n" + 
		 		"    \"data\": []\n" + 
		 		"}";
		  try {
		   	JSONObject json = new JSONObject(data);               	
		    System.out.println(json);
		    response.getWriter().write(json.toString());
		   } catch (Exception ex) {
		       ex.printStackTrace();
		   }
	}


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);        
      
        try {
        	chain.doFilter(request, response);

        } catch (CustomException e) {
        	e.printStackTrace();            
         //   response.setStatus(HttpStatus.BAD_REQUEST);
        }
    }
    
    
   
   
    
}
