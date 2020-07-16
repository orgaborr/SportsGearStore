package com.orgabor.sportsgearstore.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.products.StockDao;

public class AttributeSetter {
	private StockDao stocks;

	public AttributeSetter(StockDao stocks) {
		this.stocks = stocks;
	}

	public boolean setProduct(String search, HttpServletRequest req) {
		Product product = stocks.getProduct(Integer.parseInt(search));
		if(product != null) {
			req.setAttribute("product", product);
			return true;
		}
		return false;
	}
	
	public boolean setProductList(String search, HttpServletRequest req) {
		List<Product> products = stocks.retrieveByExpression(search);
		if(!products.isEmpty()) {
			req.setAttribute("products", products);
			return true;
		}
		return false;
	}
	
	public boolean setProductList(Categories category, HttpServletRequest req) {
		List<Product> products = stocks.retrieveByCategory(category);
		if(!products.isEmpty()) {
			req.setAttribute("products", products);
			return true;
		}
		return false;
	}
}
