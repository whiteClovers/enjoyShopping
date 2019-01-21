package com.ckwl.likemoney.cart.view;

import com.ckwl.likemoney.cart.entity.Cart;

public class CartQueryView extends Cart {
	private String product_sku_code;
	private String customer_name;
	private String product_sku_price;
	private String product_sku_img_small;
	//数据字典的中英文转换
	private String select_lable;
	private String delete_lable;
	
	public String getSelect_lable() {
		return select_lable;
	}

	public void setSelect_lable(String select_lable) {
		this.select_lable = select_lable;
	}

	public String getDelete_lable() {
		return delete_lable;
	}

	public void setDelete_lable(String delete_lable) {
		this.delete_lable = delete_lable;
	}

	public String getProduct_sku_img_small() {
		return product_sku_img_small;
	}

	public void setProduct_sku_img_small(String product_sku_img_small) {
		this.product_sku_img_small = product_sku_img_small;
	}

	public String getProduct_sku_price() {
		return product_sku_price;
	}

	public void setProduct_sku_price(String product_sku_price) {
		this.product_sku_price = product_sku_price;
	}

	public String getProduct_sku_code() {
		return product_sku_code;
	}

	public void setProduct_sku_code(String product_sku_code) {
		this.product_sku_code = product_sku_code;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
}
