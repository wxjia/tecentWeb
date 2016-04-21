package cn.wxjia.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wxjia.dao.user.UserDao;
import cn.wxjia.pojo.UserInformation;

public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		System.out.println("realname" + realname);

		Pattern pattern = Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

		Matcher matcher = pattern.matcher(username);
		boolean rightEmail = matcher.matches();
		if (!rightEmail || null == username || null == password
				|| "".equals(username) || "".equals(password)) {
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}

		UserInformation information = new UserInformation(username, password,
				realname);
		UserDao userDao = new UserDao();
		boolean isExist = userDao.isExist(username);
		if (isExist) {
			// 用户已存在
			request.setAttribute("nameIsExist", "true");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}
		userDao.insertUser(information);
		request.setAttribute("registerSuccess", "true");

		HttpSession session = request.getSession();
		session.setAttribute("username", information.getUsername());

		request.getRequestDispatcher("/jsp/main.jsp")
				.forward(request, response);

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
