package com.ckwl.likemoney.frame.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 输入
	// 每页记录数 pageSize
	// 当前页数 pageIndex
	
	// 输出
	// 每页数据list
	// 总页数 pageCount
	// 总数据 recordCount
	
	private int pageSize ;
	private int pageIndex ;
	
	private List list;
	private int pageCount ;
	private int recordCount ;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	@Override
	public String toString() {
		return "PageView [pageSize=" + pageSize + ", pageIndex=" + pageIndex + ", list=" + list + ", pageCount="
				+ pageCount + ", recordCount=" + recordCount + "]";
	}
	
}
