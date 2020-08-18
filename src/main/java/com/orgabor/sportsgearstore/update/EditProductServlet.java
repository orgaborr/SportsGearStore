package com.orgabor.sportsgearstore.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.dao.StockDao;
import com.orgabor.sportsgearstore.dao.StockDaoImpl;
import com.orgabor.sportsgearstore.utils.AttributeSetter;

@WebServlet(urlPatterns = "/edit-product")
public class EditProductServlet extends HttpServlet{
	
	private StockDao stocks = new StockDaoImpl();
	private AttributeSetter attrSetter = new AttributeSetter(stocks);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String productId = req.getParameter("productId");
		if(attrSetter.setProduct(productId, req)) {
			req.getRequestDispatcher("/WEB-INF/views/product-editor.jsp").forward(req, res);
		} else {
			req.setAttribute("errorMessage", "Product #" + productId + " can not be found");
			req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ProductUpdater updater = new ProductUpdater(req, stocks);
		updater.updateProduct();
		res.sendRedirect("/edit-product.do?productId=" + req.getParameter("productId"));
	}
}
