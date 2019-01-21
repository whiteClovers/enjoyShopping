package com.ckwl.likemoney.product.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.product.entity.ProductSize;
import com.ckwl.likemoney.product.view.ProductSizeConditionView;



public interface IProductSizeDaoImp {
	public void insert(ProductSize ProductSize);
	public void delete(ProductSize ProductSize);
	public void update(ProductSize ProductSize);
	public ArrayList<ProductSize> list(ProductSizeConditionView ProductSizeConditionView);
}
