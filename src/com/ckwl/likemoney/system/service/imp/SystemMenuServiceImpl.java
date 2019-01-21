package com.ckwl.likemoney.system.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.system.dao.ISystemMenuDao;
import com.ckwl.likemoney.system.dao.imp.SystemMenuDaoImpl;
import com.ckwl.likemoney.system.entity.SystemMenu;
import com.ckwl.likemoney.system.service.ISystemMenuService;
import com.ckwl.likemoney.system.view.SystemMenuConditionView;
import com.ckwl.likemoney.system.view.SystemMenuQueryView;

public class SystemMenuServiceImpl implements ISystemMenuService {
	private ISystemMenuDao iSystemMenuDao = new SystemMenuDaoImpl();
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemMenu> list() {
		return iSystemMenuDao.list();
	}
	
	@MyTransaction(readOnly=false)
	@Override
	public void insert(SystemMenu menu) {
		iSystemMenuDao.insert(menu);
	}
	@MyTransaction(readOnly=false)
	@Override
	public void delete(String menuId) {
		iSystemMenuDao.delete(menuId);
	}
	
	@MyTransaction(readOnly=false)
	@Override
	public void update(SystemMenu menu) {
		iSystemMenuDao.update(menu);
	}
	
	@MyTransaction(readOnly=true)
	@Override
	public SystemMenu load(String menuId) {
		return iSystemMenuDao.load(menuId);
	}
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemMenuQueryView> list(SystemMenuConditionView systemMenuConditionView) {
		return iSystemMenuDao.list(systemMenuConditionView);
	}
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemMenuQueryView> selectByEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		return iSystemMenuDao.selectByEmployeeId(employeeId);
	}

}
