package com.DAO;

import com.model.Contact;
import com.model.User;

public interface UserDAO {
	public User getUserById(String id);
	public Contact getContact(String id);
}
