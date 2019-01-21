package com.ckwl.likemoney.stock.service;
import java.util.ArrayList;

import com.ckwl.likemoney.stock.entity.StockIn;
import com.ckwl.likemoney.stock.view.StockInConditionView;
import com.ckwl.likemoney.stock.view.StockInQueryView;

public interface IStockInService {
	public void insert(StockIn stockIn);
	public void update(StockIn stockIn);
	public void delete(String stockInId);
	public ArrayList<StockIn> list();
	public StockIn load(String stockInId);
	public ArrayList<StockInQueryView> list(StockInConditionView stockInConditionView);
}
