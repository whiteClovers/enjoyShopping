package com.ckwl.likemoney.bas.entity;

public class DictionariesDetail {
	private String detailId;//数据字典明细id
	private String dictonaryId;//数据字典id(外键)
	private String code;//明细的英文
	private String dictCode;//数据字典code
	private String label;//明细的中文
	private String num;//排名，排序
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailID) {
		this.detailId = detailID;
	}
	public String getDictonaryId() {
		return this.dictonaryId;
	}
	public void setDictonaryId(String dictonaryId) {
		this.dictonaryId = dictonaryId;
	}
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DictionariesDetail [detailID=");
		builder.append(detailId);
		builder.append(", dictonaryId=");
		builder.append(dictonaryId);
		builder.append(", code=");
		builder.append(code);
		builder.append(", label=");
		builder.append(label);
		builder.append(", num=");
		builder.append(num);
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
