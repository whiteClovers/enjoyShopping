package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.cart.dao.imp.CartDaoImp;
import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.cart.service.ICartService;
import com.ckwl.likemoney.cart.service.imp.CartServiceImp;
import com.ckwl.likemoney.cart.view.CartConditionView;
import com.ckwl.likemoney.cart.view.CartQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.front.view.MyCartQueryView;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;

/**
 * Servlet implementation class CartSettle
 */
@WebServlet("/user/CartSettle.do")
public class CartSettleServlet extends BaseServlet {
	private ICartService iCartservice = (ICartService) super.getDaoImpProxyFacroty(CartServiceImp.class);
	private IProductSkuService iProductSkuservice = (IProductSkuService) super.getDaoImpProxyFacroty(
			ProductSkuServiceImp.class);
	private IUserCustomerService iUserCustomerservice = (IUserCustomerService) super.getDaoImpProxyFacroty(
			UserCustomerServiceImp.class);

	private ICartService cartService = (ICartService) super.getDaoImpProxyFacroty(CartServiceImp.class);
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartSettleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
//		String customer_name = request.getParameter("customer_name");
//		String car_select = request.getParameter("car_select");
//		String car_detect = request.getParameter("car_detect");
//		String car_date = request.getParameter("car_date");
//		request.setAttribute("customer_name", customer_name);
//		request.setAttribute("car_select", car_select);
//		request.setAttribute("car_detect", car_detect);
		
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		ArrayList<MyCartQueryView> listMyCart;
		if (customerId==null) {
			listMyCart = iCartservice.listView(new CartConditionView());
		}else{
			listMyCart = cartService.listByCustomerId(customerId);
		}
		// 传递对象数据
		request.setAttribute("listMyCart6", listMyCart);
		
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/CartSettle.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unused")
	private void deleteByCarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carId = request.getParameter("carId");
		
		Cart cart = new Cart();
		cart.setCar_id(carId);
		
		iCartservice.delete(cart);
		System.out.println("删除成功");
		
		response.sendRedirect(request.getServletContext().getContextPath()+"/user/CartSettle.do?method=list");
	}

}
