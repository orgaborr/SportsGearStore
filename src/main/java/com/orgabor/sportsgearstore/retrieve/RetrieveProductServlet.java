package com.orgabor.sportsgearstore.retrieve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.products.StockDao;
import com.orgabor.sportsgearstore.products.StockDaoImpl;
import com.orgabor.sportsgearstore.utils.AttributeSetter;

@WebServlet(urlPatterns = "/retrieve-products.do")
public class RetrieveProductServlet extends HttpServlet {
	
	private StockDao stocks = new StockDaoImpl();
	private AttributeSetter attrSetter = new AttributeSetter(stocks);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String search = req.getParameter("search");
		boolean productFound = false;
		
		if(search != null && !search.equals("")) {
			if(search.matches("\\d+")) {
				productFound = attrSetter.setProduct(search, req);
			} else {
				productFound = attrSetter.setProductList(search, req);
			}
			
			if(!productFound) {
				req.setAttribute("errorMessage", "No product found");
			}
		}

		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
}
