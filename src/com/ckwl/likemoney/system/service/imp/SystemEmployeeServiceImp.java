package com.ckwl.likemoney.system.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.system.dao.ISystemEmployeeDao;
import com.ckwl.likemoney.system.dao.imp.SystemEmployeeDaoImp;
import com.ckwl.likemoney.system.entity.SystemEmployee;
import com.ckwl.likemoney.system.service.ISystemEmployeeService;
import com.ckwl.likemoney.system.view.SystemEmployeeConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeQueryView;

public class SystemEmployeeServiceImp implements ISystemEmployeeService {
	private ISystemEmployeeDao SystemEmployeeDao=new SystemEmployeeDaoImp();
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemEmployeeQueryView> list(SystemEmployeeConditionView systemEmployeeConditionView) {

		return SystemEmployeeDao.list(systemEmployeeConditionView);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(SystemEmployee systemEmployee) {
		SystemEmployeeDao.insert(systemEmployee);
		
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String employeeId) {
		SystemEmployeeDao.delete(employeeId);
		
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(SystemEmployee systemEmployee) {
		SystemEmployeeDao.update(systemEmployee);
		
	}

	@MyTransaction(readOnly=true)
	@Override
	public SystemEmployee load(String employeeId) {
		
		return SystemEmployeeDao.load(employeeId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public SystemEmployee loginAdmin(String username, String password) {
		// TODO Auto-generated method stub
		return SystemEmployeeDao.loginAdmin(username, password);
	}

}
