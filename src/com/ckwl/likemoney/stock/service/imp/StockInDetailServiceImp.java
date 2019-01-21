package com.ckwl.likemoney.stock.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.stock.dao.IStockInDetailDao;
import com.ckwl.likemoney.stock.dao.imp.StockInDetailDaoImp;
import com.ckwl.likemoney.stock.entity.StockInDetail;
import com.ckwl.likemoney.stock.service.IStockInDetailService;
import com.ckwl.likemoney.stock.view.StockInDetailConditionView;
import com.ckwl.likemoney.stock.view.StockInDetailQueryView;

public class StockInDetailServiceImp implements IStockInDetailService{
	IStockInDetailDao  stockInDetailDao = new StockInDetailDaoImp();
	
	@MyTransaction(readOnly=false)
	public void insert(StockInDetail stockInDetail){
		stockInDetailDao.insert(stockInDetail);
	};
	
	@MyTransaction(readOnly=false)
	public void delete(String stockIn_detail_id){
		stockInDetailDao.delete(stockIn_detail_id);
	};
	
	@MyTransaction(readOnly=false)
	public void update(StockInDetail stockInDetail){
		stockInDetailDao.update(stockInDetail);
	};
	
	@MyTransaction(readOnly=true)
	public ArrayList<StockInDetail> list(){
		return stockInDetailDao.list();
	}
	
	@MyTransaction(readOnly=true)
	@Override
	public StockInDetail load(String stockIn_detail_id) {
		return stockInDetailDao.load(stockIn_detail_id);
	}
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<StockInDetailQueryView> list(StockInDetailConditionView stockInDetailConditionView) {
		return stockInDetailDao.list(stockInDetailConditionView);
	}
	
	
}
