package com.ckwl.likemoney.system.service;

import java.util.ArrayList;
import com.ckwl.likemoney.system.entity.SystemEmployee;
import com.ckwl.likemoney.system.view.SystemEmployeeConditionView;
import com.ckwl.likemoney.system.view.SystemEmployeeQueryView;

public interface ISystemEmployeeService {
	public ArrayList<SystemEmployeeQueryView> list(SystemEmployeeConditionView systemEmployeeConditionView);

	public void insert(SystemEmployee systemEmployee);

	public void delete(String employeeId);

	public void update(SystemEmployee systemEmployee);

	public SystemEmployee load(String employeeId);

	public SystemEmployee loginAdmin(String username,String password);
}
