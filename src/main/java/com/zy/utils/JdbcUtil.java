package com.zy.utils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	static {
		InputStream in=JdbcUtil.class.getClassLoader().getResourceAsStream("dbcfg.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			driverClass=prop.getProperty("driverClass");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
		}catch (IOException e) {
			throw new ExceptionInInitializerError("read database file failed!");
		}
		try {
		 Class.forName(driverClass);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError("loading driverClass'"+driverClass+"' failure!");
		}
	}
	public static Connection getConnecttion() throws SQLException{
		Connection connection=(Connection)DriverManager.getConnection(url,user,password);
		return  connection;
	
	}
	
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
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
}
