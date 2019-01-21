package com.ckwl.likemoney.stock.view;

public class StockInDetailConditionView {
	private String productSkuCode;
	private String minPrice;
	private String maxPrice;
	private String stockInCode;
	public String getProductSkuCode() {
		return productSkuCode;
	}
	public void setProductSkuCode(String productSkuCode) {
		this.productSkuCode = productSkuCode;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
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
		builder.append("StockInDetailConditionView [productSkuCode=");
		builder.append(productSkuCode);
		builder.append(", minPrice=");
		builder.append(minPrice);
		builder.append(", maxPrice=");
		builder.append(maxPrice);
		builder.append(", stockInCode=");
		builder.append(stockInCode);
		builder.append("]");
		return builder.toString();
	}
	
}
