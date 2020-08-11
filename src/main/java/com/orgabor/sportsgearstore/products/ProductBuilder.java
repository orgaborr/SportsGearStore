package com.orgabor.sportsgearstore.products;

import java.math.BigDecimal;
import java.util.Map;

public class ProductBuilder {

	public static Product buildProduct(Map<String, Object> productParams) {
		long productId = (long) productParams.get("productId");
		String name = (String) productParams.get("name");
		String description = (String) productParams.get("description");
		Categories category = (Categories) productParams.get("category");
		BigDecimal price = (BigDecimal) productParams.get("price");
		int stock = (int) productParams.get("inStock");
		String img = (String) productParams.get("img");
		
		return new Product.Builder(productId)
				.withName(name)
				.withDescription(description)
				.ofCategory(category)
				.forPrice(price)
				.withStock(stock)
				.withImg(img)
				.build();
	}
}
