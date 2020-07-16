package com.orgabor.sportsgearstore.beans;

import java.util.List;

import com.orgabor.sportsgearstore.products.Categories;

public class CategoriesBean {
	private Categories[] categories = Categories.values();

	public CategoriesBean() {}

	public Categories[] getCategories() {
		return categories;
	}
}
