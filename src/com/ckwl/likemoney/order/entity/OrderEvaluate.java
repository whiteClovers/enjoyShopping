package com.ckwl.likemoney.order.entity;

import java.util.Date;

public class OrderEvaluate {
private String evaluate_id;
private Date evaluate_time;
private String evaluate_message;
private String evaluate_img;
private String evaluate_service;
private int evaluate_amount;
private int evaluate_bad;
private int evaluate_good;
private int evaluate_common;
private String order_detail_id;//外键
private String evaluate_speed;
private String evaluate_describe;
private String customer_id;//外键
//private Order Order;//order_name
public String getEvaluate_id() {
	return evaluate_id;
}
public void setEvaluate_id(String evaluate_id) {
	this.evaluate_id = evaluate_id;
}
public Date getEvaluate_time() {
	return evaluate_time;
}
public void setEvaluate_time(Date evaluate_time) {
	this.evaluate_time = evaluate_time;
}
public String getEvaluate_message() {
	return evaluate_message;
}
public void setEvaluate_message(String evaluate_message) {
	this.evaluate_message = evaluate_message;
}
public String getEvaluate_img() {
	return evaluate_img;
}
public void setEvaluate_img(String evaluate_img) {
	this.evaluate_img = evaluate_img;
}
public String getEvaluate_service() {
	return evaluate_service;
}
public void setEvaluate_service(String evaluate_service) {
	this.evaluate_service = evaluate_service;
}
public int getEvaluate_amount() {
	return evaluate_amount;
}
public void setEvaluate_amount(int evaluate_amount) {
	this.evaluate_amount = evaluate_amount;
}
public int getEvaluate_bad() {
	return evaluate_bad;
}
public void setEvaluate_bad(int evaluate_bad) {
	this.evaluate_bad = evaluate_bad;
}
public int getEvaluate_good() {
	return evaluate_good;
}
public void setEvaluate_good(int evaluate_good) {
	this.evaluate_good = evaluate_good;
}
public int getEvaluate_common() {
	return evaluate_common;
}
public void setEvaluate_common(int evaluate_common) {
	this.evaluate_common = evaluate_common;
}
public String getEvaluate_speed() {
	return evaluate_speed;
}
public void setEvaluate_speed(String evaluate_speed) {
	this.evaluate_speed = evaluate_speed;
}
public String getEvaluate_describe() {
	return evaluate_describe;
}
public void setEvaluate_describe(String evaluate_describe) {
	this.evaluate_describe = evaluate_describe;
}
public String getOrder_detail_id() {
	return order_detail_id;
}
public void setOrder_detail_id(String order_detail_id) {
	this.order_detail_id = order_detail_id;
}
public String getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}
//public Order getOrder() {
//	return Order;
//}
//public void setOrder(Order Order) {
//	Order = Order;
//}
}
