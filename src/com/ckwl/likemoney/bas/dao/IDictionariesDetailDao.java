package com.ckwl.likemoney.bas.dao;

import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.bas.entity.DictionariesDetail;
import com.ckwl.likemoney.bas.view.DictionariesDetailConditionView;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;

public interface IDictionariesDetailDao {
	public ArrayList<DictionariesDetail> list();//查询所有的方法
	public void insert(DictionariesDetail dictionariesDetail);//增加一条记录
	public void update(DictionariesDetail dictionariesDetail);//更新一条记录
	public void delete(String detailId);//删除一条记录
	public DictionariesDetail load(String detailId);//查询个人
	
	public List<DictionariesDetailQueryView> findByDictCode(String dictCode);
	
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView);//查询所有的方法
	
	//根据当前页和每页数据条数查询数据
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView ,int pageIndex ,int pageSize);
	
	// 查询总记录条数
	public int recordCount(DictionariesDetailConditionView conditionView);
	
}
