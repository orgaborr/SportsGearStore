package com.orgabor.sportsgearstore.update;

import java.util.HashMap;
import java.util.Map;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Product;

class ProductCaller {
	private final StockDao stocks;
	private final int productId;
	
	ProductCaller(StockDao stocks, int productId) {
		this.stocks = stocks;
		this.productId = productId;
	}
	
	Map<String, Object> returnParams() {
		Product product = stocks.getProduct(productId);
		Map<String, Object> params = new HashMap<>();
		params.put("productId", product.getProductId());
		params.put("name", product.getName());
		params.put("description", product.getDescription());
		params.put("category", product.getCategory());
		params.put("price", product.getPrice());
		params.put("inStock", product.getInStock());
		params.put("img", product.getImg());
		return params;
	}
}
