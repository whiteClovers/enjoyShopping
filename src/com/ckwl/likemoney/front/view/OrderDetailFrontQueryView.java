package com.ckwl.likemoney.front.view;

import java.math.BigDecimal;
import java.util.Date;

import com.ckwl.likemoney.order.view.OrderDetailQueryView;

public class OrderDetailFrontQueryView extends OrderDetailQueryView{
private Date order_date;
private String order_status;
private Date order_paydate;
private String address_name;
private String address_consignee;
private String address_phone;
private BigDecimal product_sku_realPrice;
private String product_sku_img_small;
private String product_sku_img_mid;
private String product_name;
private String color_name;
private String dataDictonary_detail_label_order_status;
private BigDecimal order_detail_sumPrice;
private BigDecimal order_sum_money;

private String customer_name;

public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
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
public Date getOrder_paydate() {
	return order_paydate;
}
public void setOrder_paydate(Date order_paydate) {
	this.order_paydate = order_paydate;
}
public String getAddress_name() {
	return address_name;
}
public void setAddress_name(String address_name) {
	this.address_name = address_name;
}
public String getAddress_consignee() {
	return address_consignee;
}
public void setAddress_consignee(String address_consignee) {
	this.address_consignee = address_consignee;
}
public String getAddress_phone() {
	return address_phone;
}
public void setAddress_phone(String address_phone) {
	this.address_phone = address_phone;
}
public BigDecimal getProduct_sku_realPrice() {
	return product_sku_realPrice;
}
public void setProduct_sku_realPrice(BigDecimal product_sku_realPrice) {
	this.product_sku_realPrice = product_sku_realPrice;
}
public String getProduct_sku_img_small() {
	return product_sku_img_small;
}
public void setProduct_sku_img_small(String product_sku_img_small) {
	this.product_sku_img_small = product_sku_img_small;
}
public String getProduct_sku_img_mid() {
	return product_sku_img_mid;
}
public void setProduct_sku_img_mid(String product_sku_img_mid) {
	this.product_sku_img_mid = product_sku_img_mid;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getColor_name() {
	return color_name;
}
public void setColor_name(String color_name) {
	this.color_name = color_name;
}
public String getDataDictonary_detail_label_order_status() {
	return dataDictonary_detail_label_order_status;
}
public void setDataDictonary_detail_label_order_status(String dataDictonary_detail_label_order_status) {
	this.dataDictonary_detail_label_order_status = dataDictonary_detail_label_order_status;
}
public BigDecimal getOrder_detail_sumPrice() {
	return order_detail_sumPrice;
}
public void setOrder_detail_sumPrice(BigDecimal order_detail_sumPrice) {
	this.order_detail_sumPrice = order_detail_sumPrice;
}
public BigDecimal getOrder_sum_money() {
	return order_sum_money;
}
public void setOrder_sum_money(BigDecimal order_sum_money) {
	this.order_sum_money = order_sum_money;
}


}
