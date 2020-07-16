package com.orgabor.sportsgearstore.products;

import java.util.ArrayList;
import java.util.List;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public class StockDaoImpl implements StockDao {
	
	private static List<Product> products = new ArrayList<>();
	static {
		products.add(new Product(1, "Bicycle", "A cool bike", Categories.CYCLING, 329.99, 5));
		products.add(new Product(2, "Tent", "Tent for 3", Categories.CAMPING, 99.99, 4));
		products.add(new Product(3, "Rope", "50m dynamic rope", Categories.CLIMBING, 299.99, 2));
		products.add(new Product(4, "Tent Stakes", "A set of 10 tent stakes", Categories.CAMPING, 5.99, 10));
	}

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

	public List<Product> retrieveByCategory(Categories category) {
		List<Product> productsInCategory = new ArrayList<>();
		for(Product product : products) {
			if(product.getCategory() == category) {
				productsInCategory.add(product);
			}
		}
		return productsInCategory;
	}

	public List<Product> retrieveByExpression(String expression) {
		List<Product> productsByExpression = new ArrayList<>();
		for(Product product : products) {
			if(product.getName().toLowerCase().contains(expression.toLowerCase())) {
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
