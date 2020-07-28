package com.orgabor.sportsgearstore.update;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

class ProductUpdater {
	private final HttpServletRequest req;
	private final StockDao stocks;
//	private final int productId;
//	private final Product oldProduct;
//	private final Product newProduct;
//	private Map<String, Object> params;
	
	
	ProductUpdater(HttpServletRequest req, StockDao stocks) {
		this.req = req;
		this.stocks = stocks;
//		this.params = new HashMap<>();
//		int idParam = Integer.parseInt(req.getParameter("productId"));
//		this.productId = idParam;
//		this.oldProduct = stocks.getProduct(productId);
//		this.newProduct = buildProduct();
	}
	
	private void updateParams() {
		
	}
	
	private Map<String, Object> collectParams(Product product) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", product.getProductId());
		params.put("name", product.getName());
		params.put("description", product.getDescription());
		params.put("category", product.getCategory());
		params.put("price", product.getPrice());
		params.put("inStock", product.getInStock());
		return params;
	}
	
	private Product callOldProduct() {
		int id = Integer.parseInt(req.getParameter("productId"));
		return stocks.getProduct(id);
	}
	
	private Product buildProduct() {
		String name = oldProduct.getName();
		String description = oldProduct.getDescription();
		double price = oldProduct.getPrice();
		int stock = oldProduct.getInStock();
		
		String categoryParam = req.getParameter("newCategory");
		Categories category = Categories.valueOf(categoryParam);
		
		String nameParam = req.getParameter("newName");
		if(!nameParam.equals("")) {
			name = nameParam;
		}
		
		String descriptionParam = req.getParameter("newDescription");
		if(!descriptionParam.equals("")) {
			description = descriptionParam;
		}
		
		String priceParam = req.getParameter("newPrice");
		if(!priceParam.equals("")) {
			double convertedPrice = Double.parseDouble(priceParam);
			price = convertedPrice;
		}
		
		String addStockParam = req.getParameter("addStock");
		if(!addStockParam.equals("")) {
			int addedStock = Integer.parseInt(addStockParam);
			stock += addedStock;
		}
		
		return new Product.Builder(productId)
				.withName(name)
				.withDescription(description)
				.ofCategory(category)
				.forPrice(price)
				.withStock(stock)
				.build();	
	}
	
	void updateProduct() {
		stocks.updateProduct(productId, newProduct);
	}
}
