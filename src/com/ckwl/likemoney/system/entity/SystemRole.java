package com.ckwl.likemoney.system.entity;

public class SystemRole {
	private String roleId;
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "SystemRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
