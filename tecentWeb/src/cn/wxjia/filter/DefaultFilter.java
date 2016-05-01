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

import cn.wxjia.dao.VisiterDao;
import cn.wxjia.pojo.WebVisitBean;
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

		String ip = (String) httpSession.getAttribute("ip");
		if (null == ip || "".equals(ip)) {
			// 获取访客ip
			ip = servletRequest.getRemoteAddr();

			String address = GetAddressByIp
					.getAddress(
							"http://api.map.baidu.com/location/ip?ak=Yb1bpWVTGKLjAoanl5vIktfL31peMP72",
							ip);

			if (null == address) {
				address = "获取地址失败";
			}
			String userAgent = httpServletRequest.getHeader("User-Agent");
			WebVisitBean visiterBean = new WebVisitBean(0, ip, null, address,
					userAgent);

			new VisiterDao().insertNewVisiterData(visiterBean);
			httpSession.setAttribute("ip", ip);
			httpSession.setAttribute("address", address);
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("销毁过滤器");
	}
}
