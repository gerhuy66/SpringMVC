package com.huy.DAO;

import com.huy.model.Contact;
import com.huy.model.Users;

public interface UserDAO {
	public Users getUserByUserName(String id);
	public Contact getContact(String id);
	public void insertUser(Users user);
}
