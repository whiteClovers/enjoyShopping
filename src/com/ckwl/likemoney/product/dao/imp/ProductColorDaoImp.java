package com.ckwl.likemoney.product.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.dao.IProductColorDaoImp;
import com.ckwl.likemoney.product.entity.ProductColor;
import com.ckwl.likemoney.product.view.ProductColorConditionView;


public class ProductColorDaoImp extends BaseDao implements IProductColorDaoImp{

	@Override
	public void insert(ProductColor ProductColor) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into pro_color(color_id,color_name) values(?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + ProductColor.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			preparedStatement.setObject(1, uuid);
			preparedStatement.setObject(2, ProductColor.getColor_name());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();
			System.out.println("params:" + uuid + "," );
			System.out.println("影响行数" + count);

			

		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public void delete(ProductColor ProductColor) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from pro_color where color_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + ProductColor.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, ProductColor.getColor_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);


		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public void update(ProductColor ProductColor) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  pro_color set color_name=? where color_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + ProductColor.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, ProductColor.getColor_name());
			preparedStatement.setObject(2, ProductColor.getColor_id());
			
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);


		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public ArrayList<ProductColor> list(ProductColorConditionView ProductColorConditionView) {
		// TODO Auto-generated method stub
		ArrayList<ProductColor> listProductColor = new ArrayList<ProductColor>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder() ;
			sql.append(" select * from pro_color where 1=1") ;
			if(!StringUtil.isEmpty(ProductColorConditionView.getColor_name())){
				sql.append(" and pro_color.color_name like ?") ;
			}
			
			
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(!StringUtil.isEmpty(ProductColorConditionView.getColor_name()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+ProductColorConditionView.getColor_name() + "%");
			
			
			resultSet = preparedStatement.executeQuery();
//			DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {
				ProductColor ProductColor = new ProductColor();
				String id = resultSet.getString("color_id");
				String name = resultSet.getString("color_name");
			
				

				ProductColor.setColor_id(id);
				ProductColor.setColor_name(name);
				
			
				System.out.println("identity:" + id + "name:" +name );

				listProductColor.add(ProductColor);
			}
			return listProductColor;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}

	
}
