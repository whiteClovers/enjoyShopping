package com.ckwl.likemoney.bas.service;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.entity.Dictionaries;
import com.ckwl.likemoney.bas.view.DictionariesConditionView;


public interface IDictionariesService {
	/**
	 * 调用DictionariesDao的list()，返回一个ArrayList<Student>集合对象
	 * @return
	 */
	public ArrayList<Dictionaries> list();
	/**
	 * 调用DictionariesDao的insert(),传入一个实体对象，实现增加
	 * @param student
	 */
	public void insert(Dictionaries dictionaries);
	/**
	 * 调用DictionariesDao的delete(),通过id删除对象
	 * @param id
	 */
	public void delete(String id);
	/**
	 * 调用DictionariesDao的update()，通过传入的对象，实现更新
	 * @param student
	 */
	public void update(Dictionaries dictionaries);
	/**
	 * 调用DictionariesDao的load()，通过id，查询并返回一个实体对象
	 * @param id
	 */
	public Dictionaries load(String id);
	public ArrayList<Dictionaries> list(DictionariesConditionView dictionariesConditionView);
}
