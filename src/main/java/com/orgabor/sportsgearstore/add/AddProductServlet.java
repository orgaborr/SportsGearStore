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

@WebServlet(urlPatterns = "/add-product")
public class AddProductServlet extends HttpServlet {
	
	private StockDao stocks = new StockDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/product-creator.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ProductCreator creator = new ProductCreator(req);
		Product newProduct = creator.buildProduct();
		if(stocks.getProduct(newProduct.getProductId()) == null) {
			if(stocks.addProduct(newProduct)) {
				res.sendRedirect("/retrieve-products?search=" + newProduct.getProductId());
			} else {
				req.setAttribute("errorMessage", "Product with name " + newProduct.getName() + " alrady exists in database");
				req.getRequestDispatcher("/WEB-INF/views/product-creator.jsp").forward(req, res);
			}
		} else {
			req.setAttribute("errorMessage", "Product with Product ID #" + newProduct.getProductId() + " already in database");
			req.getRequestDispatcher("/WEB-INF/views/product-creator.jsp").forward(req, res);
		}	
	}
}
