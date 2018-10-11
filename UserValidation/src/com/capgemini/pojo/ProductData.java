package com.capgemini.pojo;

public class ProductData {
	private String prodID;
	private String prodName;
	private double prodPrice;
	
	public ProductData(String prodID, String prodName, double prodPrice) {
		this.prodID = prodID;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}

	public String getProdID() {
		return prodID;
	}

	public void setProdID(String prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	
}
