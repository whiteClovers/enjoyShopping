package com.ckwl.likemoney.system.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.system.dao.ISystemRoleDao;
import com.ckwl.likemoney.system.dao.imp.SystemRoleDaoImpl;
import com.ckwl.likemoney.system.entity.SystemRole;
import com.ckwl.likemoney.system.service.ISystemRoleService;
import com.ckwl.likemoney.system.view.SystemRoleConditionView;

public class SystemRoleServiceImpl implements ISystemRoleService {
	private ISystemRoleDao iSystemRoleDao = new SystemRoleDaoImpl();
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemRole> list() {
		return iSystemRoleDao.list();
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(SystemRole role) {
		iSystemRoleDao.insert(role);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String roleId) {
		iSystemRoleDao.delete(roleId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(SystemRole role) {
		iSystemRoleDao.update(role);
	}

	@MyTransaction(readOnly=true)
	@Override
	public SystemRole load(String roleId) {
		return iSystemRoleDao.load(roleId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemRole> list(SystemRoleConditionView systemRoleConditionView) {
		return iSystemRoleDao.list(systemRoleConditionView);
	}

}
