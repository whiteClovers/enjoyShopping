package com.ckwl.likemoney.system.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.dao.ISystemMenuDao;
import com.ckwl.likemoney.system.entity.SystemMenu;
import com.ckwl.likemoney.system.view.SystemMenuConditionView;
import com.ckwl.likemoney.system.view.SystemMenuQueryView;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class SystemMenuDaoImpl extends BaseDao implements ISystemMenuDao {

	@Override
	public ArrayList<SystemMenu> list() {
		ArrayList<SystemMenu> arrayList = new ArrayList<SystemMenu>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "select menu_id,menu_name,module_id from sys_menu";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemMenu menu = new SystemMenu();
				menu.setMenuId(result.getString("menu_id"));
				menu.setMenuName(result.getString("menu_name"));
				menu.setModuleId(result.getString("module_id"));
				System.out.println("menuId:"+result.getString("menu_id"));
				System.out.println("menuName:"+result.getString("menu_name"));
				System.out.println("moduleId:"+result.getString("module_id"));
				arrayList.add(menu);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块查询失败" ,e);
		}
	}

	@Override
	public void insert(SystemMenu systemMenu) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "insert into sys_menu(menu_id,menu_name,module_id) values(?,?,?) ";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, systemMenu.getMenuId());
			prepareStatement.setString(parameter++, systemMenu.getMenuName());
			prepareStatement.setString(parameter++, systemMenu.getModuleId());//为了不影响外键，先不设置
//			prepareStatement.setString(parameter++, "1");
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块插入失败" ,e);
		}
	}

	@Override
	public void delete(String menuId) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "delete from sys_menu where menu_id = ?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, menuId);
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			if(rowCount == 0){
				throw new RuntimeException("id不存在");
			}
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除菜单失败" ,e);
		}
	}

	@Override
	public void update(SystemMenu systemMenu) {
		PreparedStatement prepareStatement = null;
		try {
			//数据字典的id，英文，对应的中文解释
			String sql = "update sys_menu set menu_name=?,module_id=? where menu_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, systemMenu.getMenuName());
			prepareStatement.setString(parameter++, systemMenu.getModuleId());//为了不影响外键，先不设置
//			prepareStatement.setString(parameter++, "1");
			prepareStatement.setString(parameter++, systemMenu.getMenuId());
			System.out.println(">>>sql:"+sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:"+rowCount);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("菜单更新失败" ,e);
		}
	}

	@Override
	public SystemMenu load(String menuId) {
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			String sql = "select menu_id,menu_name,module_id from sys_menu where menu_id=?";
			prepareStatement = super.prepareStatement(sql);//继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, menuId);
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			SystemMenu menu = new SystemMenu();
			while(result.next()){
				menu.setModuleId(result.getString("module_id"));
				menu.setMenuId(result.getString("menu_id"));
				menu.setMenuName(result.getString("menu_name"));
				System.out.println("menuId:"+result.getString("menu_id"));
				System.out.println("menuName:"+result.getString("menu_name"));
				System.out.println("moduleId:"+result.getString("module_id"));
			}
			return menu;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("菜单查询失败" ,e);
		}
	}

	@Override
	public ArrayList<SystemMenuQueryView> list(SystemMenuConditionView systemMenuConditionView) {
		ArrayList<SystemMenuQueryView> arrayList = new ArrayList<SystemMenuQueryView>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append(" select sys_menu.* , sys_module.module_name from sys_menu") ;
			sql.append(" JOIN sys_module");
			sql.append(" ON sys_menu.module_id = sys_module.module_id");
			
			
			//通过模糊查询来帅选结果，还有拼接sql语句
			if(!StringUtil.isEmpty(systemMenuConditionView.getMenuName())){
				sql.append(" and sys_menu.menu_name like ?");
			}
			prepareStatement = super.prepareStatement(sql.toString());//继承BaseDao,创建并添加prepareStatement
			int parameterIndex = 1;
			if(!StringUtil.isEmpty(systemMenuConditionView.getMenuName())){
				prepareStatement.setString(parameterIndex++ , "%"+systemMenuConditionView.getMenuName()+"%" );
			}
			
			
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemMenuQueryView systemMenuView = new SystemMenuQueryView();
				systemMenuView.setMenuId(result.getString("menu_id"));
				systemMenuView.setMenuName(result.getString("menu_name"));
				systemMenuView.setModuleId(result.getString("module_id"));
				systemMenuView.setModuleName(result.getString("module_name"));
				System.out.println("menuId:"+result.getString("menu_id"));
				System.out.println("menuName:"+result.getString("menu_name"));
				System.out.println("moduleId:"+result.getString("module_id"));
				System.out.println("moduleName:"+result.getString("module_name"));
				arrayList.add(systemMenuView);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("模块查询失败" ,e);
		}
	}
	
	@Override
	public ArrayList<SystemMenuQueryView> selectByEmployeeId(String employeeId){
		ArrayList<SystemMenuQueryView> arrayList = new ArrayList<SystemMenuQueryView>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			//数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT sys_menu.*,sys_employee.employee_name ") ;
			sql.append(" FROM sys_menu");
			
			sql.append(" INNER JOIN sys_rolemenu ") ;
			sql.append(" ON sys_rolemenu.menu_id = sys_menu.menu_id");
			
			sql.append(" INNER JOIN sys_employeerole");
			sql.append(" ON sys_employeerole.role_id = sys_rolemenu.role_id ") ;
			
			sql.append(" INNER JOIN sys_employee");
			sql.append(" ON sys_employee.employee_id = sys_employeerole.employee_id ") ;
			
			sql.append(" WHERE sys_employeerole.employee_id = ? ");
			
			//通过模糊查询来帅选结果，还有拼接sql语句
			/*if(!StringUtil.isEmpty(systemMenuConditionView.getMenuName())){
				sql.append(" and sys_menu.menu_name like ?");
			}*/
			
			prepareStatement = super.prepareStatement(sql.toString());//继承BaseDao,创建并添加prepareStatement
			
			int parameterIndex = 1;
			if(!StringUtil.isEmpty(employeeId)){
				prepareStatement.setString(parameterIndex++ , employeeId );
			}
			
			System.out.println(">>>sql:"+sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);//添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while(result.next()){
				SystemMenuQueryView systemMenuView = new SystemMenuQueryView();
				systemMenuView.setMenuId(result.getString("menu_id"));
				systemMenuView.setMenuName(result.getString("menu_name"));
				systemMenuView.setModuleId(result.getString("module_id"));
				systemMenuView.setUrl(result.getString("url"));
				
				arrayList.add(systemMenuView);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
//			throw new RuntimeException("模块查询失败" ,e);
		}
	}

}
