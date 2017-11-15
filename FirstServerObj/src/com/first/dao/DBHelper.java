package com.first.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	// 数据库地址“jdbc:mysql://服务器域名:端口号/数据库名称”
	// ?useUnicode=true&characterEncoding=utf-8
	private String url = "jdbc:mysql://localhost:3306/firstserver?useSSL=false&characterEncoding=UTF-8";
	// 用户名
	private String user = "root";
	// 用户密码
	private String pwd = "wenge@wancong0";
	// 数据库链接对象
	private java.sql.Connection conn;

	private static DBHelper sDbHelper;

	public static DBHelper getInstance() {
		if (sDbHelper == null) {
			synchronized (DBHelper.class) {
				if (sDbHelper == null) {
					sDbHelper = new DBHelper();
				}
			}
		}
		return sDbHelper;
	}

	// 静态代码块
	static {
		// 1、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	// 2、创建连接
	public Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, pwd);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * 断开连接
	 */

	public void closeConnetion() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
