package cn.wxjia.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wxjia.dao.NewVisiterDao;
import cn.wxjia.pojo.NewVisiterBean;
import cn.wxjia.util.GetAddressByIp;

public class DefaultFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化过滤器");
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("进入过滤器");

		servletRequest.setCharacterEncoding("utf-8");
		servletResponse.setCharacterEncoding("utf-8");

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

		httpServletRequest.setCharacterEncoding("utf-8");
		httpServletResponse.setCharacterEncoding("utf-8");

		HttpSession httpSession = httpServletRequest.getSession();

		String initConnect = (String) httpSession.getAttribute("initConnect");
		if (null == initConnect || "".equals(initConnect)) {
			// 获取访客ip
			String ip = servletRequest.getRemoteAddr();

			String address = GetAddressByIp
					.getAddress(
							"http://api.map.baidu.com/location/ip?ak=Yb1bpWVTGKLjAoanl5vIktfL31peMP72",
							ip);

			if (null == address) {
				address = "获取地址失败";
			}
			String userAgent = httpServletRequest.getHeader("User-Agent");
			// Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like
			// Gecko
			NewVisiterBean visiterBean = new NewVisiterBean(ip, null, address,
					userAgent);

			new NewVisiterDao().insertNewVisiterData(visiterBean);
		}
		httpSession.setAttribute("initConnect", "initConnect");

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("销毁过滤器");
	}
}