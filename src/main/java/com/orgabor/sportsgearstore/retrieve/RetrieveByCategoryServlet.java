package com.orgabor.sportsgearstore.retrieve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.products.Categories;
import com.orgabor.sportsgearstore.products.StockDao;
import com.orgabor.sportsgearstore.products.StockDaoImpl;

@WebServlet(urlPatterns="/retrieve-by-category.do")
public class RetrieveByCategoryServlet extends HttpServlet {
	
	private StockDao stocks = new StockDaoImpl();
	private AttributeSetter attributeSetter = new AttributeSetter(stocks);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String categoryName = req.getParameter("category");
		Categories category = Categories.valueOf(categoryName);
		attributeSetter.setProductList(category, req);
		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
}
