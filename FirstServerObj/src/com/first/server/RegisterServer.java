package com.first.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.dao.impl.UserDaoImpl;

public class RegisterServer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");

		resp.setContentType("text/html;charset=utf-8");
		if (name == null || name.length() == 0 && pwd == null || pwd.length() < 6) {
			resp.getWriter().append("用户名或密码为空");
			return;
		}
		/**
		 * 1.判断用户是否存在
		 * 用户存在
		 */

		UserDaoImpl daoImpl = new UserDaoImpl();
		int queryUserID = daoImpl.queryUserID(name);
		if (queryUserID > 0) {
			// 用户已存在
			return;
		}

		/**
		 * 用户不存在
		 *  2.插入数据库
		 */
		
		boolean saveUser = daoImpl.saveUser(name, pwd);
		System.out.println("注册："+saveUser);
		if(saveUser){
			resp.getWriter().append("注册成功");

			/**
			 * 跳转到指定的jsp 页面
			 */
			resp.sendRedirect("index.jsp");
		}else {
			resp.getWriter().append("注册失败");
		}
		
		
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
