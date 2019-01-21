package com.ckwl.likemoney.system.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.dao.ISystemRoleDao;
import com.ckwl.likemoney.system.entity.SystemRole;
import com.ckwl.likemoney.system.view.SystemRoleConditionView;

public class SystemRoleDaoImpl extends BaseDao implements ISystemRoleDao {

	@Override
	public ArrayList<SystemRole> list() {
		ArrayList<SystemRole> arrayList = new ArrayList<SystemRole>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "select role_id,role_name from sys_role";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemRole role = new SystemRole();
				role.setRoleId(result.getString("role_id"));
				role.setRoleName(result.getString("role_name"));
				System.out.println("roleId:"+result.getString("role_id"));
				System.out.println("roleName:"+result.getString("role_name"));
				arrayList.add(role);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块查询失败" ,e);
		}
	}

	@Override
	public void insert(SystemRole role) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "insert into sys_role(role_id,role_name) values(?,?) ";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, role.getRoleId());
			prepareStatement.setString(parameter++, role.getRoleName());
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色插入失败" ,e);
		}
	}

	@Override
	public void delete(String roleId) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "delete from sys_role where role_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter, roleId);
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			if(rowCount == 0){
				throw new RuntimeException("删除角色出错");
			}
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除角色失败" ,e);
		}
	}

	@Override
	public void update(SystemRole role) {
		PreparedStatement prepareStatement = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "update sys_role set role_name=? where role_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, role.getRoleName());
			prepareStatement.setString(parameter++, role.getRoleId());
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色更新失败" ,e);
		}
	}

	@Override
	public SystemRole load(String roleId) {
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			String sql = "select role_id,role_name from sys_role where role_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, roleId);
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			SystemRole systemRole = new SystemRole();
			while(result.next()){
				systemRole.setRoleId(result.getString("role_id"));
				systemRole.setRoleName(result.getString("role_name"));
				System.out.println("roleId:"+result.getString("role_id"));
				System.out.println("roleName:"+result.getString("role_name"));
			}
			return systemRole;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色查询失败" ,e);
		}
	}

	@Override
	public ArrayList<SystemRole> list(SystemRoleConditionView systemRoleConditionView) {
		ArrayList<SystemRole> arrayList = new ArrayList<SystemRole>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append("select role_id,role_name from sys_role where 1=1");
			if(!StringUtil.isEmpty(systemRoleConditionView.getRoleName())){
				sql.append(" and role_name like ?");
			}
			prepareStatement = super.prepareStatement(sql.toString());//继承BaseDao,创建并添加prepareStatement
			int parameterIndex = 1;
			if(!StringUtil.isEmpty(systemRoleConditionView.getRoleName())){
				prepareStatement.setString(parameterIndex++,"%"+ systemRoleConditionView.getRoleName()+"%");
			}
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemRole role = new SystemRole();
				role.setRoleId(result.getString("role_id"));
				role.setRoleName(result.getString("role_name"));
				System.out.println("roleId:"+result.getString("role_id"));
				System.out.println("roleName:"+result.getString("role_name"));
				arrayList.add(role);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块查询失败" ,e);
		}
	}

}
