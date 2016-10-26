package com.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.exception.ServiceException;
import com.user.dao.CertTypeDao;
import com.user.dao.impl.CertTypeDaoImpl;
import com.user.po.CertType;
import com.utils.DBUtil;

/**
 * 证件类型服务类（采用单例模式实现）
 */
public class CertTypeService {
	/**
	 * 类实例
	 */
	private static final CertTypeService instance = new CertTypeService();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static CertTypeService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private CertTypeService() {
	}
	
	/**
	 * 获取所有证件类型列表
	 * @return 证件类型列表
	 * @throws SQLException
	 */
	public List<CertType> getCertTypeList(){
		Connection conn = null;
		List<CertType> res = null;
		try {
			conn = DBUtil.getConnection();
			CertTypeDao certTypeDao = new CertTypeDaoImpl(conn);
			DBUtil.beginTransaction(conn);
			res = certTypeDao.getCertTypeList();
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
