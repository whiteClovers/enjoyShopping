package com.ckwl.likemoney.product.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.frame.util.PageUtil;
import com.ckwl.likemoney.frame.view.PageView;
import com.ckwl.likemoney.product.dao.IProductSkuDaoImp;
import com.ckwl.likemoney.product.dao.imp.ProductSkuDaoImp;
import com.ckwl.likemoney.product.entity.ProductSku;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;

public class ProductSkuServiceImp implements IProductSkuService {
	private IProductSkuDaoImp ProductSkuDao = new ProductSkuDaoImp(); 
	
	@MyTransaction(readOnly=false)
	@Override
	public void insert(ProductSku ProductSku) {
		// TODO Auto-generated method stub
		ProductSkuDao.insert(ProductSku);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(ProductSku ProductSku) {
		// TODO Auto-generated method stub
		ProductSkuDao.delete(ProductSku);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(ProductSku ProductSku) {
		// TODO Auto-generated method stub
		ProductSkuDao.update(ProductSku);
	}

	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductSkuQueryView> list(ProductSkuConditionView ProductSkuConditionView) {
		// TODO Auto-generated method stub
		return ProductSkuDao.list(ProductSkuConditionView);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductSkuQueryView> list(String product_sku_id) {
		// TODO Auto-generated method stub
		return ProductSkuDao.list(product_sku_id);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductSkuQueryView> list1(ProductSkuConditionView ProductSkuConditionView) {
		// TODO Auto-generated method stub
		return ProductSkuDao.list(ProductSkuConditionView);
	}

	@MyTransaction(readOnly=true)
	@Override
	public int recordCount(ProductSkuConditionView ProductSkuConditionView) {
		// TODO Auto-generated method stub
		return ProductSkuDao.recordCount(ProductSkuConditionView);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<ProductSkuQueryView> listPro(ProductSkuConditionView ProductSkuConditionView, int pageIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		return ProductSkuDao.listPro(ProductSkuConditionView, pageIndex, pageSize);
	}

	@MyTransaction(readOnly=false)
	@Override
	public PageView page(ProductSkuConditionView ProductSkuConditionView, int pageIndex, int pageSize) {
		ArrayList<ProductSkuQueryView> list = ProductSkuDao.listPro(ProductSkuConditionView, pageIndex, pageSize);
		int recordCount = ProductSkuDao.recordCount(ProductSkuConditionView);
		
		PageView pageView = new PageView();
		pageView.setList(list);
		pageView.setPageIndex(pageIndex);
		pageView.setPageSize(pageSize);
		pageView.setRecordCount(recordCount);
		
//		int pageCount = (recordCount - 1) / pageSize +1 ;
		int pageCount = PageUtil.getPageCount(recordCount, pageSize);
		pageView.setPageCount(pageCount);
		
		return pageView;
	}

}
