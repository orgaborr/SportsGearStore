package com.orgabor.sportsgearstore.add;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.products.Product;

class ProductCreator {
	private final HttpServletRequest req;
	
	ProductCreator(HttpServletRequest req) {
		this.req = req;
	}
	
	private Product buildProduct(HttpServletRequest req) {
		return null;
		
	}
	
	private Map<String, String>readParams(HttpServletRequest req) {
		Map<String, String> params = new HashMap<>();
		params.put("productId", req.getParameter("productId"));
		params.put("name", req.getParameter("name"));
		params.put("description", req.getParameter("description"));
		params.put("category", req.getParameter("category"));
		params.put("price", req.getParameter("price"));
		params.put("inStock", req.getParameter("inStock"));
		return params;
	}
}
