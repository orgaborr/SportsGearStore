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
		
		public Builder(String productId) {
			int productIdInt = Integer.parseInt(productId);
			this.productId = productIdInt;
		}
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}
			
		public Builder ofCategory(String category) {
			Categories categoryEnum = Categories.valueOf(category);
			this.category = categoryEnum;
			return this;
		}
		
		public Builder forPrice(String price) {
			double priceDouble = Double.parseDouble(price);
			this.price = priceDouble;
			return this;
		}
		
		public Builder withStock(String inStock) {
			int inStockInt = Integer.parseInt(inStock);
			this.inStock = inStockInt;
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

