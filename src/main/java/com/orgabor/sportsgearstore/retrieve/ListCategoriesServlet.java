package com.orgabor.sportsgearstore.retrieve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orgabor.sportsgearstore.products.Categories;

@WebServlet(urlPatterns = "/list-categories.do")
public class ListCategoriesServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("categories", Categories.values());
		req.getRequestDispatcher("/WEB-INF/views/product-browser.jsp").forward(req, res);
	}
}
