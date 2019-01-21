package com.ckwl.likemoney.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.frame.view.PageView;
import com.ckwl.likemoney.front.view.MyCartQueryView;
import com.ckwl.likemoney.front.view.MyOrderQueryView;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderQueryView;




public interface IOrderService {
	public void insert(Order Order);
	public void delete(Order Order);
	public void update(Order Order);
	public ArrayList<OrderQueryView> list(OrderConditionView OrderConditionView);
	public ArrayList<MyOrderQueryView> list(String customer_id);
	public ArrayList<OrderQueryView> listView(String customer_id);
	public ArrayList<Order> listorder(String order_id);

	// 提交订单
	public String inputOrder(List<ArrayList<MyCartQueryView>> listCarts,BigDecimal priceSumS,String customerId);
	
	// 分页
	public ArrayList<OrderQueryView> listOrd(OrderConditionView OrderConditionView ,int pageIndex ,int pageSize);
	public int recordCount(OrderConditionView OrderConditionView);
	public PageView page(OrderConditionView OrderConditionView ,int pageIndex ,int pageSize);
	
}
