package com.orgabor.sportsgearstore.products;

public class Product {
	private final int id;
	private String name;
	private String description;
	private Categories category;
	private double price;
	private int inStock;
	
	public Product(int id, String name, String description, Categories category, double price, int inStock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.inStock = inStock;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
}
