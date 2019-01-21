package com.ckwl.likemoney.cart.entity;

import java.util.Date;

public class Cart {
	@Override
	public String toString() {
		return "Cart [car_id=" + car_id + ", product_sku_id=" + product_sku_id + ", sku_amount=" + sku_amount
				+ ", car_date=" + car_date + ", customer_id=" + customer_id + ", car_select=" + car_select
				+ ", car_detect=" + car_detect + "]";
	}
	private String car_id;
	private String product_sku_id;
	private String sku_amount;
	
	private String order_code;
	
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	private Date car_date;
	private String customer_id;
	private String car_select;
	private String car_detect;
	
	public String getSku_amount() {
		return sku_amount;
	}
	public void setSku_amount(String sku_amount) {
		this.sku_amount = sku_amount;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getProduct_sku_id() {
		return product_sku_id;
	}
	public void setProduct_sku_id(String product_sku_id) {
		this.product_sku_id = product_sku_id;
	}
	public Date getCar_date() {
		return car_date;
	}
	public void setCar_date(Date car_date) {
		this.car_date = car_date;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCar_select() {
		return car_select;
	}
	public void setCar_select(String car_select) {
		this.car_select = car_select;
	}
	public String getCar_detect() {
		return car_detect;
	}
	public void setCar_detect(String car_detect) {
		this.car_detect = car_detect;
	}
		
	
										
}
