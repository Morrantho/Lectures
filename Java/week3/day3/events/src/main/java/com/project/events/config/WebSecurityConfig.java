package com.project.events.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	private UserDetailsService userDetailsService;
	
	public WebSecurityConfig(UserDetailsService userDetailsService){
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	// Creates + returns a bcrypt instance
	public BCryptPasswordEncoder bCrypt(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			// Allow anyone to visit the following routes:
			.antMatchers("/css/**","/js/**","/register","/events/**").permitAll()
			// Allow only admins to visit routes beginning with /admin
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.anyRequest().authenticated().and()
		.formLogin()
			// Default route once a user has logged in:
			.defaultSuccessUrl("/dashboard",true)
			// Actual route where a user should login:
			.loginPage("/login")
			.permitAll().and()
		.logout()
			.permitAll();
	}

	@Autowired
	// Tells original details service to use bcrypt for handling login.
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt());
	}
}
