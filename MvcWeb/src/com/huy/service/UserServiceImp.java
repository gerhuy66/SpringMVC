package com.huy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.DAO.UserDAO;
import com.huy.model.Contact;
import com.huy.model.Users;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Users getUserByUserName(String id) {
		return userDAO.getUserByUserName(id);
	}

	@Override
	public Contact getContact(String id) {
		
		return userDAO.getContact(id);
	}

	@Override
	public void insertUser(Users user) {
		userDAO.insertUser(user);
		
	}
}
