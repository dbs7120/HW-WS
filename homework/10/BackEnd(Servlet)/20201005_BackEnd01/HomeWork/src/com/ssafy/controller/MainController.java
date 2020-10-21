package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.ProductDto;
import com.ssafy.model.MemberDto;
import com.ssafy.model.service.ProductService;
import com.ssafy.model.service.ProductServiceImpl;
import com.ssafy.model.service.LoginService;
import com.ssafy.model.service.LoginServiceImpl;

@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;
	private ProductService productService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginServiceImpl();
		productService = new ProductServiceImpl();
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

		if ("mvlogin".equals(act)) {
			response.sendRedirect(root + "/user/login.jsp");
		} else if ("login".equals(act)) {
			login(request, response);
		} else if ("logout".equals(act)) {
			logout(request, response);
		} else if ("add".equals(act)) {
			insertProduct(request, response);
		} else if ("list".equals(act)) {
			listProduct(request, response);

		} else if ("last".equals(act)) {
			lastProduct(request, response);
		} else {
			response.sendRedirect(root);
		}
	}

	private void lastProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		try {
			ProductDto product = new ProductDto();
			productService.lastProduct(product);
			request.setAttribute("product", product);
			path = "/last.jsp";
			System.out.println(product.toString());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "상품목록 로딩중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		try {
			List<ProductDto> list = productService.listProduct();
			request.setAttribute("articles", list);
			path = "/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "목록을 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if (memberDto != null) {
			ProductDto productDto = new ProductDto();
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String desc = request.getParameter("desc");

			productDto.setName(name);
			productDto.setPrice(price);
			productDto.setDesc(desc);

			productService.addProduct(productDto);
			path = "index.jsp";

		} else {
			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userinfo");
//		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");

		try {
			MemberDto memberDto = loginService.login(userid, userpwd);
			if (memberDto != null) {
//				session 설정
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);

//				cookie 설정
				String idsave = request.getParameter("idsave");
				if ("saveok".equals(idsave)) {// 아이디 저장을 체크 했다면.
					Cookie cookie = new Cookie("ssafy_id", userid);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);// 40년간 저장.
					response.addCookie(cookie);
				} else {// 아이디 저장을 해제 했다면.
					Cookie cookies[] = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if ("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
			} else {
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
