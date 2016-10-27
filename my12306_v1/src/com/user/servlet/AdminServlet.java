package com.user.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.format.Border;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			doAdminList(request, response);
		} else if ("export".equals(action)) {
			doAdminExport(request, response);
		}
	}

	private void doAdminExport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession se = request.getSession();

		User user = (User) se.getAttribute("listUser");
		UserService userService = UserService.getInstance();
		int rowCount = userService.getUserListRowCount(user);
		List<User> list = userService.getUserList(rowCount, 1, user);

		response.setHeader("Content-disposition", "attachment;filename="
				+ new String("用户".getBytes("GB2312"), "8859_1") + ".xls");
		response.setHeader("pragma", "no-cache");
		response.setContentType("application/msexcel");
		ServletOutputStream os = response.getOutputStream();
		if (list == null) {
			return;
		}
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			WritableSheet ws = workbook.createSheet("用户列表", 0);
			int rowNum = 0;

			WritableFont font1 = new WritableFont(WritableFont.TIMES, 16,
					WritableFont.BOLD);
			WritableCellFormat format1 = new WritableCellFormat(font1);
			Label cell = new Label(0, 0, "导出用户列表", format1);
			ws.addCell(cell);

			WritableCellFormat cellFormat2 = new WritableCellFormat();
			cellFormat2.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);

			ws.setColumnView(7, 50);

			rowNum = 1;
			for (int i = 0; i < list.size(); i++, rowNum++) {
				User tmp = list.get(i);
				ws.addCell(new Label(0, rowNum, tmp.getId() + "", cellFormat2));
				ws.addCell(new Label(1, rowNum, tmp.getUsername(), cellFormat2));
				ws.addCell(new Label(2, rowNum,
						"1".equals(tmp.getRule()) ? "管理员" : "普通用户", cellFormat2));
				ws.addCell(new Label(3, rowNum, tmp.getRealname(), cellFormat2));
				ws.addCell(new Label(4, rowNum, "1".equals(tmp.getSex()) ? "男"
						: "女", cellFormat2));
				ws.addCell(new Label(5, rowNum, tmp.getCity().getCity(),
						cellFormat2));
				ws.addCell(new Label(6, rowNum, tmp.getCertType().getContent(),
						cellFormat2));
				ws.addCell(new Label(7, rowNum, tmp.getCert(), cellFormat2));
			}
			workbook.write();
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		os.close();

	}

	private void doAdminList(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession se = request.getSession();
		String pageSize = request.getParameter("pageSize");
		if (pageSize == null) {
			pageSize = "10";
		}
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		String source = request.getParameter("source");
		if (source != null) {
			User user = new User();
			populateList(request, user);
			// listUser封装了页面的查询条件
			se.setAttribute("listUser", user);
			se.setAttribute("pageSize", pageSize);

		}
		try {
			User user = (User) se.getAttribute("listUser");
			UserService userService = UserService.getInstance();
			List<User> list = userService.getUserList(
					Integer.parseInt(pageSize), Integer.parseInt(page), user);
			// System.out.println(list.size());
			int pageCount = userService.getUserListPageCount(
					Integer.parseInt(pageSize), user);
			// System.out.println(pageCount);
			request.setAttribute("list", list);
			request.setAttribute("pageCount", pageCount);
			request.getRequestDispatcher("/Admin/UserManageQuery.jsp").forward(
					request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 将查询条件封装成一个user对象
	 * 
	 * @param request
	 * @param user
	 */
	private void populateList(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		// 获取表单参数
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String certTypeId = request.getParameter("certType");
		String cert = request.getParameter("cert");
		String userTypeId = request.getParameter("userType");

		user.setRealname(realname);
		user.setSex(sex);
		CertType certType = new CertType();
		certType.setId(Integer.parseInt(certTypeId));
		user.setCertType(certType);

		user.setCert(cert);
		// usertype
		UserType userType = new UserType();
		userType.setId(Integer.parseInt(userTypeId));
		user.setUserType(userType);
		// System.out.println(user);

	}

}
