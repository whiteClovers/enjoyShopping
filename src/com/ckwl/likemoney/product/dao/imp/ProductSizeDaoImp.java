package com.ckwl.likemoney.product.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.dao.IProductSizeDaoImp;
import com.ckwl.likemoney.product.entity.ProductSize;
import com.ckwl.likemoney.product.view.ProductSizeConditionView;

public class ProductSizeDaoImp extends BaseDao implements IProductSizeDaoImp {
	public void insert(ProductSize ProductSize) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into pro_size(size_id,size_name) values(?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + ProductSize.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			preparedStatement.setObject(1, uuid);
			preparedStatement.setObject(2, ProductSize.getSize_name());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();
			System.out.println("params:" + uuid + "," );
			System.out.println("影响行数" + count);

			

		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public void delete(ProductSize ProductSize) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from pro_size where size_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + ProductSize.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, ProductSize.getSize_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);


		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	public void update(ProductSize ProductSize) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  pro_size set size_name=? where size_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + ProductSize.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, ProductSize.getSize_name());
			preparedStatement.setObject(2, ProductSize.getSize_id());
			
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);


		} catch (Exception ex) {
			ex.printStackTrace();

		}		
	}

	@Override
	
	public ArrayList<ProductSize> list(ProductSizeConditionView ProductSizeConditionView) {
		// TODO Auto-generated method stub
		ArrayList<ProductSize> listProductSize = new ArrayList<ProductSize>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder() ;
			sql.append(" select * from pro_size where 1=1") ;
			if(!StringUtil.isEmpty(ProductSizeConditionView.getSize_name())){
				sql.append(" and pro_size.size_name like ?") ;
			}
			
			
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(!StringUtil.isEmpty(ProductSizeConditionView.getSize_name()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+ProductSizeConditionView.getSize_name() + "%");;
			resultSet = preparedStatement.executeQuery();
//			DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {
				ProductSize ProductSize = new ProductSize();
				String size_id = resultSet.getString("size_id");
				String size_name = resultSet.getString("size_name");
			
				

				ProductSize.setSize_id(size_id);;
				ProductSize.setSize_name(size_name);;
				
			
				System.out.println("identity:" + size_id + "name:" +size_name );

				listProductSize.add(ProductSize);
			}
			return listProductSize;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}

}
