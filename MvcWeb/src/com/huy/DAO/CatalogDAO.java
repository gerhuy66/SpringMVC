package com.huy.DAO;

import java.util.List;

import com.huy.model.Catalog;

public interface CatalogDAO {
	public List<Catalog> getCatalog();
	public Catalog getCatalogById(String id);
}
