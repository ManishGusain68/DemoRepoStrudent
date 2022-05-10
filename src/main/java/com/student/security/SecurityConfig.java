package com.student.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("Manish")
		.password("{noop}infosysmanish")
		.roles("ADMIN")
		.and()
		.withUser("Nikhil")
		.password("{noop}nikhilinfosys")
		.roles("USER");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/student/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		http.csrf().disable(); //now put,post and delete is accessible
	}
	
	

}
