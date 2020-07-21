package com.huy.model;

public class Cart {
	private String cardId;
	private String pId;
	private String userOwn;
	public Cart() {
		super();
		this.cardId = "";
		this.pId = "";
		this.userOwn = "";
	}
	public Cart(String cardId, String pId, String userOwn) {
		super();
		this.cardId = cardId;
		this.pId = pId;
		this.userOwn = userOwn;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getUserOwn() {
		return userOwn;
	}
	public void setUserOwn(String userOwn) {
		this.userOwn = userOwn;
	}
	
}
