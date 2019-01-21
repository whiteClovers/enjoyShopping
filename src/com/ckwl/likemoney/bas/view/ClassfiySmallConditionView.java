package com.ckwl.likemoney.bas.view;

import java.io.Serializable;

public class ClassfiySmallConditionView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String classfiySmallId;
	private String classfiyBigId;// 外键
	private String classfiyBigName;
	private String classfiySmallName;



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

	public String getClassfiyBigName() {
		return classfiyBigName;
	}

	public void setClassfiyBigName(String classfiyBigName) {
		this.classfiyBigName = classfiyBigName;
	}

	@Override
	public String toString() {
		return "ClassfiySmallConditionView [classfiySmallId=" + classfiySmallId + ", classfiyBigId=" + classfiyBigId
				+ ", classfiyBigName=" + classfiyBigName + ", classfiySmallName=" + classfiySmallName + "]";
	}

}
