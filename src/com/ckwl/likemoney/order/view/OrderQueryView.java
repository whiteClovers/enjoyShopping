package com.ckwl.likemoney.order.view;

import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.front.view.MyOrderQueryView;
import com.ckwl.likemoney.order.entity.Order;

public class OrderQueryView extends Order{
	private String address_name;
	private String customer_name;
	private String dataDictonary_detail_label;
	
	private List<MyOrderQueryView> listMyOrder = new ArrayList<>();

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getDataDictonary_detail_label() {
		return dataDictonary_detail_label;
	}

	public void setDataDictonary_detail_label(String dataDictonary_detail_label) {
		this.dataDictonary_detail_label = dataDictonary_detail_label;
	}

	public List<MyOrderQueryView> getListMyOrder() {
		return listMyOrder;
	}

	public void setListMyOrder(List<MyOrderQueryView> listMyOrder) {
		this.listMyOrder = listMyOrder;
	}
}
