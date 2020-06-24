package com.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Contact;
import com.model.User;

@Repository
public class UserDAOImp implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public User getUserById(String id) {
		return sqlSession.selectOne("SystemMapper.selectUser", id);
	}

	@Override
	public Contact getContact(String id) {
		
		return sqlSession.selectOne("SystemMapper.selectContact",id);
	}
	
	
}
