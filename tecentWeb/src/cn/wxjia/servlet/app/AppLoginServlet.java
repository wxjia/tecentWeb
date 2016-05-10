package cn.wxjia.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wxjia.dao.user.UserDao;

public class AppLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AppLoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Map<String, String[]> map = request.getParameterMap();

		String username = map.get("username")[0];
		String password = map.get("password")[0];

		UserDao userDao = new UserDao();
		boolean ret = userDao.check(username, password);
		if (ret == false) {
			System.out.println("NO");
			out.print("NO");
		} else {
			out.print("YES");
			System.out.println("YES");
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}
}
