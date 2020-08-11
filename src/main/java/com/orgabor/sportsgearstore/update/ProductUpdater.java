package com.orgabor.sportsgearstore.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.products.ProductBuilder;
import com.orgabor.sportsgearstore.utils.ImgPathBuilder;

class ProductUpdater {
	private final HttpServletRequest req;
	private final StockDao stocks;
	private final long productId;
	
	ProductUpdater(HttpServletRequest req, StockDao stocks) {
		this.req = req;
		this.stocks = stocks;
		this.productId = Integer.parseInt(req.getParameter("productId"));
	}
	
	void updateProduct() {
		Map<String, Object> oldParams = new ProductCaller(stocks, productId).returnParams();
		Map<String, Object> newParams = new UpdateParamExtractor(req).returnParams();
		Product product = ProductBuilder.buildProduct(overwriteParams(oldParams, newParams));
		stocks.updateProduct(productId, product);
	}
	
	private Map<String, Object> overwriteParams(Map<String, Object> oldParams, Map<String, Object> newParams) {
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
		if(newParams.get("img") != null) {
			String newImage = ImgPathBuilder.buildImgPath(
								(Categories) newParams.get("category"),
								(String) newParams.get("img"));
			oldParams.replace("img", newImage);
		}
			
		return oldParams;
	}
}
