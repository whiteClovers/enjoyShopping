package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;

/**
 * Servlet implementation class zcServerlet
 */

@WebServlet("/user/RegisterServlet.do")
public class RegisterServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
       
	// 注册
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/Register.jsp").forward(request, response);
	}
	
	protected void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收客户端发送的数据customerName
		String customerName = request.getParameter("customerName");
		
		// 页面交互逻辑
		// 如果查询该用户存在，返回true，否则返回false
		boolean b = iUserCustomerService.checkName(customerName);
		
		// 向客户端响应
		PrintWriter out = response.getWriter();
		out.print(b);
	}
	
	// 注册
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收用户输入
		String customerPhone = request.getParameter("customerPhone");
		String customerName = request.getParameter("customerName");
		String customerNickName = request.getParameter("customerNickName");
		String customerPwd = request.getParameter("customerPwd");
		String customerEmail = request.getParameter("customerEmail");
		
		UserCustomer customer = new UserCustomer();
		customer.setCustomerName(customerName);
		customer.setCustomerNickName(customerNickName);
		customer.setCustomerPwd(customerPwd);
		customer.setCustomerPhone(customerPhone);
		customer.setCustomerEmail(customerEmail);
		
		// 进行注册
		boolean registerCustomer = iUserCustomerService.register(customer);
		
		if (registerCustomer) {
			response.getWriter().println("<script>alert(\"注册成功，赶快去登录吧\");</script>");
		}
		if (registerCustomer) {
			
			try {
				Thread.currentThread().sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect(request.getServletContext().getContextPath()+"/LoginServlet.do");
		}else{
			response.getWriter().println("<script>alert(\"注册失败\");</script>");
			request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/front_register_error.jsp");
		}
		
	}


}
