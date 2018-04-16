package com.claims.manage.rest.jwt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claims.manage.rest.jwt.model.JwtUser;
import com.claims.manage.rest.jwt.security.JwtGenerator;
import com.claims.manage.rest.response.ApiResponse;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/token")
@Api(tags = "STEP 1 GENERATE TOKEN" )
public class TokenController {


	
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public ResponseEntity<Object>  generate(@RequestBody final JwtUser jwtUser) {

    	Integer id = (int) jwtUser.getId();
    	
    	/*if(user==null)
    	{
    		throw new CustomException("No User found with this ID");
    	}*/    	
    	String token  =  jwtGenerator.generate(jwtUser);
    	
    	
    	Token token2 = new Token();
    	token2.setToken(token);
    //	token2.setUser(user);
    	
    	return ApiResponse.<Token>generatePositiveResponse(token2);
        

    }
    class Token{
    	private String token;
    //	private UserDto user;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		/*public UserDto getUser() {
			return user;
		}

		public void setUser(UserDto user) {
			this.user = user;
		}*/
    }
}
