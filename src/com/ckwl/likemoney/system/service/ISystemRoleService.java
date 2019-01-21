package com.ckwl.likemoney.system.service;

import java.util.ArrayList;

import com.ckwl.likemoney.system.entity.SystemRole;
import com.ckwl.likemoney.system.view.SystemRoleConditionView;

public interface ISystemRoleService {
	public ArrayList<SystemRole> list();
	public void insert(SystemRole role);
	public void delete(String roleId);
	public void update(SystemRole role);
	public SystemRole load(String roleId);
	public ArrayList<SystemRole> list(SystemRoleConditionView systemRoleConditionView);
}
