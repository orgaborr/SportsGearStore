package com.orgabor.sportsgearstore.beans;

import com.orgabor.sportsgearstore.products.Categories;

public class CategoriesBean {
	private Categories[] categories = new Categories[Categories.values().length];

	public CategoriesBean() {
		categories = Categories.values();
	}

	public Categories[] getCategories() {
		return categories;
	}
}
