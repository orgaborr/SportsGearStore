package com.orgabor.sportsgearstore.retrieve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.products.Product;
import com.orgabor.sportsgearstore.products.StockDao;
import com.orgabor.sportsgearstore.products.StockDaoImpl;

@WebServlet(urlPatterns = "/retrieve-product.do")
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
		
		try {
			String productId = req.getParameter("productId");
			Product product = null;
			if(!productId.equals("")) {
				product = stocks.getProduct(Integer.parseInt(productId));
				if(product != null) {
					req.setAttribute("product", product);
				} else {
					req.setAttribute("errorMessage", "No product found");
				}
			} else {
				req.setAttribute("errorMessage", "Empty query");
			}
			req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);

		} catch(Exception e) {
			req.setAttribute("errorMessage", "Invalid ID format");
			req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
		}
	}
}
