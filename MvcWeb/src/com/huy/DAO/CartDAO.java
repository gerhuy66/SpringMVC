package com.huy.DAO;

import java.util.List;

import com.huy.model.Cart;

public interface CartDAO {
	public void insertCart(Cart cart);
	public List<Cart> getOrderHistoryByUserName(String username);
}
