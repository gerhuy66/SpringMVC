package com.huy.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class Users {
	private String id;
	private String username;
	private String password;
	private String email;
	private String fullname;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Users(String id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Users() {
		this.id="";
		this.username = "";
		this.password = "";
		this.email = "";
		this.fullname = "";
	}
	
	public Users(String username2, String password2, List<GrantedAuthority> grantList) {
		super();
		this.username = username2;
		this.password = password2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
