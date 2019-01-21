package com.ckwl.likemoney.product.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.product.dao.IProductStoreDao;
import com.ckwl.likemoney.product.dao.imp.ProductStoreDaoImp;
import com.ckwl.likemoney.product.entity.ProductStore;
import com.ckwl.likemoney.product.service.IProductStoreService;
import com.ckwl.likemoney.product.view.ProductStoreConditionView;
import com.ckwl.likemoney.product.view.ProductStoreQueryView;

public class ProductStoreServiceImp implements IProductStoreService {
	private IProductStoreDao ProductStoreDao = new ProductStoreDaoImp();

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductStore> list() {
		return ProductStoreDao.list();
	}

	@MyTransaction(readOnly=false)
	@Override
	public void insert(ProductStore productStore) {
		ProductStoreDao.insert(productStore);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String storeId) {
		ProductStoreDao.delete(storeId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(ProductStore productStore) {
		ProductStoreDao.update(productStore);

	}

	@MyTransaction(readOnly=true)
	@Override
	public ProductStore load(String storeId) {
		return ProductStoreDao.load(storeId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductStoreQueryView> list(ProductStoreConditionView productStoreConditionView) {
		// TODO Auto-generated method stub
		return ProductStoreDao.list(productStoreConditionView);
	}

}
