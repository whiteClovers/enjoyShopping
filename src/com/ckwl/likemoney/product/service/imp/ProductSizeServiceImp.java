package com.ckwl.likemoney.product.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.product.dao.IProductSizeDaoImp;
import com.ckwl.likemoney.product.dao.imp.ProductSizeDaoImp;
import com.ckwl.likemoney.product.entity.ProductSize;
import com.ckwl.likemoney.product.service.IProductSizeService;
import com.ckwl.likemoney.product.view.ProductSizeConditionView;

public class ProductSizeServiceImp implements IProductSizeService{
private IProductSizeDaoImp ProductSizeDao = new ProductSizeDaoImp(); 
	

	/**代理*/
	@MyTransaction(readOnly=false)
	public void insert(ProductSize ProductSize) {		
		
		ProductSizeDao.insert(ProductSize);
	}

	@MyTransaction(readOnly=false)
	public void delete(ProductSize ProductSize) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		ProductSizeDao.delete(ProductSize);
	}

	@MyTransaction(readOnly=false)
	public void update(ProductSize ProductSize) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		ProductSizeDao.update(ProductSize);
	}


	

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductSize> list(ProductSizeConditionView ProductSizeConditionView) {
		// TODO Auto-generated method stub
		return ProductSizeDao.list(ProductSizeConditionView);
	}
}
