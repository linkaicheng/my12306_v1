package com.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.user.po.Province;

/**
 * 省份操作接口
 * @author Administrator
 *
 */
public interface ProvinceDao {
	/**
	 * 获取所有省份列表
	 * @return 省份信息列表
	 * @throws SQLException
	 */
	List<Province> getProvinceList() throws SQLException;
}
