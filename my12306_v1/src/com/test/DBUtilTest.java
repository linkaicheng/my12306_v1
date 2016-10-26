package com.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.utils.DBUtil;

public class DBUtilTest {

	@Test
	public void testGetConnection() {
		Connection conn=null;
			conn=DBUtil.getConnection();
			System.out.println(conn);
		
	}

}
