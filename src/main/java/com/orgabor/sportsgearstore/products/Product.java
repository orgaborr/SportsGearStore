package com.orgabor.sportsgearstore.products;

public class Product {
	private final int productId;
	private final String name;
	private final String description;
	private final Categories category;
	private final double price;
	private final int inStock;
	
	public static class Builder {
		private int productId;
		private String name;
		private String description;
		private Categories category;
		private double price;
		private int inStock;
		
		public Builder(int productId) {
			this.productId = productId;
		}
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}
			
		public Builder ofCategory(Categories category) {
			this.category = category;
			return this;
		}
		
		public Builder forPrice(double price) {
			this.price = price;
			return this;
		}
		
		public Builder withStock(int inStock) {
			this.inStock = inStock;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}
	
	public Product(Builder builder) {
		this.productId = builder.productId;
		this.name = builder.name;
		this.description = builder.description;
		this.category = builder.category;
		this.price = builder.price;
		this.inStock = builder.inStock;
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

