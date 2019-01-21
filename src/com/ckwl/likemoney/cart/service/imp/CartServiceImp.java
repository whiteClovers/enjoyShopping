package com.ckwl.likemoney.cart.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.cart.dao.ICartDao;
import com.ckwl.likemoney.cart.dao.imp.CartDaoImp;
import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.cart.service.ICartService;
import com.ckwl.likemoney.cart.view.CartConditionView;
import com.ckwl.likemoney.cart.view.CartQueryView;
import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.front.view.MyCartQueryView;


public class CartServiceImp implements ICartService{
	private ICartDao CartDao = new CartDaoImp(); 
	@MyTransaction(readOnly=false)
	@Override
	public void insert(Cart Cart) {
		CartDao.insert(Cart);
		
	}
	@MyTransaction(readOnly=false)
	@Override
	public void delete(Cart Cart) {
		CartDao.delete(Cart);
		
	}
	@MyTransaction(readOnly=false)
	@Override
	public void update(Cart Cart) {
		CartDao.update(Cart);
		
	}
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<CartQueryView> list(CartConditionView CartConditionView) {
		// TODO Auto-generated method stub
		return CartDao.list(CartConditionView);
	}
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<MyCartQueryView> listView(CartConditionView CartConditionView) {
		
		return CartDao.listView(CartConditionView);
	}
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<MyCartQueryView> listByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return CartDao.listByCustomerId(customerId);
	}
	@MyTransaction(readOnly=true)
	@Override
	public boolean cartMount(String productSkuId,String customerId) {
		// TODO Auto-generated method stub
		return CartDao.cartMount(productSkuId,customerId);
	}

}
