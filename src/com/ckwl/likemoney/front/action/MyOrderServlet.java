package com.ckwl.likemoney.front.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.service.imp.OrderServiceImp;
import com.ckwl.likemoney.order.view.OrderQueryView;

/**
 * Servlet implementation class wddd233Serverlet
 */
@WebServlet("/user/MyOrderServerlet.do")
public class MyOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IOrderService iOrderservice = (IOrderService) super.getDaoImpProxyFacroty(OrderServiceImp.class);
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
	
    	HttpSession session = request.getSession();
    	String customer_id=(String) session.getAttribute("customerId");
    	
    	// 分页
    	String pageIndexStr = request.getParameter("pageIndex");
    	Integer pageIndex = 0 ;
    	if (!StringUtil.isEmpty(pageIndexStr)) {
			pageIndex = Integer.valueOf(pageIndexStr);
		}
    	
    	String pageSizeStr = request.getParameter("pageSize");
    	Integer pageSize = 0 ;
    	if (!StringUtil.isEmpty(pageSizeStr)) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
	
		ArrayList<OrderQueryView> listMyOrder = iOrderservice.listView(customer_id);

		// 传递对象数据
		request.setAttribute("listMyOrder6", listMyOrder);
		
		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/front/MyOrder.jsp").forward(request, response);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
