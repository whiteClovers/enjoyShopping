package com.ckwl.likemoney.front.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.order.view.OrderQueryView;

public class MyOrderQueryView extends OrderQueryView{

	private String product_name;
	private String product_sku_img_small;
	private String order_detail_id;
	public String getOrder_detail_id() {
		return order_detail_id;
	}
	public void setOrder_detail_id(String order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	private String order_detail_amount ;
	private String address_consignee ;
	private BigDecimal product_sku_realPrice ;
	private String product_sku_code ;
	private String dataDictonary_detail_label;
	private String color_name;
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_sku_img_small() {
		return product_sku_img_small;
	}
	public void setProduct_sku_img_small(String product_sku_img_small) {
		this.product_sku_img_small = product_sku_img_small;
	}
	public String getOrder_detail_amount() {
		return order_detail_amount;
	}
	public void setOrder_detail_amount(String order_detail_amount) {
		this.order_detail_amount = order_detail_amount;
	}
	
	public BigDecimal getProduct_sku_realPrice() {
		return product_sku_realPrice;
	}
	public void setProduct_sku_realPrice(BigDecimal product_sku_realPrice) {
		this.product_sku_realPrice = product_sku_realPrice;
	}
	public String getDataDictonary_detail_label() {
		return dataDictonary_detail_label;
	}
	public void setDataDictonary_detail_label(String dataDictonary_detail_label) {
		this.dataDictonary_detail_label = dataDictonary_detail_label;
	}
	public String getAddress_consignee() {
		return address_consignee;
	}
	public void setAddress_consignee(String address_consignee) {
		this.address_consignee = address_consignee;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getProduct_sku_code() {
		return product_sku_code;
	}
	public void setProduct_sku_code(String product_sku_code) {
		this.product_sku_code = product_sku_code;
	}
	
	
	
	
	
}
