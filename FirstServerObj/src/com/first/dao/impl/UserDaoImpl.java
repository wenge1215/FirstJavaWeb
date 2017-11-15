package com.first.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.first.dao.DBHelper;
import com.first.dao.UserDao;

public class UserDaoImpl implements UserDao {
	Connection connection = DBHelper.getInstance().getConnection();

	@Override
	public void saveUser(String name, String pwd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserPwd(String pwd) {
		// TODO Auto-generated method stub

	}

	@Override
	public int queryUserID(String name) {
		String sql = "select _id from user where name='"+name+"'";
		int id = -1;

		try {
			if (connection.isClosed()) {
				connection = DBHelper.getInstance().getConnection();
			}
			connection.createStatement();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				id = executeQuery.getInt(1);
				// String name1 = executeQuery.getString(2);
				// String pwd = executeQuery.getString(3);
				// String tocken = executeQuery.getString(4);
				// System.out.println(name1+" "+pwd+" "+tocken);
			}
			executeQuery.close();
			DBHelper.getInstance().closeConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;

	}

	@Override
	public boolean queryUserName(String name) {
		if ("张三".equals(name)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean queryUserPwd(int id, String pwd) {
		String sql = "select pwd from user where _id=" + id;
		String passwor = "";
		try {
			if (connection.isClosed()) {
				connection = DBHelper.getInstance().getConnection();
			}
			connection.createStatement();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				passwor = executeQuery.getString(1);
				System.out.println(passwor);
			}
			if(passwor.equals(pwd)){
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return false;
	}

}
