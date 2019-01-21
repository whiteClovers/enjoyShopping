 package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserAddressService;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserAddressServiceImp;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.ReceivingAddressQueryView;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class shouhuodizhiServerlet
 * 收货地址
 * @author lwh
 *
 */
@WebServlet("/user/ReceivingAddressServlet.do")
public class ReceivingAddressServlet extends BaseServlet {
	private IUserAddressService iUserAddressService = (IUserAddressService) super.getDaoImpProxyFacroty(UserAddressServiceImp.class);
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceivingAddressServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserCustomer customer = (UserCustomer) request.getSession().getAttribute("session_customer");
		String userCustomerId = customer.getCustomerId();
		UserCustomerConditionView conditionView = new UserCustomerConditionView();
		conditionView.setCustomerId(userCustomerId);
		ArrayList<UserCustomer> arrayList = iUserCustomerService.list(conditionView);
		ArrayList<ReceivingAddressQueryView> listView = iUserAddressService.listView(userCustomerId);
		request.setAttribute("listView", listView);
		request.setAttribute("userList", arrayList);
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/ReceivingAddress.jsp").forward(request, response);
	}
}
