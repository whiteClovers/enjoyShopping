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
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.service.IOrderDetailService;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.service.imp.OrderDetailServiceImp;
import com.ckwl.likemoney.order.service.imp.OrderServiceImp;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderDetailConditionView;
import com.ckwl.likemoney.order.view.OrderDetailQueryView;
import com.ckwl.likemoney.order.view.OrderQueryView;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.service.imp.ProductSkuServiceImp;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;

/**
 * Servlet implementation class OrderDetailDaoServlet
 */
@WebServlet("/admin/order/OrderDetailServlet.do")
public class OrderDetailServlet extends BaseServlet {
	private IOrderDetailService iOrderDetailservice = (IOrderDetailService) super.getDaoImpProxyFacroty(OrderDetailServiceImp.class);
	private IOrderService iOrderservice = (IOrderService) super.getDaoImpProxyFacroty(OrderServiceImp.class);
	private IProductSkuService iProductSkuservice = (IProductSkuService) super.getDaoImpProxyFacroty(ProductSkuServiceImp.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
super.doGet(request, response);	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据业务逻辑，查询数据

		String order_code = request.getParameter("order_code");
	    String product_sku_code = request.getParameter("product_sku_code");
	    String order_detail_out = request.getParameter("order_detail_out");
	    if(!StringUtil.isEmpty(order_code)){
	    	order_code = order_code.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(product_sku_code)){
	    	product_sku_code = product_sku_code.trim();//去掉空格
		}
	    if(!StringUtil.isEmpty(order_detail_out)){
	    	order_detail_out = order_detail_out.trim();//去掉空格
		}
	    OrderDetailConditionView OrderDetailConditionView = new OrderDetailConditionView();
	    OrderDetailConditionView.setOrder_code(order_code);
	    OrderDetailConditionView.setProduct_sku_code(product_sku_code);
	    OrderDetailConditionView.setOrder_detail_out(order_detail_out);
		ArrayList<OrderDetailQueryView> listOrderDetail = iOrderDetailservice.list(OrderDetailConditionView);

		// 传递对象数据
		request.setAttribute("listOrderDetail6", listOrderDetail);

		// 页面的跳转：转发
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/order_detail_list.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// s1.取参数
		String OrderDetail_id = request.getParameter("order_detail_id");

		// s2.业务逻辑
		// System.out.println("删除ID:" + studentId7);
		OrderDetail OrderDetail = new OrderDetail();
		OrderDetail.setOrder_detail_id(OrderDetail_id);
		iOrderDetailservice.delete(OrderDetail);

		// s3.页面跳转：重定向
		response.sendRedirect("OrderDetailServlet.do?method=list");

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// S1.获取参数
		String OrderDetailId7 = request.getParameter("order_detail_id");
		OrderConditionView OrderConditionView = new OrderConditionView();
		ArrayList<OrderQueryView> listOrder = iOrderservice.list(OrderConditionView);
		request.setAttribute("listOrder6", listOrder);
		ProductSkuConditionView ProductSkuConditionView = new ProductSkuConditionView();
		ArrayList<ProductSkuQueryView> listProductSku = iProductSkuservice.list(ProductSkuConditionView);
		request.setAttribute("listProductSku6", listProductSku);
		// 根据OrderDetailId是否为空判断是新增还是修改的编辑

		if (StringUtil.isEmpty(OrderDetailId7)) {// 新增
			String displaystatus="none";
			request.setAttribute("displaystatus",displaystatus);
		} else {// 修改
				// S2.业务逻辑操作
			String displaystatus="block";
			request.setAttribute("displaystatus",displaystatus);
			OrderDetail OrderDetail = new OrderDetail();
			OrderDetail.setOrder_detail_id(OrderDetailId7);

			request.setAttribute("OrderDetail4", OrderDetail);

		}

		// S3.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/likemoney/admin/ord/order_detail_edit.jsp").forward(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		// 设置请求与响应的编码

		// S1.接收请求参数
		String order_detail_id = request.getParameter("order_detail_id");
		String product_sku_realPrice = request.getParameter("product_sku_realPrice");
		String order_id = request.getParameter("order_id");//外键
		String product_sku_id = request.getParameter("product_sku_id");
		String order_detail_amount = request.getParameter("order_detail_amount");
		String order_detail_send = request.getParameter("order_detail_send");
		String order_detail_logistics = request.getParameter("order_detail_logistics");
		String order_detail_receive = request.getParameter("order_detail_receive");
		
		String order_detail_evaluate_time = request.getParameter("order_detail_evaluate_time");
		String order_detail_evaluate = request.getParameter("order_detail_evaluate");

		String product_sku_price = request.getParameter("product_sku_price");
		String order_detail_out = request.getParameter("order_detail_out");
		String order_detail_outTime = request.getParameter("order_detail_outTime");
		String order_detail_logistics_time = request.getParameter("order_detail_logistics_time");
		String order_detail_receive_time = request.getParameter("order_detail_receive_time");
		String order_detail_code = request.getParameter("order_detail_code");

		// 根据OrderDetailId是否为空判断是新增还是修改的编辑
		if (StringUtil.isEmpty(order_detail_id)) {// 新增
			
			OrderDetail OrderDetail = new OrderDetail();
			OrderDetail.setOrder_detail_id(order_detail_id);
			OrderDetail.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));
			OrderDetail.setOrder_detail_amount(StringUtil.stringToInteger(order_detail_amount));
			OrderDetail.setOrder_detail_send(order_detail_send);
			OrderDetail.setOrder_detail_logistics(order_detail_logistics);
			OrderDetail.setOrder_detail_receive(order_detail_receive);
			OrderDetail.setOrder_detail_evaluate_time(StringUtil.stringToDate(order_detail_evaluate_time));
			OrderDetail.setOrder_detail_evaluate(order_detail_evaluate);
			OrderDetail.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
			OrderDetail.setProduct_sku_id(product_sku_id);
			OrderDetail.setOrder_id(order_id);
			OrderDetail.setOrder_detail_out(order_detail_out);

			OrderDetail.setOrder_detail_outTime(StringUtil.stringToDate(order_detail_outTime));

			OrderDetail.setOrder_detail_logistics_time(StringUtil.stringToDate(order_detail_logistics_time));
			OrderDetail.setOrder_detail_receive_time(StringUtil.stringToDate(order_detail_receive_time));
			OrderDetail.setOrder_detail_code(order_detail_code);
			iOrderDetailservice.insert(OrderDetail);
		} else {// 修改
				// S2.业务处理：调数据库,略
			OrderDetail OrderDetail = new OrderDetail();
			OrderDetail.setOrder_detail_id(order_detail_id);
			OrderDetail.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));
			OrderDetail.setOrder_detail_amount(StringUtil.stringToInteger(order_detail_amount));
			OrderDetail.setOrder_detail_send(order_detail_send);
			OrderDetail.setOrder_detail_logistics(order_detail_logistics);
			OrderDetail.setOrder_detail_receive(order_detail_receive);
			OrderDetail.setOrder_detail_evaluate_time(StringUtil.stringToDate(order_detail_evaluate_time));
			OrderDetail.setOrder_detail_evaluate(order_detail_evaluate);
			OrderDetail.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
			OrderDetail.setProduct_sku_id(product_sku_id);
			OrderDetail.setOrder_id(order_id);
			OrderDetail.setOrder_detail_out(order_detail_out);

			OrderDetail.setOrder_detail_outTime(StringUtil.stringToDate(order_detail_outTime));

			OrderDetail.setOrder_detail_logistics_time(StringUtil.stringToDate(order_detail_logistics_time));
			OrderDetail.setOrder_detail_code(order_detail_code);
			OrderDetail.setOrder_detail_receive_time(StringUtil.stringToDate(order_detail_receive_time));
			iOrderDetailservice.update(OrderDetail);
		}

		// S3.页面跳转：重定向
		response.sendRedirect("OrderDetailServlet.do?method=list");

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

}
