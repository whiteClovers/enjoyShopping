package com.ckwl.likemoney.system.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.dao.ISystemEmployeeRoleDao;
import com.ckwl.likemoney.system.entity.SystemEmployeeRole;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleQueryView;

public class SystemEmployeeRoleDaoImp extends BaseDao implements ISystemEmployeeRoleDao {

	@Override
	public ArrayList<SystemEmployeeRole> list() {
		ArrayList<SystemEmployeeRole> listSystemEmployeeRole = new ArrayList<SystemEmployeeRole>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from sys_employeerole";
			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {

				SystemEmployeeRole systemEmployeeRoleRole = new SystemEmployeeRole();
				String emPloyeeRoleId = resultSet.getString("employeeRole_id");
				String emPloyeeId = resultSet.getString("employee_id");
				String roleId = resultSet.getString("role_id");

				systemEmployeeRoleRole.setEmPloyeeRoleId(emPloyeeRoleId);
				systemEmployeeRoleRole.setEmPloyeeId(emPloyeeId);
				systemEmployeeRoleRole.setRoleId(roleId);

				System.out.println(systemEmployeeRoleRole.toString());

				listSystemEmployeeRole.add(systemEmployeeRoleRole);
			}
			return listSystemEmployeeRole;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("员工信息查询失败", ex);
		}
	}

	@Override
	public void insert(SystemEmployeeRole systemEmployeeRole) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into sys_employeerole(employeeRole_id,employee_id,role_id) values(?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + systemEmployeeRole.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			systemEmployeeRole.setEmPloyeeRoleId(uuid);
			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, systemEmployeeRole.getEmPloyeeId());
			preparedStatement.setObject(paramIndex++, systemEmployeeRole.getRoleId());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + systemEmployeeRole.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("新增保存成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("新增保存失败");
		}

	}

	@Override
	public void delete(String emPloyeeRoleId) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from sys_employeerole where employeeRole_id=?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;
			String uuid = emPloyeeRoleId;
			preparedStatement.setObject(paramIndex++, uuid);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:删除id:" + emPloyeeRoleId);

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("员工ID不存在:" + emPloyeeRoleId);
			}
			System.out.println("***影响行数:" + rowCount);

			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}

	}

	@Override
	public void update(SystemEmployeeRole systemEmployeeRole) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update sys_employeerole set employee_id=?,role_id=? where employeeRole_id=?";
			System.out.println("update sql:" + sql);

			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, systemEmployeeRole.getEmPloyeeId());
			preparedStatement.setObject(paramIndex++, systemEmployeeRole.getRoleId());
			preparedStatement.setObject(paramIndex++, systemEmployeeRole.getEmPloyeeRoleId());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + systemEmployeeRole.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("更新成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("更新失败");
		}

	}

	@Override
	public SystemEmployeeRole load(String emPloyeeRoleId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			SystemEmployeeRole systemEmployeeRole = new SystemEmployeeRole();

			// S3.获取statement(执行语句的对象)
			String sql = "select * from sys_employeerole where employeeRole_id = ?";
			preparedStatement = super.prepareStatement(sql);

			preparedStatement.setObject(1, emPloyeeRoleId);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:id=" + emPloyeeRoleId);

			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
//			super.addResultSet(resultSet);// 待封装

			// s4-1.遍历resultSet

			System.out.println("***SQL查询结果begin");
			if (resultSet.next()) {
				systemEmployeeRole.setEmPloyeeRoleId(resultSet.getString("employeeRole_id"));
				systemEmployeeRole.setEmPloyeeId(resultSet.getString("employee_id"));
				systemEmployeeRole.setRoleId(resultSet.getString("role_id"));

				System.out.println(systemEmployeeRole.toString());
			} else {
				System.out.println("ID不存在");
			}
			System.out.println("***SQL查询结果end");
			System.out.println("操作成功");
			return systemEmployeeRole;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		}
	}

	@Override
	public ArrayList<SystemEmployeeRoleQueryView> list(SystemEmployeeRoleConditionView systemEmployeeRoleConditionView) {

		ArrayList<SystemEmployeeRoleQueryView> listSystemEmployeeRole = new ArrayList<SystemEmployeeRoleQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select sys_employeerole.* , sys_employee.employee_name ,sys_role.role_name  from sys_employeerole ") ;
			sql.append(" JOIN sys_employee");
			sql.append(" on sys_employeerole.employee_id = sys_employee.employee_id");
			sql.append(" JOIN sys_role");
			sql.append(" on sys_employeerole.role_id = sys_role.role_id");
			
			if(!StringUtil.isEmpty(systemEmployeeRoleConditionView.getEmPloyeeName())){
				sql.append(" and sys_employee.employee_name like ?") ;
			}
			
			if(!StringUtil.isEmpty(systemEmployeeRoleConditionView.getRoleName())){
				sql.append(" and sys_role.role_name like ?") ;
			}
			

			System.out.println("sql"+sql);
	
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(!StringUtil.isEmpty(systemEmployeeRoleConditionView.getEmPloyeeName()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+systemEmployeeRoleConditionView.getEmPloyeeName() + "%");
			
			if(!StringUtil.isEmpty(systemEmployeeRoleConditionView.getRoleName()))
				preparedStatement.setObject(parameterIndex++ , "%"+systemEmployeeRoleConditionView.getRoleName()+ "%");
			

			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {

				SystemEmployeeRoleQueryView systemEmployeeRole = new SystemEmployeeRoleQueryView();
				systemEmployeeRole.setEmPloyeeRoleId(resultSet.getString("employeeRole_id"));;
				systemEmployeeRole.setEmPloyeeId(resultSet.getString("employee_id"));
				systemEmployeeRole.setRoleId(resultSet.getString("role_id"));
				systemEmployeeRole.setEmPloyeeName(resultSet.getString("employee_name"));
				systemEmployeeRole.setRoleName(resultSet.getString("role_name"));
				System.out.println(systemEmployeeRole.toString());

				listSystemEmployeeRole.add(systemEmployeeRole);
			}
			return listSystemEmployeeRole;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("员工信息查询失败", ex);
		}
	

	}


}
