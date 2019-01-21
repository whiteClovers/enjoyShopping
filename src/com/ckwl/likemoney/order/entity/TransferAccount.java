package com.ckwl.likemoney.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TransferAccount {
private String transferAccountsId;
private String customerId;//外键
private String orderId;
private String receivablesId;
private String receivablesName;
private BigDecimal orderSumMoney;
private Date orderPaydate;
public String getTransferAccountsId() {
	return transferAccountsId;
}
public void setTransferAccountsId(String transferAccountsId) {
	this.transferAccountsId = transferAccountsId;
}
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
public String getReceivablesId() {
	return receivablesId;
}
public void setReceivablesId(String receivablesId) {
	this.receivablesId = receivablesId;
}
public String getReceivablesName() {
	return receivablesName;
}
public void setReceivablesName(String receivablesName) {
	this.receivablesName = receivablesName;
}
public BigDecimal getOrderSumMoney() {
	return orderSumMoney;
}
public void setOrderSumMoney(BigDecimal orderSumMoney) {
	this.orderSumMoney = orderSumMoney;
}
public Date getOrderPaydate() {
	return orderPaydate;
}
public void setOrderPaydate(Date orderPaydate) {
	this.orderPaydate = orderPaydate;
}
@Override
public String toString() {
	return "TransferAccount [transferAccountsId=" + transferAccountsId + ", customerId=" + customerId + ", orderId="
			+ orderId + ", receivablesId=" + receivablesId + ", receivablesName=" + receivablesName + ", orderSumMoney="
			+ orderSumMoney + ", orderPaydate=" + orderPaydate + "]";
}


}
