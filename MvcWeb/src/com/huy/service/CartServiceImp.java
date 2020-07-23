package com.huy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.DAO.CartDAO;
import com.huy.model.Cart;


@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	CartDAO cartDAO;
	
	@Override
	public void insertCart(Cart cart) {
		cartDAO.insertCart(cart);
	}

	@Override
	public List<Cart> getOrderHistoryByUserName(String username) {
		// TODO Auto-generated method stub
		return cartDAO.getOrderHistoryByUserName(username);
	}

}
