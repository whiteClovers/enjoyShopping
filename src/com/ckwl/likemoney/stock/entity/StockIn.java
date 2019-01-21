package com.ckwl.likemoney.stock.entity;

import java.math.BigDecimal;

public class StockIn {
	String stockInId;//入库id
	String stockInCode;//入库编号
	String stockInTime;//入库时间
	BigDecimal stockInPay;//费用
	String employeeId;//员工id---外键
	public String getStockInId() {
		return stockInId;
	}
	public void setStockInId(String stockInId) {
		this.stockInId = stockInId;
	}
	public String getStockInCode() {
		return stockInCode;
	}
	public void setStockInCode(String stockInCode) {
		this.stockInCode = stockInCode;
	}
	public String getStockInTime() {
		return stockInTime;
	}
	public void setStockInTime(String stockInTime) {
		this.stockInTime = stockInTime;
	}
	public BigDecimal getStockInPay() {
		return stockInPay;
	}
	public void setStockInPay(BigDecimal stockInPay) {
		this.stockInPay = stockInPay;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "StockIn [stockInId=" + stockInId + ", stockInCode=" + stockInCode + ", stockInTime=" + stockInTime
				+ ", stockInPay=" + stockInPay + ", employeeId=" + employeeId + "]";
	}
	
	

}
