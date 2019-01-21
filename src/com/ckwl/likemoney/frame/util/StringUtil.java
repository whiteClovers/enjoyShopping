package com.ckwl.likemoney.frame.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0 || s.trim().length() == 0;
	}
	
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s) ;
	}
	/**
	 * 日期格式转换
	 * @param str
	 * @return
	 */
	public static Date Dateformatconversion(String s){
		if(s==null){
			return null;
		}
//		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(s);
		Date date=null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return date;
		
	}
	/**
	 * 字符串转为整数
	 * @param str
	 * @return
	 */
	public static Integer stringToInteger(String str){
//		if(null==str){
//			throw new RuntimeException("输入为空");
//		}
//		if(str.length()==0){
//			throw new RuntimeException("空字符串");
//		}
		//获得字符串的字符的长度
		if(str.length()==0){
			return	null;
		}
		int length = str.length();
		//判断第一个字符,是否为符号
		char first  = str.charAt(0);
		if(first=='+'||first=='-'){	
		//循环比较每一个字符，是否在0-9之间	
			for(int i = 1;i<length;i++){
			char c = str.charAt(i);
			if(c<'0' || c >'9'){
				throw new RuntimeException("输入有误");
				}
			}
		}else{
			for(int i = 0;i<length;i++){
				char c = str.charAt(i);
				if(c<'0' || c >'9'){
					throw new RuntimeException("输入有误");
				}
			}
		}
		//进行字符串转换成整数
		Integer result = Integer.parseInt(str);
		return result;
	}
	/**
	 * 字符串解析成小数
	 * @param str
	 * @return
	 */
	public static BigDecimal stringToBigdecimal(String str){
//		if(null==str){
//			throw new RuntimeException("输入为空");
//		}
//		if(str.length()==0){
//			throw new RuntimeException("空字符串");
//		}
		//判断是否全是数字或者含有一个'.'和一个正负号
		//获得字符串的字符的长度
		if(str.length()==0){
			String s1="0";
			BigDecimal s2=new BigDecimal(s1);
			return	s2;
		}
		int length = str.length();
		//判断第一个字符,是否为符号
		char first  = str.charAt(0);
		int index = 0;//记录小数点的下标
		if(first=='+'||first=='-'){	
		//循环比较每一个字符，是否只有一个'.'
			int num = 0;//记录'.'的数目
			for(int i = 1;i<length;i++){
				char c = str.charAt(i);
				if(c=='.'){
					num++;
					index = i;
				}
			}
			if(num>1||num==0){//必须为小数，这里判断是否存在几个小数点
				throw new RuntimeException("含有多个小数点或输入非小数");
			}
			String str2 = str.substring(1, index)+str.substring(index+1, str.length());//循环遍历除去符号，小数点的其他字符是否都是数字
			for(int i = 0;i<str2.length();i++){
				char c = str2.charAt(i);
				if(c<'0' || c >'9'){
					throw new RuntimeException("输入有误");
				}
			}
			
		}else{//判断是否都为数字			
			//循环比较每一个字符，是否只有一个'.'
			int num = 0;//记录'.'的数目
			for(int i = 0;i<length;i++){
				char c = str.charAt(i);
				if(c=='.'){
					num++;
					index = i;
				}
			}
			if(num>1||num==0){//必须为小数，这里判断是否存在几个小数点
				throw new RuntimeException("含有多个小数点或输入非小数");
			}
			String str2 = str.substring(0, index)+str.substring(index+1, str.length());//循环遍历除去下去小数点的其他字符是否都是数字
			for(int i = 0;i<str2.length();i++){
				char c = str2.charAt(i);
				if(c<'0' || c >'9'){
					throw new RuntimeException("输入有误");
					}
				}
			}
		return new BigDecimal(str);
	}
	/**
	 * 字符串转日期格式，必须是yyyy-MM-dd或者yyyy/MM/dd
	 * 月份和年份必须是两位数，如1月要写成01。
	 * 日期和时间中间有一个空格，而且时间的格式也为两位
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String str) throws ParseException{
//		if(null==str){
//			throw new RuntimeException("输入为空");
//		}
//		if(str.length()==0){
//			throw new RuntimeException("空字符串");
//		}
		Date date = null;
		if(Pattern.compile("[0-9]{4}/[0-9]{2}/[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}").matcher(str).matches()){
			int month = Integer.parseInt(str.substring(5, 7));//月份判断
			int day = Integer.parseInt(str.substring(8, 10));//日期判断
			int hour = Integer.parseInt(str.substring(11, 13));//小时     012345678
			int minute = Integer.parseInt(str.substring(14, 16));//分钟2012-12-12 12:22:22
			int seconds = Integer.parseInt(str.substring(17,str.length()));//秒钟
			if(month<=0||month>12){
				throw new RuntimeException("格式有误");
			}
			if(day>31||day<0){
				throw new RuntimeException("格式有误");
			}
			if(hour<0||hour>60){
				throw new RuntimeException("格式有误");
			}
			if(minute<0||minute>60){
				throw new RuntimeException("格式有误");
			}
			if(seconds<0||seconds>60){
				throw new RuntimeException("格式有误");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    	date = sdf.parse(str);
		}
		if(Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}").matcher(str).matches()){
			int month = Integer.parseInt(str.substring(5, 7));//月份判断
			int day = Integer.parseInt(str.substring(8, 10));//日期判断
			int hour = Integer.parseInt(str.substring(11, 13));//小时
			int minute = Integer.parseInt(str.substring(14, 16));//分钟2012-12-12 12:22:22
			int seconds = Integer.parseInt(str.substring(17,str.length()));//秒钟
			if(month<=0||month>12){
				throw new RuntimeException("格式有误");
			}
			if(day>31||day<0){
				throw new RuntimeException("格式有误");
			}
			if(hour<0||hour>60){
				throw new RuntimeException("格式有误");
			}
			if(minute<0||minute>60){
				throw new RuntimeException("格式有误");
			}
			if(seconds<0||seconds>60){
				throw new RuntimeException("格式有误");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        date = sdf.parse(str);
		}
		if(date==null){
			date=null;
		}
        return date;
	}
	/**
	 * 此方法用于从数据库中获得的数据然后引用stringToDate方法前的处理
	 * 因为从数据中获取的数据是：2018-01-01 01-01-01.0
	 * 所以此方法去除最后的'.0'，然后在返回一个字符串
	 * 这样的话样式就符合了stringToDate的格式
	 * @param str
	 * @return
	 */
	public String sqlString(String str){
		return str.substring(0, 19);
	}
}
