package com.user.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.exception.ServiceException;
import com.user.dao.UserDao;
import com.user.dao.impl.UserDaoImp;
import com.user.dao.impl.UserDaoImpl;
import com.user.po.User;
import com.utils.DBUtil;

/**
 * 用户服务类，（采用单例模式）
 * 
 * @author admin
 *
 */
public class UserService {
	private static final UserService instance = new UserService();

	public static UserService getInstance() {
		return instance;
	}

	private UserService() {

	}

//	/**
//	 * 增加用户
//	 * 
//	 * @param user
//	 */
//	public void addUser(User user) {
//		Connection conn = null;
//		try {
//			conn = DBUtil.getConnection();
//			UserDao userDao = new UserDaoImpl(conn);
//			DBUtil.beginTransaction(conn);
//			userDao.save(user);
//			DBUtil.commit(conn);
//		} catch (SQLException e) {
//			// TODO: handle exception
//			DBUtil.rollback(conn);
//			e.printStackTrace();
//		} finally {
//			DBUtil.release(conn);
//		}
//	}
	/**
	 * 增加用户
	 * 
	 * @param user
	 *            用户对象
	 */
	public int addUser(User user) {
		UserDaoImp userDao = new UserDaoImp();
		int row=0;
		try {
			 row=userDao.save(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	public User findUser(User one) {
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			user = userDao.findUser(one);
			DBUtil.commit(conn);
		} catch (SQLException e) {
			// TODO: handle exception
			DBUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBUtil.release(conn);
		}
		return user;
	}

	public boolean updateUser(User one) {
		Connection conn = null;
		boolean res = false;
		try {
			conn = DBUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			// System.out.println("userservice " + one);
			res = userDao.updateUser(one);
			DBUtil.commit(conn);
		} catch (SQLException e) {
			// TODO: handle exception
			DBUtil.rollback(conn);
			throw new ServiceException("更新用户信息错误", e);

		} finally {
			DBUtil.release(conn);
		}
		return res;
	}

	/**
	 * 登录验证
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			user = userDao.login(username, password);
			// System.out.println("userservice " + user);
			DBUtil.commit(conn);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new ServiceException("查询用户错误", e);
		} finally {
			DBUtil.release(conn);
		}

		return user;
	}
}
