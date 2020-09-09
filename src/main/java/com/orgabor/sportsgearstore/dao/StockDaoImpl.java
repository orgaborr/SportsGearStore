package com.orgabor.sportsgearstore.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.utils.ImgPathBuilder;

public class StockDaoImpl implements StockDao {
		
	private Connection getConnection() {
		Connection con = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/databasename";
			String username = "root";
			String password = "root";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection successful");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	private static List<Product> products = new ArrayList<>();
	static {
		products.add(new Product.Builder(1)
								.withName("Bicycle")
								.withDescription("A cool bike")
								.ofCategory(Categories.CYCLING)
								.forPrice(new BigDecimal("329.99")).withStock(5)
								.withImg(ImgPathBuilder.buildImgPath(Categories.CYCLING, "bicycle.png"))
								.build());
		products.add(new Product.Builder(2)
								.withName("Tent")
								.withDescription("Tent for 3")
								.ofCategory(Categories.CAMPING)
								.forPrice(new BigDecimal("99.99"))
								.withStock(4)
								.withImg(ImgPathBuilder.buildImgPath(Categories.CAMPING, "tent.png"))
								.build());
		products.add(new Product.Builder(3)
								.withName("Rope")
								.withDescription("50m dynamic rope")
								.ofCategory(Categories.CLIMBING)
								.forPrice(new BigDecimal("299.99"))
								.withStock(2)
								.withImg(ImgPathBuilder.buildImgPath(Categories.CLIMBING, "rope.jpg"))
								.build());
		products.add(new Product.Builder(4)
								.withName("Tent Stakes")
								.withDescription("A set of 10 tent stakes")
								.ofCategory(Categories.CAMPING)
								.forPrice(new BigDecimal("5.99"))
								.withStock(10)
								.withImg(ImgPathBuilder.buildImgPath(Categories.CAMPING, "stakes.jpg"))
								.build());
	}
	
	@Override
	public void addProduct(Product product) {
		products.add(product);
	}

	@Override
	public Product getProduct(long productId) {
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
	public void updateProduct(long productId, Product updatedProduct) {
		Product product = getProduct(productId);
		int productIndex = products.indexOf(product);
		products.set(productIndex, updatedProduct);	
	}

	@Override
	public void deleteProduct(long productId) {
		for(Product product : products) {
			if(product.getProductId() == productId) {
				products.remove(product);
				break;
			}
		}
	}
}
