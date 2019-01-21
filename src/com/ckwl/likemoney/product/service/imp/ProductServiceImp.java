package com.ckwl.likemoney.product.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.product.dao.IProductDaoImp;
import com.ckwl.likemoney.product.dao.imp.ProductDaoImp;
import com.ckwl.likemoney.product.entity.Product;
import com.ckwl.likemoney.product.service.IProductService;
import com.ckwl.likemoney.product.view.ProductConditionView;
import com.ckwl.likemoney.product.view.ProductQueryView;

public class ProductServiceImp implements IProductService {
	private IProductDaoImp ProductDao = new ProductDaoImp(); 
	
	@Override
	@MyTransaction(readOnly=false)
	public void insert(Product Product) {
		// TODO Auto-generated method stub
		ProductDao.insert(Product);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(Product Product) {
		// TODO Auto-generated method stub
		ProductDao.delete(Product);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(Product Product) {
		// TODO Auto-generated method stub
		ProductDao.update(Product);
	}


	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductQueryView> list(ProductConditionView ProductConditionView) {
		// TODO Auto-generated method stub
		return ProductDao.list(ProductConditionView);
	}

}
