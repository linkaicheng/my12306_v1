package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.po.CertType;
import com.user.po.City;
import com.user.po.User;
import com.user.po.UserType;
import com.user.service.UserService;
import com.utils.Md5Utils;
import com.utils.TextUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 取得请求参数
		User user = new User();
		populate(request, user);
		// rule(可以放在service中）
		user.setRule("2");
		// status(可以放在service中）
		user.setStatus("1");

		// 服务器端验证
		String msg = validate(user);
		if (TextUtils.isEmpty(msg)) {
			UserService userService = UserService.getInstance();

			// 检查用户名是否重复
			User tmp = new User();
			tmp.setUsername(user.getUsername());
			;
			User dbUser = userService.findUser(tmp);
			if (dbUser == null) {
				user.setPassword(Md5Utils.md5(user.getPassword()));
				int row=userService.addUser(user);
				if(row!=0){
					msg = "注册成功";
				}
				else{
					msg="注册失败";
				}
			} else {
				msg = "用户名重复";
			}
		}
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>注册信息</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	private String validate(User user) {
		String errorMsg = null;
		if (TextUtils.isEmpty(user.getUsername())) {
			errorMsg = "请输入用户名";
		} else if (user.getUsername().length() < 6 || user.getUsername().length() > 30) {
			errorMsg = "用户名长度在6到30之间";
		} else if (!user.getUsername().matches("[a-zA-Z0-9_]{6,30}")) {
			errorMsg = "用户名只能包含字母，数字或“-”";
		} else if (TextUtils.isEmpty(user.getPassword())) {
			errorMsg = "请输入密码";
		} else if (!user.getPassword().equals(user.getPassword2())) {
			errorMsg = "两次密码不相等";
		} else if (TextUtils.isEmpty(user.getRealname())) {
			errorMsg = "请输入真实姓名";
		} else if (user.getCity().getCityId() == null) {
			errorMsg = "请输入所在城市";

		} else if (TextUtils.isEmpty(user.getCert())) {
			errorMsg = "请输入证件号码";
		} else if (user.getBirthday() == null) {
			errorMsg = "请输入出生日期";
		}

		return errorMsg;
	}

	private void populate(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		// 获取客户端ip
		String loginIp = request.getRemoteAddr();
		// 获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		// 需要修改前台代码
		String cityId = request.getParameter("city");
		String certTypeId = request.getParameter("certType");
		String cert = request.getParameter("cert");
		String birthday = request.getParameter("birthday");
		String userTypeId = request.getParameter("userType");
		String content = request.getParameter("ocntent");

		user.setLoginIp(loginIp);
		user.setUsername(username);
		user.setPassword(password);
		user.setPassword2(password2);
		user.setRealname(realname);
		user.setSex(sex);
		// city
		City city = new City();
		if(!cityId.equals("城市")){
			city.setCityId(cityId);
		}
		user.setCity(city);

		// certType
		CertType certType = new CertType();
		certType.setId(Integer.parseInt(certTypeId));
		user.setCertType(certType);

		// cert
		user.setCert(cert);

		// birthday
		if (!TextUtils.isEmpty(birthday)) {
			user.setBirthday(Date.valueOf(birthday));
		}
		// usertype
		UserType userType = new UserType();
		userType.setId(Integer.parseInt(userTypeId));
		user.setUserType(userType);
		// content
		user.setContent(content);

	}

}
