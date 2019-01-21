package com.ckwl.likemoney.system.entity;

import java.util.Date;

public class SystemEmployee {
	private String employeeId;
	private String employeeName;
	private String employeePwd;
	private String employeePhone;
	private String employeeSex;
	private String employeeStatus;
	private Date employeeBirthday;
	private String employeeInformation;



	@Override
	public String toString() {
		return "SystemEmployee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePwd="
				+ employeePwd + ", employeePhone=" + employeePhone + ", employeeSex=" + employeeSex
				+ ", employeeStatus=" + employeeStatus + ", employeeBirthday=" + employeeBirthday
				+ ", employeeInformation=" + employeeInformation + "]";
	}

	public String getEmployeeInformation() {
		return employeeInformation;
	}

	public void setEmployeeInformation(String employeeInformation) {
		this.employeeInformation = employeeInformation;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePwd() {
		return employeePwd;
	}

	public void setEmployeePwd(String employeePwd) {
		this.employeePwd = employeePwd;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Date getEmployeeBirthday() {
		return employeeBirthday;
	}

	public void setEmployeeBirthday(Date employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}



}
