package com.test;

import java.sql.Connection;

import org.junit.Test;

import com.user.dao.UserDao;
import com.user.dao.impl.UserDaoImpl;
import com.utils.DBUtil;

public class UserDaoImplTest {
	Connection conn = DBUtil.getConnection();
	UserDao dao = new UserDaoImpl(conn);

	/**
	 * 测试新增用户
	 */
	@Test
	public void testSaveUser() {
		// City city = new City(1, "1002", "广州", new Province(1, "1002", "广东"));
		// CertType certType = new CertType(1, "身份证");
		// User user = new User(1, "cheng", "cheng", "cheng", "0", "cheng", "0",
		// city, certType, "cert", new Date(),
		// new UserType(1, "content"), "content", "0", "loginIp", "imagePath");
		// try {
		// int row = dao.save(user);
		// System.out.println(row);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
