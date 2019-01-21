package com.ckwl.likemoney.order.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.front.view.MyOrderQueryView;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderQueryView;


public interface IOrderDaoImp {
	public void insert(Order order);
	public void delete(Order order);
	public void update(Order order);
	public ArrayList<OrderQueryView> list(OrderConditionView OrderConditionView);
	public ArrayList<MyOrderQueryView> list(String customer_id);
	public ArrayList<Order> listorder(String  order_id);

	// 分页
	public ArrayList<OrderQueryView> listOrd(OrderConditionView OrderConditionView ,int pageIndex ,int pageSize);
	public int recordCount(OrderConditionView OrderConditionView);
	
}
