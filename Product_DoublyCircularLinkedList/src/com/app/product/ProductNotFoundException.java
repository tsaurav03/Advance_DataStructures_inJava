package com.app.product;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String mesg) {
		super(mesg);
		
	}
      
}
