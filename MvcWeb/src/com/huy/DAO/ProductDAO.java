package com.huy.DAO;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.huy.model.Product;

public interface ProductDAO extends PagingAndSortingRepository<Product, Long>{
	public List<Product> getProductByCatalogId(String catalogId);
	public Product getDetailProduct(String productId);
	public List<Product> getTopProduct();
	public List<Product> getOnSaleProduct();
	public List<Product> searchProByName(String product);
}
