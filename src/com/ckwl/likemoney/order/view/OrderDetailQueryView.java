package com.ckwl.likemoney.order.view;

import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.front.view.MyOrderQueryView;
import com.ckwl.likemoney.order.entity.OrderDetail;

public class OrderDetailQueryView extends OrderDetail {
private String order_code;
private String product_sku_code;
private String dataDictonary_detail_label_send;
private String dataDictonary_detail_label_logistics;
private String dataDictonary_detail_label_receive;
private String dataDictonary_detail_label_evaluate;
private String dataDictonary_detail_label_out;
private List<MyOrderQueryView> listMyOrder = new ArrayList<>();

public String getOrder_code() {
	return order_code;
}
public void setOrder_code(String order_code) {
	this.order_code = order_code;
}
public String getProduct_sku_code() {
	return product_sku_code;
}
public void setProduct_sku_code(String product_sku_code) {
	this.product_sku_code = product_sku_code;
}

public String getDataDictonary_detail_label_send() {
	return dataDictonary_detail_label_send;
}
public void setDataDictonary_detail_label_send(String dataDictonary_detail_label_send) {
	this.dataDictonary_detail_label_send = dataDictonary_detail_label_send;
}
public String getDataDictonary_detail_label_logistics() {
	return dataDictonary_detail_label_logistics;
}
public void setDataDictonary_detail_label_logistics(String dataDictonary_detail_label_logistics) {
	this.dataDictonary_detail_label_logistics = dataDictonary_detail_label_logistics;
}
public String getDataDictonary_detail_label_receive() {
	return dataDictonary_detail_label_receive;
}
public void setDataDictonary_detail_label_receive(String dataDictonary_detail_label_receive) {
	this.dataDictonary_detail_label_receive = dataDictonary_detail_label_receive;
}
public String getDataDictonary_detail_label_evaluate() {
	return dataDictonary_detail_label_evaluate;
}
public void setDataDictonary_detail_label_evaluate(String dataDictonary_detail_label_evaluate) {
	this.dataDictonary_detail_label_evaluate = dataDictonary_detail_label_evaluate;
}
public String getDataDictonary_detail_label_out() {
	return dataDictonary_detail_label_out;
}
public void setDataDictonary_detail_label_out(String dataDictonary_detail_label_out) {
	this.dataDictonary_detail_label_out = dataDictonary_detail_label_out;
}
public List<MyOrderQueryView> getListMyOrder() {
	return listMyOrder;
}
public void setListMyOrder(List<MyOrderQueryView> listMyOrder) {
	this.listMyOrder = listMyOrder;
}

}
