package com.ckwl.likemoney.cart.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.cart.dao.ICartDao;
import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.cart.view.CartConditionView;
import com.ckwl.likemoney.cart.view.CartQueryView;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.front.view.MyCartQueryView;


public class CartDaoImp extends BaseDao implements ICartDao {
	
	@Override
	public boolean cartMount(String productSkuId,String customerId) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "UPDATE car_cart set sku_amount = sku_amount+1 WHERE product_sku_id = ? and customer_id = ?";
			
			System.out.println("insert sql:" + sql);
			
			preparedStatement = super.prepareStatement(sql);
			
			int parameterIndex = 1;
			preparedStatement.setObject(parameterIndex++ , productSkuId );
			preparedStatement.setObject(parameterIndex++ , customerId );
			
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();

		}
		return false;
	}
	
	@Override
	public void insert(Cart Cart) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into car_cart(car_id,product_sku_id,car_date,customer_id,car_select,car_detect,sku_amount) values(?,?,?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + Cart.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			
			int paramIndex=1;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, Cart.getProduct_sku_id());
			preparedStatement.setObject(paramIndex++, Cart.getCar_date());
			preparedStatement.setObject(paramIndex++, Cart.getCustomer_id());
			preparedStatement.setObject(paramIndex++, Cart.getCar_select());
			preparedStatement.setObject(paramIndex++, Cart.getCar_detect());
			preparedStatement.setObject(paramIndex++, Cart.getSku_amount());
			
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();
			
			System.out.println("影响行数" + count);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	@Override
	public void delete(Cart Cart) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "UPDATE car_cart set car_detect = 'true',car_select = 'no' where car_id = ? ";
			
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + Cart.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, Cart.getCar_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	@Override
	public void update(Cart Cart) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  car_cart set product_sku_id=?,car_date=?,customer_id=?,car_select=?,car_detect=? where car_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + Cart.toString());
			int parameterIndex = 1;
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(parameterIndex++, Cart.getProduct_sku_id());
			preparedStatement.setObject(parameterIndex++, Cart.getCar_date());
			preparedStatement.setObject(parameterIndex++, Cart.getCustomer_id());
			preparedStatement.setObject(parameterIndex++, Cart.getCar_select());
			preparedStatement.setObject(parameterIndex++, Cart.getCar_detect());
			preparedStatement.setObject(parameterIndex++, Cart.getCar_id());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}


	}

	@Override
	public ArrayList<CartQueryView> list(CartConditionView CartConditionView) {
		ArrayList<CartQueryView> listCart = new ArrayList<CartQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			// 获取Connection
			

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder() ;
			sql.append(" select car_cart.* , pro_product_sku.product_sku_code ,usr_customer.customer_name ,  ") ;
			sql.append(" a1.dataDictonary_detail_label as select_lable ,");
			sql.append(" a2.dataDictonary_detail_label as delete_label");
			sql.append(" from car_cart");
			sql.append(" JOIN pro_product_sku");
			sql.append(" on car_cart.product_sku_id = pro_product_sku.product_sku_id");
			sql.append(" JOIN usr_customer");
			sql.append(" on car_cart.customer_id = usr_customer.customer_id");
			sql.append(" JOIN bas_datadictonary_detail as a1");
			sql.append(" ON a1.dataDictonary_detail_code = car_cart.car_select");
			sql.append(" JOIN bas_datadictonary_detail as a2");
			sql.append(" ON a2.dataDictonary_detail_code = car_cart.car_detect");
			sql.append(" WHERE a1.dataDictonary_code = 'car_select' AND a2.dataDictonary_code = 'car_detect' ");
			
			if(!StringUtil.isEmpty(CartConditionView.getCustomer_name())){
				sql.append(" and usr_customer.customer_name like ?") ;
			}
			
			if(!StringUtil.isEmpty(CartConditionView.getCar_select())){
				sql.append(" and a1.dataDictonary_detail_label like ?") ;
			}
			
			if(!StringUtil.isEmpty(CartConditionView.getCar_detect())){
				sql.append(" and a2.dataDictonary_detail_label like ?") ;
			}
			if(!StringUtil.isEmpty(CartConditionView.getCar_date())){
				sql.append(" and car_cart.car_date like ?") ;
			}
			
			
	
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(!StringUtil.isEmpty(CartConditionView.getCustomer_name()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+CartConditionView.getCustomer_name() + "%");
			
			if(!StringUtil.isEmpty(CartConditionView.getCar_select()))
				preparedStatement.setObject(parameterIndex++ , "%"+CartConditionView.getCar_select()+ "%");
			
			if(!StringUtil.isEmpty(CartConditionView.getCar_detect()))
				preparedStatement.setObject(parameterIndex++ , "%"+CartConditionView.getCar_detect()+ "%");
			if(!StringUtil.isEmpty(CartConditionView.getCar_date()))
				preparedStatement.setObject(parameterIndex++ , "%"+CartConditionView.getCar_date()+ "%");
			
//			if(StringUtil.isNotEmpty(xyz))
//				preparedStatement.setObject(parameterIndex++ , xyz);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + CartConditionView.toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
			
			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				CartQueryView CartQueryView = new CartQueryView();
				CartQueryView.setCar_id(resultSet.getString("car_id"));
				CartQueryView.setProduct_sku_id(resultSet.getString("product_sku_id"));
				CartQueryView.setProduct_sku_code(resultSet.getString("product_sku_code"));
				
				CartQueryView.setCar_date(StringUtil.Dateformatconversion(resultSet.getString("car_date")));
				
				CartQueryView.setCustomer_id(resultSet.getString("customer_id"));
				CartQueryView.setCustomer_name(resultSet.getString("customer_name"));
				CartQueryView.setCar_select(resultSet.getString("car_select"));
				CartQueryView.setCar_detect(resultSet.getString("car_detect"));
				CartQueryView.setSelect_lable(resultSet.getString("select_lable"));
				CartQueryView.setDelete_lable(resultSet.getString("delete_label"));
				
				listCart.add(CartQueryView);

				System.out.println(CartQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listCart;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		} 
	
		
	}

	
	public void deleteFromCart(String customerId) {
		
		PreparedStatement preparedStatement = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			
			sql.append(" DELETE from car_cart WHERE car_cart.car_detect = 'true'");
			sql.append(" and car_cart.customer_id = ? ");
			
			preparedStatement = super.prepareStatement(sql.toString());
			
			int parameterInde = 1;
			preparedStatement.setObject(parameterInde++, customerId);

			System.out.println("***SQL:" + sql);
//			System.out.println("***param:" + .toString());
			// s4-1.执行sql
			int res = preparedStatement.executeUpdate();
			System.out.println("成功删除"+res);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("删除失败", e);
		}
	}
	
	public ArrayList<MyCartQueryView> listByCarId(String carId) {
	ArrayList<MyCartQueryView> listMyCart = new ArrayList<MyCartQueryView>();

	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	try {
		// 获取Connection

		// S3.获取statement(执行语句的对象)
		StringBuilder sql = new StringBuilder();
		sql.append(
				" select car_cart.* ,pro_product_sku.product_sku_price, pro_product.product_name,pro_product_sku.product_sku_img_small ,pro_product_sku.product_sku_realPrice ,pro_color.color_name ,pro_size.size_name ,pro_store.store_name from car_cart ");
		
		sql.append(" JOIN pro_product_sku");
		sql.append(" on car_cart.product_sku_id = pro_product_sku.product_sku_id");
		
		sql.append(" JOIN pro_product");
		sql.append(" on pro_product_sku.product_id = pro_product.product_id");
		
		sql.append(" JOIN pro_store");
		sql.append(" on pro_product.store_id = pro_store.store_id");
		
		sql.append(" JOIN pro_color");
		sql.append(" on pro_product_sku.color_id = pro_color.color_id");
		
		sql.append(" JOIN pro_size");
		sql.append(" on pro_product_sku.size_id = pro_size.size_id");
		
		sql.append(" JOIN usr_customer");
		sql.append(" on usr_customer.customer_id = car_cart.customer_id");
		
		sql.append(" where car_cart.car_select ='no' and car_cart.car_detect='true' ");
		sql.append(" and car_cart.car_id= ?");
		sql.append(" order by car_cart.car_id");

		preparedStatement = super.prepareStatement(sql.toString());
		
		int parameterInde = 1;
		preparedStatement.setObject(parameterInde++, carId);

		System.out.println("***SQL:" + sql);
//		System.out.println("***param:" + .toString());
		// s4-1.执行sql
		resultSet = preparedStatement.executeQuery();

		// s4-1.遍历resultSet

		/*
		 * student_id student_name start_date max_count remark
		 * 
		 */
		System.out.println("***SQL查询结果 begin");

		while (resultSet.next()) {
			MyCartQueryView MyCartQueryView = new MyCartQueryView();
			
			MyCartQueryView.setProduct_sku_price(resultSet.getString("product_sku_price"));
			
			MyCartQueryView.setCar_id(resultSet.getString("car_id"));
			MyCartQueryView.setSku_amount(resultSet.getString("sku_amount"));
			MyCartQueryView.setProduct_sku_id(resultSet.getString("product_sku_id"));
//			MyCartQueryView.setProduct_sku_code(resultSet.getString("product_sku_code"));
			MyCartQueryView.setCar_date(resultSet.getTimestamp("car_date"));
			MyCartQueryView.setCustomer_id(resultSet.getString("customer_id"));
//			MyCartQueryView.setCustomer_name(resultSet.getString("customer_name"));
			MyCartQueryView.setCar_select(resultSet.getString("car_select"));
			MyCartQueryView.setCar_detect(resultSet.getString("car_detect"));
			MyCartQueryView.setProduct_name(resultSet.getString("product_name"));
			MyCartQueryView.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(resultSet.getString("product_sku_realPrice")));
			MyCartQueryView.setProduct_sku_img_small(resultSet.getString("product_sku_img_small"));
			MyCartQueryView.setColor_name(resultSet.getString("color_name"));
			MyCartQueryView.setSize_name(resultSet.getString("size_name"));
			MyCartQueryView.setStore_name(resultSet.getString("store_name"));
			
			listMyCart.add(MyCartQueryView);

			System.out.println(MyCartQueryView.toString());
		}
		System.out.println("***SQL查询结果 end");
		System.out.println("操作成功");

		return listMyCart;
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("操作失败");

		throw new RuntimeException("学生查询失败", e);
	}
}
	
	
	@Override
	public ArrayList<MyCartQueryView> listByCustomerId(String customerId) {
		ArrayList<MyCartQueryView> listMyCart = new ArrayList<MyCartQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(" select car_cart.* ,usr_address.* , pro_product.product_name,pro_product_sku.product_sku_img_small ,");
					
			sql.append(" pro_product_sku.product_sku_realPrice ,pro_color.color_name ,pro_size.size_name ,");
			sql.append(" pro_store.store_name from car_cart ");
			
			sql.append(" JOIN pro_product_sku");
			sql.append(" on car_cart.product_sku_id = pro_product_sku.product_sku_id");
			
			sql.append(" JOIN pro_product");
			sql.append(" on pro_product_sku.product_id = pro_product.product_id");
			
			sql.append(" JOIN pro_store");
			sql.append(" on pro_product.store_id = pro_store.store_id");
			
			sql.append(" JOIN pro_color");
			sql.append(" on pro_product_sku.color_id = pro_color.color_id");
			
			sql.append(" JOIN pro_size");
			sql.append(" on pro_product_sku.size_id = pro_size.size_id");
			
			sql.append(" JOIN usr_customer");
			sql.append(" on usr_customer.customer_id = car_cart.customer_id");
			
			sql.append(" left JOIN usr_address");
			sql.append(" on usr_address.customer_id = car_cart.customer_id");
			
			sql.append(" where car_cart.car_select ='yes' and car_cart.car_detect='false' and car_cart.customer_id = ? ");
			sql.append(" order by car_cart.car_id");
			
			/*if (！StringUtil.isEmpty(s)) {
				
			}*/
			
			preparedStatement = super.prepareStatement(sql.toString());
			
			int parameterIndex=1;
			preparedStatement.setObject(parameterIndex++, customerId);

			System.out.println("***SQL:" + sql);
//			System.out.println("***param:" + .toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				MyCartQueryView MyCartQueryView = new MyCartQueryView();
				
				MyCartQueryView.setCar_id(resultSet.getString("car_id"));
				MyCartQueryView.setAddress_name(resultSet.getString("address_name"));
				MyCartQueryView.setSku_amount(resultSet.getString("sku_amount"));
				MyCartQueryView.setProduct_sku_id(resultSet.getString("product_sku_id"));
//				MyCartQueryView.setProduct_sku_code(resultSet.getString("product_sku_code"));
				MyCartQueryView.setCar_date(resultSet.getTimestamp("car_date"));
				MyCartQueryView.setCustomer_id(resultSet.getString("customer_id"));
//				MyCartQueryView.setCustomer_name(resultSet.getString("customer_name"));
				MyCartQueryView.setCar_select(resultSet.getString("car_select"));
				MyCartQueryView.setCar_detect(resultSet.getString("car_detect"));
				MyCartQueryView.setProduct_name(resultSet.getString("product_name"));
				MyCartQueryView.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(resultSet.getString("product_sku_realPrice")));
				MyCartQueryView.setProduct_sku_img_small(resultSet.getString("product_sku_img_small"));
				MyCartQueryView.setColor_name(resultSet.getString("color_name"));
				MyCartQueryView.setSize_name(resultSet.getString("size_name"));
				MyCartQueryView.setStore_name(resultSet.getString("store_name"));
				listMyCart.add(MyCartQueryView);

				System.out.println(MyCartQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listMyCart;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}
	}
	
	
	
	
	@Override
	public ArrayList<MyCartQueryView> listView(CartConditionView CartConditionView) {
		ArrayList<MyCartQueryView> listMyCart = new ArrayList<MyCartQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select car_cart.* , pro_product.product_name,pro_product_sku.product_sku_img_small ,pro_product_sku.product_sku_realPrice ,pro_color.color_name ,pro_size.size_name ,pro_store.store_name from car_cart ");
			
			sql.append(" JOIN pro_product_sku");
			sql.append(" on car_cart.product_sku_id = pro_product_sku.product_sku_id");
			
			sql.append(" JOIN pro_product");
			sql.append(" on pro_product_sku.product_id = pro_product.product_id");
			
			sql.append(" JOIN pro_store");
			sql.append(" on pro_product.store_id = pro_store.store_id");
			
			sql.append(" JOIN pro_color");
			sql.append(" on pro_product_sku.color_id = pro_color.color_id");
			
			sql.append(" JOIN pro_size");
			sql.append(" on pro_product_sku.size_id = pro_size.size_id");
			
			sql.append(" JOIN usr_customer");
			sql.append(" on usr_customer.customer_id = car_cart.customer_id");
			
			sql.append(" where car_cart.car_select ='yes' and car_cart.car_detect='false' ");
//			sql.append(" and car_cart.car_id= ?");
			sql.append(" order by car_cart.car_id");

			preparedStatement = super.prepareStatement(sql.toString());
			
			/*int parameterInde = 1;
			preparedStatement.setObject(parameterInde++, CartConditionView.getCar_id());*/

			System.out.println("***SQL:" + sql);
//			System.out.println("***param:" + .toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				MyCartQueryView MyCartQueryView = new MyCartQueryView();
				
				MyCartQueryView.setCar_id(resultSet.getString("car_id"));
				MyCartQueryView.setSku_amount(resultSet.getString("sku_amount"));
				MyCartQueryView.setProduct_sku_id(resultSet.getString("product_sku_id"));
//				MyCartQueryView.setProduct_sku_code(resultSet.getString("product_sku_code"));
				MyCartQueryView.setCar_date(resultSet.getTimestamp("car_date"));
				MyCartQueryView.setCustomer_id(resultSet.getString("customer_id"));
//				MyCartQueryView.setCustomer_name(resultSet.getString("customer_name"));
				MyCartQueryView.setCar_select(resultSet.getString("car_select"));
				MyCartQueryView.setCar_detect(resultSet.getString("car_detect"));
				MyCartQueryView.setProduct_name(resultSet.getString("product_name"));
				MyCartQueryView.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(resultSet.getString("product_sku_realPrice")));
				MyCartQueryView.setProduct_sku_img_small(resultSet.getString("product_sku_img_small"));
				MyCartQueryView.setColor_name(resultSet.getString("color_name"));
				MyCartQueryView.setSize_name(resultSet.getString("size_name"));
				MyCartQueryView.setStore_name(resultSet.getString("store_name"));
				
				listMyCart.add(MyCartQueryView);

				System.out.println(MyCartQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listMyCart;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}
	}
	}


