package com.ckwl.likemoney.order.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ckwl.likemoney.cart.dao.imp.CartDaoImp;
import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.frame.util.PageUtil;
import com.ckwl.likemoney.frame.view.PageView;
import com.ckwl.likemoney.front.view.MyCartQueryView;
import com.ckwl.likemoney.front.view.MyOrderQueryView;
import com.ckwl.likemoney.front.view.OrderDetailFrontQueryView;
import com.ckwl.likemoney.order.dao.IOrderDaoImp;
import com.ckwl.likemoney.order.dao.imp.OrderDaoImp;
import com.ckwl.likemoney.order.dao.imp.OrderDetailDaoImp;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.service.IOrderService;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderDetailQueryView;
import com.ckwl.likemoney.order.view.OrderQueryView;



public class OrderServiceImp implements IOrderService {
private IOrderDaoImp OrderDao = new OrderDaoImp(); 
	
	@MyTransaction(readOnly=false)
	/**代理*/
	public void insert(Order Order) {		
		
		 OrderDao.insert(Order);
	}

	@MyTransaction(readOnly=false)
	public void delete(Order Order) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		OrderDao.delete(Order);
	}

	@MyTransaction(readOnly=false)
	public void update(Order Order) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		OrderDao.update(Order);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<OrderQueryView> list(OrderConditionView OrderConditionView) {
		// TODO Auto-generated method stub
		return OrderDao.list(OrderConditionView);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<MyOrderQueryView> list(String order_id) {
		// TODO Auto-generated method stub
		return OrderDao.list(order_id);
	}
	
	@MyTransaction(readOnly=true)
	public ArrayList<OrderQueryView> listView(String customer_id){
		 ArrayList<OrderQueryView> listOrderOrderQueryView = new ArrayList<OrderQueryView>();
		 ArrayList<Order> listOrder = this.listorder(customer_id) ;
		 for (Order Order : listOrder) {
			OrderQueryView orderQueryView=new OrderQueryView();
			orderQueryView.setOrder_id(Order.getOrder_id());
			orderQueryView.setOrder_code(Order.getOrder_code());
			orderQueryView.setOrder_date(Order.getOrder_date());
			
			 ArrayList<MyOrderQueryView> listMyOrder= OrderDao.list(Order.getOrder_id()) ;
			 orderQueryView.setListMyOrder(listMyOrder);
			 listOrderOrderQueryView.add(orderQueryView);
		}
		 
		 return listOrderOrderQueryView ;
		
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<Order> listorder(String customer_id) {
		// TODO Auto-generated method stub
		return OrderDao.listorder(customer_id);
	}
	
	@MyTransaction(readOnly=false)
	// 提交订单后，增加一个订单，一个订单详情，删除购物车3个操作
	public String inputOrder(List<ArrayList<MyCartQueryView>> listCarts,BigDecimal priceSumS,String customerId){
		OrderDaoImp orderDaoImp = new OrderDaoImp();
		OrderDetailDaoImp detailDaoImp = new OrderDetailDaoImp();
		CartDaoImp cartDaoImp = new CartDaoImp();
		// 根据customerId查询到该用户的购物车中delete为true的商品，即为一笔订单,
		// 先添加订单，需要添加一个订单，一个订单详情
		
		// 增加一个订单
		Order order = new Order();
		int order_code = orderDaoImp.findMax();
		
		order.setAddress_id("江西省抚州市临川区");
		order.setCustomer_id(customerId);
		order.setAddress_id("7");
		order.setOrder_status("account paid");
		order.setOrder_sum_money(priceSumS);
		order.setOrder_date(new Date());
		order.setOrder_paydate(new Date());
		order.setOrder_code(String.valueOf(++order_code));
		
		Order order2 = orderDaoImp.insertOrder(order);
		
		// 增加一个订单详情
//		ArrayList<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
		for (ArrayList<MyCartQueryView> listCart : listCarts) {
			OrderDetailFrontQueryView orderDetail = new OrderDetailFrontQueryView();
			for (MyCartQueryView myCartQueryView : listCart) {
				
				orderDetail.setOrder_detail_amount(Integer.valueOf(myCartQueryView.getSku_amount()));
				orderDetail.setProduct_sku_img_small(myCartQueryView.getProduct_sku_img_small());
				orderDetail.setProduct_name(myCartQueryView.getProduct_name());
				orderDetail.setCustomer_name(myCartQueryView.getCustomer_name());
				orderDetail.setProduct_sku_realPrice(priceSumS);

				orderDetail.setOrder_code(order2.getOrder_code());
				
				orderDetail.setProduct_sku_id(myCartQueryView.getProduct_sku_id());
				orderDetail.setOrder_detail_send("yes");
				orderDetail.setOrder_detail_logistics("arrive");
				orderDetail.setOrder_detail_receive("yes");
				orderDetail.setOrder_detail_evaluate("yes");
				orderDetail.setOrder_detail_evaluate_time(new Date());
				orderDetail.setOrder_id(order2.getOrder_id());
				orderDetail.setProduct_sku_price(new BigDecimal(myCartQueryView.getProduct_sku_price()));
				orderDetail.setOrder_detail_out("yes");
				orderDetail.setOrder_detail_outTime(new Date());
				orderDetail.setOrder_detail_logistics_time(new Date());
				orderDetail.setOrder_detail_receive_time(new Date());
				
			}
			detailDaoImp.insert(orderDetail);
		}
		
		// 再删除delete为true的商品
		cartDaoImp.deleteFromCart(customerId);
		
		return order2.getOrder_id();
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<OrderQueryView> listOrd(OrderConditionView OrderConditionView, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return OrderDao.listOrd(OrderConditionView, pageIndex, pageSize);
	}

	@MyTransaction(readOnly=true)
	@Override
	public int recordCount(OrderConditionView OrderConditionView) {
		// TODO Auto-generated method stub
		return OrderDao.recordCount(OrderConditionView);
	}

	@MyTransaction(readOnly=false)
	@Override
	public PageView page(OrderConditionView OrderConditionView, int pageIndex, int pageSize) {
		ArrayList<OrderQueryView> list = OrderDao.listOrd(OrderConditionView, pageIndex, pageSize);
		int recordCount = OrderDao.recordCount(OrderConditionView);
		
		PageView pageView = new PageView();
		
		pageView.setList(list);
		pageView.setPageIndex(pageIndex);
		pageView.setPageSize(pageSize);
		pageView.setRecordCount(recordCount);
		pageView.setPageCount(PageUtil.getPageCount(recordCount, pageSize));
		
		return pageView;
		
	}
	
	
}
