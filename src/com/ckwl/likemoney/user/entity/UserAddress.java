package com.ckwl.likemoney.user.entity;

public class UserAddress  {
	private String addressId;
	private String addressName;
	private String addressPhone;
	private String addressConsignee;
	private String addressEmail;
	private String addressCode;
	private String customerId;// 外键
	private String addressRegion;
	private String addressDefault;
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressPhone() {
		return addressPhone;
	}
	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}
	public String getAddressConsignee() {
		return addressConsignee;
	}
	public void setAddressConsignee(String addressConsignee) {
		this.addressConsignee = addressConsignee;
	}
	public String getAddressEmail() {
		return addressEmail;
	}
	public void setAddressEmail(String addressEmail) {
		this.addressEmail = addressEmail;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAddressRegion() {
		return addressRegion;
	}
	public void setAddressRegion(String addressRegion) {
		this.addressRegion = addressRegion;
	}
	public String getAddressDefault() {
		return addressDefault;
	}
	public void setAddressDefault(String addressDefault) {
		this.addressDefault = addressDefault;
	}
	@Override
	public String toString() {
		return "UserAddress [addressId=" + addressId + ", addressName=" + addressName + ", addressPhone=" + addressPhone
				+ ", addressConsignee=" + addressConsignee + ", addressEmail=" + addressEmail + ", addressCode="
				+ addressCode + ", customerId=" + customerId + ", addressRegion=" + addressRegion + ", addressDefault="
				+ addressDefault + "]";
	}

	

	

}
