package com.ckwl.likemoney.product.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.product.entity.ProductColor;
import com.ckwl.likemoney.product.view.ProductColorConditionView;



public interface IProductColorDaoImp {
	public void insert(ProductColor ProductColor);
	public void delete(ProductColor ProductColor);
	public void update(ProductColor ProductColor);
	public ArrayList<ProductColor> list(ProductColorConditionView ProductColorConditionView);

}
