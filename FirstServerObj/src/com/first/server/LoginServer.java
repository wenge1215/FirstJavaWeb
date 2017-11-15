package com.first.server;

import java.io.IOException;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.first.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServer
 */
// @WebServlet("/LoginServer")
public class LoginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("phone");

		response.setContentType("text/html;charset=utf-8");
		if (name == null || name.length() == 0 && pwd == null || pwd.length() < 6) {
			response.getWriter().append("用户名或密码为空");
			return;
		}

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int userID = userDaoImpl.queryUserID(name);

		if (userID > 0) {
			if (userDaoImpl.queryUserPwd(userID, pwd)) {
				response.getWriter().append("登录成功,当前用户id为： " + userID);
			} else {
				response.getWriter().append("密码错误，请重新输入");
			}

		} else {
			response.getWriter().append("该用户尚未注册，请先注册");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
