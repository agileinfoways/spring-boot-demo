package com.claims.manage.rest.jwt.security;





import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.claims.manage.rest.jwt.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	Logger logger=Logger.getLogger(JwtGenerator.class);

    public String generate(JwtUser jwtUser) {

    	
   	 Calendar cal = Calendar.getInstance();        	 
	 cal.add(Calendar.DATE, 1);
	 Date d= cal.getTime();
	
	 logger.error(d);
        Claims claims = Jwts.claims()
        		
        		.setIssuedAt(new Date())
        		.setExpiration(d)
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)                
                .signWith(SignatureAlgorithm.HS512, "AGILE")
                .compact();
    }
}
