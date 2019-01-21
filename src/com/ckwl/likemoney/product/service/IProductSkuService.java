package com.ckwl.likemoney.product.service;

import java.util.ArrayList;

import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.frame.view.PageView;
import com.ckwl.likemoney.product.entity.ProductSku;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;

public interface IProductSkuService {
	public void insert(ProductSku ProductSku);
	public void delete(ProductSku ProductSku);
	public void update(ProductSku ProductSku);
	public ArrayList<ProductSkuQueryView> list(ProductSkuConditionView ProductSkuConditionView);
	public ArrayList<ProductSkuQueryView> list(String product_sku_id);
	public ArrayList<ProductSkuQueryView> list1(ProductSkuConditionView ProductSkuConditionView);
	
	// 分页
	public ArrayList<ProductSkuQueryView> listPro(ProductSkuConditionView ProductSkuConditionView ,int pageIndex ,int pageSize);
	
	public int recordCount(ProductSkuConditionView ProductSkuConditionView);
	
	public PageView page(ProductSkuConditionView ProductSkuConditionView ,int pageIndex ,int pageSize);
}
