package com.ckwl.likemoney.system.view;

import com.ckwl.likemoney.system.entity.SystemRoleMenu;

public class SystemRoleMenuQueryView extends SystemRoleMenu {
	private String roleName;
	private String menuName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemRoleMenuQueryView [roleName=");
		builder.append(roleName);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append("]");
		return builder.toString();
	}
	
}
