package com.ckwl.likemoney.bas.view;

public class DictionariesConditionView {
	private String dictCode;
	private String dictLabel;
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
		builder.append("DictionariesConditionView [dictCode=");
		builder.append(dictCode);
		builder.append(", dictLabel=");
		builder.append(dictLabel);
		builder.append("]");
		return builder.toString();
	}
	
	
}
