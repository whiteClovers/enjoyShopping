package com.ckwl.likemoney.bas.service;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.entity.Bank;
import com.ckwl.likemoney.bas.view.BankConditionView;
import com.ckwl.likemoney.bas.view.BankQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;

public interface IBankService {
	public void insert(Bank bank);
	public void delete(String bankId);
	public void update(Bank bank);
	public ArrayList<Bank > select();
	public Bank load(String bankId);
	public ArrayList<BankQueryView > select(BankConditionView conditionView);
}
