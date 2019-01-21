package com.ckwl.likemoney.bas.view;

import com.ckwl.likemoney.bas.entity.DictionariesDetail;

public class DictionariesDetailQueryView extends DictionariesDetail{
	private String dictLabel;

	public String getDictLabel() {
		return dictLabel;
	}

	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DictionariesQueryView [dictLabel=");
		builder.append(dictLabel);
		builder.append("]");
		return builder.toString();
	}
	
	
}
