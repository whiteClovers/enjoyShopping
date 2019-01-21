package com.ckwl.likemoney.user.view;

public class UserAttentionConditionView {
private String attentionId;
private String storeId;
private String customerId;
public String getAttentionId() {
	return attentionId;
}
public void setAttentionId(String attentionId) {
	this.attentionId = attentionId;
}
public String getStoreId() {
	return storeId;
}
public void setStoreId(String storeId) {
	this.storeId = storeId;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
@Override
public String toString() {
	return "UserAttentionConditionView [attentionId=" + attentionId + ", storeId=" + storeId + ", customerId="
			+ customerId + "]";
}

}
