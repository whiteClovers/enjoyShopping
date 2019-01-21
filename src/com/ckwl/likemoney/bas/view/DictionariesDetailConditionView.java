package com.ckwl.likemoney.bas.view;

public class DictionariesDetailConditionView {
	private String code;//根据英文来查询
	private String label;//根据中文来查询
	private String dictCode;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DictionariesConditionView [code=");
		builder.append(code);
		builder.append(", label=");
		builder.append(label);
		builder.append("]");
		return builder.toString();
	}
	public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	
}
