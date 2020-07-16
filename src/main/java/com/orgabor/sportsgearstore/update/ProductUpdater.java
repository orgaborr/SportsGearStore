package com.orgabor.sportsgearstore.update;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public class ProductUpdater {
	private HttpServletRequest req;
	private StockDao stocks;
	private int id;
	private Product newProduct;
	
	
	ProductUpdater(HttpServletRequest req, StockDao stocks) {
		this.req = req;
		this.stocks = stocks;
		this.id = Integer.parseInt(req.getParameter("product"));
		this.newProduct = buildProduct();
	}
	
	void updateProduct() {
		if(!stocks.getProduct(id).equals(newProduct)) {
			stocks.updateProduct(id, newProduct);
		}
	}

	private Product buildProduct() {
		String name = req.getParameter("newName");
		String description = req.getParameter("newDescription");
		Categories category = Categories.valueOf(req.getParameter("newCategory"));
		double price = Double.parseDouble(req.getParameter("newPrice"));
		int stockIncrease = Integer.parseInt(req.getParameter("addStock"));
		
		return new Product(id, name, description, category, price, stockIncrease);
	}
}
