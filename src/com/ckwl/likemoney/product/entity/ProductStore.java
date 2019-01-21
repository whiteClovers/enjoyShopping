package com.ckwl.likemoney.product.entity;

public class ProductStore {
	private String storeId;
	private String storeName;
	private String storeMessage;
	private String customerId;// 外键

	@Override
	public String toString() {
		return "ProductStore [storeId=" + storeId + ", storeName=" + storeName + ", storeMessage=" + storeMessage
				+ ", customerId=" + customerId + "]";
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreMessage() {
		return storeMessage;
	}

	public void setStoreMessage(String storeMessage) {
		this.storeMessage = storeMessage;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
