package com.ckwl.likemoney.order.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.bas.view.BankConditionView;
import com.ckwl.likemoney.bas.view.BankQueryView;
import com.ckwl.likemoney.order.entity.TransferAccount;
import com.ckwl.likemoney.order.view.TransferAccountConditionView;
import com.ckwl.likemoney.order.view.TransferAccountQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;



public interface ITransferAccount {
	public void insert(TransferAccount transferAccount);
	public void delete(String TransferAccountsId);
	public void update(TransferAccount transferAccount);
	public ArrayList<TransferAccount > select();
	public TransferAccount load(String TransferAccountsId);
	public ArrayList<TransferAccountQueryView > select(TransferAccountConditionView conditionView);
}
