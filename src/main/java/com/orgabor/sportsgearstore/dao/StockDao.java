package com.orgabor.sportsgearstore.dao;

import java.util.List;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public interface StockDao {
	public boolean addProduct(Product product);
	public Product getProduct(long productId);
	public List<Product> retrieveByCategory(Categories category);
	public List<Product> retrieveByExpression(String expression);
	public void updateProduct(long productId, Product updatedProduct);
	public void deleteProduct(long productId);
}
