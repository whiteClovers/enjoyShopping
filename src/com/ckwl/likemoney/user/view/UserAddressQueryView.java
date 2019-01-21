package com.ckwl.likemoney.user.view;

import com.ckwl.likemoney.user.entity.UserAddress;

public class UserAddressQueryView extends UserAddress{
private String customerId;

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

@Override
public String toString() {
	return "UserAddressQueryView [customerId=" + customerId + "]";
}

}
