package com.ckwl.likemoney.product.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.dao.IProductStoreDao;
import com.ckwl.likemoney.product.entity.ProductStore;
import com.ckwl.likemoney.product.view.ProductStoreConditionView;
import com.ckwl.likemoney.product.view.ProductStoreQueryView;

public class ProductStoreDaoImp extends BaseDao implements IProductStoreDao {

	@Override
	public ArrayList<ProductStore> list() {
		ArrayList<ProductStore> listProductStore = new ArrayList<ProductStore>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String sql = "select * from pro_store";

			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);

			while (resultSet.next()) {

				ProductStore productStore = new ProductStore();

				String storeId = resultSet.getString("store_id");
				String storeName = resultSet.getString("store_name");
				String storeMessage = resultSet.getString("store_message");
				String customerId = resultSet.getString("customer_id");

				productStore.setStoreId(storeId);
				productStore.setStoreName(storeName);
				productStore.setStoreMessage(storeMessage);
				productStore.setCustomerId(customerId);

				System.out.println(productStore.toString());

				listProductStore.add(productStore);
			}
			return listProductStore;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("员工信息查询失败", ex);
		}
	}

	@Override
	public void insert(ProductStore productStore) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into pro_store(store_id,store_name,store_message,customer_id) values(?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + productStore.toString());

			preparedStatement = super.prepareStatement(sql);

			String uuid = UUID.randomUUID().toString().replaceAll("-", "");

			productStore.setStoreId(uuid);
			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, productStore.getStoreName());
			preparedStatement.setObject(paramIndex++, productStore.getStoreMessage());
			preparedStatement.setObject(paramIndex++, productStore.getCustomerId());

			DbUtil.getSetpreparedStatement().add(preparedStatement);

			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + productStore.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("新增保存成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("新增保存失败");
		}

	}

	@Override
	public void delete(String storeId) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from pro_store where store_id=?";

			preparedStatement = super.prepareStatement(sql);
			int paramIndex = 1;
			String uuid = storeId;
			preparedStatement.setObject(paramIndex++, uuid);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:删除id:" + storeId);

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("商店ID不存在:" + storeId);
			}
			System.out.println("***影响行数:" + rowCount);

			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}
	}

	@Override
	public void update(ProductStore productStore) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update pro_store set store_name=?,store_message=?,customer_id=? where store_id=?";
			System.out.println("update sql:" + sql);

			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, productStore.getStoreName());
			preparedStatement.setObject(paramIndex++, productStore.getStoreMessage());
			preparedStatement.setObject(paramIndex++, productStore.getCustomerId());
			preparedStatement.setObject(paramIndex++, productStore.getStoreId());

			DbUtil.getSetpreparedStatement().add(preparedStatement);

			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + productStore.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("更新成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("更新失败");
		}

	}

	@Override
	public ProductStore load(String storeId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			ProductStore productStore = new ProductStore();

			// S3.获取statement(执行语句的对象)
			String sql = "select * from pro_store where store_id = ?";
			preparedStatement = super.prepareStatement(sql);

			preparedStatement.setObject(1, storeId);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:id=" + storeId);

			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
			// super.addResultSet(resultSet);// 待封装

			// s4-1.遍历resultSet

			System.out.println("***SQL查询结果begin");
			if (resultSet.next()) {

				productStore.setStoreId(resultSet.getString("store_id"));
				productStore.setStoreName(resultSet.getString("store_name"));
				productStore.setStoreMessage(resultSet.getString("store_message"));
				productStore.setCustomerId(resultSet.getString("customer_id"));

				System.out.println(productStore.toString());
			} else {
				System.out.println("ID不存在");
			}
			System.out.println("***SQL查询结果end");
			System.out.println("操作成功");
			return productStore;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		}
	}

	@Override
	public ArrayList<ProductStoreQueryView> list(ProductStoreConditionView productStoreConditionView) {

		ArrayList<ProductStoreQueryView> listProductStore = new ArrayList<ProductStoreQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(" select pro_store.* , usr_customer.customer_name as customer_name from pro_store ");
			sql.append(" JOIN usr_customer");
			sql.append(" on pro_store.customer_id = usr_customer.customer_id");

			if (!StringUtil.isEmpty(productStoreConditionView.getStoreName())) {
				sql.append(" and pro_store.store_name like ?");
			}

			if (!StringUtil.isEmpty(productStoreConditionView.getStoreMessage())) {
				sql.append(" and pro_store.store_message like ?");
			}

			if (!StringUtil.isEmpty(productStoreConditionView.getCustomerName())) {
				sql.append(" and usr_customer.customer_name like ?");
			}

			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(productStoreConditionView.getStoreName()))
				preparedStatement.setObject(parameterIndex++, "%" + productStoreConditionView.getStoreName() + "%");

			if (!StringUtil.isEmpty(productStoreConditionView.getStoreMessage()))
				preparedStatement.setObject(parameterIndex++, "%" + productStoreConditionView.getStoreMessage() + "%");

			if (!StringUtil.isEmpty(productStoreConditionView.getCustomerName()))
				preparedStatement.setObject(parameterIndex++, "%" + productStoreConditionView.getCustomerName() + "%");

			resultSet = preparedStatement.executeQuery();

			DbUtil.getSetresultSet().add(resultSet);

			while (resultSet.next()) {

				ProductStoreQueryView productStore = new ProductStoreQueryView();

				productStore.setStoreId(resultSet.getString("store_id"));
				productStore.setStoreName(resultSet.getString("store_name"));
				productStore.setStoreMessage(resultSet.getString("store_message"));
				productStore.setCustomerId(resultSet.getString("customer_id"));
				productStore.setCustomerName(resultSet.getString("customer_name"));

				listProductStore.add(productStore);
				System.out.println(productStore.toString());
			}
			return listProductStore;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("员工信息查询失败", ex);
		}

	}

}
