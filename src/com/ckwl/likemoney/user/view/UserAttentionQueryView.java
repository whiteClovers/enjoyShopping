package com.ckwl.likemoney.user.view;

import com.ckwl.likemoney.user.entity.UserAttention;

public class UserAttentionQueryView extends UserAttention{
private String storeId;
private String productId;
private String customerId;
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
@Override
public String toString() {
	return "UserAttentionQueryView [storeId=" + storeId + ", productId=" + productId + ", customerId=" + customerId
			+ "]";
}

}
