package com.ckwl.likemoney.bas.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.view.ClassfiyBigConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.front.view.ClassfiyBigView;

public interface IclassfiyBigDao {
	public ArrayList<ClassfiyBig> list(ClassfiyBigConditionView classfiyBigConditionView );

	public void insert(ClassfiyBig calssfiyBig);

	public void delete(String calssfiyBigId);

	public void update(ClassfiyBig calssfiyBig);

	public ClassfiyBig load(String calssfiyBigId);

	public ArrayList<ClassfiyBigView> listView();
	
//	public ArrayList<ClassfiyBigConditionView> list(ClassfiyBigConditionView classfiyBigConditionView );
}
