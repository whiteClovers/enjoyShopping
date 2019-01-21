package com.ckwl.likemoney.bas.entity;

public class Dictionaries {
	private String id;//id
	private String dictCode;//英文
	private String dictLabel;//中文
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getDictLabel() {
		return dictLabel;
	}
	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dictionaries [id=");
		builder.append(id);
		builder.append(", dictCode=");
		builder.append(dictCode);
		builder.append(", dictLabel=");
		builder.append(dictLabel);
		builder.append("]");
		return builder.toString();
	}
	
	
}
