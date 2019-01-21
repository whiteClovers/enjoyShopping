package com.ckwl.likemoney.frame.dao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.exception.DbException;

public class DaoImpProxy implements InvocationHandler {
	private Object target;
	public DaoImpProxy(Object target){
		this.target=target;
	}
	@SuppressWarnings("unused")
	@Override
	public Object invoke(Object poxy, Method method, Object[] arg2) throws Throwable {
		Class<? extends Object> clazz = method.getClass() ;
		MyTransaction annotation = clazz.getDeclaredAnnotation(MyTransaction.class);
		
		boolean autoCommit = true ;
		boolean readOnly = false ;
		int isolation = 4 ;
		
		if (annotation!=null) {
			isolation = annotation.isolation();
			readOnly = annotation.readOnly();
			autoCommit = annotation.autoCommit();
		}
		
//		System.out.println("isolation :==========="+isolation);
		
		Connection connection = DbUtil.getConnection();
		try{
			
			
			connection.setReadOnly(readOnly);
			connection.setAutoCommit(autoCommit);
			connection.setTransactionIsolation(isolation);
			
//			DbUtil.beginTransaction();
			Object result=method.invoke(target, arg2);
//			DbUtil.commit();
			if (autoCommit==false) {
				connection.commit(); 
			}
//			connection.commit(); ; 
			
			System.out.println("提交成功");
			return result;
		}catch (Exception ex) {
			ex.printStackTrace();
			if (autoCommit==false) {
				connection.rollback(); 
			}
//			DbUtil.rollback();
			throw new DbException(ex.getMessage(), ex);
		} finally {
			DbUtil.closeAll();
		}
	}

}
