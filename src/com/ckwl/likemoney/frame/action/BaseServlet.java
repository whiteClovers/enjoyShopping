package com.ckwl.likemoney.frame.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.dao.proxy.DaoImpProxyFactory;
import com.ckwl.likemoney.frame.util.StringUtil;

/**
 * Servlet implementation class BaseServlet
 */

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求与响应的编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String methodName = request.getParameter("method");
		if (StringUtil.isEmpty(methodName)) {
			methodName = "list";
		}

		Class<?> clazz = this.getClass();
		try {

			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);

			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected Object getDaoImpProxyFacroty(Class<?> clazz) {
		return DaoImpProxyFactory.getProxyInstance(clazz);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
