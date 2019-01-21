package com.ckwl.likemoney.user.view;

import java.util.ArrayList;

import com.ckwl.likemoney.user.entity.UserAddress;

public class ReceivingAddressQueryView extends UserAddress{
	private ArrayList<UserAddressQueryView> userCustomers = new ArrayList<UserAddressQueryView>();

	public ArrayList<UserAddressQueryView> getUserCustomers() {
		return userCustomers;
	}

	public void setUserCustomers(ArrayList<UserAddressQueryView> userCustomers) {
		this.userCustomers = userCustomers;
	}
	
}
