package com.huy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import com.huy.DAO.ProductDAO;
import com.huy.model.Product;

@Service
public class PageProductService {
	private List<Product> products;
	
	@Autowired
	ProductDAO productDAO;
	
	public void setProductList(String id) {
		List<Product> proList = productDAO.getProductByCatalogId(id);
		this.products = proList;
	}
	public void setProductSearchList(List list) {
		this.products = list;
	}
    public Page<Product> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;
 
        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }
 
        Page<Product> productPage
          = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());
 
        return productPage;
    }
}