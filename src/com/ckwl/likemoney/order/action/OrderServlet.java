package com.ckwl.likemoney.order.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.bas.constant.DictConstant;
import com.ckwl.likemoney.bas.service.IDictionariesDetailService;
import com.ckwl.likemoney.bas.service.imp.DictionariesDetailServiceImpl;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;
import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.service.imp.OrderServiceImp;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserAddressService;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserAddressServiceImp;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserAddressConditionView;
import com.ckwl.likemoney.user.view.UserAddressQueryView;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/admin/order/OrderServlet.do")
public class OrderServlet extends BaseServlet {
	private IOrderService iOrderservice = (IOrderService) super.getDaoImpProxyFacroty(OrderServiceImp.class);
	private IUserCustomerService iUserCustomerservice = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);
	private IUserAddressService iUserAddressservice = (IUserAddressService) super.getDaoImpProxyFacroty(UserAddressServiceImp.class);
	private IDictionariesDetailService iDictionariesDetailService=(IDictionariesDetailService) super.getDaoImpProxyFacroty(DictionariesDetailServiceImpl.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

	}

    public void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/order_menu.jsp").forward(request, response);
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
		String order_code = request.getParameter("order_code");
	    String order_status = request.getParameter("order_status");
	    String customer_name = request.getParameter("customer_name");
	    if(!StringUtil.isEmpty(order_code)){
	    	order_code = order_code.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(order_status)){
	    	order_status = order_status.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(customer_name)){
	    	customer_name = customer_name.trim();//去掉空格
		}
	    OrderConditionView OrderConditionView = new OrderConditionView();
	    OrderConditionView.setOrder_code(order_code);
	    OrderConditionView.setOrder_status(order_status);
	    OrderConditionView.setCustomer_name(customer_name);
		ArrayList<OrderQueryView> listOrder = iOrderservice.list(OrderConditionView);
	

		// 传递对象数据
		request.setAttribute("listOrder6", listOrder);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/order_list.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String order_id = request.getParameter("order_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		Order Order = new Order();
		Order.setOrder_id(order_id);
		iOrderservice.delete(Order);

		// s3.页面跳转：重定向
		response.sendRedirect("OrderServlet.do?method=list");

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String OrderId7 = request.getParameter("order_id");
//		String order_code = request.getParameter("order_code");
//		String address_id = request.getParameter("address_id");
//		String customer_id = request.getParameter("customer_id");
//		String order_date = request.getParameter("order_date");
//		String order_status = request.getParameter("order_status");
//		String order_sum_money = request.getParameter("order_sum_money");
//		String order_paydate = request.getParameter("order_paydate");

		// 根据OrderId是否为空判断是新增还是修改的编辑

		UserCustomerConditionView UserCustomerConditionView = new UserCustomerConditionView();
		UserAddressConditionView UserAddressConditionView = new UserAddressConditionView();
		ArrayList<UserCustomer> listUserCustomer = iUserCustomerservice.list(UserCustomerConditionView);
		ArrayList<UserAddressQueryView> listUserAddress = iUserAddressservice.select(UserAddressConditionView);
		ArrayList<DictionariesDetailQueryView> listDictionariesDetail = (ArrayList<DictionariesDetailQueryView>) iDictionariesDetailService.findByDictCode(DictConstant.ORDER_STATUS);
		request.setAttribute("listUserCustomer6", listUserCustomer);
		request.setAttribute("listUserAddress6", listUserAddress);
		request.setAttribute("listDictionariesDetail6", listDictionariesDetail);
		if (StringUtil.isEmpty(OrderId7)) {// 新增
			String displaystatus="none";
			request.setAttribute("displaystatus",displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus="block";
			request.setAttribute("displaystatus",displaystatus);
			Order Order = new Order();
			Order.setOrder_id(OrderId7);
//			Order.setOrder_code(order_code);
//			Order.setAddress_id(address_id);
//			Order.setCustomer_id(customer_id);
//			try {
//				Order.setOrder_date(StringUtil.stringToDate(order_date));
//				Order.setOrder_paydate(StringUtil.stringToDate(order_paydate));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Order.setOrder_status(order_status);
//			Order.setOrder_sum_money(StringUtil.stringToBigdecimal(order_sum_money));
//			

			request.setAttribute("Order4", Order);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/order_edit.jsp").forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String order_id = request.getParameter("order_id");
		String order_code = request.getParameter("order_code");
		String address_id = request.getParameter("address_id");//外键
		String customer_id = request.getParameter("customer_id");
		String order_date = request.getParameter("order_date");
		String order_status = request.getParameter("order_status");
		String order_sum_money = request.getParameter("order_sum_money");
		String order_paydate = request.getParameter("order_paydate");

		// 根据OrderId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(order_id)) {// 新增
			
			Order Order = new Order();
			
			Order.setOrder_code(order_code);
			Order.setAddress_id(address_id);
			Order.setCustomer_id(customer_id);
			Order.setOrder_date(StringUtil.stringToDate(order_date));
			Order.setOrder_status(order_status);
			Order.setOrder_sum_money(StringUtil.stringToBigdecimal(order_sum_money));
			Order.setOrder_paydate(StringUtil.stringToDate(order_paydate));
			iOrderservice.insert(Order);
		} else {// 修改
				// S2.业务处理：调数据库,略
			Order Order = new Order();
			Order.setOrder_id(order_id);
			Order.setOrder_code(order_code);
			Order.setAddress_id(address_id);
			Order.setCustomer_id(customer_id);
			Order.setOrder_date(StringUtil.stringToDate(order_date));
			Order.setOrder_status(order_status);
			Order.setOrder_sum_money(StringUtil.stringToBigdecimal(order_sum_money));
			Order.setOrder_paydate(StringUtil.stringToDate(order_paydate));
			iOrderservice.update(Order);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("OrderServlet.do?method=list");

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
