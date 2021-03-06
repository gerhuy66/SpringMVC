package com.huy.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huy.model.Cart;
@Repository
public class CartDAOImp implements CartDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void insertCart(Cart cart) {
		sqlSession.insert("SystemMapper.insertCart", cart);
	}
	@Override
	public List<Cart> getOrderHistoryByUserName(String username) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SystemMapper.getOrderHistoryByUserName",username);
	}

}
