package com.ckwl.likemoney.system.view;

public class SystemRoleConditionView {
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemRoleConditionView [roleName=");
		builder.append(roleName);
		builder.append("]");
		return builder.toString();
	}
	
}