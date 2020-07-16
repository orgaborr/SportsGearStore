package com.orgabor.sportsgearstore.products;

import java.util.List;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public interface StockDao {
	public void addProduct(Product product);
	public Product getProduct(int id);
	public List<Product> retrieveByCategory(Categories category);
	public List<Product> retrieveByExpression(String expression);
	public void updateProduct(int id, Product updatedProduct);
	public void deleteProduct(int id);
}