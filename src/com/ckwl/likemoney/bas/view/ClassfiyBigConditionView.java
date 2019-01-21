package com.ckwl.likemoney.bas.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClassfiyBigConditionView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String classfiyBigId;
	private String classfiyBigName;
	
	// 小类集合
	private List<ClassfiySmallQueryView> listSmall = new ArrayList<ClassfiySmallQueryView>();
	
	public List<ClassfiySmallQueryView> getListSmall() {
		return listSmall;
	}
	public void setListSmall(List<ClassfiySmallQueryView> listSmall) {
		this.listSmall = listSmall;
	}
	public String getClassfiyBigId() {
		return classfiyBigId;
	}
	public void setClassfiyBigId(String classfiyBigId) {
		this.classfiyBigId = classfiyBigId;
	}
	public String getClassfiyBigName() {
		return classfiyBigName;
	}
	public void setClassfiyBigName(String classfiyBigName) {
		this.classfiyBigName = classfiyBigName;
	}
	@Override
	public String toString() {
		return "ClassfiyBigConditionView [classfiyBigId=" + classfiyBigId + ", classfiyBigName=" + classfiyBigName
				+ "]";
	}
	
	
	
}
