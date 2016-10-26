package com.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.dao.ProvinceDao;
import com.user.po.Province;
import com.utils.DBUtil;

public class ProvinceDaoImpl implements ProvinceDao {
	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * 
	 * @param conn
	 *            数据库连接
	 */
	public ProvinceDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Province> getProvinceList() throws SQLException {
		// SQL语句
		String find_sql = "SELECT * FROM t_province";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Province> result = new ArrayList<Province>();
		try {
			// 设置语句对象，SQL语句条件
			pstmt = conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 解析结果集对象
				Province one = new Province();
				one.setProvinceId(rs.getString("province_ID"));
				one.setProvince(rs.getString("province"));

				// 保存城市信息列表
				result.add(one);
			}
		} finally {
			DBUtil.release(pstmt,rs);
		}

		return result;
	}
}
