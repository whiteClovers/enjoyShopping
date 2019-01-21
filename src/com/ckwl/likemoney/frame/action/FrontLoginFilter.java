package com.ckwl.likemoney.frame.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.user.entity.UserCustomer;

/**
 * Servlet Filter implementation class EncodingFilter
 */

public class FrontLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FrontLoginFilter() {
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
		// 前台用户filter
		System.out.println("前台过滤器开始");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		UserCustomer customer = (UserCustomer) session.getAttribute("session_customer");
		
		/*// 获取context路劲
		String contextPath = request.getServletContext().getContextPath();
		System.out.println("contextPath="+contextPath);
		
		// 获取当前URL路劲
		String requestURI = request.getRequestURI();
		System.out.println("requestURI="+requestURI);
		
		// 获取具体字符串
		String currentUrl = requestURI.substring(contextPath.length()+"/user/".length());
		System.out.println("currentUrl="+currentUrl);*/
		
		String Url = request.getServletPath();
		System.out.println("Url:"+Url);
		
		String currentUrl = Url.substring(1);
		System.out.println("currentUrl:"+currentUrl);
		
		List<String> listUrl = new ArrayList<String>();
		listUrl.add("user/SettlementServerlet.do");
		listUrl.add("user/PayServlet.do");
		listUrl.add("user/MyOrderServerlet.do");
		listUrl.add("user/OrderDetailFrontServlet.do");
		listUrl.add("user/MyCenterServerlet.do");
		listUrl.add("user/MyInformServerlet.do");
		listUrl.add("user/EvaluateCenterServlet.do");
		listUrl.add("user/ReceivingAddressServlet.do");
		listUrl.add("user/AddtoCart.do");
		listUrl.add("user/CartSettle.do");
		
		// ftqStore/admin/HomepageServlet.do
		if (customer==null && listUrl.contains(currentUrl)) {
			System.out.println("即将前往登录页");
			response.sendRedirect(request.getServletContext().getContextPath()+"/LoginServlet.do?method=list");
			System.out.println("进入登录页");
		}else {
			chain.doFilter(servletRequest, servletResponse);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
