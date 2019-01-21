package com.ckwl.likemoney.system.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.dao.ISystemModuleDao;
import com.ckwl.likemoney.system.entity.SystemModule;
import com.ckwl.likemoney.system.view.SystemModuleConditionView;

public class SystemModuleDaoImpl extends BaseDao implements ISystemModuleDao {

	@Override
	public ArrayList<SystemModule> list() {
		ArrayList<SystemModule> arrayList = new ArrayList<SystemModule>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "select module_id,module_name from sys_module";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemModule module = new SystemModule();
				module.setModuleId(result.getString("module_id"));
				module.setModuleName(result.getString("module_name"));
				System.out.println("moduleId:"+result.getString("module_id"));
				System.out.println("moduleName:"+result.getString("module_name"));
				arrayList.add(module);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块查询失败" ,e);
		}
	}

	@Override
	public void insert(SystemModule module) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "insert into sys_module(module_id,module_name) values(?,?) ";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, module.getModuleId());
			prepareStatement.setString(parameter++, module.getModuleName());
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块插入失败" ,e);
		}
	}

	@Override
	public void delete(String moduleId) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "delete from sys_module where module_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter, moduleId);
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			if(rowCount == 0){
				throw new RuntimeException("删除模块出错");
			}
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除模块失败" ,e);
		}
	}

	@Override
	public void update(SystemModule module) {
		PreparedStatement prepareStatement = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "update sys_module set module_name=? where module_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, module.getModuleName());
			prepareStatement.setString(parameter++, module.getModuleId());
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块更新失败" ,e);
		}
	}

	@Override
	public SystemModule load(String moduleId) {
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			String sql = "select module_id,module_name from sys_module where module_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, moduleId);
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			SystemModule systemModule = new SystemModule();
			while(result.next()){
				systemModule.setModuleId(result.getString("module_id"));
				systemModule.setModuleName(result.getString("module_name"));
				System.out.println("moduleId:"+result.getString("module_id"));
				System.out.println("moduleName:"+result.getString("module_name"));
			}
			return systemModule;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败" ,e);
		}
	}

	@Override
	public ArrayList<SystemModule> list(SystemModuleConditionView systemModuleConditionView) {
		ArrayList<SystemModule> arrayList = new ArrayList<SystemModule>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append("select module_id,module_name from sys_module where 1=1");
			if(!StringUtil.isEmpty(systemModuleConditionView.getModuleName())){
				sql.append(" and module_name like ?");
			}
			prepareStatement = super.prepareStatement(sql.toString());//继承BaseDao,创建并添加prepareStatement
			int parameterIndex = 1;
			if(!StringUtil.isEmpty(systemModuleConditionView.getModuleName())){
				prepareStatement.setString(parameterIndex, "%"+systemModuleConditionView.getModuleName()+"%");
			}
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemModule module = new SystemModule();
				module.setModuleId(result.getString("module_id"));
				module.setModuleName(result.getString("module_name"));
				System.out.println("moduleId:"+result.getString("module_id"));
				System.out.println("moduleName:"+result.getString("module_name"));
				arrayList.add(module);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块查询失败" ,e);
		}
	}

}
