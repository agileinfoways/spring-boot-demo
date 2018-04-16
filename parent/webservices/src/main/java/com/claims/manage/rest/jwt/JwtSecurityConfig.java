package com.claims.manage.rest.jwt;





import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.Collections;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.claims.manage.rest.fileservice.StorageProperties;
import com.claims.manage.rest.fileservice.StorageService;
import com.claims.manage.rest.jwt.security.JwtAuthenticationEntryPoint;
import com.claims.manage.rest.jwt.security.JwtAuthenticationProvider;
import com.claims.manage.rest.jwt.security.JwtAuthenticationTokenFilter;
import com.claims.manage.rest.jwt.security.JwtSuccessHandler;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages  = {"com.claims.manage.db", "com.claims.manage.common", "com.claims.manage.business", "com.claims.manage.services"})
@EnableJpaRepositories(basePackages="com.claims.manage.db")
@EnableConfigurationProperties(StorageProperties.class)
@EnableWebSecurity
@EnableSwagger2
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {


	
    @Autowired
    private JwtAuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }
    
    @Bean
    public Mapper mapper()
    {return new DozerBeanMapper();}
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
    
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.claims.manage"))                 
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData())
                .securitySchemes(Arrays.asList(apiKey()));
                
    }
    private ApiKey apiKey() {
        return new ApiKey("authkey", "Authorization", "header");
      }
    
    private ApiInfo metaData() {
    	Contact contact = new Contact("Claim Management System ","http://agileinfoways.com/","himesh.gausvami@agileinfoways.com");    	
        ApiInfo apiInfo =new ApiInfoBuilder()
        		.title("Claim Management System ")
        		.license( "Apache License Version 2.0")
        		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        		.description("Claim Management System Rest api for users")
        		.contact(contact)
        		.build();
        		
        	
        return apiInfo;
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }
    
   


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
    	.antMatchers("/users/**").authenticated()
    	.antMatchers("/userAddresses/**").authenticated()
    	.antMatchers("/networks/**").authenticated()
    	.antMatchers("/userTagses/**").authenticated()
    	.antMatchers("/userLinkses/**").authenticated()*/
    	http.csrf()
        .disable()
        .authorizeRequests()
        			.antMatchers(HttpMethod.OPTIONS).permitAll()
        			.antMatchers(HttpMethod.POST,"**/rest/users/create").permitAll()
                	.antMatchers(HttpMethod.GET,"**/rest/**","/roles/**","/users/**","/userAddresses/**",
                			"/networks/**","/userTagses/**","/userLinkses/**").authenticated()
                	.antMatchers(HttpMethod.POST,"**/rest/**","/roles/**","/users/**","/userAddresses/**",
                			"/networks/**","/userTagses/**","/userLinkses/**").authenticated()                	
                	.antMatchers(HttpMethod.PUT,"**/rest/**","/roles/**","/users/**","/userAddresses/**",
                			"/networks/**","/userTagses/**","/userLinkses/**").authenticated()
                	.antMatchers(HttpMethod.DELETE,"**/rest/**","/roles/**","/users/**","/userAddresses/**",
                			"/networks/**","/userTagses/**","/userLinkses/**").authenticated()
                .and()                
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }
}
