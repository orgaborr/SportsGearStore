package com.orgabor.sportsgearstore.update;

import java.util.HashMap;
import java.util.Map;

import com.orgabor.sportsgearstore.dao.StockDao;

class ProductCaller {
	private final StockDao stocks;
	Map<String, Object> params;
	
	ProductCaller(StockDao stocks) {
		this.stocks = stocks;
		this.params = new HashMap<>();
	}
	
	
}
