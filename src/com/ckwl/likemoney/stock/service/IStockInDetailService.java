package com.ckwl.likemoney.stock.service;

import java.util.ArrayList;


import com.ckwl.likemoney.stock.entity.StockInDetail;
import com.ckwl.likemoney.stock.view.StockInDetailConditionView;
import com.ckwl.likemoney.stock.view.StockInDetailQueryView;

public interface IStockInDetailService {
	public void insert(StockInDetail stockInDetail);
	public void update(StockInDetail stockInDetail);
	public void delete(String stockIn_detail_id);
	public ArrayList<StockInDetail> list();
	public StockInDetail load(String stockIn_detail_id);
	public ArrayList<StockInDetailQueryView> list(StockInDetailConditionView stockInDetailConditionView);
}
