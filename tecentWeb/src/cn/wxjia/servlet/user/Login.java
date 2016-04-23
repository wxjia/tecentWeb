package cn.wxjia.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wxjia.dao.user.LoginRecordDao;
import cn.wxjia.dao.user.UserDao;
import cn.wxjia.pojo.LoginRecord;

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
		if (false == ret) {
			// 登录失败
			request.setAttribute("loginFaliure", "true");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}

		// identifyCode
		HttpSession session = request.getSession();
		String inputIdentifyCode = request.getParameter("inputIdentifyCode");
		if (null == inputIdentifyCode || "".equals(inputIdentifyCode)) {
			// 登录失败
			request.setAttribute("loginFaliure", "true");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}

		request.setAttribute("loginSuccess", "true");
		session.setAttribute("username", username);
		// session.setAttribute("realname", realname);

		String ip = (String) session.getAttribute("ip");
		String address = (String) session.getAttribute("address");

		String browser = "unkonwn browser";
		String os = "unknown os";
		LoginRecord loginRecord = new LoginRecord(username, null, ip, address,
				browser, os);

		LoginRecordDao loginRecordDao = new LoginRecordDao();
		boolean retLoginRecord = loginRecordDao.insertLoginRecord(loginRecord);
		if (retLoginRecord) {
			System.out.println(username + " 登录记录插入成功");
		} else {
			System.out.println(username + " 登录记录插入失败");
		}

		if ("emma.lp.young@qq.com".equals(username)) {
			request.getRequestDispatcher("/jsp/index.jsp").forward(request,
					response);
			return;
		}
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
