package com.ckwl.likemoney.system.view;

public class SystemMenuConditionView {
	private String menuName;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemMenuConditionView [menuName=");
		builder.append(menuName);
		builder.append("]");
		return builder.toString();
	}
	
}
