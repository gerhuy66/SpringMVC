package com.huy.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huy.model.Contact;
import com.huy.model.Users;

@Repository
public class UserDAOImp implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public Users getUserByUserName(String id) {
		return sqlSession.selectOne("SystemMapper.selectUser", id);
	}

	@Override
	public Contact getContact(String id) {
		
		return sqlSession.selectOne("SystemMapper.selectContact",id);
	}

	@Override
	public void insertUser(Users user) {
		
		sqlSession.selectOne("SystemMapper.insertUser",user);
	}
	
	
}
