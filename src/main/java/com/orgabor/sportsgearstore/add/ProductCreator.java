package com.orgabor.sportsgearstore.add;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.products.ProductBuilder;
import com.orgabor.sportsgearstore.utils.ImgPathBuilder;

class ProductCreator {
	private final HttpServletRequest req;
	Map<String, Object> params = new HashMap<>();
	
	ProductCreator(HttpServletRequest req) {
		this.req = req;
	}
	
	Product buildProduct() {
		readParams();
		convertParams();
		return ProductBuilder.buildProduct(params);
	}
	
	private void convertParams() {
		long productIdInt = Long.parseLong((String) params.get("productId"));
		params.replace("productId", productIdInt);	
		Categories categoryEnum = Categories.valueOf((String) params.get("category"));
		params.replace("category", categoryEnum);	
		BigDecimal priceBigDecimal = new BigDecimal((String) params.get("price"));
		params.replace("price", priceBigDecimal);	
		int inStockInt = Integer.parseInt((String) params.get("inStock"));
		params.replace("inStock", inStockInt);
		String imgPath = ImgPathBuilder.buildImgPath(
							(Categories) categoryEnum,
							(String) params.get("img"));
		params.replace("img", imgPath);
	}
	
	private void readParams() {
		params.put("productId", req.getParameter("productId"));
		params.put("name", req.getParameter("name"));
		params.put("description", req.getParameter("description"));
		params.put("category", req.getParameter("category"));
		params.put("price", req.getParameter("price"));
		params.put("inStock", req.getParameter("inStock"));
		params.put("img", req.getParameter("img"));
	}
}
