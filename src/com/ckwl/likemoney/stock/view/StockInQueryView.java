package com.ckwl.likemoney.stock.view;

import com.ckwl.likemoney.stock.entity.StockIn;

public class StockInQueryView extends StockIn {
	private String employeeName;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockInQueryView [employeeName=");
		builder.append(employeeName);
		builder.append("]");
		return builder.toString();
	}
}
