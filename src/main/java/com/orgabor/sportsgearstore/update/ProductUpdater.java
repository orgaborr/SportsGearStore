package com.orgabor.sportsgearstore.update;

import javax.servlet.http.HttpServletRequest;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.products.Product.Builder;

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
