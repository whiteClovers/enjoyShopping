package com.ckwl.likemoney.system.entity;

public class SystemModule {
	private String moduleId;//模块id
	private String moduleName;//模块名
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	@Override
	public String toString() {
		return "SystemModule [moduleId=" + moduleId + ", moduleName=" + moduleName + "]";
	}
	
}
