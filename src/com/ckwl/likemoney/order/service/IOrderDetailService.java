package com.ckwl.likemoney.order.service;

import java.util.ArrayList;

import com.ckwl.likemoney.front.view.OrderDetailFrontQueryView;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.view.OrderDetailConditionView;
import com.ckwl.likemoney.order.view.OrderDetailQueryView;
import com.ckwl.likemoney.product.entity.ProductSku;

public interface IOrderDetailService {
	public void insert(OrderDetail OrderDetail);
	public void delete(OrderDetail OrderDetail);
	public void update(OrderDetail OrderDetail);
	public ArrayList<OrderDetailQueryView> list(OrderDetailConditionView OrderDetailConditionView) ;
	public ArrayList<OrderDetailFrontQueryView> list(String order_id);
	public ArrayList<OrderDetailFrontQueryView> listView(String order_id);
	
	public OrderDetailFrontQueryView listByDetailId(String orderDetailId);

}
