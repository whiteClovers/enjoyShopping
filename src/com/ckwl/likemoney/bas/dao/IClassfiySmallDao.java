package com.ckwl.likemoney.bas.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.entity.ClassfiySmall;
import com.ckwl.likemoney.bas.view.ClassfiySmallConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;

public interface IClassfiySmallDao {
	public ArrayList<ClassfiySmall> list();

	public void insert(ClassfiySmall classfiySmall);

	public void delete(String classfiySmallId);

	public void update(ClassfiySmall classfiySmall);

	public ClassfiySmall load(String classfiySmallId);
	
	public ArrayList<ClassfiySmallQueryView> list(ClassfiySmallConditionView classfiySmallConditionView);

}
