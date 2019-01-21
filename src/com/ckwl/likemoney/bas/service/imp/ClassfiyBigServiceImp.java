package com.ckwl.likemoney.bas.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.dao.IclassfiyBigDao;
import com.ckwl.likemoney.bas.dao.imp.ClassfiyBigDaoImp;
import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.service.IClassfiyBigService;
import com.ckwl.likemoney.bas.view.ClassfiyBigConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.front.view.ClassfiyBigView;

public class ClassfiyBigServiceImp implements IClassfiyBigService {
	private IclassfiyBigDao classfiyBigDao=new ClassfiyBigDaoImp();

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ClassfiyBigView> listView() {
		
		return classfiyBigDao.listView();
	}
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ClassfiyBig> list( ClassfiyBigConditionView classfiyBigConditionView) {
		return classfiyBigDao.list(classfiyBigConditionView);
	}
	@MyTransaction(readOnly=false)
	@Override
	public void insert(ClassfiyBig calssfiyBig) {
		classfiyBigDao.insert(calssfiyBig);
		
	}
	@MyTransaction(readOnly=false)
	@Override
	public void delete(String calssfiyBigId) {
		classfiyBigDao.delete(calssfiyBigId);
		
	}
	@MyTransaction(readOnly=false)
	@Override
	public void update(ClassfiyBig calssfiyBig) {
		classfiyBigDao.update(calssfiyBig);
		
	}
	@MyTransaction(readOnly=true)
	@Override
	public ClassfiyBig load(String calssfiyBigId) {
		return classfiyBigDao.load(calssfiyBigId);
	}
	

}
