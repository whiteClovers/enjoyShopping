package com.ckwl.likemoney.user.view;

import com.ckwl.likemoney.user.entity.UserCustomer;

public class UserCustomerConditionView extends UserCustomer{
private String customerId;
private String customerName;
private String customerSex;
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerSex() {
	return customerSex;
}
public void setCustomerSex(String customerSex) {
	this.customerSex = customerSex;
}
@Override
public String toString() {
	return "UserCustomerConditionView [customerId=" + customerId + ", customerName=" + customerName + ", customerSex="
			+ customerSex + "]";
}

}
