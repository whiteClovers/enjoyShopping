package com.ckwl.likemoney.bas.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.dao.IDictionariesDao;
import com.ckwl.likemoney.bas.dao.imp.DictionariesDaoImpl;
import com.ckwl.likemoney.bas.entity.Dictionaries;
import com.ckwl.likemoney.bas.service.IDictionariesService;
import com.ckwl.likemoney.bas.view.DictionariesConditionView;
import com.ckwl.likemoney.frame.annotation.MyTransaction;

public class DictionariesServiceImpl implements IDictionariesService {
	private IDictionariesDao iDictionariesDao = new DictionariesDaoImpl();
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<Dictionaries> list() {
		ArrayList<Dictionaries> dictionaries = iDictionariesDao.list();
		return dictionaries;
	}

	@MyTransaction(readOnly = false)
	@Override
	public void insert(Dictionaries dictionaries) {
		iDictionariesDao.insert(dictionaries);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String id) {
		iDictionariesDao.delete(id);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(Dictionaries dictionaries) {
		iDictionariesDao.update(dictionaries);
	}

	@MyTransaction(readOnly=true)
	@Override
	public Dictionaries load(String id) {
		Dictionaries dictionaries = iDictionariesDao.load(id);
		return dictionaries;
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<Dictionaries> list(DictionariesConditionView dictionariesConditionView) {
		return iDictionariesDao.list(dictionariesConditionView);
	}

}
