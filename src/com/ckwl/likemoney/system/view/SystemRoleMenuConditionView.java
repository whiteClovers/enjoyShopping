package com.ckwl.likemoney.system.view;

public class SystemRoleMenuConditionView {
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
		builder.append("SystemRoleMenuCoditionView [roleName=");
		builder.append(roleName);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append("]");
		return builder.toString();
	}
	
}
