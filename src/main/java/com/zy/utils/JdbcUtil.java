package com.zy.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcUtil {
	private static DataSource dataSource=null;
	static{
		dataSource=new ComboPooledDataSource("mysql");
	}

	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnecttion(){
		java.sql.Connection conn=null;
		try {
			conn=dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void release(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public static void release(PreparedStatement stmt, Connection conn) {
		if(stmt!=null) {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
