package com.claims.manage;







import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class ClaimManagementApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ClaimManagementApplication.class, args);
	}
	
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(ClaimManagementApplication.class);
	 }
}
