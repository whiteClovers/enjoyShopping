package com.ckwl.likemoney.user.service;

import java.util.ArrayList;

import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

public interface IUserCustomerService {
	public void insert(UserCustomer userCustomer);
	public void delete(String customerId);
	public void update(UserCustomer userCustomer);
	public ArrayList<UserCustomer> list(UserCustomerConditionView conditionView);
	public UserCustomer load(String customerId);
	
	public UserCustomer login(String customerName,String customerPwd);
	public boolean register(UserCustomer customer);
	
	// ajax验证注册
	public boolean checkPhone(String customerPhone); // 验证手机号
	public boolean checkName(String customerName); // 验证姓名
	public boolean checkNickName(String customerNickName); // 验证昵称
	public boolean checkPassword(String customerPassword); // 验证密码
	public boolean checkIdCard(String customerIdCard); // 验证身份证号码
	public boolean checkEmail(String customerEmail); // 验证邮箱
	
}
