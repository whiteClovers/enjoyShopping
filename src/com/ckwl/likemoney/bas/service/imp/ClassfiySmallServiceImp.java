package com.ckwl.likemoney.bas.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.dao.IClassfiySmallDao;
import com.ckwl.likemoney.bas.dao.imp.ClassfiySmallDaoImp;
import com.ckwl.likemoney.bas.entity.ClassfiySmall;
import com.ckwl.likemoney.bas.service.IClassfiySmallService;
import com.ckwl.likemoney.bas.view.ClassfiySmallConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.frame.annotation.MyTransaction;

public class ClassfiySmallServiceImp implements IClassfiySmallService {
	private IClassfiySmallDao classfiySmallDao = new ClassfiySmallDaoImp();
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ClassfiySmall> list() {

		return classfiySmallDao.list();
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(ClassfiySmall classfiySmall) {
		classfiySmallDao.insert(classfiySmall);

	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String classfiySmallId) {
		classfiySmallDao.delete(classfiySmallId);

	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(ClassfiySmall classfiySmall) {
		classfiySmallDao.update(classfiySmall);

	}
	@MyTransaction(readOnly=true)
	@Override
	public ClassfiySmall load(String classfiySmallId) {
		// TODO Auto-generated method stub
		return classfiySmallDao.load(classfiySmallId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ClassfiySmallQueryView> list(ClassfiySmallConditionView classfiySmallConditionView) {
		
		return classfiySmallDao.list(classfiySmallConditionView);
	}

}
