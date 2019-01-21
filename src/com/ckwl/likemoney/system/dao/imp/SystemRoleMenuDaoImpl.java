package com.ckwl.likemoney.system.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.dao.ISystemRoleMenuDao;
import com.ckwl.likemoney.system.entity.SystemRoleMenu;
import com.ckwl.likemoney.system.view.SystemRoleMenuConditionView;
import com.ckwl.likemoney.system.view.SystemRoleMenuQueryView;

public class SystemRoleMenuDaoImpl extends BaseDao implements ISystemRoleMenuDao {

	@Override
	public ArrayList<SystemRoleMenu> list() {
		ArrayList<SystemRoleMenu> arrayList = new ArrayList<SystemRoleMenu>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "select roleMenu_id,role_id,menu_id from sys_rolemenu";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemRoleMenu systemRoleMenu = new SystemRoleMenu();
				systemRoleMenu.setRoleMenuId(result.getString("roleMenu_id"));
				systemRoleMenu.setRoleId(result.getString("role_id"));
				systemRoleMenu.setMenuId(result.getString("menu_id"));
				System.out.println("roleMenuId:"+result.getString("roleMenu_id"));
				System.out.println("roleId:"+result.getString("role_id"));
				System.out.println("menuId:"+result.getString("menu_id"));
				arrayList.add(systemRoleMenu);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色菜单查询失败" ,e);
		}
	}

	@Override
	public void insert(SystemRoleMenu systemRoleMenu) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "insert into sys_rolemenu(roleMenu_id,role_id,menu_id) values(?,?,?) ";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, systemRoleMenu.getRoleMenuId());
			prepareStatement.setString(parameter++, systemRoleMenu.getRoleId());//为了不影响外键，先不设置
			prepareStatement.setString(parameter++, systemRoleMenu.getMenuId());//为了不影响外键，先不设置
//			prepareStatement.setString(parameter++, "1");
//			prepareStatement.setString(parameter++, "1");
			
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色菜单插入失败" ,e);
		}
	}

	@Override
	public void delete(String roleMenuId) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "delete from sys_rolemenu where roleMenu_id = ?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, roleMenuId);
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			if(rowCount == 0){
				throw new RuntimeException("id不存在");
			}
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色菜单删除失败" ,e);
		}
	}

	@Override
	public void update(SystemRoleMenu systemRoleMenu) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update sys_rolemenu set role_id=?,menu_id=? where roleMenu_id =? ";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			
			prepareStatement.setString(parameter++, systemRoleMenu.getRoleId());//为了不影响外键，先不设置
			prepareStatement.setString(parameter++, systemRoleMenu.getMenuId());//为了不影响外键，先不设置
//			prepareStatement.setString(parameter++, "1");
//			prepareStatement.setString(parameter++, "1");
			prepareStatement.setString(parameter++, systemRoleMenu.getRoleMenuId());
			
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色菜单更新失败" ,e);
		}
	}

	@Override
	public SystemRoleMenu load(String roleMenuId) {
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			String sql = "select roleMenu_id,role_id,menu_id from sys_rolemenu where roleMenu_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, roleMenuId);
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			SystemRoleMenu systemRoleMenu = new SystemRoleMenu();
			while(result.next()){
				systemRoleMenu.setRoleMenuId(result.getString("roleMenu_id"));
				systemRoleMenu.setRoleId(result.getString("role_id"));
				systemRoleMenu.setMenuId(result.getString("menu_id"));
				System.out.println("roleMenuId:"+result.getString("roleMenu_id"));
				System.out.println("roleId:"+result.getString("role_id"));
				System.out.println("menuId:"+result.getString("menu_id"));
			}
			return systemRoleMenu;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色菜单查询失败" ,e);
		}
	}

	@Override
	public ArrayList<SystemRoleMenuQueryView> list(SystemRoleMenuConditionView roleMenuConditionView) {
		ArrayList<SystemRoleMenuQueryView> arrayList = new ArrayList<SystemRoleMenuQueryView>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append("select sys_rolemenu.roleMenu_id,sys_rolemenu.role_id,sys_rolemenu.menu_id,sys_menu.menu_name,sys_role.role_name from sys_rolemenu");
			sql.append(" JOIN sys_menu ");
			sql.append(" ON sys_rolemenu.menu_id = sys_menu.menu_id ");
			sql.append(" JOIN sys_role ");
			sql.append(" ON sys_rolemenu.role_id = sys_role.role_id where 1=1");
			if(!StringUtil.isEmpty(roleMenuConditionView.getMenuName())){
				sql.append(" and sys_menu.menu_name like ?");
			}
			if(!StringUtil.isEmpty(roleMenuConditionView.getRoleName())){
				sql.append(" and sys_role.role_name like ?");
			}
			prepareStatement = super.prepareStatement(sql.toString());//继承BaseDao,创建并添加prepareStatement
			int parameterIndex = 1;
			if(!StringUtil.isEmpty(roleMenuConditionView.getMenuName())){
				prepareStatement.setString(parameterIndex++, "%"+roleMenuConditionView.getMenuName()+"%");
			}
			if(!StringUtil.isEmpty(roleMenuConditionView.getRoleName())){
				prepareStatement.setString(parameterIndex++, "%" + roleMenuConditionView.getRoleName() + "%");
			}
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemRoleMenuQueryView systemRoleMenuQueryView= new SystemRoleMenuQueryView();
				systemRoleMenuQueryView.setRoleMenuId(result.getString("sys_rolemenu.roleMenu_id"));
				systemRoleMenuQueryView.setRoleId(result.getString("sys_rolemenu.role_id"));
				systemRoleMenuQueryView.setMenuId(result.getString("sys_rolemenu.menu_id"));
				systemRoleMenuQueryView.setRoleName(result.getString("sys_role.role_name"));
				systemRoleMenuQueryView.setMenuName(result.getString("sys_menu.menu_name"));
				
				System.out.println("roleMenuId:"+result.getString("sys_rolemenu.roleMenu_id"));
				System.out.println("roleId:"+result.getString("sys_rolemenu.role_id"));
				System.out.println("menuId:"+result.getString("sys_rolemenu.menu_id"));
				System.out.println("roleId:"+result.getString("sys_role.role_name"));
				System.out.println("menuId:"+result.getString("sys_menu.menu_name"));
				arrayList.add(systemRoleMenuQueryView);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("角色菜单查询失败" ,e);
		}
	}

}
