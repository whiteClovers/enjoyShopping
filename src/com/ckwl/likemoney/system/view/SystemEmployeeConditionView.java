package com.ckwl.likemoney.system.view;

import java.io.Serializable;

public class SystemEmployeeConditionView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String employeeName;
	private String employeeStatus;
	private String employeeInformation;
	
	
	public String getEmployeeInformation() {
		return employeeInformation;
	}


	public void setEmployeeInformation(String employeeInformation) {
		this.employeeInformation = employeeInformation;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeStatus() {
		return employeeStatus;
	}


	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}


	@Override
	public String toString() {
		return "SystemEmployeeConditionView [employeeInformation=" + employeeInformation + ", employeeName=" + employeeName
				+ ", employeeStatus=" + employeeStatus + "]";
	}


	
	
	

}
