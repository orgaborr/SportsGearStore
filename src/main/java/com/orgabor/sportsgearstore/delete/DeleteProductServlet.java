package com.orgabor.sportsgearstore.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.dao.StockDaoImpl;

@WebServlet(urlPatterns = "/delete-product.do")
public class DeleteProductServlet extends HttpServlet{
	
	private StockDao stocks = new StockDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String productIdParam = req.getParameter("productId");
		int productIdInt = Integer.parseInt(productIdParam);
		stocks.deleteProduct(productIdInt);
		res.sendRedirect("/retrieve-products.do");
	}
}
