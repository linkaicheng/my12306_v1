package com.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	// /**
	// * 增加用户
	// *
	// * @param user
	// */
	// public void addUser(User user) {
	// Connection conn = null;
	// try {
	// conn = DBUtil.getConnection();
	// UserDao userDao = new UserDaoImpl(conn);
	// DBUtil.beginTransaction(conn);
	// userDao.save(user);
	// DBUtil.commit(conn);
	// } catch (SQLException e) {
	// // TODO: handle exception
	// DBUtil.rollback(conn);
	// e.printStackTrace();
	// } finally {
	// DBUtil.release(conn);
	// }
	// }
	/**
	 * 增加用户
	 * 
	 * @param user
	 *            用户对象
	 */
	public int addUser(User user) {
		UserDaoImp userDao = new UserDaoImp();
		int row = 0;
		try {
			row = userDao.save(user);
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

	/**
	 * 获取指定页用户信息列表，通过分页SQL语句实现
	 * 
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param one，需要获取的页数
	 * @return 用户信息列表，List[User]，若无满足条件则列表为空
	 * @throws SQLException
	 */
	public List<User> getUserList(int pageSize, int rowNum, User one) {
		Connection conn = null;
		List<User> res = null;
		try {
			conn = DBUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			res = userDao.getUserList(pageSize, rowNum, one);
			DBUtil.commit(conn);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new ServiceException("查询错误", e);
		} finally {
			DBUtil.release(conn);
		}

		return res;
	}

	/**
	 * 获取用户列表最大页数
	 * 
	 * @param pageSize，每页显示信息条数
	 * @return 列表最大页数
	 * @throws SQLException
	 */
	public int getUserListPageCount(int pageSize, User one) throws SQLException {
		Connection conn = null;
		int res = 0;
		try {
			conn = DBUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			res = userDao.getUserListPageCount(pageSize, one);
			DBUtil.commit(conn);
		} finally {
			DBUtil.release(conn);
		}

		return res;
	}

	/**
	 * 获取用户列表最大行数
	 * 
	 * @return 列表最大行数
	 * @throws SQLException
	 */
	public int getUserListRowCount(User one) {
		Connection conn = null;
		int res = 0;
		try {
			conn = DBUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			res = userDao.getUserListRowCount(one);
			DBUtil.commit(conn);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new ServiceException("查询错误", e);
		} finally {
			DBUtil.release(conn);
		}

		return res;
	}
}
