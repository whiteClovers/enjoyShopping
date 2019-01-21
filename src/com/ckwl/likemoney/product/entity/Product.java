package com.ckwl.likemoney.product.entity;

import java.util.Date;

public class Product {
private String product_id;
private String product_name;
private String product_code;
private String brand_id;//外键
private String evaluate_amount;
private String store_id;//外键
private	String classfiy_small_id;//外键
private int evaluate_good;
private int evaluate_bad;
private int evaluate_common;
private String product_shelf_status;
private Date product_shelf_time;
private String	product_img;
private String product_introduce;
public String getProduct_id() {
	return product_id;
}
public void setProduct_id(String product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_code() {
	return product_code;
}
public void setProduct_code(String product_code) {
	this.product_code = product_code;
}
public String getEvaluate_amount() {
	return evaluate_amount;
}
public void setEvaluate_amount(String evaluate_amount) {
	this.evaluate_amount = evaluate_amount;
}
public int getEvaluate_good() {
	return evaluate_good;
}
public void setEvaluate_good(int evaluate_good) {
	this.evaluate_good = evaluate_good;
}
public int getEvaluate_bad() {
	return evaluate_bad;
}
public void setEvaluate_bad(int evaluate_bad) {
	this.evaluate_bad = evaluate_bad;
}
public int getEvaluate_common() {
	return evaluate_common;
}
public void setEvaluate_common(int evaluate_common) {
	this.evaluate_common = evaluate_common;
}
public String getProduct_shelf_status() {
	return product_shelf_status;
}
public void setProduct_shelf_status(String product_shelf_status) {
	this.product_shelf_status = product_shelf_status;
}
public Date getProduct_shelf_time() {
	return product_shelf_time;
}
public void setProduct_shelf_time(Date product_shelf_time) {
	this.product_shelf_time = product_shelf_time;
}
public String getProduct_img() {
	return product_img;
}
public void setProduct_img(String product_img) {
	this.product_img = product_img;
}
public String getProduct_introduce() {
	return product_introduce;
}
public void setProduct_introduce(String product_introduce) {
	this.product_introduce = product_introduce;
}
public String getBrand_id() {
	return brand_id;
}
public void setBrand_id(String brand_id) {
	this.brand_id = brand_id;
}
public String getStore_id() {
	return store_id;
}
public void setStore_id(String store_id) {
	this.store_id = store_id;
}
public String getClassfiy_small_id() {
	return classfiy_small_id;
}
public void setClassfiy_small_id(String classfiy_small_id) {
	this.classfiy_small_id = classfiy_small_id;
}
}
