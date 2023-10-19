package com.example.kiosk.service;

public class UserVO {
	//DTO
	private String productType;
	private String productName;
	private int productPrice;
	private int productKcal;
	
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
		System.out.printf("%s\t%7s\t%d원\t%3dKcal\n", productType, productName, productPrice, productKcal);
		return null;
	}
	
	public String print() {
		System.out.printf("%7s (%d원)\t", productName, productPrice);
		return null;
	}

}
