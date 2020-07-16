package com.orgabor.sportsgearstore.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.products.StockDao;
import com.orgabor.sportsgearstore.products.StockDaoImpl;
import com.orgabor.sportsgearstore.utils.AttributeSetter;

@WebServlet(urlPatterns = "/edit-product.do")
public class EditProductServlet extends HttpServlet{
	
	private StockDao stocks = new StockDaoImpl();
	private AttributeSetter attributeSetter = new AttributeSetter(stocks);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String productId = req.getParameter("product");
		if(attributeSetter.setProduct(productId, req)) {
			req.getRequestDispatcher("/WEB-INF/views/product-editor.jsp").forward(req, res);
		} else {
			req.setAttribute("errorMessage", "Product #" + productId + " can no longer be found");
			req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
		}
		
	}
}
