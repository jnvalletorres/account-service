package com.nielsen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String USER = "USER";
	private static final String ADMIN = "ADMIN";

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/svc/v1/private/accounts/*").hasRole(USER).and().formLogin();
		httpSecurity.authorizeRequests().antMatchers("/svc/v1/private/admin/**").hasRole(ADMIN).and().formLogin();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("jnvalle").password("password").roles(USER).and().withUser("vallje02")
				.password("password").roles(ADMIN, USER);
	}
}
