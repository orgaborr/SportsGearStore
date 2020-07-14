package com.orgabor.sportsgearstore.retrieve;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.products.StockDao;

public class AttributeSetter {
	private StockDao stocks;

	public AttributeSetter(StockDao stocks) {
		this.stocks = stocks;
	}

	boolean setProduct(String search, HttpServletRequest req) {
		Product product = stocks.getProduct(Integer.parseInt(search));
		if(product != null) {
			req.setAttribute("product", product);
			return true;
		}
		return false;
	}
	
	boolean setProductList(String search, HttpServletRequest req) {
		List<Product> products = stocks.retrieveByExpression(search);
		if(!products.isEmpty()) {
			req.setAttribute("products", products);
			return true;
		}
		return false;
	}
}
