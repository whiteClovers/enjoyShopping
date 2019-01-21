package com.ckwl.likemoney.user.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserCustomer {
	private String customerId;
	private String customerEd;
	private String customerName;
	private String customerPwd;
	private String customerPayPwd;
	private String customerPhone;
	private String customerEmail;
	private String customerSex;
	private String customerVip;
	private Date customerBirthday;
	private String customerHobby;
	private String customerNickName;
	private String customerImg;
	private BigDecimal customerBalance;
	private BigDecimal customerIncome;
	private String customerIdCard;
	private String customerMaritalStatus;
	private String customerAvailableStatus;

	
	
	
	@Override
	public String toString() {
		return "UserCustomer [customerId=" + customerId + ", customerEd=" + customerEd + ", customerName="
				+ customerName + ", customerPwd=" + customerPwd + ", customerPayPwd=" + customerPayPwd
				+ ", customerPhone=" + customerPhone + ", customerEmail=" + customerEmail + ", customerSex="
				+ customerSex + ", customerVip=" + customerVip + ", customerBirthday=" + customerBirthday
				+ ", customerHobby=" + customerHobby + ", customerNickName=" + customerNickName + ", customerImg="
				+ customerImg + ", customerBalance=" + customerBalance + ", customerIncome=" + customerIncome
				+ ", customerIdCard=" + customerIdCard + ", customerMaritalStatus=" + customerMaritalStatus
				+ ", customerAvailableStatus=" + customerAvailableStatus + "]";
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerEd() {
		return customerEd;
	}

	public void setCustomerEd(String customerEd) {
		this.customerEd = customerEd;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPwd() {
		return customerPwd;
	}

	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}

	public String getCustomerPayPwd() {
		return customerPayPwd;
	}

	public void setCustomerPayPwd(String customerPayPwd) {
		this.customerPayPwd = customerPayPwd;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerVip() {
		return customerVip;
	}

	public void setCustomerVip(String customerVip) {
		this.customerVip = customerVip;
	}

	public Date getCustomerBirthday() {
		return customerBirthday;
	}

	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	public String getCustomerHobby() {
		return customerHobby;
	}

	public void setCustomerHobby(String customerHobby) {
		this.customerHobby = customerHobby;
	}

	public String getCustomerNickName() {
		return customerNickName;
	}

	public void setCustomerNickName(String customerNickName) {
		this.customerNickName = customerNickName;
	}

	public String getCustomerImg() {
		return customerImg;
	}

	public void setCustomerImg(String customerImg) {
		this.customerImg = customerImg;
	}

	public BigDecimal getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(BigDecimal customerBalance) {
		this.customerBalance = customerBalance;
	}

	public BigDecimal getCustomerIncome() {
		return customerIncome;
	}

	public void setCustomerIncome(BigDecimal customerIncome) {
		this.customerIncome = customerIncome;
	}

	public String getCustomerIdCard() {
		return customerIdCard;
	}

	public void setCustomerIdCard(String customerIdCard) {
		this.customerIdCard = customerIdCard;
	}

	public String getCustomerMaritalStatus() {
		return customerMaritalStatus;
	}

	public void setCustomerMaritalStatus(String customerMaritalStatus) {
		this.customerMaritalStatus = customerMaritalStatus;
	}

	public String getCustomerAvailableStatus() {
		return customerAvailableStatus;
	}

	public void setCustomerAvailableStatus(String customerAvailableStatus) {
		this.customerAvailableStatus = customerAvailableStatus;
	}

}
