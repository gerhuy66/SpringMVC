package com.huy.model;

public class Product {
	String p_id;
	String p_name;
	String p_des;
	String p_img;
	String catalog_id;
	String topProduct;
	String onSale;
	String p_loc;
	String p_pri;
	String p_bigImg;
	public Product(String p_id, String p_name, String p_des, String p_img, String catalog_id) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_des = p_des;
		this.p_img = p_img;
		this.catalog_id = catalog_id;
	}
	
	public Product(String p_id, String p_name, String p_des, String p_img, String catalog_id, String topProduct,
			String onSale, String p_loc, String p_pri, String p_bigImg) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_des = p_des;
		this.p_img = p_img;
		this.catalog_id = catalog_id;
		this.topProduct = topProduct;
		this.onSale = onSale;
		this.p_loc = p_loc;
		this.p_pri = p_pri;
		this.p_bigImg = p_bigImg;
	}

	public Product(String p_id, String p_name, String p_des, String p_img, String catalog_id, String p_loc,
			String p_pri, String p_bigImg) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_des = p_des;
		this.p_img = p_img;
		this.catalog_id = catalog_id;
		this.p_loc = p_loc;
		this.p_pri = p_pri;
		this.p_bigImg = p_bigImg;
	}
	
	public Product() {
		super();
		this.p_name="";
		this.catalog_id="";
	}

	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_des() {
		return p_des;
	}
	public void setP_des(String p_des) {
		this.p_des = p_des;
	}
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public String getP_loc() {
		return p_loc;
	}
	public void setP_loc(String p_loc) {
		this.p_loc = p_loc;
	}
	public String getP_pri() {
		return p_pri;
	}
	public void setP_pri(String p_pri) {
		this.p_pri = p_pri;
	}
	public String getP_bigImg() {
		return p_bigImg;
	}
	public void setP_bigImg(String p_bigImg) {
		this.p_bigImg = p_bigImg;
	}
	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_des=" + p_des + ", p_img=" + p_img
				+ ", catalog_id=" + catalog_id + ", topProduct=" + topProduct + ", onSale=" + onSale + ", p_loc="
				+ p_loc + ", p_pri=" + p_pri + ", p_bigImg=" + p_bigImg + "]";
	}
	
}
