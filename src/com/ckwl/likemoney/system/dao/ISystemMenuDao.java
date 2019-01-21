package com.ckwl.likemoney.system.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.system.entity.SystemMenu;
import com.ckwl.likemoney.system.view.SystemMenuConditionView;
import com.ckwl.likemoney.system.view.SystemMenuQueryView;

public interface ISystemMenuDao {
	public ArrayList<SystemMenu> list();
	public ArrayList<SystemMenuQueryView> list(SystemMenuConditionView systemMenuConditionView); 
	public void insert(SystemMenu systemMenu);
	public void delete(String menuId);
	public void update(SystemMenu systemMenu);
	public SystemMenu load(String menuId);
	
	public ArrayList<SystemMenuQueryView> selectByEmployeeId(String employeeId);
}
