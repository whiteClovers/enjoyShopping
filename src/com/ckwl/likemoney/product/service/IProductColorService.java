package com.ckwl.likemoney.product.service;

import java.util.ArrayList;

import com.ckwl.likemoney.product.entity.ProductColor;
import com.ckwl.likemoney.product.view.ProductColorConditionView;



public interface IProductColorService {
	public void insert(ProductColor ProductColor);
	public void delete(ProductColor ProductColor);
	public void update(ProductColor ProductColor);
	public ArrayList<ProductColor> list(ProductColorConditionView ProductColorConditionView);
}
