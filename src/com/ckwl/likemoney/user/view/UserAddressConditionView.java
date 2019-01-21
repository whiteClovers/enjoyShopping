package com.ckwl.likemoney.user.view;

public class UserAddressConditionView {

	private String addressName;
	private String addressConsignee;
	private String customerId;


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressConsignee() {
		return addressConsignee;
	}

	public void setAddressConsignee(String addressConsignee) {
		this.addressConsignee = addressConsignee;
	}

	@Override
	public String toString() {
		return "UserAddressConditionView [addressName=" + addressName + ", addressConsignee=" + addressConsignee + "]";
	}

}
