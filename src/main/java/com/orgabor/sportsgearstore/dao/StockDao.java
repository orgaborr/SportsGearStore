package com.orgabor.sportsgearstore.dao;

import java.util.List;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public interface StockDao {
	public void addProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> retrieveByCategory(Categories category);
	public List<Product> retrieveByExpression(String expression);
	public void updateProduct(int productId, Product updatedProduct);
	public void deleteProduct(int productId);
	public String getImgSourceFolder();
}
