package com.ckwl.likemoney.system.view;

public class SystemModuleConditionView {
	private String  moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemModuleConditionView [moduleName=");
		builder.append(moduleName);
		builder.append("]");
		return builder.toString();
	}
	
}
