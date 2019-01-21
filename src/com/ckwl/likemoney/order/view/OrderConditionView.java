package com.ckwl.likemoney.order.view;

public class OrderConditionView {
	private String order_code;
	private String order_date;
	private String order_status;
	private String order_sum_money;
	private String order_paydate;
	private String customer_name;
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getOrder_sum_money() {
		return order_sum_money;
	}
	public void setOrder_sum_money(String order_sum_money) {
		this.order_sum_money = order_sum_money;
	}
	public String getOrder_paydate() {
		return order_paydate;
	}
	public void setOrder_paydate(String order_paydate) {
		this.order_paydate = order_paydate;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
}
