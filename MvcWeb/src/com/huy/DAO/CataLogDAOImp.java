package com.huy.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huy.model.Catalog;

@Repository
public class CataLogDAOImp implements CatalogDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Catalog> getCatalog() {
		
		return sqlSession.selectList("SystemMapper.getCatalog");
	}

	@Override
	public Catalog getCatalogById(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("SystemMapper.getCatalogById",id);
	}


	


}
