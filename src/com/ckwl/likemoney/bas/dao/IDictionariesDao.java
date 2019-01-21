package com.ckwl.likemoney.bas.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.entity.Dictionaries;
import com.ckwl.likemoney.bas.view.DictionariesConditionView;

public interface IDictionariesDao {
	/**
	 * 查询所有的学生记录
	 * @return ArrayList<Student>
	 */
	public ArrayList<Dictionaries> list();//查询所有的方法
	/**
	 * 传入一个实体对象，然后把数据添加到数据库
	 * @param student
	 */
	public void insert(Dictionaries dictionaries );//增加一条记录
	/**
	 * 传入一个实体对象，然后更新相应id的记录
	 * @param student
	 */
	public void update(Dictionaries dictionaries);//更新一条记录
	/**
	 * 通过传入的Id，然后于数据库连接，删除对应记录
	 * @param id
	 */
	public void delete(String id);//删除一条记录
	/**
	 * 根据传入的id，查出对应的记录，然后返回一个实体对象
	 * @param id
	 * @return
	 */
	public Dictionaries load(String id);//查询个人
	public ArrayList<Dictionaries> list(DictionariesConditionView dictionariesConditionView);
	
}
