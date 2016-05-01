package cn.wxjia.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeviceInformationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeviceInformationServlet() {
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
		Set<String> set = map.keySet();

		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String[] value = map.get(key);
			out.print(key);
			out.print(" = ");
			out.println(value[0]);

		}

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
