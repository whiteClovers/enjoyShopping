package com.ckwl.likemoney.stock.view;

public class StockInConditionView {
	private String stockInCode;//编号
	private String startTime;
	private String endTime;
	private String stockInPay;
	private String employeeName;
	public String getStockInCode() {
		return stockInCode;
	}
	public void setStockInCode(String stockInCode) {
		this.stockInCode = stockInCode;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStockInPay() {
		return stockInPay;
	}
	public void setStockInPay(String stockInPay) {
		this.stockInPay = stockInPay;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockInConditionView [stockInCode=");
		builder.append(stockInCode);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", stockInPay=");
		builder.append(stockInPay);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append("]");
		return builder.toString();
	}
	
}
