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
		System.out.printf("%3s %7s  %5d원 %3dKcal\n", productType, productName, productPrice, productKcal);
		return null;
	}
	
	public void print() {
		System.out.printf("%d원\t%dKcal\n", productPrice, productKcal);
	}
	

}
