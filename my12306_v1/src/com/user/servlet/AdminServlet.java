package com.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.awt.RepaintArea;

import com.user.po.CertType;
import com.user.po.User;
import com.user.po.UserType;
import com.user.service.UserService;

/**
 * Servlet implementation class AdminServlet
 */

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if("list".equals(action)){
			doAdminList(request,response);
		}
	}

	private void doAdminList(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession se=request.getSession();
		String pageSize=request.getParameter("pageSize");
		if(pageSize==null){
			pageSize="10";
		}
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
		String source=request.getParameter("source");
		if(source!=null){
			User user=new User();
			populateList(request,user);
			se.setAttribute("listUser", user);
			se.setAttribute("pageSize", pageSize);
			
		}
		try {
			User user=(User) se.getAttribute("listUser");
			UserService userService=UserService.getInstance();
			List<User> list=userService.getUserList(Integer.parseInt(pageSize),Integer.parseInt(page),user);
			//System.out.println(list.size());
			int pageCount=userService.getUserListPageCount(Integer.parseInt(pageSize),user);
			//System.out.println(pageCount);
			request.setAttribute("list", list);
			request.setAttribute("pageCount", pageCount);
			request.getRequestDispatcher("/Admin/UserManageQuery.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private void populateList(HttpServletRequest request,
			User user) {
		// TODO Auto-generated method stub
		//获取表单参数
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String certTypeId=request.getParameter("certType");
		String cert=request.getParameter("cert");
		String userTypeId=request.getParameter("userType");
		
		user.setRealname(realname);
		user.setSex(sex);
		CertType certType=new CertType();
		certType.setId(Integer.parseInt(certTypeId));
		user.setCertType(certType);
		
		user.setCert(cert);
		//usertype
		UserType userType=new UserType();
		userType.setId(Integer.parseInt(userTypeId));
		user.setUserType(userType);
		
	}

}
