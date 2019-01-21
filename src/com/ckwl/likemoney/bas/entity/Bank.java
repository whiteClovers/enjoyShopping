package com.ckwl.likemoney.bas.entity;

public class Bank {
	private String bankId;
	private String bankName;
	private String bankNum;//银行卡号
	private String customerId;//外键
	private String bankType;

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bandNum=" + bankNum + ", customerId="
				+ customerId + ", bandType=" + bankType + "]";
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bandNum) {
		this.bankNum = bandNum;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bandType) {
		this.bankType = bandType;
	}
	
	
}
