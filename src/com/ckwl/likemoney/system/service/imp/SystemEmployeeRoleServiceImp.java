package com.ckwl.likemoney.system.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.system.dao.ISystemEmployeeRoleDao;
import com.ckwl.likemoney.system.dao.imp.SystemEmployeeRoleDaoImp;
import com.ckwl.likemoney.system.entity.SystemEmployeeRole;
import com.ckwl.likemoney.system.service.ISystemEmployeeRoleService;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleQueryView;

public class SystemEmployeeRoleServiceImp implements ISystemEmployeeRoleService {
	private ISystemEmployeeRoleDao systemEmployeeRoleDao=new SystemEmployeeRoleDaoImp();

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemEmployeeRole> list() {
		return systemEmployeeRoleDao.list();
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(SystemEmployeeRole employeeRole) {
		systemEmployeeRoleDao.insert(employeeRole);
		
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String emolloyeeRoleId) {
		systemEmployeeRoleDao.delete(emolloyeeRoleId);
		
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(SystemEmployeeRole employeeRole) {
		systemEmployeeRoleDao.update(employeeRole);
		
	}

	@MyTransaction(readOnly=true)
	@Override
	public SystemEmployeeRole load(String emolloyeeRoleId) {
		return systemEmployeeRoleDao.load(emolloyeeRoleId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemEmployeeRoleQueryView> list(
			SystemEmployeeRoleConditionView systemEmployeeRoleConditionView) {
		// TODO Auto-generated method stub
		return systemEmployeeRoleDao.list(systemEmployeeRoleConditionView);
	}


	
}
