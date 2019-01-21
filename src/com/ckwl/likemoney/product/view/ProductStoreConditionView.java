package com.ckwl.likemoney.product.view;

import java.io.Serializable;

public class ProductStoreConditionView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String storeMessage;
	private String storeName;
	private String customerId;// 外键
	private String customerName;


	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getStoreMessage() {
		return storeMessage;
	}

	public void setStoreMessage(String storeMessage) {
		this.storeMessage = storeMessage;
	}

	@Override
	public String toString() {
		return "ProductStoreConditionView [storeMessage=" + storeMessage + ", storeName=" + storeName + ", customerId="
				+ customerId + "]";
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
