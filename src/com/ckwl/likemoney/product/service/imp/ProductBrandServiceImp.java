package com.ckwl.likemoney.product.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.product.dao.IProductBrandDaoImp;
import com.ckwl.likemoney.product.dao.imp.ProductBrandDaoImp;
import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.service.IProductBrandService;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;

public class ProductBrandServiceImp implements IProductBrandService{
private IProductBrandDaoImp ProductBrandDao = new ProductBrandDaoImp(); 
	
	/**代理*/
	@MyTransaction(readOnly=false)
	public void insert(ProductBrand productBrand) {		
		
		ProductBrandDao.insert(productBrand);
	}

	@MyTransaction(readOnly=false)
	public void delete(ProductBrand productBrand) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		ProductBrandDao.delete(productBrand);
	}

	@MyTransaction(readOnly=false)
	public void update(ProductBrand productBrand) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		ProductBrandDao.update(productBrand);
	}


	

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductBrand> list(ProductBrandConditionView ProductBrandConditionView) {
		// TODO Auto-generated method stub
		return ProductBrandDao.list(ProductBrandConditionView);
	}
}
