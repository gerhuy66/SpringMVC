/**
 * 
 */
package com.huy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.DAO.CatalogDAO;
import com.huy.model.Catalog;

/**
 * @author huy
 *
 */

@Service
public class CatalogServiceImp implements CatalogService {

	@Autowired
	CatalogDAO catalogDAO;
	@Override
	public List<Catalog> getCatalog() {

		return catalogDAO.getCatalog();
	}
	@Override
	public Catalog getCatalogById(String id) {
		// TODO Auto-generated method stub
		return catalogDAO.getCatalogById(id);
	}

}
