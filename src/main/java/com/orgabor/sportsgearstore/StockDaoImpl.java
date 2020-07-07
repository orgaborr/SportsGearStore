package com.orgabor.sportsgearstore;

import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao {
	
	private List<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
		products.add(product);
	}

	public Product getProduct(int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public List<Product> retrieveByCategory(String category) {
		List<Product> productsInCategory = new ArrayList<>();
		for(Product product : products) {
			if(product.getCategory().equals(category)) {
				productsInCategory.add(product);
			}
		}
		return productsInCategory;
	}

	public List<Product> retrieveByExpression(String expression) {
		List<Product> productsByExpression = new ArrayList<>();
		for(Product product : products) {
			if(product.getCategory().equals(expression)) {
				productsByExpression.add(product);
			}
		}
		return productsByExpression;
	}

	public void updateProduct(int id, Product updatedProduct) {
		Product product = getProduct(id);
		int productIndex = products.indexOf(product);
		products.set(productIndex, updatedProduct);	
	}

	public void deleteProduct(int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				products.remove(product);
			}
		}
	}
	
}
