package com.huy.service;

import java.util.List;

import com.huy.model.Catalog;

public interface CatalogService {
	public List<Catalog> getCatalog();
	public Catalog getCatalogById(String id);
}
