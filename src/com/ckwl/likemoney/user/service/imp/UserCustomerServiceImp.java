package com.ckwl.likemoney.user.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.user.dao.IUserCustomerDao;
import com.ckwl.likemoney.user.dao.imp.UserCustomerDaoImp;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;

import com.ckwl.likemoney.user.view.UserCustomerConditionView;

public class UserCustomerServiceImp implements IUserCustomerService {

	private IUserCustomerDao  userCustomerDao=new UserCustomerDaoImp();
	
	@MyTransaction(readOnly=false)
	@Override
	public void insert(UserCustomer userCustomer) {
		// TODO Auto-generated method stub
		userCustomerDao.insert(userCustomer);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String customerId) {
		// TODO Auto-generated method stub
		userCustomerDao.delete(customerId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(UserCustomer userCustomer) {
		// TODO Auto-generated method stub
		userCustomerDao.update(userCustomer);
	}

	@MyTransaction(readOnly=true)
	public UserCustomer load(String customerId) {
		// TODO Auto-generated method stub
		return userCustomerDao.load(customerId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<UserCustomer> list(UserCustomerConditionView conditionView) {
		// TODO Auto-generated method stub
		return userCustomerDao.select(conditionView);
	}

	@MyTransaction(readOnly=true)
	@Override
	public UserCustomer login(String customerName, String customerPwd) {
		
		return userCustomerDao.login(customerName,customerPwd);
	}

	@MyTransaction(readOnly=false)
	@Override
	public boolean register(UserCustomer customer) {
		// TODO Auto-generated method stub
		return userCustomerDao.register(customer);
	}

	@MyTransaction(readOnly=true)
	@Override
	public boolean checkPhone(String customerPhone) {
		// TODO Auto-generated method stub
		return userCustomerDao.checkPhone(customerPhone);
	}

	@MyTransaction(readOnly=true)
	@Override
	public boolean checkName(String customerName) {
		// TODO Auto-generated method stub
		return userCustomerDao.checkName(customerName);
	}

	@MyTransaction(readOnly=true)
	@Override
	public boolean checkNickName(String customerNickName) {
		// TODO Auto-generated method stub
		return userCustomerDao.checkNickName(customerNickName);
	}

	@MyTransaction(readOnly=true)
	@Override
	public boolean checkPassword(String customerPassword) {
		// TODO Auto-generated method stub
		return userCustomerDao.checkPassword(customerPassword);
	}

	@MyTransaction(readOnly=true)
	@Override
	public boolean checkIdCard(String customerIdCard) {
		// TODO Auto-generated method stub
		return userCustomerDao.checkIdCard(customerIdCard);
	}

	@MyTransaction(readOnly=true)
	@Override
	public boolean checkEmail(String customerEmail) {
		// TODO Auto-generated method stub
		return userCustomerDao.checkEmail(customerEmail);
	}

	
}
