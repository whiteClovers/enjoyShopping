package com.ckwl.likemoney.product.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;

public interface IProductBrandDaoImp {
	public void insert(ProductBrand productBrand);
	public void delete(ProductBrand productBrand);
	public void update(ProductBrand productBrand);
	public ArrayList<ProductBrand> list(ProductBrandConditionView ProductBrandConditionView);

}
