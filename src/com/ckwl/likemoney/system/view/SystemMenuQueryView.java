package com.ckwl.likemoney.system.view;

import com.ckwl.likemoney.system.entity.SystemMenu;

public class SystemMenuQueryView extends SystemMenu{
	private String moduleName;
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
}
