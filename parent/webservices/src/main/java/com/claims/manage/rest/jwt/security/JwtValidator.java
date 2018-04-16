package com.claims.manage.rest.jwt.security;





import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.claims.manage.rest.jwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {


    private String secret = "AGILE";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
        	
        	 Calendar cal = Calendar.getInstance();        	 
        	 cal.add(Calendar.MINUTE, 3);
            Claims body = Jwts.parser()
                    .setSigningKey(secret)                    
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
