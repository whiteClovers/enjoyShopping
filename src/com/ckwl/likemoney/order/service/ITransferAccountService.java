package com.ckwl.likemoney.order.service;

import java.util.ArrayList;

import com.ckwl.likemoney.order.entity.TransferAccount;
import com.ckwl.likemoney.order.view.TransferAccountConditionView;
import com.ckwl.likemoney.order.view.TransferAccountQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;

public interface ITransferAccountService {
	public void insert(TransferAccount transferAccount);
	public void delete(String transferAccountsId);
	public void update(TransferAccount transferAccount);
	public ArrayList<TransferAccount > select();
	public TransferAccount load(String transferAccountsId);
	public ArrayList<TransferAccountQueryView > select(TransferAccountConditionView conditionView);
}
