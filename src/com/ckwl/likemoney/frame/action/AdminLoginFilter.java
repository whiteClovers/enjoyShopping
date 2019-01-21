package com.ckwl.likemoney.frame.action;

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

import com.ckwl.likemoney.system.entity.SystemEmployee;

/**
 * Servlet Filter implementation class EncodingFilter
 */

public class AdminLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		// 后台登录过滤器
		System.out.println("后台登录过滤开始");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		SystemEmployee employee = (SystemEmployee) session.getAttribute("session_employee");
		
		if (employee==null) {
			System.out.println("即将前往登录页");
			response.sendRedirect(request.getServletContext().getContextPath()+"/LoginAdmin.do?method=list");
			System.out.println("进入登录页");
		}else {
			chain.doFilter(servletRequest, servletResponse);
		}
		System.out.println("后台登录过滤结束");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
