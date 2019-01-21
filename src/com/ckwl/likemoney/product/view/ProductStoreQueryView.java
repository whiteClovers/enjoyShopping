package com.ckwl.likemoney.product.view;

import java.io.Serializable;

import com.ckwl.likemoney.product.entity.ProductStore;

public class ProductStoreQueryView extends ProductStore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


}
