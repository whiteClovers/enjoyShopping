package com.ckwl.likemoney.system.dao.imp;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.system.dao.ISystemEmployeeDao;
import com.ckwl.likemoney.system.entity.SystemEmployee;
import com.ckwl.likemoney.system.view.SystemEmployeeConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeQueryView;

public class SystemEmployeeDaoImp extends BaseDao implements ISystemEmployeeDao {

	@Override
	public ArrayList<SystemEmployeeQueryView> list(SystemEmployeeConditionView systemEmployeeConditionView) {
		ArrayList<SystemEmployeeQueryView> listSystemEmployee = new ArrayList<SystemEmployeeQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder();

			sql.append("select sys_employee.*,bas_datadictonary_detail.dataDictonary_detail_label  from sys_employee");
			sql.append(" JOIN bas_datadictonary_detail");
			sql.append(" ON sys_employee.employee_status=bas_datadictonary_detail.dataDictonary_detail_code");
			sql.append(" where bas_datadictonary_detail.dataDictonary_code='employee_status'");
			
			
			if (!StringUtil.isEmpty(systemEmployeeConditionView.getEmployeeName())) {
				sql.append(" and sys_employee.employee_name like ?");
			}
			if (!StringUtil.isEmpty(systemEmployeeConditionView.getEmployeeStatus())) {
				sql.append(" and sys_employee.employee_status like ?");
			}
			if (!StringUtil.isEmpty(systemEmployeeConditionView.getEmployeeInformation())) {
				sql.append(" and sys_employee.employee_information like ?");
			}
			
			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql.toString());
			
			int parameterIndex = 1;
			if (!StringUtil.isEmpty(systemEmployeeConditionView.getEmployeeName())) {
				preparedStatement.setObject(parameterIndex++,
						"%" + systemEmployeeConditionView.getEmployeeName() + "%");
			}
			if (!StringUtil.isEmpty(systemEmployeeConditionView.getEmployeeStatus())) {
				preparedStatement.setObject(parameterIndex++,
						"%" + systemEmployeeConditionView.getEmployeeStatus() + "%");
			}
			if (!StringUtil.isEmpty(systemEmployeeConditionView.getEmployeeInformation())) {
				preparedStatement.setObject(parameterIndex++,
						"%" + systemEmployeeConditionView.getEmployeeInformation() + "%");
			}
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {

				SystemEmployeeQueryView systemEmployee = new SystemEmployeeQueryView();
				String employeeId = resultSet.getString("employee_id");
				String employeeName = resultSet.getString("employee_name");
				String employeePwd = resultSet.getString("employee_pwd");
				String employeePhone = resultSet.getString("employee_phone");
				String employeeSex = resultSet.getString("employee_sex");
				String employeeStatus = resultSet.getString("employee_status");
				Date employeeBirthday = resultSet.getDate("employee_birthday");
				String employeeInformation = resultSet.getString("employee_information");
				String dataDictonaryDetailLabel = resultSet.getString("dataDictonary_detail_label");

				systemEmployee.setEmployeeId(employeeId);
				systemEmployee.setEmployeeName(employeeName);
				systemEmployee.setEmployeePwd(employeePwd);
				systemEmployee.setEmployeePhone(employeePhone);
				systemEmployee.setEmployeeSex(employeeSex);
				systemEmployee.setEmployeeStatus(employeeStatus);
				systemEmployee.setEmployeeBirthday(employeeBirthday);
				systemEmployee.setEmployeeInformation(employeeInformation);
				systemEmployee.setDataDictonaryDetailLabel(dataDictonaryDetailLabel);
				System.out.println(systemEmployee.toString());

				listSystemEmployee.add(systemEmployee);
			}
			return listSystemEmployee;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("员工信息查询失败", ex);
		}
	}

	@Override
	public void insert(SystemEmployee systemEmployee) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into sys_employee(employee_id,employee_name,employee_pwd,employee_phone,employee_sex,employee_status,employee_birthday,employee_information) values(?,?,?,?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + systemEmployee.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			systemEmployee.setEmployeeId(uuid);
			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeName());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeePwd());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeePhone());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeSex());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeStatus());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeBirthday());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeInformation());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + systemEmployee.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("新增保存成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("新增保存失败");
		}

	}

	@Override
	public void delete(String employeeId) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from sys_employee where employee_id=?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;
			String uuid = employeeId;
			preparedStatement.setObject(paramIndex++, uuid);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:删除id:" + employeeId);

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("员工ID不存在:" + employeeId);
			}
			System.out.println("***影响行数:" + rowCount);

			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}

	}

	@Override
	public void update(SystemEmployee systemEmployee) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update sys_employee set employee_name=?,employee_pwd=?,employee_phone=?,employee_sex=?,employee_status=?,employee_birthday=?,employee_information=? where employee_id=?";
			System.out.println("update sql:" + sql);

			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeName());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeePwd());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeePhone());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeSex());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeStatus());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeBirthday());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeInformation());
			preparedStatement.setObject(paramIndex++, systemEmployee.getEmployeeId());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + systemEmployee.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("更新成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("更新失败");
		}

	}

	@Override
	public SystemEmployee load(String employeeId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			SystemEmployee systemEmployee = new SystemEmployee();

			// S3.获取statement(执行语句的对象)
			String sql = "select * from sys_employee where employee_id = ?";
			preparedStatement = super.prepareStatement(sql);

			preparedStatement.setObject(1, employeeId);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:id=" + employeeId);

			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
//			super.addResultSet(resultSet);// 待封装

			// s4-1.遍历resultSet

			System.out.println("***SQL查询结果begin");
			if (resultSet.next()) {
				systemEmployee.setEmployeeId(resultSet.getString("employee_id"));
				systemEmployee.setEmployeeName(resultSet.getString("employee_name"));
				systemEmployee.setEmployeePwd(resultSet.getString("employee_pwd"));
				systemEmployee.setEmployeePhone(resultSet.getString("employee_phone"));
				systemEmployee.setEmployeeSex(resultSet.getString("employee_sex"));
				systemEmployee.setEmployeeStatus(resultSet.getString("employee_status"));
				systemEmployee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
				systemEmployee.setEmployeeInformation(resultSet.getString("employee_information"));

				System.out.println(systemEmployee.toString());
			} else {
				System.out.println("ID不存在");
			}
			System.out.println("***SQL查询结果end");
			System.out.println("操作成功");
			return systemEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		}
	}

	public SystemEmployee login(String username,String password) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			SystemEmployee systemEmployee = new SystemEmployee();

			// S3.获取statement(执行语句的对象)
			String sql = "select * from sys_employee where employee_name = ? ";
			preparedStatement = super.prepareStatement(sql);

			preparedStatement.setObject(1, username);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:name=" + username);

			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
//			super.addResultSet(resultSet);// 待封装

			// s4-1.遍历resultSet

			System.out.println("***SQL查询结果begin");
			if (resultSet.next()) {
				systemEmployee.setEmployeeId(resultSet.getString("employee_id"));
				systemEmployee.setEmployeeName(resultSet.getString("employee_name"));
				systemEmployee.setEmployeePwd(resultSet.getString("employee_pwd"));
				systemEmployee.setEmployeePhone(resultSet.getString("employee_phone"));
				systemEmployee.setEmployeeSex(resultSet.getString("employee_sex"));
				systemEmployee.setEmployeeStatus(resultSet.getString("employee_status"));
				systemEmployee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
				systemEmployee.setEmployeeInformation(resultSet.getString("employee_information"));

				System.out.println(systemEmployee.toString());
			} else {
				System.out.println("name不存在");
			}
			System.out.println("***SQL查询结果end");
			System.out.println("操作成功");
			return systemEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		}
	}

	
	@Override
	public SystemEmployee loginAdmin(String username, String password) {
		/*ISystemEmployeeDao employeeDao = new SystemEmployeeDaoImp();
		SystemEmployee employee = new SystemEmployee();
		ArrayList<SystemEmployeeQueryView> listSystemEmployee = employeeDao.list(new SystemEmployeeConditionView());
		
		for (SystemEmployeeQueryView systemEmployeeQueryView : listSystemEmployee) {
			if (systemEmployeeQueryView.getEmployeeName().equals(username)&&systemEmployeeQueryView.getEmployeePwd().equals(password)) {
				employee = systemEmployeeQueryView;
			}else {
				employee = null;
			}
		}
		
		return employee;*/
		if (StringUtil.isEmpty(username)||StringUtil.isEmpty(password)) {
			return null;
		}
		
		SystemEmployeeDaoImp employeeDao = new SystemEmployeeDaoImp();
		SystemEmployee employee = employeeDao.login(username, password);
		
		if (!employee.getEmployeePwd().equals(password)) {
			System.out.println("没有该用户");
			return null;
		}
		System.out.println("查询成功");
		
		return employee;
		
	}

}
