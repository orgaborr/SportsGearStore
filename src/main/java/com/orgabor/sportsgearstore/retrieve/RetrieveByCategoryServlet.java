package com.orgabor.sportsgearstore.retrieve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.dao.StockDaoImpl;
import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.utils.AttributeSetter;

@WebServlet(urlPatterns="/retrieve-by-category")
public class RetrieveByCategoryServlet extends HttpServlet {
	
	private StockDao stocks = new StockDaoImpl();
	private AttributeSetter attrSetter = new AttributeSetter(stocks);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String categoryName = req.getParameter("category");
		Categories category = Categories.valueOf(categoryName);
		attrSetter.setProductList(category, req);
		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
}
