package com.ckwl.likemoney.product.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.product.dao.IProductColorDaoImp;
import com.ckwl.likemoney.product.dao.imp.ProductColorDaoImp;
import com.ckwl.likemoney.product.entity.ProductColor;
import com.ckwl.likemoney.product.service.IProductColorService;
import com.ckwl.likemoney.product.view.ProductColorConditionView;

public class ProductColorServiceImp implements IProductColorService{
private IProductColorDaoImp ProductColorDao = new ProductColorDaoImp(); 
	
	/**代理*/
	@MyTransaction(readOnly=false)
	public void insert(ProductColor ProductColor) {		
		
		ProductColorDao.insert(ProductColor);
	}

	@MyTransaction(readOnly=false)
	public void delete(ProductColor ProductColor) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		ProductColorDao.delete(ProductColor);
	}
	@MyTransaction(readOnly=false)
	public void update(ProductColor ProductColor) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		ProductColorDao.update(ProductColor);
	}




	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductColor> list(ProductColorConditionView ProductColorConditionView) {
		// TODO Auto-generated method stub
		return ProductColorDao.list(ProductColorConditionView);
	}
}
