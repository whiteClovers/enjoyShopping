package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.cart.dao.imp.CartDaoImp;
import com.ckwl.likemoney.cart.service.ICartService;
import com.ckwl.likemoney.cart.service.imp.CartServiceImp;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.front.view.MyCartQueryView;
import com.ckwl.likemoney.order.dao.IOrderDaoImp;
import com.ckwl.likemoney.order.dao.imp.OrderDaoImp;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.service.IOrderDetailService;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.service.imp.OrderDetailServiceImp;
import com.ckwl.likemoney.order.service.imp.OrderServiceImp;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/user/PayServlet.do")
public class PayServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private IOrderService iOrderService = (IOrderService) super.getDaoImpProxyFacroty(OrderServiceImp.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void orderSubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取customerId
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		
		BigDecimal priceSumS = (BigDecimal) session.getAttribute("priceSumS");
		request.setAttribute("priceSumS", priceSumS);
		
		List<ArrayList<MyCartQueryView>> listCarts = (List<ArrayList<MyCartQueryView>>) session.getAttribute("listCarts");
		
		// 调用orderService的inputOrder()
		String order_id = iOrderService.inputOrder(listCarts, priceSumS, customerId);
		session.setAttribute("order_id", order_id);
		
//		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/Pay.jsp").forward(request, response);	
		response.sendRedirect(request.getServletContext().getContextPath()+"/user/MyOrderServerlet.do");
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/Pay.jsp").forward(request, response);	
	}
}
