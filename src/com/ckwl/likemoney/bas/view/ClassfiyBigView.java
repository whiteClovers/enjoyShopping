package com.ckwl.likemoney.bas.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.bas.entity.ClassfiyBig;

public class ClassfiyBigView extends ClassfiyBig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ClassfiySmallQueryView> listBig = new ArrayList<ClassfiySmallQueryView>();

	public List<ClassfiySmallQueryView> getListBig() {
		return listBig;
	}

	public void setListBig(List<ClassfiySmallQueryView> listBig) {
		this.listBig = listBig;
	}

	@Override
	public String toString() {
		return "ClassfiyBigView [listBig=" + listBig + "]";
	}
	
}
