package com.ckwl.likemoney.stock.entity;

import java.math.BigDecimal;

public class StockInDetail {
	private String stockIn_detail_id;//入库明细id
	private String product_sku_id;//产品skuid---外键
	private String stockIn_detail_amount;//入库明细数量
	private BigDecimal stockIn_detail_price;//入库明细价格
	private String stockIn_id;//入库id----外键
	public String getStockIn_detail_id() {
		return stockIn_detail_id;
	}
	public void setStockIn_detail_id(String stockIn_detail_id) {
		this.stockIn_detail_id = stockIn_detail_id;
	}
	public String getProduct_sku_id() {
		return product_sku_id;
	}
	public void setProduct_sku_id(String product_sku_id) {
		this.product_sku_id = product_sku_id;
	}
	public String getStockIn_detail_amount() {
		return stockIn_detail_amount;
	}
	public void setStockIn_detail_amount(String stockIn_detail_amount) {
		this.stockIn_detail_amount = stockIn_detail_amount;
	}
	public BigDecimal getStockIn_detail_price() {
		return stockIn_detail_price;
	}
	public void setStockIn_detail_price(BigDecimal stockIn_detail_price) {
		this.stockIn_detail_price = stockIn_detail_price;
	}
	public String getStockIn_id() {
		return stockIn_id;
	}
	public void setStockIn_id(String stockIn_id) {
		this.stockIn_id = stockIn_id;
	}
	@Override
	public String toString() {
		return "StockInDetail [stockIn_detail_id=" + stockIn_detail_id + ", product_sku_id=" + product_sku_id
				+ ", stockIn_detail_amount=" + stockIn_detail_amount + ", stockIn_detail_price=" + stockIn_detail_price
				+ ", stockIn_id=" + stockIn_id + "]";
	}
	
	
	
	

}
