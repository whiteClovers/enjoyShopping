package com.ckwl.likemoney.bas.service;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.view.ClassfiyBigConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.front.view.ClassfiyBigView;

public interface IClassfiyBigService {
	public ArrayList<ClassfiyBig> list(ClassfiyBigConditionView classfiyBigConditionView );
	
	public ArrayList<ClassfiyBigView> listView();

	public void insert(ClassfiyBig calssfiyBig);

	public void delete(String calssfiyBigId);

	public void update(ClassfiyBig calssfiyBig);

	public ClassfiyBig load(String calssfiyBigId);

}
