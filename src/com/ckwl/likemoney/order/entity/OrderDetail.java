package com.ckwl.likemoney.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
private	String order_detail_id;
private String product_sku_id;//外键
private BigDecimal product_sku_realPrice;
private int order_detail_amount;
private String order_detail_send;
private String order_detail_logistics;
private String order_detail_receive;
private String order_detail_out;
private Date order_detail_outTime;
private Date order_detail_logistics_time;
private Date order_detail_receive_time;
private Date order_detail_evaluate_time;
private String order_detail_evaluate;
private String order_id;//外键
private BigDecimal product_sku_price;
private String order_detail_code;

// 订单编号
private String order_code;

public String getOrder_code() {
	return order_code;
}
public void setOrder_code(String order_code) {
	this.order_code = order_code;
}
public String getOrder_detail_id() {
	return order_detail_id;
}
public void setOrder_detail_id(String order_detail_id) {
	this.order_detail_id = order_detail_id;
}
public BigDecimal getProduct_sku_realPrice() {
	return product_sku_realPrice;
}
public void setProduct_sku_realPrice(BigDecimal product_sku_realPrice) {
	this.product_sku_realPrice = product_sku_realPrice;
}
public int getOrder_detail_amount() {
	return order_detail_amount;
}
public void setOrder_detail_amount(int order_detail_amount) {
	this.order_detail_amount = order_detail_amount;
}
public String getOrder_detail_send() {
	return order_detail_send;
}
public void setOrder_detail_send(String order_detail_send) {
	this.order_detail_send = order_detail_send;
}
public String getOrder_detail_logistics() {
	return order_detail_logistics;
}
public void setOrder_detail_logistics(String order_detail_logistics) {
	this.order_detail_logistics = order_detail_logistics;
}
public String getOrder_detail_receive() {
	return order_detail_receive;
}
public void setOrder_detail_receive(String order_detail_receive) {
	this.order_detail_receive = order_detail_receive;
}
public Date getOrder_detail_evaluate_time() {
	return order_detail_evaluate_time;
}
public void setOrder_detail_evaluate_time(Date order_detail_evaluate_time) {
	this.order_detail_evaluate_time = order_detail_evaluate_time;
}
public String getOrder_detail_evaluate() {
	return order_detail_evaluate;
}
public void setOrder_detail_evaluate(String order_detail_evaluate) {
	this.order_detail_evaluate = order_detail_evaluate;
}
public BigDecimal getProduct_sku_price() {
	return product_sku_price;
}
public void setProduct_sku_price(BigDecimal product_sku_price) {
	this.product_sku_price = product_sku_price;
}
public String getProduct_sku_id() {
	return product_sku_id;
}
public void setProduct_sku_id(String product_sku_id) {
	this.product_sku_id = product_sku_id;
}
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getOrder_detail_out() {
	return order_detail_out;
}
public void setOrder_detail_out(String order_detail_out) {
	this.order_detail_out = order_detail_out;
}
public Date getOrder_detail_outTime() {
	return order_detail_outTime;
}
public void setOrder_detail_outTime(Date order_detail_outTime) {
	this.order_detail_outTime = order_detail_outTime;
}
public Date getOrder_detail_logistics_time() {
	return order_detail_logistics_time;
}
public void setOrder_detail_logistics_time(Date order_detail_logistics_time) {
	this.order_detail_logistics_time = order_detail_logistics_time;
}
public Date getOrder_detail_receive_time() {
	return order_detail_receive_time;
}
public void setOrder_detail_receive_time(Date order_detail_receive_time) {
	this.order_detail_receive_time = order_detail_receive_time;
}
public String getOrder_detail_code() {
	return order_detail_code;
}
public void setOrder_detail_code(String order_detail_code) {
	this.order_detail_code = order_detail_code;
}

}
