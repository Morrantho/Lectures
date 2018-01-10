package com.tony.admindashboard.config;

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
	public BCryptPasswordEncoder bCrypt(){
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/css/**","/js/**","/register","/events/**").permitAll()
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.anyRequest().authenticated().and()
		.formLogin()
			.defaultSuccessUrl("/dashboard",true)
			.loginPage("/login")
			.permitAll().and()
		.logout()
			.permitAll();
	}

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt());
	}
}
