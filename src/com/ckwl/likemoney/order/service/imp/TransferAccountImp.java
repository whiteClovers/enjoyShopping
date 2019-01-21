package com.ckwl.likemoney.order.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.order.dao.ITransferAccount;
import com.ckwl.likemoney.order.dao.imp.TransferAccountDaoImp;
import com.ckwl.likemoney.order.entity.TransferAccount;
import com.ckwl.likemoney.order.service.ITransferAccountService;
import com.ckwl.likemoney.order.view.TransferAccountConditionView;
import com.ckwl.likemoney.order.view.TransferAccountQueryView;

public class TransferAccountImp implements ITransferAccountService {
private ITransferAccount iTransferAccount = new TransferAccountDaoImp();

	@MyTransaction(readOnly=false)
	@Override
	public void insert(TransferAccount transferAccount) {
		iTransferAccount.insert(transferAccount);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String transferAccountsId) {
		iTransferAccount.delete(transferAccountsId);

	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(TransferAccount transferAccount) {
		iTransferAccount.update(transferAccount);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<TransferAccount> select() {
		
		return iTransferAccount.select();
	}

	@MyTransaction(readOnly=true)
	@Override
	public TransferAccount load(String transferAccountsId) {
		return iTransferAccount.load(transferAccountsId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<TransferAccountQueryView> select(TransferAccountConditionView conditionView) {
		// TODO Auto-generated method stub
		return iTransferAccount.select(conditionView);
	}


}
