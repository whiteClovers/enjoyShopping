package com.ckwl.likemoney.system.view;

import java.io.Serializable;

public class SystemEmployeeRoleConditionView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	private String emPloyeeRoleId;
	private String emPloyeeId; // 外键
	private String roleId; // 外键
	private String emPloyeeName;
	private String roleName;




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

	public String getEmPloyeeName() {
		return emPloyeeName;
	}

	public void setEmPloyeeName(String emPloyeeName) {
		this.emPloyeeName = emPloyeeName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "SystemEmployeeRoleConditionView [emPloyeeRoleId=" + emPloyeeRoleId + ", emPloyeeId=" + emPloyeeId
				+ ", roleId=" + roleId + ", emPloyeeName=" + emPloyeeName + ", roleName=" + roleName + "]";
	}

}
