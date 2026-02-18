package com.howtodoinjava.example.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.howtodoinjava.example.apigateway.customFilter.RateLimitFilter;

@Configuration

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private RateLimitFilter rateLimitFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(requests -> requests.antMatchers("/employeeDetails/**").permitAll())
        	;

        http.csrf(csrf -> csrf.disable())
            .authorizeRequests(requests -> requests.antMatchers("/employeeDetails/**").permitAll().
    		     anyRequest().authenticated())
            .authorizeRequests(requests -> requests.anyRequest().authenticated())
            .oauth2ResourceServer(server -> server.jwt());  	// oauth security
		
		http.addFilterBefore(rateLimitFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
