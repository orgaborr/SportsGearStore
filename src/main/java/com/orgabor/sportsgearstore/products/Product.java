package com.orgabor.sportsgearstore.products;

public class Product {
	private final int productId;
	private final String name;
	private final String description;
	private final Categories category;
	private final double price;
	private final int inStock;
	
	public Product(int id, String name, String description, Categories category, double price, int inStock) {
		this.productId = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.inStock = inStock;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Categories getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getInStock() {
		return inStock;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Product)) {
			return false;
		}
		
		return this.productId == ((Product) obj).getProductId();
	}
}

