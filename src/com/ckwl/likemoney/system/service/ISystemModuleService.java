package com.ckwl.likemoney.system.service;

import java.util.ArrayList;

import com.ckwl.likemoney.system.entity.SystemModule;
import com.ckwl.likemoney.system.view.SystemModuleConditionView;

public interface ISystemModuleService {
	public ArrayList<SystemModule> list();
	public void insert(SystemModule module);
	public void delete(String moduleId);
	public void update(SystemModule module);
	public SystemModule load(String moduleId);
	public ArrayList<SystemModule> list(SystemModuleConditionView systemModuleConditionView);
}
