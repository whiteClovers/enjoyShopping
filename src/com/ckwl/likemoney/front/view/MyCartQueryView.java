package com.ckwl.likemoney.front.view;

import java.math.BigDecimal;

import com.ckwl.likemoney.cart.view.CartQueryView;

public class MyCartQueryView extends CartQueryView{
	private String product_name;
	private String product_sku_id;
	
	private String address_name;
	
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getProduct_sku_id() {
		return product_sku_id;
	}
	public void setProduct_sku_id(String product_sku_id) {
		this.product_sku_id = product_sku_id;
	}
	private String product_sku_img_small;
	private BigDecimal product_sku_realPrice ;
	private String color_name;
	private String size_name;
	private String store_name;
	
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getSize_name() {
		return size_name;
	}
	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}
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
	public BigDecimal getProduct_sku_realPrice() {
		return product_sku_realPrice;
	}
	public void setProduct_sku_realPrice(BigDecimal product_sku_realPrice) {
		this.product_sku_realPrice = product_sku_realPrice;
	}
	@Override
	public String toString() {
		return "MyCartQueryView [product_name=" + product_name + ", product_sku_id=" + product_sku_id
				+ ", product_sku_img_small=" + product_sku_img_small + ", product_sku_realPrice="
				+ product_sku_realPrice + ", color_name=" + color_name + ", size_name=" + size_name + ", store_name="
				+ store_name + "]";
	}
	
}
