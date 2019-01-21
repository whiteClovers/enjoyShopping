package com.ckwl.likemoney.bas.entity;

public class ClassfiySmall {
	private String classfiySmallId;
	private String classfiyBigId;// 外键
	private String classfiySmallName;

	@Override
	public String toString() {
		return "ClassfiySmall [classfiySmallId=" + classfiySmallId + ", classfiyBigId=" + classfiyBigId
				+ ", classfiySmallName=" + classfiySmallName + "]";
	}

	public String getClassfiySmallId() {
		return classfiySmallId;
	}

	public void setClassfiySmallId(String classfiySmallId) {
		this.classfiySmallId = classfiySmallId;
	}

	public String getClassfiyBigId() {
		return classfiyBigId;
	}

	public void setClassfiyBigId(String classfiyBigId) {
		this.classfiyBigId = classfiyBigId;
	}

	public String getClassfiySmallName() {
		return classfiySmallName;
	}

	public void setClassfiySmallName(String classfiySmallName) {
		this.classfiySmallName = classfiySmallName;
	}



}
