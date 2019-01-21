package com.ckwl.likemoney.order.view;

public class TransferAccountConditionView {
private String customerId;
private String orderId;
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
@Override
public String toString() {
	return "TransferAccountConditionView [customerId=" + customerId + ", orderId=" + orderId + "]";
}

}
