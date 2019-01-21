package com.ckwl.likemoney.order.view;

import com.ckwl.likemoney.order.entity.OrderEvaluate;

public class OrderEvaluateQueryView extends OrderEvaluate {
private String customer_name;

private String order_detail_code;
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}

public String getOrder_detail_code() {
	return order_detail_code;
}
public void setOrder_detail_code(String order_detail_code) {
	this.order_detail_code = order_detail_code;
}
}
