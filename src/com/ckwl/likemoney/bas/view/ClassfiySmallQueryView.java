package com.ckwl.likemoney.bas.view;

import java.io.Serializable;

import com.ckwl.likemoney.bas.entity.ClassfiySmall;

public class ClassfiySmallQueryView extends ClassfiySmall implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String classfiyBigName;

	public String getClassfiyBigName() {
		return classfiyBigName;
	}

	public void setClassfiyBigName(String classfiyBigName) {
		this.classfiyBigName = classfiyBigName;
	}


}
