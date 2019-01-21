package com.ckwl.likemoney.frame.util;

public class PageUtil {
	
	public static int getPageCount(int recordCount ,int pageSize){
		return (recordCount - 1) / pageSize + 1 ;
	}
	
}
