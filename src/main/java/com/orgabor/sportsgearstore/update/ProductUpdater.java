package com.orgabor.sportsgearstore.update;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public class ProductUpdater {
	private HttpServletRequest req;
	private StockDao stocks;
	private int productId;
	private Product oldProduct;
	private Product newProduct;
	
	
	ProductUpdater(HttpServletRequest req, StockDao stocks) {
		this.req = req;
		this.stocks = stocks;
		int id = Integer.parseInt(req.getParameter("productId"));
		this.productId = id;
		this.oldProduct = stocks.getProduct(productId);
		this.newProduct = buildProduct();
	}
	
	private Product buildProduct() {
		String name = oldProduct.getName();
		String description = oldProduct.getDescription();
		Categories category = Categories.valueOf(req.getParameter("newCategory"));
		double price = oldProduct.getPrice();
		int stock = oldProduct.getInStock();
		
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
