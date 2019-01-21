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

import com.ckwl.likemoney.system.view.SystemMenuQueryView;

/**
 * Servlet Filter implementation class EncodingFilter
 */

public class AuthorityManageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorityManageFilter() {
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
		System.out.println("权限过滤器开始");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String Url = request.getServletPath();
		System.out.println("Url:"+Url);
		
		String currentUrl = Url.substring(1);
		System.out.println("currentUrl:"+currentUrl);
		
		// 获取权限集合
		HttpSession session = request.getSession();
		ArrayList<SystemMenuQueryView> listMenuQuery = (ArrayList<SystemMenuQueryView>) session.getAttribute("session_listMenuQuery");
		
		boolean b = false;
		
		for (SystemMenuQueryView systemMenuQueryView : listMenuQuery) {
			if (systemMenuQueryView.getUrl().equals(currentUrl)) {
				b = true;
				break;
			}
		}
		if (b) {
			chain.doFilter(servletRequest, servletResponse);
		}else {
			response.sendRedirect(request.getServletContext().getContextPath()+"/AuthorityShowServlet.do");
		}
		
		
		System.out.println("权限过滤结束");
		
	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
