package com.ckwl.likemoney.product.dao.imp;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;

import com.ckwl.likemoney.product.dao.IProductBrandDaoImp;
import com.ckwl.likemoney.product.entity.ProductBrand;
import com.ckwl.likemoney.product.view.ProductBrandConditionView;



public class ProductBrandDaoImp extends BaseDao implements IProductBrandDaoImp{

	@Override
	public void insert(ProductBrand productBrand) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into pro_brand(brand_id,brand_name,brand_img) values(?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + productBrand.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			preparedStatement.setObject(1, uuid);
			preparedStatement.setObject(2, productBrand.getBrand_name());
			preparedStatement.setObject(3, productBrand.getBrand_img());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();
			System.out.println("params:" + uuid + "," );
			System.out.println("影响行数" + count);

			

		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public void delete(ProductBrand productBrand) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from pro_brand where brand_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + productBrand.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, productBrand.getBrand_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);


		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public void update(ProductBrand productBrand) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  pro_brand set brand_name=?,brand_img=? where brand_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + productBrand.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, productBrand.getBrand_name());
			preparedStatement.setObject(2, productBrand.getBrand_img());
			
			preparedStatement.setObject(3, productBrand.getBrand_id());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);


		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public ArrayList<ProductBrand> list(ProductBrandConditionView ProductBrandConditionView) {
		// TODO Auto-generated method stub
		ArrayList<ProductBrand> listproductBrand = new ArrayList<ProductBrand>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder() ;
			sql.append(" select * from pro_brand where 1=1") ;
			if(!StringUtil.isEmpty(ProductBrandConditionView.getBrand_name())){
				sql.append(" and pro_brand.brand_name like ?") ;
			}
			
			if(!StringUtil.isEmpty(ProductBrandConditionView.getBrand_img())){
				sql.append(" and pro_brand.brand_img like ?") ;
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(!StringUtil.isEmpty(ProductBrandConditionView.getBrand_name()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+ProductBrandConditionView.getBrand_name() + "%");
			
			if(!StringUtil.isEmpty(ProductBrandConditionView.getBrand_img()))
				preparedStatement.setObject(parameterIndex++ , "%"+ProductBrandConditionView.getBrand_img()+ "%");
			resultSet = preparedStatement.executeQuery();
//			DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {
				ProductBrand productBrand = new ProductBrand();
				String id = resultSet.getString("brand_id");
				String name = resultSet.getString("brand_name");
				String brand_img = resultSet.getString("brand_img");
				

				productBrand.setBrand_id(id);
				productBrand.setBrand_name(name);
				productBrand.setBrand_img(brand_img);
			
				System.out.println("identity:" + id + "name:" +name+ "brand_img:" +brand_img );

				listproductBrand.add(productBrand);
			}
			return listproductBrand;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}

	



	

}
