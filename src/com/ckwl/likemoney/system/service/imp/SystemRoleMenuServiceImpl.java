package com.ckwl.likemoney.system.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.system.dao.ISystemRoleMenuDao;
import com.ckwl.likemoney.system.dao.imp.SystemRoleMenuDaoImpl;
import com.ckwl.likemoney.system.entity.SystemRoleMenu;
import com.ckwl.likemoney.system.service.ISystemRoleMenuService;
import com.ckwl.likemoney.system.view.SystemRoleMenuConditionView;
import com.ckwl.likemoney.system.view.SystemRoleMenuQueryView;

public class SystemRoleMenuServiceImpl implements ISystemRoleMenuService {
	private ISystemRoleMenuDao iSystemRoleMenuDao = new SystemRoleMenuDaoImpl();
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemRoleMenu> list() {
		return iSystemRoleMenuDao.list();
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(SystemRoleMenu systemRoleMenu) {
		iSystemRoleMenuDao.insert(systemRoleMenu);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String roleMenuId) {
		iSystemRoleMenuDao.delete(roleMenuId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(SystemRoleMenu systemRoleMenu) {
		iSystemRoleMenuDao.update(systemRoleMenu);
	}

	@MyTransaction(readOnly=true)
	@Override
	public SystemRoleMenu load(String roleMenuId) {
		return iSystemRoleMenuDao.load(roleMenuId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemRoleMenuQueryView> list(SystemRoleMenuConditionView roleMenuConditionView) {
		return iSystemRoleMenuDao.list(roleMenuConditionView);
	}

}
