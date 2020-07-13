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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String productSearch = req.getParameter("searchField");
		
		if(productSearch.matches("\\d+")) {
			Product product = stocks.getProduct(Integer.parseInt(productSearch));
			if(product != null) {
				req.setAttribute("product", product);
			} else {
				req.setAttribute("errorMessage", "No product found");
			}
			
		} else {
			List<Product> products = stocks.retrieveByExpression(productSearch);
			if(!products.isEmpty()) {
				req.setAttribute("products", products);
			} else {
				req.setAttribute("errorMessage", "No product found");
			}
		}
		
		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
}
