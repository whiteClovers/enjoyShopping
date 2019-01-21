package com.ckwl.likemoney.product.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.product.entity.ProductStore;
import com.ckwl.likemoney.product.view.ProductStoreConditionView;
import com.ckwl.likemoney.product.view.ProductStoreQueryView;

public interface IProductStoreDao {

	public ArrayList<ProductStore> list();

	public void insert(ProductStore productStore);

	public void delete(String storeId);

	public void update(ProductStore productStore);

	public ProductStore load(String storeId);

	public ArrayList<ProductStoreQueryView> list(ProductStoreConditionView productStoreConditionView);

}
