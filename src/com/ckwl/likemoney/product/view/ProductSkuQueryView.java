package com.ckwl.likemoney.product.view;

import java.math.BigDecimal;

import com.ckwl.likemoney.product.entity.ProductSku;

public class ProductSkuQueryView extends ProductSku {
	private String size_name;
	private String product_code;
	private String color_name;
	private String evaluate_amount;
	private String product_name;
	private String product_introduce;
	private String product_sku_img_big;
	private BigDecimal product_sku_price;
	private String product_sku_id;
	
	
	// 状态中文字段
	private String product_shelf_status_label;
	private String product_sku_stock_label;
	
	public String getProduct_shelf_status_label() {
		return product_shelf_status_label;
	}

	public void setProduct_shelf_status_label(String product_shelf_status_label) {
		this.product_shelf_status_label = product_shelf_status_label;
	}

	public String getProduct_sku_stock_label() {
		return product_sku_stock_label;
	}

	public void setProduct_sku_stock_label(String product_sku_stock_label) {
		this.product_sku_stock_label = product_sku_stock_label;
	}

	public String getSize_name() {
		return size_name;
	}

	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getColor_name() {
		return color_name;
	}

	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}

	public String getEvaluate_amount() {
		return evaluate_amount;
	}

	public void setEvaluate_amount(String evaluate_amount) {
		this.evaluate_amount = evaluate_amount;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	

	@Override
	public String toString() {
		return "ProductSkuQueryView [size_name=" + size_name + ", product_code=" + product_code + ", color_name="
				+ color_name + ", evaluate_amount=" + evaluate_amount + ", product_name=" + product_name
				+ ", product_introduce=" + product_introduce + ", product_sku_img_big=" + product_sku_img_big
				+ ", product_sku_price=" + product_sku_price + ", product_sku_id=" + product_sku_id
				+ ", product_shelf_status_label=" + product_shelf_status_label + ", product_sku_stock_label="
				+ product_sku_stock_label + "]";
	}

	public String getProduct_introduce() {
		return product_introduce;
	}

	public void setProduct_introduce(String product_introduce) {
		this.product_introduce = product_introduce;
	}

	public String getProduct_sku_img_big() {
		return product_sku_img_big;
	}

	public void setProduct_sku_img_big(String product_sku_img_big) {
		this.product_sku_img_big = product_sku_img_big;
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



}
