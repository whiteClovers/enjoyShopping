package com.ckwl.likemoney.bas.view;

public class BankConditionView {
private String bankNum;
private String customerId;
public String getBankNum() {
	return bankNum;
}
public void setBankNum(String bankNum) {
	this.bankNum = bankNum;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
@Override
public String toString() {
	return "BankConditionView [bankNum=" + bankNum + ", customerId=" + customerId + "]";
}

}
