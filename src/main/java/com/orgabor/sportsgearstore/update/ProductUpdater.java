package com.orgabor.sportsgearstore.update;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

class ProductUpdater {
	private final HttpServletRequest req;
	private final StockDao stocks;
	private final int productId;
	private final Product oldProduct;
	private final Product newProduct;
	
	
	ProductUpdater(HttpServletRequest req, StockDao stocks) {
		this.req = req;
		this.stocks = stocks;
		int idParam = Integer.parseInt(req.getParameter("productId"));
		this.productId = idParam;
		this.oldProduct = stocks.getProduct(productId);
		this.newProduct = buildProduct();
	}
	
	private Product buildProduct() {
		String name = oldProduct.getName();
		String description = oldProduct.getDescription();
		double price = oldProduct.getPrice();
		int stock = oldProduct.getInStock();
		String categoryParam = req.getParameter("newCategory");
		Categories category = Categories.valueOf(categoryParam);
		
		if(!req.getParameter("newName").equals("")) {
			name = req.getParameter("newName");
		}
		if(!req.getParameter("newDescription").equals("")) {
			description = req.getParameter("newDescription");
		}
		if(!req.getParameter("newPrice").equals("")) {
			double convertedPrice = Double.parseDouble(req.getParameter("newPrice"));
			price = convertedPrice;
		}
		if(!req.getParameter("addStock").equals("")) {
			int addedStock = Integer.parseInt(req.getParameter("addStock"));
			stock += addedStock;
		}
		
		return new Product(productId, name, description, category, price, stock);
	}
	
	void updateProduct() {
		stocks.updateProduct(productId, newProduct);
	}
}
