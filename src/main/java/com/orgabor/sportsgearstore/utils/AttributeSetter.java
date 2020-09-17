package com.orgabor.sportsgearstore.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public class AttributeSetter {
	private StockDao stocks;

	public AttributeSetter(StockDao stocks) {
		this.stocks = stocks;
	}

	public boolean setProduct(String productIdString, HttpServletRequest req) {
		long productIdLong = Long.parseLong(productIdString);
		Product product = stocks.getProduct(productIdLong);
		if(product != null) {
			req.setAttribute("product", product);
			return true;
		}
		return false;
	}
	
	public boolean setProductList(String expression, HttpServletRequest req) {
		List<Product> products = stocks.retrieveByExpression(expression);
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
