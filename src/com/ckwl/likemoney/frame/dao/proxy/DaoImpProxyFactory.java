package com.ckwl.likemoney.frame.dao.proxy;

import java.lang.reflect.Proxy;

import com.ckwl.likemoney.frame.exception.BaseException;

public class DaoImpProxyFactory {
	private DaoImpProxyFactory() {

	}

	public static Object getProxyInstance(Object target) {
		DaoImpProxy daoInvocationHandler = new DaoImpProxy(target);

		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				daoInvocationHandler);
	}
	public static Object getProxyInstance(Class<?> clazz){//最终调用
		try{
			Object target=clazz.newInstance();
			return getProxyInstance(target);//调用上面的方法
		}catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(e.getMessage(), e);
		}
	}

}
