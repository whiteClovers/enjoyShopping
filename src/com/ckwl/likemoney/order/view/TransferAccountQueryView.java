package com.ckwl.likemoney.order.view;

import com.ckwl.likemoney.order.entity.TransferAccount;

public class TransferAccountQueryView  extends TransferAccount{
private String cuetomerId;
private String orderId;
public String getCuetomerId() {
	return cuetomerId;
}
public void setCuetomerId(String cuetomerId) {
	this.cuetomerId = cuetomerId;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}

}
