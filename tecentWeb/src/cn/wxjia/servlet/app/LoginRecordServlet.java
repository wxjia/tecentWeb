package cn.wxjia.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wxjia.dao.app.AppLoginRecordDao;
import cn.wxjia.pojo.app.AppLoginRecordBean;

public class LoginRecordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginRecordServlet() {
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
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		Map<String, String[]> map = request.getParameterMap();

		String username = map.get("username")[0];
		String ip = map.get("ip")[0];
		String address = map.get("address")[0];
		String teleNumber = map.get("teleNumber")[0];
		String providersName = map.get("providersName")[0];
		String screen = map.get("screen")[0];
		String apps = map.get("apps")[0];
		String contacts = map.get("contacts")[0];

		System.out.println("providersName = " + providersName);
		System.out.println("contacts = " + contacts);

		AppLoginRecordDao appLoginRecordDao = new AppLoginRecordDao();
		AppLoginRecordBean appLoginRecordBean = new AppLoginRecordBean(0,
				username, null, ip, address, teleNumber, providersName, screen,
				apps, contacts, null, null, null);
		boolean ret = appLoginRecordDao
				.insertAppVisiterData(appLoginRecordBean);
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
