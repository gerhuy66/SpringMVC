package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.UserDAO;
import com.model.User;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User getUserById(String id) {
		userDAO.getUserById(id);
		return null;
	}
}
