package com.orgabor.sportsgearstore.update;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public class ProductUpdater {
	private HttpServletRequest req;
	private StockDao stocks;
	private int id;
	private Product oldProduct;
	private Product newProduct;
	
	
	ProductUpdater(HttpServletRequest req, StockDao stocks) {
		this.req = req;
		this.stocks = stocks;
		this.id = Integer.parseInt(req.getParameter("productId"));
		this.oldProduct = stocks.getProduct(id);
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
			price = Double.parseDouble(req.getParameter("newPrice"));
		}
		if(!req.getParameter("addStock").equals("")) {
			stock += Integer.parseInt(req.getParameter("addStock"));
		}
		
		return new Product(id, name, description, category, price, stockIncrease);
	}
	
	void updateProduct() {
		if(!oldProduct.equals(newProduct)) {
			stocks.updateProduct(id, newProduct);
		}
	}
}
