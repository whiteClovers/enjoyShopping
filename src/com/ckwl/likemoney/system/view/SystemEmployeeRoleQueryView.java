package com.ckwl.likemoney.system.view;

import java.io.Serializable;

import com.ckwl.likemoney.system.entity.SystemEmployeeRole;

public class SystemEmployeeRoleQueryView extends SystemEmployeeRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String emPloyeeName;
	private String roleName;

	

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getEmPloyeeName() {
		return emPloyeeName;
	}
	public void setEmPloyeeName(String emPloyeeName) {
		this.emPloyeeName = emPloyeeName;
	}

	
}
