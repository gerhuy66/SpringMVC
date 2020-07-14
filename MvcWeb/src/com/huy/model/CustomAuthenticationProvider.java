package com.huy.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;


public class CustomAuthenticationProvider implements AuthenticationProvider{
	UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication arg0)
			throws org.springframework.security.core.AuthenticationException {
		try {
		UserDetails user = userDetailsService.loadUserByUsername(arg0.getName());

		UsernamePasswordAuthenticationToken result = null;
		if (user.getUsername().equals(arg0.getName()) && user.getPassword().equals(arg0.getCredentials().toString())) {
			result = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
					new ArrayList<GrantedAuthority>());
		}
		return result;
		}catch(UsernameNotFoundException ex) {
			throw ex;
		}

	}
	
	public void setUserDetailService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	
}
