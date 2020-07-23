package com.huy.service;

import java.util.HashMap;
import java.util.List;

import com.huy.model.Product;

public interface ProductService {
	public List<Product> getProductByCatalogId(String catalogId);
	public Product getDetailProduct(String productId);
	List<Product> findPaginated(int pageNo, int pageSize);
	public List<Product> getTopProduct();
	public List<Product> getOnSaleProduct();
	public List<Product> searchProByName(Product product);
	public Product getProductById(String proId);
}
