package com.huy.model;

public class Contact {
	private String c_id;
	private String phone;
	private String address;
	private String open_time;
	private String email;
	
	
	
	
	public Contact(String c_id, String phone, String address, String open_time, String email) {
		super();
		this.c_id = c_id;
		this.phone = phone;
		this.address = address;
		this.open_time = open_time;
		this.email = email;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
