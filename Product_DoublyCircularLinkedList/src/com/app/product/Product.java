package com.app.product;

public class Product {
	
	int productId;
	String name;
	String type;
	double price;
	public Product(int productId, String name, String type, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
	
	

}
