package com.ckwl.likemoney.user.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.user.dao.IUserAttentionDao;
import com.ckwl.likemoney.user.entity.UserAttention;
import com.ckwl.likemoney.user.view.ReceivingAddressQueryView;
import com.ckwl.likemoney.user.view.UserAttentionConditionView;
import com.ckwl.likemoney.user.view.UserAttentionQueryView;

public class UserAttentionDaoImp extends BaseDao implements IUserAttentionDao {

	@Override
	public void insert(UserAttention userAttention) {
		PreparedStatement preparedStatement = null;

		try {
			

			// S3.获取statement(执行语句的对象)
			String sql = "insert into usr_attention( attention_id ,store_id ,product_id,customer_id,attention_date) values(?,?,?,?,?)";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			// String studentName = "aa2" ;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++,userAttention.getStoreId());
			preparedStatement.setObject(paramIndex++, userAttention.getProductId());
			preparedStatement.setObject(paramIndex++, userAttention.getCustomerId());
			preparedStatement.setObject(paramIndex++, userAttention.getAttentionDate());
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + userAttention.toString());

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();

			System.out.println("***影响行数:" + rowCount);

			System.out.println("新增保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("新增保存失败");
		} 

	}

	@Override
	public void delete(String attentionId) {
		PreparedStatement preparedStatement = null;
	      try {
				
				// S3.获取statement(执行语句的对象)
				String sql = "delete from usr_attention where attention_id = ?";
				preparedStatement = super.prepareStatement(sql);

				int paramIndex = 1;
				preparedStatement.setObject(paramIndex++, attentionId);
				System.out.println("sql:"+sql);
				System.out.println("参数：bankId:"+attentionId);

				// s4-1.执行sql
				int rowCount = preparedStatement.executeUpdate();
				System.out.println("影响行数:" + rowCount);
				if(rowCount == 0){
					throw new RuntimeException("卡号不存在:" + attentionId);
				}
				

				System.out.println("操作成功");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("操作失败");
				throw new RuntimeException("删除失败" ,e) ;
			} 

	}

	@Override
	public void update(UserAttention userAttention) {
		PreparedStatement preparedStatement = null;
		
		
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			String sql = "update usr_attention set store_id = ?,product_id = ?,customer_id= ?,attention_date = ?  where attention_id = ?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, userAttention.getAttentionId());
			preparedStatement.setObject(paramIndex++, userAttention.getStoreId());
			preparedStatement.setObject(paramIndex++, userAttention.getProductId());
			preparedStatement.setObject(paramIndex++, userAttention.getCustomerId());
			preparedStatement.setObject(paramIndex++, userAttention.getAttentionDate());

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();

			System.out.println("影响行数:" + rowCount);

			System.out.println("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
		} 

	}

	@Override
	public ArrayList<UserAttention> list() {
		ArrayList<UserAttention> listuserAttention = new ArrayList<UserAttention>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			
			String sql = "select * from usr_attention";
			preparedStatement = super.prepareStatement(sql);
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + "");
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				UserAttention userAttention=new UserAttention();
				String attention_id = resultSet.getString("attention_id");
				String store_id = resultSet.getString("store_id");
				String product_id = resultSet.getString("product_id");
				String customer_id = resultSet.getString("customer_id");
				String attention_date= resultSet.getString("attention_date");
				
				userAttention.setAttentionId(attention_id);
				userAttention.setStoreId(store_id);
				userAttention.setProductId(product_id);
				userAttention.setCustomerId(customer_id);
				userAttention.setAttentionDate(StringUtil.stringToDate(attention_date));
				
				
				System.out.println("attention_id:" + attention_id + "," + "store_id:"
						+ store_id+","+"product_id:"+product_id+","+"customer_id:"+customer_id+","+"attention_date:"+attention_date);
				
				listuserAttention.add(userAttention);

				
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listuserAttention;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		} 
	}

	@Override
	public UserAttention load(String attentionId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			UserAttention userAttention=new UserAttention();
		
			String sql = "select * from usr_attention where attention_id = ?";
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, attentionId);

		
			resultSet = preparedStatement.executeQuery();

			
			if (resultSet.next()) {
				userAttention.setAttentionId(resultSet.getString("attention_id"));
				userAttention.setStoreId(resultSet.getString("store_id"));
				userAttention.setProductId(resultSet.getString("product_id"));
				userAttention.setCustomerId(resultSet.getString("customer_id"));
				userAttention.setAttentionDate(StringUtil.stringToDate(resultSet.getString("attention_date")));
				
				
				
				System.out.println(
				"attention_id:" + resultSet.getString("attention_id") + "," + 
				"store_id:"+ resultSet.getString("store_id") + "," + 
				"product_id:"+ resultSet.getString("product_id") + "," +
				"customer_id:"+ resultSet.getString("customer_id") + "," + 
				"attention_date:"+ resultSet.getString("attention_date"));
			} else {
				System.out.println("ID不存在");
				throw new RuntimeException("查询失败");
			}

			System.out.println("操作成功");
			return userAttention;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		} 
	}

	@Override
	public ArrayList<UserAttentionQueryView> list(UserAttentionConditionView conditionView) {
		ArrayList<UserAttentionQueryView> lisUserAttentionQueryView = new ArrayList<UserAttentionQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select usr_attention.*,usr_customer.customer_name,pro_store.store_name,pro_product.product_name  from usr_attention");
			sql.append(" JOIN usr_customer");
			sql.append(" on usr_attention.customer_id=usr_customer.customer_id");
			sql.append(" JOIN pro_store");
			sql.append(" on usr_attention.store_id=pro_store.store_id");
			sql.append(" JOIN pro_product");
			sql.append(" on usr_attention.product_id=pro_product.product_id");
			
			if(StringUtil.isNotEmpty(conditionView.getAttentionId())){
				sql.append(" and usr_attention.attention_id like ?") ;
			}
			if(StringUtil.isNotEmpty(conditionView.getStoreId())){
				sql.append(" and usr_attention.store_id like ?") ;
			}
			if(StringUtil.isNotEmpty(conditionView.getCustomerId())){
				sql.append(" and usr_attention.customer_id = ? ") ;
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			if(StringUtil.isNotEmpty(conditionView.getAttentionId()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getAttentionId() + "%");
			if(StringUtil.isNotEmpty(conditionView.getStoreId()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getStoreId() + "%");
			if(StringUtil.isNotEmpty(conditionView.getCustomerId()))
				preparedStatement.setObject(parameterIndex++ , conditionView.getCustomerId());

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + "");
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				UserAttentionQueryView userAttention=new UserAttentionQueryView();
				String attention_id = resultSet.getString("attention_id");
				String store_id = resultSet.getString("store_id");
				String product_id = resultSet.getString("product_id");
				String customer_id = resultSet.getString("customer_id");
				String attention_date= resultSet.getString("attention_date");
				
				userAttention.setAttentionId(attention_id);
				userAttention.setStoreId(store_id);
				userAttention.setProductId(product_id);
				userAttention.setCustomerId(customer_id);
				userAttention.setAttentionDate(StringUtil.stringToDate(attention_date));
				
				
				System.out.println("attention_id:" + attention_id + "," + "store_id:"
						+ store_id+","+"product_id:"+product_id+","+"customer_id:"+customer_id+","+"attention_date:"+attention_date);
				
				lisUserAttentionQueryView.add(userAttention);

				
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return lisUserAttentionQueryView;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		} 
	}

}
