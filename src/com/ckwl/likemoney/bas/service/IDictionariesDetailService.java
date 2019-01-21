package com.ckwl.likemoney.bas.service;

import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.bas.entity.DictionariesDetail;
import com.ckwl.likemoney.bas.view.DictionariesDetailConditionView;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;
import com.ckwl.likemoney.frame.view.PageView;

public interface IDictionariesDetailService {
	public ArrayList<DictionariesDetail> list();
	public void insert(DictionariesDetail dictionariesDetail);
	public void delete(String detailId);
	public void update(DictionariesDetail dictionariesDetail);
	public DictionariesDetail load(String load);
	public List<DictionariesDetailQueryView> findByDictCode(String dictCode);
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView);
	
	// 分页
	//根据当前页和每页数据条数查询数据
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView ,int pageIndex ,int pageSize);
	
	// 查询总记录条数
	public int recordCount(DictionariesDetailConditionView conditionView);
	
	// 组合page
	public PageView page(DictionariesDetailConditionView conditionView ,int pageIndex ,int pageSize);
}
