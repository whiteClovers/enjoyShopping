package com.ckwl.likemoney.bas.view;

import com.ckwl.likemoney.bas.entity.Bank;

public class BankQueryView extends Bank{
private String customerId;

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

@Override
public String toString() {
	return "BankQueryView [customerId=" + customerId + "]";
}

}
