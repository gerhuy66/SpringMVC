package com.huy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huy.DAO.ProductDAO;
import com.huy.model.Product;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductDAO productDao;

	@Override
	public List<Product> getProductByCatalogId(String catalogId) {
		return productDao.getProductByCatalogId(catalogId);
	}

	@Override
	public Product getDetailProduct(String productId) {
		return productDao.getDetailProduct(productId);
	}

	@Override
	public List<Product> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pagedResult = productDao.findAll(paging);
		return pagedResult.toList();
	}

	@Override
	public List<Product> getTopProduct() {
		// TODO Auto-generated method stub
		return productDao.getTopProduct();
	}

	@Override
	public List<Product> getOnSaleProduct() {
		// TODO Auto-generated method stub
		return productDao.getOnSaleProduct();
	}

	@Override
	public List<Product> searchProByName(String product) {
		// TODO Auto-generated method stub
		return productDao.searchProByName(product);
	}

}
