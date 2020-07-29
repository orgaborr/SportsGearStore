package com.orgabor.sportsgearstore.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

class ProductUpdater {
	private final HttpServletRequest req;
	private final StockDao stocks;	
	
	ProductUpdater(HttpServletRequest req, StockDao stocks) {
		this.req = req;
		this.stocks = stocks;
	}
	
	void updateProduct() {
		Product product = buildProduct();
		int productId = product.getProductId();
		stocks.updateProduct(productId, product);
	}
	
	private Product buildProduct() {
		Map<String, Object> productParams = overwriteParams();
		
		int productId = (int) productParams.get("productId");
		String name = (String) productParams.get("name");
		String description = (String) productParams.get("description");
		Categories category = (Categories) productParams.get("category");
		double price = (double) productParams.get("price");
		int stock = (int) productParams.get("inStock");
		
		return new Product.Builder(productId)
				.withName(name)
				.withDescription(description)
				.ofCategory(category)
				.forPrice(price)
				.withStock(stock)
				.build();	
	}
	
	private Map<String, Object> overwriteParams() {
 		int id = Integer.parseInt(req.getParameter("productId"));
		Map<String, Object> oldParams = new ProductCaller(stocks, id).returnParams();
		Map<String, Object> newParams = new UpdateParamExtractor(req).returnParams();
		
		if(!newParams.get("name").equals("")) {
			oldParams.replace("name", newParams.get("name"));
		}
		if(!newParams.get("description").equals("")) {
			oldParams.replace("description", newParams.get("description"));
		}
		
		oldParams.replace("category", newParams.get("category"));
		
		if(newParams.get("price") != null) {
			oldParams.replace("price", newParams.get("price"));
		}
		if(newParams.get("inStock") != null) {
			int stock = (int) oldParams.get("inStock") + (int) newParams.get("inStock");
			oldParams.replace("inStock", stock);
		}
		
		return oldParams;
	}
}
