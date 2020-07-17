package com.huy.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.huy.model.Product;

@Repository
public class ProductDAOImp implements ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Product> getProductByCatalogId(String catalogId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getProductByCatalogId",catalogId);
	}

	@Override
	public Product getDetailProduct(String productId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getDetailProduct",productId);
	}

	@Override
	public Iterable<Product> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> findAll(Pageable pageAble) {
		// TODO Auto-generated method stub
		

		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Product arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Product> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Product> findAllById(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findById(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Product> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getTopProduct() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SystemMapper.selectTopProduct");
	}

	@Override
	public List<Product> getOnSaleProduct() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SystemMapper.selectOnSaleProduct");
	}

	@Override
	public List<Product> searchProByName(Product product) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("SystemMapper.searchProductByName",product);
	}
}
