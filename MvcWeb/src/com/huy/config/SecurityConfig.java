package com.huy.config;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.huy.component.CustomBCryptPasswordEncoder;
import com.huy.service.UserDetailServiceImp;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan(basePackages = {"com.huy"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImp userDetailsService;

	@Autowired
	private CustomBCryptPasswordEncoder passEncoder;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 
		auth.authenticationProvider(authProvider());
		    
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		http.sessionManagement().maximumSessions(2);
		//For test purpose !
		http.authorizeRequests().antMatchers("/catagory/**").permitAll();
		http.authorizeRequests().antMatchers("/home").permitAll();
		
		//End test purpse
		http.authorizeRequests()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/img/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/cart").permitAll()
//				.antMatchers("/information").access("hasRole('ROLE_USER')")
				.antMatchers("/register").permitAll()
				.antMatchers("/doRegister").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.loginProcessingUrl("/loginCheck")
				.defaultSuccessUrl("/information")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
			.logout();
	}

	
 
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passEncoder);
		return provider;
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}

}