package com.ckwl.likemoney.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
private String order_id;
private String order_code;
private String	address_id;//外键
private String customer_id;//外键
private Date order_date;
private String order_status;
private BigDecimal order_sum_money;
private Date order_paydate;
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getOrder_code() {
	return order_code;
}
public void setOrder_code(String order_code) {
	this.order_code = order_code;
}
public Date getOrder_date() {
	return order_date;
}
public void setOrder_date(Date order_date) {
	this.order_date = order_date;
}
public String getOrder_status() {
	return order_status;
}
public void setOrder_status(String order_status) {
	this.order_status = order_status;
}
public BigDecimal getOrder_sum_money() {
	return order_sum_money;
}
public void setOrder_sum_money(BigDecimal order_sum_money) {
	this.order_sum_money = order_sum_money;
}
public Date getOrder_paydate() {
	return order_paydate;
}
public void setOrder_paydate(Date order_paydate) {
	this.order_paydate = order_paydate;
}
public String getAddress_id() {
	return address_id;
}
public void setAddress_id(String address_id) {
	this.address_id = address_id;
}
public String getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}
}
