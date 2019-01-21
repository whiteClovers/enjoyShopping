package com.ckwl.likemoney.product.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.dao.IProductDaoImp;
import com.ckwl.likemoney.product.entity.Product;
import com.ckwl.likemoney.product.view.ProductConditionView;
import com.ckwl.likemoney.product.view.ProductQueryView;

public class ProductDaoImp extends BaseDao implements IProductDaoImp{
	public void insert(Product Product) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into pro_product(product_id,product_name,product_code,brand_id,evaluate_amount,store_id,classfiy_small_id,evaluate_good,evaluate_bad,evaluate_common,product_shelf_time,product_img,product_introduce) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + Product.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			preparedStatement.setObject(1, uuid);
			preparedStatement.setObject(2, Product.getProduct_name());
			preparedStatement.setObject(3, Product.getProduct_code());
			preparedStatement.setObject(4, Product.getBrand_id());
			preparedStatement.setObject(5, Product.getEvaluate_amount());
			preparedStatement.setObject(6, Product.getStore_id());
			preparedStatement.setObject(7, Product.getClassfiy_small_id());
			preparedStatement.setObject(8, Product.getEvaluate_good());
			preparedStatement.setObject(9, Product.getEvaluate_bad());
			preparedStatement.setObject(10, Product.getEvaluate_common());
			
			preparedStatement.setObject(11, Product.getProduct_shelf_time());
			preparedStatement.setObject(12, Product.getProduct_img());
			preparedStatement.setObject(13, Product.getProduct_introduce());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();

			System.out.println("影响行数" + count);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void delete(Product Product) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from pro_product where product_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + Product.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, Product.getProduct_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void update(Product Product) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  pro_product set product_name=?,product_code=?,brand_id=?,evaluate_amount=?, store_id=?, classfiy_small_id=?, evaluate_good=?, evaluate_bad=?, evaluate_common=?,  product_shelf_time=?,product_img=?,product_introduce=? where product_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + Product.toString());
			preparedStatement = super.prepareStatement(sql);

			
			preparedStatement.setObject(1, Product.getProduct_name());
			preparedStatement.setObject(2, Product.getProduct_code());
			preparedStatement.setObject(3, Product.getBrand_id());
			preparedStatement.setObject(4, Product.getEvaluate_amount());
			preparedStatement.setObject(5, Product.getStore_id());
			preparedStatement.setObject(6, Product.getClassfiy_small_id());
			preparedStatement.setObject(7, Product.getEvaluate_good());
			preparedStatement.setObject(8, Product.getEvaluate_bad());
			preparedStatement.setObject(9, Product.getEvaluate_common());
			
			preparedStatement.setObject(10, Product.getProduct_shelf_time());
			preparedStatement.setObject(11, Product.getProduct_img());
			preparedStatement.setObject(12, Product.getProduct_introduce());
			preparedStatement.setObject(13, Product.getProduct_id());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	

	@Override
	public ArrayList<ProductQueryView> list(ProductConditionView ProductConditionView) {
		// TODO Auto-generated method stub
		ArrayList<ProductQueryView> listProduct = new ArrayList<ProductQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder() ;
			sql.append(" select pro_product.* , pro_store.store_name ,bas_classfiy_small.classfiy_small_name ,pro_brand.brand_name from pro_product ") ;
			sql.append(" JOIN pro_store");
			sql.append(" on pro_product.store_id = pro_store.store_id");
			sql.append(" JOIN bas_classfiy_small");
			sql.append(" on pro_product.classfiy_small_id = bas_classfiy_small.classfiy_small_id");
			sql.append(" JOIN pro_brand");
			sql.append(" on pro_product.brand_id = pro_brand.brand_id");
			
			if(!StringUtil.isEmpty(ProductConditionView.getClassfiy_small_name())){
				sql.append(" and bas_classfiy_small.classfiy_small_name like ?") ;
			}
			
			if(!StringUtil.isEmpty(ProductConditionView.getBrand_name())){
				sql.append(" and pro_brand.brand_name like ?") ;
			}
			
			if(!StringUtil.isEmpty(ProductConditionView.getProduct_code())){
				sql.append(" and pro_product.product_code like ?") ;
			}
			
			
	
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(!StringUtil.isEmpty(ProductConditionView.getClassfiy_small_name()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+ProductConditionView.getClassfiy_small_name() + "%");
			
			if(!StringUtil.isEmpty(ProductConditionView.getBrand_name()))
				preparedStatement.setObject(parameterIndex++ , "%"+ProductConditionView.getBrand_name()+ "%");
			
			if(!StringUtil.isEmpty(ProductConditionView.getProduct_code()))
				preparedStatement.setObject(parameterIndex++ , "%"+ProductConditionView.getProduct_code()+ "%");
			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + ProductConditionView.toString());
		resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductQueryView ProductQueryView = new ProductQueryView();
				String product_id = resultSet.getString("product_id");
				String product_name = resultSet.getString("product_name");
				String product_code = resultSet.getString("product_code");
				String brand_id = resultSet.getString("brand_id");
				String brand_name = resultSet.getString("brand_name");
				String evaluate_amount = resultSet.getString("evaluate_amount");
				String store_id = resultSet.getString("store_id");
				String store_name = resultSet.getString("store_name");
				String classfiy_small_id = resultSet.getString("classfiy_small_id");
				String classfiy_small_name = resultSet.getString("classfiy_small_name");
				String evaluate_good = resultSet.getString("evaluate_good");
				String evaluate_bad = resultSet.getString("evaluate_bad");
				String evaluate_common = resultSet.getString("evaluate_common");
			
				Date product_shelf_time = resultSet.getTimestamp("product_shelf_time");
				String product_img = resultSet.getString("product_img");
				String product_introduce = resultSet.getString("product_introduce");
				ProductQueryView.setProduct_id(product_id);
				ProductQueryView.setProduct_name(product_name);
				ProductQueryView.setProduct_code(product_code);
				ProductQueryView.setBrand_id(brand_id);
				ProductQueryView.setBrand_name(brand_name);
				ProductQueryView.setEvaluate_amount(evaluate_amount);
				ProductQueryView.setStore_id(store_id);
				ProductQueryView.setStore_name(store_name);
				ProductQueryView.setClassfiy_small_id(classfiy_small_id);
				ProductQueryView.setClassfiy_small_name(classfiy_small_name);

				ProductQueryView.setEvaluate_good(StringUtil.stringToInteger(evaluate_good));
				ProductQueryView.setEvaluate_bad(StringUtil.stringToInteger(evaluate_bad));

				ProductQueryView.setEvaluate_common(StringUtil.stringToInteger(evaluate_common));

				

				ProductQueryView.setProduct_shelf_time(product_shelf_time);
				ProductQueryView.setProduct_img(product_img);
				ProductQueryView.setProduct_introduce(product_introduce);;
		
//
//				System.out.println("identity:" + id + "code:" + code + "address_id:" + address_id + "customer_id:"
//						+ customer_id + "Product_date:" + Product_date + "Product_status:"
//						+ Product_status + "Product_sum_money:" + Product_sum_money + "Product_paydate:"
//						+ Product_paydate);

				listProduct.add(ProductQueryView);
			}
			return listProduct;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}
}
