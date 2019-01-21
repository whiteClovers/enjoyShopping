package com.ckwl.likemoney.product.view;

import com.ckwl.likemoney.product.entity.Product;

public class ProductQueryView extends Product {
private String brand_name;
private String store_name;
private String classfiy_small_name;
public String getBrand_name() {
	return brand_name;
}
public void setBrand_name(String brand_name) {
	this.brand_name = brand_name;
}
public String getStore_name() {
	return store_name;
}
public void setStore_name(String store_name) {
	this.store_name = store_name;
}
public String getClassfiy_small_name() {
	return classfiy_small_name;
}
public void setClassfiy_small_name(String classfiy_small_name) {
	this.classfiy_small_name = classfiy_small_name;
}
}
