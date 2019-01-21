package com.ckwl.likemoney.system.entity;

public class SystemMenu {
	private String menuId;         
	private String menuName;       
	private String moduleId;//外键
	
	private String url;//外键
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
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
		builder.append("SystemMenu [menuId=");
		builder.append(menuId);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", moduleId=");
		builder.append(moduleId);
		builder.append("]");
		return builder.toString();
	}       
	
}
