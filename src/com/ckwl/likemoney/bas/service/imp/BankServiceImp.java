package com.ckwl.likemoney.bas.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.dao.IMoneyBank;
import com.ckwl.likemoney.bas.dao.imp.MoneyBankImp;
import com.ckwl.likemoney.bas.entity.Bank;
import com.ckwl.likemoney.bas.service.IBankService;
import com.ckwl.likemoney.bas.view.BankConditionView;
import com.ckwl.likemoney.bas.view.BankQueryView;
import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.user.entity.UserCustomer;

public class BankServiceImp implements IBankService{
	
private IMoneyBank moneyBank= new MoneyBankImp();

	@MyTransaction(readOnly=false)
	@Override
	public void insert(Bank bank) {
		moneyBank.insert(bank);
		
	}
	@MyTransaction(readOnly=false)
	@Override
	public void delete(String bankId) {
		moneyBank.delete(bankId);
		
	}
	@MyTransaction(readOnly=false)
	@Override
	public void update(Bank bank) {
		// TODO Auto-generated method stub
		moneyBank.update(bank);
	}
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<Bank> select() {
		// TODO Auto-generated method stub
		
		return moneyBank.select();
	}
	@MyTransaction(readOnly=true)
	@Override
	public Bank load(String bankId) {
		return moneyBank.load(bankId);
		
		
	}
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<BankQueryView> select(BankConditionView conditionView) {
		
		return moneyBank.select(conditionView);
	}


}
