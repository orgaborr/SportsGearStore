package com.orgabor.sportsgearstore.retrieve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.products.StockDao;
import com.orgabor.sportsgearstore.products.StockDaoImpl;

@WebServlet(urlPatterns = "/retrieve-products.do")
public class RetrieveProductServlet extends HttpServlet {
	
	private StockDao stocks = new StockDaoImpl();
	private AttributeSetter attributeSetter = new AttributeSetter(stocks);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String productSearch = req.getParameter("searchField");
		boolean productFound = false;
		
		if(productSearch.matches("\\d+")) {
			productFound = attributeSetter.setProduct(productSearch, req);
		} else {
			productFound = attributeSetter.setProductList(productSearch, req);
		}
		
		if(!productFound) {
			req.setAttribute("errorMessage", "No product found");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
	
	
	
}
