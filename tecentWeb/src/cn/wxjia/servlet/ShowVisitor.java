package cn.wxjia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wxjia.dao.GetVisiterDao;
import cn.wxjia.pojo.NewVisiterBean;

public class ShowVisitor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ShowVisitor() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<NewVisiterBean> list = new GetVisiterDao().getVisiterData();

		request.setAttribute("list", list);
		request.setAttribute("listSize", list.size());
		request.getRequestDispatcher("/jsp/showVisit.jsp").forward(request,
				response);

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
