package com.huy.model;

public class Catalog {
	private String catalog_id;
	private String cata_name;
	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}
	public String getCata_name() {
		return cata_name;
	}
	public void setCata_name(String cata_name) {
		this.cata_name = cata_name;
	}
	public Catalog(String catalog_id, String cata_name) {
		super();
		this.catalog_id = catalog_id;
		this.cata_name = cata_name;
	}
	
}
