package com.first.dao;

public interface UserDao {
	
	/**
	 * 保存数据到数据库
	 * @param name
	 * @param pwd
	 * @return 是否插入成功
	 */
	boolean saveUser(String name,String pwd);
	
	/**
	 * 根据用户名删除当前用户
	 * @param name
	 */
	void deleteUser(String name);
	
	
	/**
	 * 根据用户名修改当前用户名
	 * @param name
	 */
	
	void updateUserName(String name);
	
	/**
	 * 修改密码
	 * @param pwd
	 */
	void updateUserPwd(String pwd);
	
	/**
	 * 查询数据库中对应用户名的ID
	 * @param name
	 */
	int queryUserID(String name);
	
	/**
	 * 根据用户名id查询当前用户
	 * @param name
	 */
	boolean queryUserName(String name);
	
	boolean queryUserPwd(int id,String pwd);

}
