package com.ckwl.likemoney.system.service;

import java.util.ArrayList;

import com.ckwl.likemoney.system.entity.SystemEmployeeRole;
import com.ckwl.likemoney.system.view.SystemEmployeeConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeRoleQueryView;

public interface ISystemEmployeeRoleService {
	public ArrayList<SystemEmployeeRole> list();

	public void insert(SystemEmployeeRole employeeRole);

	public void delete(String emolloyeeRoleId);

	public void update(SystemEmployeeRole employeeRole);

	public SystemEmployeeRole load(String emolloyeeRoleId);
	
	public ArrayList<SystemEmployeeRoleQueryView> list(SystemEmployeeRoleConditionView systemEmployeeRoleConditionView);

}
