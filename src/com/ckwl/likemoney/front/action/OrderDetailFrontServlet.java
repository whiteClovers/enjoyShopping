package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.front.view.OrderDetailFrontQueryView;
import com.ckwl.likemoney.order.service.IOrderDetailService;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.service.imp.OrderDetailServiceImp;
import com.ckwl.likemoney.order.service.imp.OrderServiceImp;
import com.ckwl.likemoney.order.view.OrderQueryView;

/**
 * Servlet implementation class orderDetailServlet
 */
@WebServlet("/user/OrderDetailFrontServlet.do")
public class OrderDetailFrontServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IOrderDetailService iOrderDetailService = (IOrderDetailService) super.getDaoImpProxyFacroty(OrderDetailServiceImp.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailFrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	 private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 根据业务逻辑，查询数据
//		 	String order_id = request.getParameter("order_id");
		 
		 	HttpSession session = request.getSession();
		 	String order_id = (String) session.getAttribute("order_id");
		 
		 	// 根据order_detail_id查询所对应订单详情
		 	
			ArrayList<OrderDetailFrontQueryView> listOrderDetailFront = iOrderDetailService.listView(order_id);
		
			// 传递对象数据
			request.setAttribute("listOrderDetailFront6", listOrderDetailFront);

			// 页面的跳转：转发
			request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/OrderDetail.jsp").forward(request, response);

		}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
