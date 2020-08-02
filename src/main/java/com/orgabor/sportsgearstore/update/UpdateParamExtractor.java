package com.orgabor.sportsgearstore.update;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

import com.orgabor.sportsgearstore.products.Categories;

class UpdateParamExtractor {
	private final ServletRequest req;
	private Map<String, Object> params;
	
	UpdateParamExtractor(ServletRequest req) {
		this.req = req;
		params = new HashMap<>();
	}
	
	Map<String, Object> returnParams() {
		readParams();
		convertParams();
		return params;
	}
	
	private void convertParams() {
		Categories categoryEnum = Categories.valueOf((String) params.get("category"));
		params.replace("category", categoryEnum);
		
		if(params.get("price").equals("")) {
			params.replace("price", null);
		} else {
			double priceDouble = Double.parseDouble((String) params.get("price"));
			params.replace("price", priceDouble);	
		}
		if(params.get("inStock").equals("")) {
			params.replace("inStock", null);
		} else {
			int inStockInt = Integer.parseInt((String) params.get("inStock"));
			params.replace("inStock", inStockInt);
		}
	}
	
	private void readParams() { 
		params.put("name", req.getParameter("newName"));
		params.put("description", req.getParameter("newDescription"));
		params.put("category", req.getParameter("newCategory"));
		params.put("price", req.getParameter("newPrice"));
		params.put("inStock", req.getParameter("addStock"));
		params.put("img", req.getParameter("newImg"));
	}
}
