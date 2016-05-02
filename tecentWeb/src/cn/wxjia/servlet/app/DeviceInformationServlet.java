package cn.wxjia.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wxjia.dao.app.AppVisitDao;
import cn.wxjia.pojo.app.AppVisitBean;

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
		
		String teleNumber = map.get("teleNumber")[0];
		String ip = map.get("ip")[0];
		String address = map.get("address")[0];
		String mType = map.get("mType")[0];
		int mWidth = Integer.valueOf(map.get("mWidth")[0]);
		int mHeight = Integer.valueOf(map.get("mHeight")[0]);
		String imei = map.get("imei")[0];
		String macAddress = map.get("macAddress")[0];

		AppVisitBean bean = new AppVisitBean(0, teleNumber, null, ip, address,
				mType, mWidth, mHeight, imei, macAddress);

		AppVisitDao appVisitDao = new AppVisitDao();
		appVisitDao.insertAppVisiterData(bean);

		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
