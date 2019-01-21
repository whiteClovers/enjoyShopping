package com.ckwl.likemoney.system.service;

import java.util.ArrayList;

import com.ckwl.likemoney.system.entity.SystemMenu;
import com.ckwl.likemoney.system.view.SystemMenuConditionView;
import com.ckwl.likemoney.system.view.SystemMenuQueryView;

public interface ISystemMenuService {
	public ArrayList<SystemMenu> list();
	public ArrayList<SystemMenuQueryView> list(SystemMenuConditionView systemMenuConditionView);
	public void insert(SystemMenu menu);
	public void delete(String menuId);
	public void update(SystemMenu menu);
	public SystemMenu load(String menuId);
	
	public ArrayList<SystemMenuQueryView> selectByEmployeeId(String employeeId);
}
