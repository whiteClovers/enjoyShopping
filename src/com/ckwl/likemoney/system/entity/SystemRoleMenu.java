package com.ckwl.likemoney.system.entity;

public class SystemRoleMenu {
	private String roleMenuId;
	private String roleId;       //外键
	private String menuId;       //外键

	public String getRoleMenuId() {
		return roleMenuId;
	}
	public void setRoleMenuId(String roleMenuId) {
		this.roleMenuId = roleMenuId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemRoleMenu [roleMenuId=");
		builder.append(roleMenuId);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append(", menuId=");
		builder.append(menuId);
		builder.append("]");
		return builder.toString();
	}
	
}  
