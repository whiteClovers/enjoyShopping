package com.ckwl.likemoney.system.entity;

public class SystemEmployeeRole {
	
	private String emPloyeeRoleId;
	private String emPloyeeId; // 外键
	private String roleId; // 外键



	@Override
	public String toString() {
		return "SystemEmployeeRole [emPloyeeRoleId=" + emPloyeeRoleId + ", emPloyeeId=" + emPloyeeId + ", roleId="
				+ roleId + "]";
	}

	public String getEmPloyeeRoleId() {
		return emPloyeeRoleId;
	}

	public void setEmPloyeeRoleId(String emPloyeeRoleId) {
		this.emPloyeeRoleId = emPloyeeRoleId;
	}

	public String getEmPloyeeId() {
		return emPloyeeId;
	}

	public void setEmPloyeeId(String emPloyeeId) {
		this.emPloyeeId = emPloyeeId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
