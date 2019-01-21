package com.ckwl.likemoney.bas.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.bas.dao.IDictionariesDetailDao;
import com.ckwl.likemoney.bas.dao.imp.DictionariesDetailDaoImpl;
import com.ckwl.likemoney.bas.entity.DictionariesDetail;
import com.ckwl.likemoney.bas.service.IDictionariesDetailService;
import com.ckwl.likemoney.bas.view.DictionariesDetailConditionView;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;
import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.frame.view.PageView;

public class DictionariesDetailServiceImpl implements IDictionariesDetailService{
	IDictionariesDetailDao iDictionariesDetailDao = new DictionariesDetailDaoImpl();
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<DictionariesDetail> list() {
		return iDictionariesDetailDao.list();
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(DictionariesDetail dictionariesDetail) {
		iDictionariesDetailDao.insert(dictionariesDetail);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String detailId) {
		iDictionariesDetailDao.delete(detailId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(DictionariesDetail dictionariesDetail) {
		iDictionariesDetailDao.update(dictionariesDetail);
	}

	@MyTransaction(readOnly=false)
	@Override
	public DictionariesDetail load(String detailId) {
		return iDictionariesDetailDao.load(detailId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView) {
		return iDictionariesDetailDao.list(conditionView);
	}

	@MyTransaction(readOnly=true)
	@Override
	public List<DictionariesDetailQueryView> findByDictCode(String dictCode) {
		// TODO Auto-generated method stub
		return iDictionariesDetailDao.findByDictCode(dictCode);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView, int pageIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		return iDictionariesDetailDao.list(conditionView, pageIndex, pageSize);
	}

	@MyTransaction(readOnly=true)
	@Override
	public int recordCount(DictionariesDetailConditionView conditionView) {
		// TODO Auto-generated method stub
		return iDictionariesDetailDao.recordCount(conditionView);
	}

	@MyTransaction(readOnly=false)
	@Override
	public PageView page(DictionariesDetailConditionView conditionView, int pageIndex, int pageSize) {
		ArrayList<DictionariesDetailQueryView> list = iDictionariesDetailDao.list(conditionView, pageIndex, pageSize);
		int recordCount = iDictionariesDetailDao.recordCount(conditionView);
		
		PageView pageView = new PageView();
		
		pageView.setList(list);
		pageView.setPageIndex(pageIndex);
		pageView.setPageSize(pageSize);
		pageView.setRecordCount(recordCount);
		
		int pageCount = (recordCount - 1)/pageSize + 1 ;
		pageView.setPageCount(pageCount);
		
		return pageView;
	}

}
