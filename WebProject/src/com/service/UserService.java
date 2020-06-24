package com.service;

import com.model.Contact;
import com.model.User;

public interface UserService {
	public User getUserById(String id);
	public Contact getContact(String id);
}
