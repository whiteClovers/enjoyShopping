package com.ckwl.likemoney.system.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.system.entity.SystemRoleMenu;
import com.ckwl.likemoney.system.view.SystemRoleMenuConditionView;
import com.ckwl.likemoney.system.view.SystemRoleMenuQueryView;

public interface ISystemRoleMenuDao {
	public ArrayList<SystemRoleMenu> list();
	public void insert(SystemRoleMenu systemRoleMenu);
	public void delete(String roleMenuId);
	public void update(SystemRoleMenu systemRoleMenu);
	public SystemRoleMenu load(String roleMenuId);
	public ArrayList<SystemRoleMenuQueryView> list(SystemRoleMenuConditionView roleMenuConditionView);
}
