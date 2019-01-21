package com.ckwl.likemoney.product.entity;

import java.math.BigDecimal;

public class ProductSku {
private String product_sku_id;
private String product_id;//外键
private String color_id;//
private String size_id;//
private String evaluate_id;//
private String product_sku_amount;
private BigDecimal	product_sku_price;
private String product_sku_img;
private String product_sku_stock;
private String product_shelf_status; // 上架下架
private BigDecimal product_sku_realPrice;
private String product_sku_img_big;
private String product_sku_img_small;
private String product_sku_img_mid;
private String product_stock_max;
private String product_stock_min;
private String product_sku_code;

public String getProduct_sku_id() {
	return product_sku_id;
}
public void setProduct_sku_id(String product_sku_id) {
	this.product_sku_id = product_sku_id;
}
public String getProduct_sku_amount() {
	return product_sku_amount;
}
public void setProduct_sku_amount(String product_sku_amount) {
	this.product_sku_amount = product_sku_amount;
}
public BigDecimal getProduct_sku_price() {
	return product_sku_price;
}
public void setProduct_sku_price(BigDecimal product_sku_price) {
	this.product_sku_price = product_sku_price;
}
public String getProduct_sku_img() {
	return product_sku_img;
}
public void setProduct_sku_img(String product_sku_img) {
	this.product_sku_img = product_sku_img;
}
public String getProduct_sku_stock() {
	return product_sku_stock;
}
public void setProduct_sku_stock(String product_sku_stock) {
	this.product_sku_stock = product_sku_stock;
}
public BigDecimal getProduct_sku_realPrice() {
	return product_sku_realPrice;
}
public void setProduct_sku_realPrice(BigDecimal product_sku_realPrice) {
	this.product_sku_realPrice = product_sku_realPrice;
}
public String getProduct_sku_img_big() {
	return product_sku_img_big;
}
public void setProduct_sku_img_big(String product_sku_img_big) {
	this.product_sku_img_big = product_sku_img_big;
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
public String getProduct_stock_max() {
	return product_stock_max;
}
public void setProduct_stock_max(String product_stock_max) {
	this.product_stock_max = product_stock_max;
}
public String getProduct_stock_min() {
	return product_stock_min;
}
public void setProduct_stock_min(String product_stock_min) {
	this.product_stock_min = product_stock_min;
}
public String getProduct_id() {
	return product_id;
}
public void setProduct_id(String product_id) {
	this.product_id = product_id;
}
public String getColor_id() {
	return color_id;
}
public void setColor_id(String color_id) {
	this.color_id = color_id;
}
public String getSize_id() {
	return size_id;
}
public void setSize_id(String size_id) {
	this.size_id = size_id;
}
public String getEvaluate_id() {
	return evaluate_id;
}
public void setEvaluate_id(String evaluate_id) {
	this.evaluate_id = evaluate_id;
}

public String getProduct_sku_code() {
	return product_sku_code;
}
public void setProduct_sku_code(String product_sku_code) {
	this.product_sku_code = product_sku_code;
}
public String getProduct_shelf_status() {
	return product_shelf_status;
}
public void setProduct_shelf_status(String product_shelf_status) {
	this.product_shelf_status = product_shelf_status;
}
@Override
public String toString() {
	return "ProductSku [product_sku_id=" + product_sku_id + ", product_id=" + product_id + ", color_id=" + color_id
			+ ", size_id=" + size_id + ", evaluate_id=" + evaluate_id + ", product_sku_amount=" + product_sku_amount
			+ ", product_sku_price=" + product_sku_price + ", product_sku_img=" + product_sku_img
			+ ", product_sku_stock=" + product_sku_stock + ", product_shelf_status=" + product_shelf_status
			+ ", product_sku_realPrice=" + product_sku_realPrice + ", product_sku_img_big=" + product_sku_img_big
			+ ", product_sku_img_small=" + product_sku_img_small + ", product_sku_img_mid=" + product_sku_img_mid
			+ ", product_stock_max=" + product_stock_max + ", product_stock_min=" + product_stock_min
			+ ", product_sku_code=" + product_sku_code + "]";
}

}
