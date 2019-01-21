package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;

/**
 * Servlet implementation class myDetailServerlet 我的详情
 * 
 * @author lwh
 */
@WebServlet("/user/MyInformServerlet.do")
public class MyInformServlet extends BaseServlet {
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(
			UserCustomerServiceImp.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyInformServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String customerId = request.getParameter("customerId");
		String customerId = "1";
		// 需要传入一个id
		// 然后根据id来查数据
		UserCustomer userCustomer = iUserCustomerService.load(customerId);
		// 对日期进行处理
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(userCustomer.getCustomerBirthday());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		request.setAttribute("years", year);
		request.setAttribute("months", month);
		request.setAttribute("dates", date);

		request.setAttribute("user", userCustomer);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/MyInform.jsp").forward(request, response);
	}
}
