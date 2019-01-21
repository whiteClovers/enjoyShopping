package com.ckwl.likemoney.product.service;

import java.util.ArrayList;

import com.ckwl.likemoney.product.entity.Product;
import com.ckwl.likemoney.product.view.ProductConditionView;
import com.ckwl.likemoney.product.view.ProductQueryView;

public interface IProductService {
	public void insert(Product Product);
	public void delete(Product Product);
	public void update(Product Product);
	public ArrayList<ProductQueryView> list(ProductConditionView ProductConditionView);
}
