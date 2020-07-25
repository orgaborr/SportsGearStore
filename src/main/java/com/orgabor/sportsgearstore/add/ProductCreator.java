package com.orgabor.sportsgearstore.add;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

class ProductCreator {
	private final HttpServletRequest req;
	Map<String, Object> params = new HashMap<>();
	
	ProductCreator(HttpServletRequest req) {
		this.req = req;
	}
	
	Product buildProduct() {
		readParams();
		convertParams();
		return new Product.Builder((Integer) params.get("productId"))
				.withName((String) params.get("name"))
				.withDescription((String) params.get("description"))
				.ofCategory((Categories) params.get("category"))
				.forPrice((Double) params.get("price"))
				.withStock((Integer) params.get("inStock"))
				.build();
	}
	
	private void convertParams() {
		int productIdInt = Integer.parseInt((String) params.get("productId"));
		params.replace("productId", productIdInt);	
		Categories categoryEnum = Categories.valueOf((String) params.get("category"));
		params.replace("category", categoryEnum);	
		double priceDouble = Double.parseDouble((String) params.get("price"));
		params.replace("price", priceDouble);	
		int inStockInt = Integer.parseInt((String) params.get("inStock"));
		params.replace("inStock", inStockInt);
	}
	
	private void readParams() {
		params.put("productId", req.getParameter("productId"));
		params.put("name", req.getParameter("name"));
		params.put("description", req.getParameter("description"));
		params.put("category", req.getParameter("category"));
		params.put("price", req.getParameter("price"));
		params.put("inStock", req.getParameter("inStock"));
	}
}
