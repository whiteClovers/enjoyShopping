package com.ckwl.likemoney.front.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;

public class ClassfiyBigView extends ClassfiyBig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ClassfiySmallQueryView> listSmall = new ArrayList<ClassfiySmallQueryView>();

	public List<ClassfiySmallQueryView> getListSmall() {
		return listSmall;
	}

	public void setListSmall(List<ClassfiySmallQueryView> listSmall) {
		this.listSmall = listSmall;
	}

	@Override
	public String toString() {
		return "ClassfiyBigView [listSmall=" + listSmall + "]";
	}

	
}
