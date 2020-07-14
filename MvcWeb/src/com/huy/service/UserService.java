package com.huy.service;

import com.huy.model.Contact;
import com.huy.model.Users;

public interface UserService {
	public Users getUserByUserName(String id);
	public Contact getContact(String id);
	public void insertUser(Users user);
}
