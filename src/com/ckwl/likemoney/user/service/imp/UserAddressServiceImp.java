package com.ckwl.likemoney.user.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.user.dao.IUserAddressDao;
import com.ckwl.likemoney.user.dao.imp.UserAddressDaoImp;
import com.ckwl.likemoney.user.entity.UserAddress;
import com.ckwl.likemoney.user.service.IUserAddressService;
import com.ckwl.likemoney.user.view.ReceivingAddressQueryView;
import com.ckwl.likemoney.user.view.UserAddressConditionView;
import com.ckwl.likemoney.user.view.UserAddressQueryView;

public class UserAddressServiceImp implements IUserAddressService {
private IUserAddressDao userAddressDao=new UserAddressDaoImp();

	@MyTransaction(readOnly=false)
	@Override
	public void insert(UserAddress userAddress) {
		// TODO Auto-generated method stub
		userAddressDao.insert(userAddress);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String addressId) {
		// TODO Auto-generated method stub
		userAddressDao.delete(addressId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(UserAddress userAddress) {
		// TODO Auto-generated method stub
		userAddressDao.update(userAddress);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<UserAddress> select() {
		// TODO Auto-generated method stub
		return userAddressDao.select();
	}

	@MyTransaction(readOnly=true)
	@Override
	public UserAddress load(String addressId) {
		// TODO Auto-generated method stub
		return userAddressDao.load(addressId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<UserAddressQueryView> select(UserAddressConditionView conditionView) {
		// TODO Auto-generated method stub
		return userAddressDao.select(conditionView);
	}
	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ReceivingAddressQueryView> listView(String userCustomerId) {
		return userAddressDao.listView(userCustomerId);
	}
}
