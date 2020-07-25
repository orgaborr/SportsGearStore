package com.orgabor.sportsgearstore.utils;

import com.orgabor.sportsgearstore.products.Categories;

public class ProductBuilder {
	private final int productId;
	private final String name;
	private final String description;
	private final Categories category;
	private final double price;
	private final int inStock;
	
	public ProductBuilder(int productId) {
		this.productId = productId;
	}
	
	
}
