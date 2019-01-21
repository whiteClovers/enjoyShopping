package com.ckwl.likemoney.order.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckwl.likemoney.frame.action.BaseServlet;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.entity.OrderEvaluate;
import com.ckwl.likemoney.order.service.IOrderDetailService;
import com.ckwl.likemoney.order.service.IOrderEvaluateService;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.service.imp.OrderDetailServiceImp;
import com.ckwl.likemoney.order.service.imp.OrderEvaluateServiceImp;
import com.ckwl.likemoney.order.service.imp.OrderServiceImp;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderDetailConditionView;
import com.ckwl.likemoney.order.view.OrderDetailQueryView;
import com.ckwl.likemoney.order.view.OrderEvaluateConditionView;
import com.ckwl.likemoney.order.view.OrderEvaluateQueryView;
import com.ckwl.likemoney.order.view.OrderQueryView;
import com.ckwl.likemoney.user.entity.UserAddress;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.service.imp.UserCustomerServiceImp;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

/**
 * Servlet implementation class OrderEvaluateServlet
 */
@WebServlet("/admin/order/OrderEvaluateServlet.do")
public class OrderEvaluateServlet extends BaseServlet {
	private IOrderEvaluateService iOrderEvaluateservice = (IOrderEvaluateService) super.getDaoImpProxyFacroty(OrderEvaluateServiceImp.class);
	private IOrderDetailService iOrderDetailservice = (IOrderDetailService) super.getDaoImpProxyFacroty(OrderDetailServiceImp.class);
	private IUserCustomerService iUserCustomerService = (IUserCustomerService) super.getDaoImpProxyFacroty(UserCustomerServiceImp.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderEvaluateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	public void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/order_menu.jsp").forward(request, response);
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据
		String order_code = request.getParameter("order_code");
	    String customer_name = request.getParameter("customer_name");
//	    String evaluate_time = request.getParameter("evaluate_time");
	    if(!StringUtil.isEmpty(order_code)){
	    	order_code = order_code.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(customer_name)){
	    	customer_name = customer_name.trim();//去掉空格
		}
//	    if(!StringUtil.isEmpty(order_detail_out)){
//	    	order_detail_out = order_detail_out.trim();//去掉空格
//		}
	    OrderEvaluateConditionView OrderEvaluateConditionView = new OrderEvaluateConditionView();
	    OrderEvaluateConditionView.setOrder_code(order_code);
	    OrderEvaluateConditionView.setCustomer_name(customer_name);;
//	    OrderEvaluateConditionView.setOrder_detail_out(order_detail_out);
		ArrayList<OrderEvaluateQueryView> listOrderEvaluate = iOrderEvaluateservice.list(OrderEvaluateConditionView);
	

		// 传递对象数据
		request.setAttribute("listOrderEvaluate6", listOrderEvaluate);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/order_evaluate_list.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String Evaluate_id = request.getParameter("evaluate_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		OrderEvaluate OrderEvaluate = new OrderEvaluate();
		OrderEvaluate.setEvaluate_id(Evaluate_id);
		iOrderEvaluateservice.delete(OrderEvaluate);

		// s3.页面跳转：重定向
		response.sendRedirect("OrderEvaluateServlet.do?method=list");

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String EvaluateId7 = request.getParameter("evaluate_id");
//		String OrderEvaluate_code = request.getParameter("OrderEvaluate_code");
//		String address_id = request.getParameter("address_id");
//		String customer_id = request.getParameter("customer_id");
//		String OrderEvaluate_date = request.getParameter("OrderEvaluate_date");
//		String OrderEvaluate_status = request.getParameter("OrderEvaluate_status");
//		String OrderEvaluate_sum_money = request.getParameter("OrderEvaluate_sum_money");
//		String OrderEvaluate_paydate = request.getParameter("OrderEvaluate_paydate");

		// 根据OrderEvaluateId是否为空判断是新增还是修改的编辑
		
//		request.setAttribute("listOrder", listOrder);
	//	OrderEvaluateConditionView OrderEvaluateConditionView = new OrderEvaluateConditionView();
		OrderDetailConditionView OrderDetailConditionView = new OrderDetailConditionView();
		UserCustomerConditionView UserCustomerConditionView = new UserCustomerConditionView();
		ArrayList<UserCustomer> listUserCustomer = iUserCustomerService.list(UserCustomerConditionView);
		ArrayList<OrderDetailQueryView> listOrderDetail = iOrderDetailservice.list(OrderDetailConditionView);
		request.setAttribute("listUserCustomer6", listUserCustomer);
		request.setAttribute("listOrderDetail6", listOrderDetail);
//		request.setAttribute("listUserCustomer6", listUserCustomer);
		if (StringUtil.isEmpty(EvaluateId7)) {// 新增
			String displaystatus="none";
			request.setAttribute("displaystatus",displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus="block";
			request.setAttribute("displaystatus",displaystatus);
			OrderEvaluate OrderEvaluate = new OrderEvaluate();
			OrderEvaluate.setEvaluate_id(EvaluateId7);
//			OrderEvaluate.setOrderEvaluate_code(OrderEvaluate_code);
//			OrderEvaluate.setAddress_id(address_id);
//			OrderEvaluate.setCustomer_id(customer_id);
//			try {
//				OrderEvaluate.setOrderEvaluate_date(StringUtil.stringToDate(OrderEvaluate_date));
//				OrderEvaluate.setOrderEvaluate_paydate(StringUtil.stringToDate(OrderEvaluate_paydate));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			OrderEvaluate.setOrderEvaluate_status(OrderEvaluate_status);
//			OrderEvaluate.setOrderEvaluate_sum_money(StringUtil.stringToBigdecimal(OrderEvaluate_sum_money));
//			

			request.setAttribute("OrderEvaluate4", OrderEvaluate);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/order_evaluate_edit.jsp").forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String evaluate_id = request.getParameter("evaluate_id");
		String evaluate_time = request.getParameter("evaluate_time");
		String order_detail_id = request.getParameter("order_detail_id");//外键
		String customer_id = request.getParameter("customer_id");
		String evaluate_message = request.getParameter("evaluate_message");
		String evaluate_img = request.getParameter("evaluate_img");
		String evaluate_service = request.getParameter("evaluate_service");
		String evaluate_amount = request.getParameter("evaluate_amount");
		String evaluate_bad = request.getParameter("evaluate_bad");
		
		String evaluate_good = request.getParameter("evaluate_good");
		String evaluate_common = request.getParameter("evaluate_common");
		String evaluate_speed = request.getParameter("evaluate_speed");
		String evaluate_describe = request.getParameter("evaluate_describe");

		// 根据OrderEvaluateId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(evaluate_id)) {// 新增
			
			OrderEvaluate OrderEvaluate = new OrderEvaluate();
			OrderEvaluate.setOrder_detail_id(order_detail_id);
			OrderEvaluate.setCustomer_id(customer_id);
			OrderEvaluate.setEvaluate_time(StringUtil.stringToDate(evaluate_time));
			OrderEvaluate.setEvaluate_message(evaluate_message);
			OrderEvaluate.setEvaluate_img(evaluate_img);
			OrderEvaluate.setEvaluate_service(evaluate_service);
			OrderEvaluate.setEvaluate_amount(StringUtil.stringToInteger(evaluate_amount));
			OrderEvaluate.setEvaluate_bad(StringUtil.stringToInteger(evaluate_bad));
			OrderEvaluate.setEvaluate_good(StringUtil.stringToInteger(evaluate_good));
			OrderEvaluate.setEvaluate_common(StringUtil.stringToInteger(evaluate_common));

//			OrderEvaluate.setOrder_detail_id(order_detail_id);

			OrderEvaluate.setEvaluate_speed(evaluate_speed);

			OrderEvaluate.setEvaluate_describe(evaluate_describe);
//			OrderEvaluate.setCustomer_id(customer_id);
			iOrderEvaluateservice.insert(OrderEvaluate);
		} else {// 修改
				// S2.业务处理：调数据库,略
			OrderEvaluate OrderEvaluate = new OrderEvaluate();
			OrderEvaluate.setEvaluate_id(evaluate_id);
			OrderEvaluate.setOrder_detail_id(order_detail_id);
			OrderEvaluate.setCustomer_id(customer_id);
			OrderEvaluate.setEvaluate_time(StringUtil.stringToDate(evaluate_time));
			OrderEvaluate.setEvaluate_message(evaluate_message);
			OrderEvaluate.setEvaluate_img(evaluate_img);
			OrderEvaluate.setEvaluate_service(evaluate_service);
			OrderEvaluate.setEvaluate_amount(StringUtil.stringToInteger(evaluate_amount));
			OrderEvaluate.setEvaluate_bad(StringUtil.stringToInteger(evaluate_bad));
			OrderEvaluate.setEvaluate_good(StringUtil.stringToInteger(evaluate_good));
			OrderEvaluate.setEvaluate_common(StringUtil.stringToInteger(evaluate_common));

//			OrderEvaluate.setOrder_detail_id(order_detail_id);

			OrderEvaluate.setEvaluate_speed(evaluate_speed);

			OrderEvaluate.setEvaluate_describe(evaluate_describe);
//			OrderEvaluate.setCustomer_id(customer_id);
			iOrderEvaluateservice.update(OrderEvaluate);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("OrderEvaluateServlet.do?method=list");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
