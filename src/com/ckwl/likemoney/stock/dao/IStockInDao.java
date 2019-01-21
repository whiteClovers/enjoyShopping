package com.ckwl.likemoney.stock.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.stock.entity.StockIn;
import com.ckwl.likemoney.stock.view.StockInConditionView;
import com.ckwl.likemoney.stock.view.StockInQueryView;

public interface IStockInDao {
	public void insert(StockIn stockIn);
	public void delete(String stockInId);
	public void update(StockIn stockIn);
	public StockIn load(String stockInId);
	public ArrayList<StockIn> list();
	public ArrayList<StockInQueryView> list(StockInConditionView stockInConditionView);
}
