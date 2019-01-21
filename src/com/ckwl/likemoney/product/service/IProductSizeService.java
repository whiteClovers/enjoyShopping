package com.ckwl.likemoney.product.service;

import java.util.ArrayList;

import com.ckwl.likemoney.product.entity.ProductSize;
import com.ckwl.likemoney.product.view.ProductSizeConditionView;



public interface IProductSizeService {
	public void insert(ProductSize ProductSize);
	public void delete(ProductSize ProductSize);
	public void update(ProductSize ProductSize);
	public ArrayList<ProductSize> list(ProductSizeConditionView ProductSizeConditionView);
}
