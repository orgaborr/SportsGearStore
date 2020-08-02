package com.orgabor.sportsgearstore.dao;

import java.util.ArrayList;
import java.util.List;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;

public class StockDaoImpl implements StockDao {
	private final static String imgSourceFolder = "../../images/";
	
	private static List<Product> products = new ArrayList<>();
	static {
		products.add(new Product.Builder(1).withName("Bicycle").withDescription("A cool bike").ofCategory(Categories.CYCLING).forPrice(329.99).withStock(5).withImg(imgSourceFolder + "cycling/bicycle.png").build());
		products.add(new Product.Builder(2).withName("Tent").withDescription("Tent for 3").ofCategory(Categories.CAMPING).forPrice(99.99).withStock(4).build());
		products.add(new Product.Builder(3).withName("Rope").withDescription("50m dynamic rope").ofCategory(Categories.CLIMBING).forPrice(299.99).withStock(2).build());
		products.add(new Product.Builder(4).withName("Tent Stakes").withDescription("A set of 10 tent stakes").ofCategory(Categories.CAMPING).forPrice(5.99).withStock(10).build());
	}
	
	@Override
	public void addProduct(Product product) {
		products.add(product);
	}

	@Override
	public Product getProduct(int productId) {
		for(Product product : products) {
			if(product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> retrieveByCategory(Categories category) {
		List<Product> productsInCategory = new ArrayList<>();
		for(Product product : products) {
			if(product.getCategory() == category) {
				productsInCategory.add(product);
			}
		}
		return productsInCategory;
	}

	@Override
	public List<Product> retrieveByExpression(String expression) {
		List<Product> productsByExpression = new ArrayList<>();
		for(Product product : products) {
			if(product.getName().toLowerCase().contains(expression.toLowerCase())) {
				productsByExpression.add(product);
			}
		}
		return productsByExpression;
	}

	@Override
	public void updateProduct(int productId, Product updatedProduct) {
		Product product = getProduct(productId);
		int productIndex = products.indexOf(product);
		products.set(productIndex, updatedProduct);	
	}

	@Override
	public void deleteProduct(int productId) {
		for(Product product : products) {
			if(product.getProductId() == productId) {
				products.remove(product);
				break;
			}
		}
	}

	@Override
	public String getImgSourceFolder() {
		return imgSourceFolder;
	}
}
