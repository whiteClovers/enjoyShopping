package com.ckwl.likemoney.stock.view;

import com.ckwl.likemoney.stock.entity.StockInDetail;

public class StockInDetailQueryView extends StockInDetail{
	private String productSkuCode;
	private String stockInCode;
	public String getProductSkuCode() {
		return productSkuCode;
	}
	public void setProductSkuCode(String productSkuCode) {
		this.productSkuCode = productSkuCode;
	}
	public String getStockInCode() {
		return stockInCode;
	}
	public void setStockInCode(String stockInCode) {
		this.stockInCode = stockInCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StockInDetailQueryView [productSkuCode=");
		builder.append(productSkuCode);
		builder.append(", stockInCode=");
		builder.append(stockInCode);
		builder.append("]");
		return builder.toString();
	}
	
}
