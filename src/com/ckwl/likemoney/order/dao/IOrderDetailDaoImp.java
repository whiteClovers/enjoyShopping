package com.ckwl.likemoney.order.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.front.view.OrderDetailFrontQueryView;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.view.OrderDetailConditionView;
import com.ckwl.likemoney.order.view.OrderDetailQueryView;

public interface IOrderDetailDaoImp {
	public void insert(OrderDetail OrderDetail);
	public void delete(OrderDetail OrderDetail);
	public void update(OrderDetail OrderDetail);
	public ArrayList<OrderDetailQueryView> list(OrderDetailConditionView OrderDetailConditionView) ;
	public ArrayList<OrderDetailFrontQueryView> list(String order_id);
	
	public OrderDetailFrontQueryView listByDetailId(String orderDetailId);
}
