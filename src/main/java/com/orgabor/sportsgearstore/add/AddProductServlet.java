package com.orgabor.sportsgearstore.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.dao.StockDaoImpl;
import com.orgabor.sportsgearstore.products.Product;

@WebServlet(urlPatterns = "/add-product.do")
public class AddProductServlet extends HttpServlet {
	
	private StockDao stocks = new StockDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/product-creator.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ProductCreator creator = new ProductCreator(req);
		stocks.addProduct(creator.buildProduct());
	}
}
