package cn.wxjia.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wxjia.dao.user.UserDao;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();
		boolean ret = userDao.check(username, password);
		if(false == ret){
			//登录失败
			request.setAttribute("loginFaliure", "true");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		request.setAttribute("loginSuccess", "true");

		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	public void init() throws ServletException {
	}

}
