package com.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.exception.ServiceException;
import com.user.dao.ProvinceDao;
import com.user.dao.impl.ProvinceDaoImpl;
import com.user.po.Province;
import com.utils.DBUtil;

/**
 * 省份服务类（采用单例模式实现）
 */
public class ProvinceService {
	/**
	 * 类实例
	 */
	private static final ProvinceService instance = new ProvinceService();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static ProvinceService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private ProvinceService() {
	}
	
	/**
	 * 获取所有省份列表
	 * @return 省份信息列表
	 * @throws SQLException
	 */
	public List<Province> getProvinceList(){
		Connection conn = null;
		List<Province> res = null;
		try {
			conn = DBUtil.getConnection();
			ProvinceDao provinceDao = new ProvinceDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			res = provinceDao.getProvinceList();
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
