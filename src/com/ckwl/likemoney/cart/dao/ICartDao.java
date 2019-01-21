package com.ckwl.likemoney.cart.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.cart.view.CartConditionView;
import com.ckwl.likemoney.cart.view.CartQueryView;
import com.ckwl.likemoney.front.view.MyCartQueryView;
import com.ckwl.likemoney.front.view.MyOrderQueryView;

public interface ICartDao {
	public void insert(Cart Cart);
	public void delete(Cart Cart);
	public void update(Cart Cart);
	public ArrayList<CartQueryView> list(CartConditionView CartConditionView);
	public ArrayList<MyCartQueryView> listView(CartConditionView CartConditionView);
	
	public ArrayList<MyCartQueryView> listByCustomerId(String customerId) ;
	
	public boolean cartMount(String productSkuId,String customerId) ;
}
