package com.ckwl.likemoney.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ckwl.likemoney.bas.dao.IDictionariesDao;
import com.ckwl.likemoney.bas.entity.Dictionaries;
import com.ckwl.likemoney.bas.view.DictionariesConditionView;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;

public class DictionariesDaoImpl extends BaseDao implements IDictionariesDao{

	@Override
	public ArrayList<Dictionaries> list() {
		ArrayList<Dictionaries> arrayList = new ArrayList<Dictionaries>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "select dataDictonary_id,dataDictonary_code,dataDictonary_label from bas_datadictonary";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				Dictionaries dictionaries = new Dictionaries();
				dictionaries.setId(result.getString("dataDictonary_id"));
				dictionaries.setDictCode(result.getString("dataDictonary_code"));
				dictionaries.setDictLabel(result.getString("dataDictonary_label"));
				System.out.println("id:"+result.getString("dataDictonary_id"));
				System.out.println("code:"+result.getString("dataDictonary_code"));
				System.out.println("label:"+result.getString("dataDictonary_label"));
				arrayList.add(dictionaries);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败" ,e);
		}
	}

	@Override
	public void insert(Dictionaries dictionaries) {
		PreparedStatement prepareStatement = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "insert into bas_datadictonary(dataDictonary_code,dataDictonary_label,dataDictonary_id) values(?,?,?)";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, dictionaries.getDictCode());
			prepareStatement.setString(parameter++, dictionaries.getDictLabel());
			prepareStatement.setString(parameter++, dictionaries.getId());
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败" ,e);
		}
	}
	
	@Override
	public void update(Dictionaries dictionaries) {
		PreparedStatement prepareStatement = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "update bas_datadictonary set dataDictonary_code=?,dataDictonary_label=? where dataDictonary_id = ?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, dictionaries.getDictCode());
			prepareStatement.setString(parameter++, dictionaries.getDictLabel());
			prepareStatement.setString(parameter++, dictionaries.getId());
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典更新失败" ,e);
		}
	}

	@Override
	public void delete(String id) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "delete from bas_datadictonary where dataDictonary_id = ?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, id);
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
			if(rowCount == 0){
				throw new RuntimeException("数据字典id不存在");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典删除失败" ,e);
		}
	}

	@Override
	public Dictionaries load(String id) {
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			String sql = "select dataDictonary_id,dataDictonary_code,dataDictonary_label from bas_datadictonary where dataDictonary_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, id);
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			Dictionaries dictionaries = new Dictionaries();
			while(result.next()){
				dictionaries.setId(result.getString("dataDictonary_id"));
				dictionaries.setDictCode(result.getString("dataDictonary_code"));
				dictionaries.setDictLabel(result.getString("dataDictonary_label"));
				System.out.println("id:"+result.getString("dataDictonary_id"));
				System.out.println("code:"+result.getString("dataDictonary_code"));
				System.out.println("label:"+result.getString("dataDictonary_label"));
			}
			System.out.println(">>>输出结果end.");
			return dictionaries;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败" ,e);
		}
	}

	@Override
	public ArrayList<Dictionaries> list(DictionariesConditionView dictionariesConditionView) {
		ArrayList<Dictionaries> arrayList = new ArrayList<Dictionaries>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append("select dataDictonary_id,dataDictonary_code,dataDictonary_label from bas_datadictonary where 1=1");
			if(!StringUtil.isEmpty(dictionariesConditionView.getDictCode())){
				sql.append(" and dataDictonary_code like ?");
			}
			if(!StringUtil.isEmpty(dictionariesConditionView.getDictLabel())){
				sql.append(" and dataDictonary_label like ?");
			}
			prepareStatement = super.prepareStatement(sql.toString());//继承BaseDao,创建并添加prepareStatement
			int parameterIndex = 1;
			if(!StringUtil.isEmpty(dictionariesConditionView.getDictCode())){
				prepareStatement.setString(parameterIndex++,"%"+ dictionariesConditionView.getDictCode()+"%");
			}
			if(!StringUtil.isEmpty(dictionariesConditionView.getDictLabel())){
				prepareStatement.setString(parameterIndex++,"%"+ dictionariesConditionView.getDictLabel()+"%");
			}
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				Dictionaries dictionaries = new Dictionaries();
				dictionaries.setId(result.getString("dataDictonary_id"));
				dictionaries.setDictCode(result.getString("dataDictonary_code"));
				dictionaries.setDictLabel(result.getString("dataDictonary_label"));
				System.out.println("id:"+result.getString("dataDictonary_id"));
				System.out.println("code:"+result.getString("dataDictonary_code"));
				System.out.println("label:"+result.getString("dataDictonary_label"));
				arrayList.add(dictionaries);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败" ,e);
		}
	}

	

}
