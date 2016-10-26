package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();

		session.removeAttribute("user");
		session.invalidate();
		// 清除自动登录cookie
		if (cookies != null) {
			Cookie c = new Cookie("username", "");
			c.setMaxAge(0);
			c.setPath("/");
			response.addCookie(c);

			Cookie cLogin = new Cookie("autoLogin", "");
			cLogin.setMaxAge(0);
			cLogin.setPath("/");
			response.addCookie(cLogin);

		}

		response.sendRedirect(request.getContextPath() + "/Login.jsp?action=logout");
	}

}
