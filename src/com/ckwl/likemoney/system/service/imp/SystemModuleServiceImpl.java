package com.ckwl.likemoney.system.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.system.dao.ISystemModuleDao;
import com.ckwl.likemoney.system.dao.imp.SystemModuleDaoImpl;
import com.ckwl.likemoney.system.entity.SystemModule;
import com.ckwl.likemoney.system.service.ISystemModuleService;
import com.ckwl.likemoney.system.view.SystemModuleConditionView;

public class SystemModuleServiceImpl implements ISystemModuleService {
	private ISystemModuleDao iSystemModuleDao = new SystemModuleDaoImpl();
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemModule> list() {
		return iSystemModuleDao.list();
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(SystemModule module) {
		iSystemModuleDao.insert(module);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String moduleId) {
		iSystemModuleDao.delete(moduleId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(SystemModule module) {
		iSystemModuleDao.update(module);
	}

	@MyTransaction(readOnly=true)
	@Override
	public SystemModule load(String moduleId) {
		return iSystemModuleDao.load(moduleId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<SystemModule> list(SystemModuleConditionView systemModuleConditionView) {
		return iSystemModuleDao.list(systemModuleConditionView);
	}

}
