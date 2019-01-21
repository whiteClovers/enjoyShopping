package com.ckwl.likemoney.product.service;

import java.util.ArrayList;


import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;

public interface IProductBrandService {
	public void insert(ProductBrand productBrand);
	public void delete(ProductBrand productBrand);
	public void update(ProductBrand productBrand);
	public ArrayList<ProductBrand> list(ProductBrandConditionView ProductBrandConditionView);

}
