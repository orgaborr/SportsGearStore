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
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String search = req.getParameter("search");
		boolean productFound = false;
		
		if(search != null && !search.equals("")) {
			if(search.matches("\\d+")) {
				productFound = attributeSetter.setProduct(search, req);
			} else {
				productFound = attributeSetter.setProductList(search, req);
			}
			
			if(!productFound) {
				req.setAttribute("errorMessage", "No product found");
			}
			
			req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, res);
		}
	}
}
