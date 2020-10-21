package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.ProductDto;
import com.ssafy.model.SearchDto;
import com.ssafy.model.dao.ProductDaoImpl;
import com.ssafy.model.service.ProductServiceImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");

		if ("mvadd".equals(act)) {
			response.sendRedirect(root + "/add.jsp");
		} else if ("add".equals(act)) {
			addProduct(request, response);
		} else if ("list".equals(act)) {
			listProduct(request, response);
		} else if ("mvdelete".equals(act)) {
			response.sendRedirect(root + "/delete.jsp");
		} else if ("delete".equals(act)) {
			deleteProduct(request, response);
		}

	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		ProductDaoImpl.getProductDao().deleteProduct(product_id);
		request.getRequestDispatcher(path).forward(request, response);

	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		ProductDto productDto = new ProductDto();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));


		productDto.setProduct_id(product_id);
		productDto.setName(name);
		productDto.setType(type);
		productDto.setPrice(price);
		productDto.setAmount(amount);

		System.out.println(productDto.toString());

		ProductServiceImpl.getProductService().addProduct(productDto);
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/list.jsp";
		SearchDto searchDto = new SearchDto();
		searchDto.setSearchType(request.getParameter("searchType"));
		searchDto.setSearchWord(request.getParameter("searchWord"));
		List<ProductDto> list = ProductServiceImpl.getProductService().allProduct(searchDto);
		request.setAttribute("products", list);
		request.getRequestDispatcher(path).forward(request, response);

	}

}
