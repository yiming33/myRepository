package me.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by YiMing on 2016/11/2.
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class Myfilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化...");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("过滤器处理中...");
        filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁...");
	}
}
