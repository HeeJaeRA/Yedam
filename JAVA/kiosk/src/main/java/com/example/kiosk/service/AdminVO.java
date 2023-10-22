package com.example.kiosk.service;

public class AdminVO {
	// DTO	
	private int productKey;
	private String productType;
	private String productName;
	private int productPrice;
	private int productKcal;
	
	public int getProductKey() {
		return productKey;
	}
	
	public void setProductKey(int productKey) {
		this.productKey = productKey;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getProductKcal() {
		return productKcal;
	}
	
	public void setProductKcal(int productKcal) {
		this.productKcal = productKcal;
	}
	
	@Override
	public String toString() {
		System.out.printf("%d번\t%s\t%8s\t%d원\t%dKcal\n", productKey, productType, productName, productPrice, productKcal);
		return null;
	}
	

}
