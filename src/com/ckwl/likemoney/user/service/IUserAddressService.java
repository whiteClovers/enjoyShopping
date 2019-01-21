package com.ckwl.likemoney.user.service;

import java.util.ArrayList;

import com.ckwl.likemoney.user.entity.UserAddress;
import com.ckwl.likemoney.user.view.ReceivingAddressQueryView;
import com.ckwl.likemoney.user.view.UserAddressConditionView;
import com.ckwl.likemoney.user.view.UserAddressQueryView;

public interface IUserAddressService {
	public void insert(UserAddress userAddress);
	public void delete(String addressId);
	public void update(UserAddress userAddress);
	public ArrayList<UserAddress > select();
	public UserAddress load(String addressId);
	public ArrayList<UserAddressQueryView > select(UserAddressConditionView conditionView);
	public ArrayList<ReceivingAddressQueryView> listView(String userCustomerId);
}
