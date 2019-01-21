package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.system.view.SystemMenuQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class loginServerlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
    
	// 登录
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/Login.jsp").forward(request, response);
	}
	
	// 登录
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从页面获取请求参数
		String customerPhone = request.getParameter("customerPhone");
		String customerPwd = request.getParameter("password");
		
		// session
		UserCustomer customer = new UserCustomer();
		customer = iUserCustomerService.login(customerPhone, customerPwd);
		
		HttpSession session = request.getSession();
//		ArrayList<SystemMenuQueryView> listMenuQuery = (ArrayList<SystemMenuQueryView>) session.getAttribute("session_listMenuQuery");
		
		// 用户登录，如果customer不为空，则用户存在，登录成功
		if (customer.getCustomerId()!=null) {
			
			System.out.println("登录成功");
			System.out.println("customerPhone"+customerPhone);
			System.out.println("customerPwd"+customerPwd);
			/*session.setAttribute("customer", customer);*/
			
			session.setAttribute("customerId", customer.getCustomerId());
			session.setAttribute("customerName", customer.getCustomerName());
			session.setAttribute("session_customer", customer);
			
			response.sendRedirect(request.getServletContext().getContextPath()+"/user/HomepageServlet.do");
		}else {
			System.out.println("登录失败");
			System.out.println("customerPhone"+customerPhone);
			System.out.println("customerPwd"+customerPwd);
			request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/front_login_error.jsp").forward(request, response);
		}
		
	}


}
