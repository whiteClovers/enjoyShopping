package com.ckwl.likemoney.user.entity;

import java.util.Date;

public class UserAttention {
	private String attentionId;
	private String storeId;
	private String productId;// 外键
	private String customerId;
	private Date attentionDate;

	@Override
	public String toString() {
		return "UserAttention [attentionId=" + attentionId + ", storeId=" + storeId + ", productId=" + productId
				+ ", customerId=" + customerId + ", attentionDate=" + attentionDate + "]";
	}

	public String getAttentionId() {
		return attentionId;
	}

	public void setAttentionId(String attentionId) {
		this.attentionId = attentionId;
	}

	public Date getAttentionDate() {
		return attentionDate;
	}

	public void setAttentionDate(Date attentionDate) {
		this.attentionDate = attentionDate;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
