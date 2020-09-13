package com.orgabor.sportsgearstore.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

class ProductDbReader {
	
	Map<String, Object> readResult(ResultSet results) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", results.getLong("productId"));
		params.put("name", results.getString("name"));
		params.put("description", results.getString("description"));
		params.put("category", results.getString("category"));
		params.put("price", results.getBigDecimal("price"));
		params.put("inStock", results.getInt("inStock"));
		params.put("img", results.getString("img"));
		return params;
	}
}
