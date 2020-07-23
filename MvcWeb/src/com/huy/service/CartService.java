package com.huy.service;

import java.util.List;

import com.huy.model.Cart;

public interface CartService {
	public void insertCart(Cart cart);
	public List<Cart> getOrderHistoryByUserName(String username);
}
