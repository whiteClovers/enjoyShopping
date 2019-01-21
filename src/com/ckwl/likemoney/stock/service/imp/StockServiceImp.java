package com.ckwl.likemoney.stock.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.stock.dao.IStockInDao;
import com.ckwl.likemoney.stock.dao.imp.StockInDaoImp;
import com.ckwl.likemoney.stock.entity.StockIn;
import com.ckwl.likemoney.stock.service.IStockInService;
import com.ckwl.likemoney.stock.view.StockInConditionView;
import com.ckwl.likemoney.stock.view.StockInQueryView;

public class StockServiceImp implements IStockInService{
	IStockInDao  stockInDao = new StockInDaoImp();
	
	@MyTransaction(readOnly=false)
	public void insert(StockIn stockIn){
		stockInDao.insert(stockIn);
	}
	
	@MyTransaction(readOnly=false)
	public void delete(String stockInId){
		stockInDao.delete(stockInId);
	}
	
	@MyTransaction(readOnly=false)
	public void update(StockIn stockIn){
		stockInDao.update(stockIn);
	}
	
	@MyTransaction(readOnly=true)
	public ArrayList<StockIn> list(){
		return stockInDao.list();
	}
	
	
	@MyTransaction(readOnly=true)
	@Override
	public StockIn load(String stockInId) {
		return stockInDao.load(stockInId);
	}
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<StockInQueryView> list(StockInConditionView stockInConditionView) {
		return stockInDao.list(stockInConditionView);
	};
}
