package cn.wxjia.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wxjia.dao.LeaveWordDao;
import cn.wxjia.pojo.LeaveWordBean;

public class LeaveWord extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LeaveWord() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String userComment = request.getParameter("userComment");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (null == userComment || "".equals(userComment)) {
			System.out.println("评论为空");
			request.setAttribute("commentSuccess", "false");
			request.getRequestDispatcher("/jsp/main.jsp").forward(request,
					response);
			return;
		}

		if (null == username || "".equals(username)) {
			System.out.println("非法用户试图留言");
			request.getRequestDispatcher("/jsp/main.jsp").forward(request,
					response);
			return;
		}

		LeaveWordBean leaveWordBean = new LeaveWordBean(username, null,
				userComment);
		LeaveWordDao leaveWordDao = new LeaveWordDao();
		boolean insertLeaveWord = leaveWordDao.insertLeaveWord(leaveWordBean);
		if (insertLeaveWord == false) {
			System.out.println("评论提交失败");
			request.setAttribute("commentSuccess", "false");
			request.getRequestDispatcher("/jsp/main.jsp").forward(request,
					response);
			return;
		}

		System.out.println("评论提交成功");
		request.setAttribute("commentSuccess", "true");
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
