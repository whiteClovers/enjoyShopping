package com.ckwl.likemoney.order.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.front.view.MyOrderQueryView;
import com.ckwl.likemoney.order.dao.IOrderDaoImp;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.view.OrderConditionView;
import com.ckwl.likemoney.order.view.OrderQueryView;

public class OrderDaoImp extends BaseDao implements IOrderDaoImp {
	
	public int findMax(){
		PreparedStatement preparedStatement = null;
		int maxCode = 0;
		
		try {
			String sql = "SELECT max(ord_order.order_code+0) as maxCode from ord_order" ;
			
			preparedStatement = super.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				maxCode = Integer.valueOf(resultSet.getString("maxCode"));
				System.out.println("maxCode="+maxCode);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return maxCode;
	}
	
	public Order insertOrder(Order Order) {
		PreparedStatement preparedStatement = null;
		Order order2 = new Order();
		
		try {
			String sql = "insert into ord_order(order_id,order_code,address_id,customer_id,order_date,order_status,order_sum_money,order_paydate) values(?,?,?,?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + Order.toString());
			
			preparedStatement = super.prepareStatement(sql);
			
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
//			int indexCode = findMax();
//			String code = String.valueOf(indexCode++);
			
			preparedStatement.setObject(1, uuid);
			preparedStatement.setObject(2, Order.getOrder_code());
			
			preparedStatement.setObject(3, Order.getAddress_id());
			preparedStatement.setObject(4, Order.getCustomer_id());
			preparedStatement.setObject(5, Order.getOrder_date());
			preparedStatement.setObject(6, Order.getOrder_status());
			preparedStatement.setObject(7, Order.getOrder_sum_money());
			preparedStatement.setObject(8, Order.getOrder_paydate());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();
			System.out.println("params:" + uuid + "," + Order.getOrder_code());
			System.out.println("影响行数" + count);

			
			order2.setOrder_id(uuid);
			order2.setOrder_code(Order.getOrder_code());
			
			
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return order2;

	}
	
	
	public void insert(Order Order) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into ord_order(order_id,order_code,address_id,customer_id,order_date,order_status,order_sum_money,order_paydate) values(?,?,?,?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + Order.toString());
			
			preparedStatement = super.prepareStatement(sql);
			
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			preparedStatement.setObject(1, uuid);
			preparedStatement.setObject(2, Order.getOrder_code());
			
			preparedStatement.setObject(3, Order.getAddress_id());
			preparedStatement.setObject(4, Order.getCustomer_id());
			preparedStatement.setObject(5, Order.getOrder_date());
			preparedStatement.setObject(6, Order.getOrder_status());
			preparedStatement.setObject(7, Order.getOrder_sum_money());
			preparedStatement.setObject(8, Order.getOrder_paydate());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();
			System.out.println("params:" + uuid + "," + Order.getOrder_code());
			System.out.println("影响行数" + count);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void delete(Order Order) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from ord_order where order_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + Order.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, Order.getOrder_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void update(Order Order) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  ord_order set order_code=?,address_id=?,customer_id=?,order_date=?,order_status=?,order_sum_money=?, order_paydate=? where order_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + Order.toString());
			int parameterIndex = 1;
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(parameterIndex++, Order.getOrder_code());
			preparedStatement.setObject(parameterIndex++, Order.getAddress_id());
			preparedStatement.setObject(parameterIndex++, Order.getCustomer_id());
			preparedStatement.setObject(parameterIndex++, Order.getOrder_date());
			preparedStatement.setObject(parameterIndex++, Order.getOrder_status());
			preparedStatement.setObject(parameterIndex++, Order.getOrder_sum_money());
			preparedStatement.setObject(parameterIndex++, Order.getOrder_paydate());
			preparedStatement.setObject(parameterIndex++, Order.getOrder_id());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	// public ArrayList<Order> selete() {
	// ArrayList<Order> listOrder = new ArrayList<Order>();
	// PreparedStatement preparedStatement = null;
	// ResultSet resultSet = null;
	// try {
	// String sql = "select * from ord_order";
	// System.out.println("select sql:" + sql);
	// preparedStatement = super.prepareStatement(sql);
	// resultSet = preparedStatement.executeQuery();
	// DbUtil.getSetresultSet().add(resultSet);
	// while (resultSet.next()) {
	// Order Order = new Order();
	// String id = resultSet.getString("order_id");
	// String code = resultSet.getString("order_code");
	// String address_id = resultSet.getString("address_id");
	// String customer_id = resultSet.getString("customer_id");
	// Date order_date = resultSet.getTimestamp("order_date");
	// String order_status = resultSet.getString("order_status");
	// String order_sum_money = resultSet.getString("order_sum_money");
	// Date order_paydate = resultSet.getTimestamp("order_paydate");
	//
	// Order.setOrder_id(id);
	// Order.setOrder_code(code);
	// Order.setAddress_id(address_id);
	// Order.setCustomer_id(customer_id);
	// Order.setOrder_date(order_date);
	// Order.setOrder_status(order_status);
	// Order.setOrder_sum_money(StringUtil.stringToBigdecimal(order_sum_money));
	// Order.setOrder_paydate(order_paydate);
	// System.out.println("identity:" + id + "code:" + code + "address_id:" +
	// address_id + "customer_id:"
	// + customer_id + "order_date:" + order_date + "order_status:" +
	// order_status + "order_sum_money:"
	// + order_sum_money + "order_paydate:" + order_paydate);
	//
	// listOrder.add(Order);
	// }
	// return listOrder;
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// throw new RuntimeException("订单查询失败", ex);
	// }
	// }

	public ArrayList<OrderQueryView> list(OrderConditionView OrderConditionView) {
		ArrayList<OrderQueryView> listOrder = new ArrayList<OrderQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select ord_order.* , usr_address.address_name ,usr_customer.customer_name,bas_datadictonary_detail.dataDictonary_detail_label  from ord_order ");
			sql.append(" JOIN usr_address");
			sql.append(" on ord_order.address_id = usr_address.address_id");
			sql.append(" JOIN usr_customer");
			sql.append(" on ord_order.customer_id = usr_customer.customer_id");
			sql.append(" JOIN bas_datadictonary_detail");
			sql.append(" on ord_order.order_status = bas_datadictonary_detail.dataDictonary_detail_code");
			sql.append(" where bas_datadictonary_detail.dataDictonary_code ='order_status'");

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_code())) {
				sql.append(" and ord_order.order_code like ?");
			}

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_status())) {
				sql.append(" and ord_order.order_status like ?");
			}

			if (!StringUtil.isEmpty(OrderConditionView.getCustomer_name())) {
				sql.append(" and usr_customer.customer_name like ?");
			}

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_code()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getOrder_code() + "%");

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_status()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getOrder_status() + "%");

			if (!StringUtil.isEmpty(OrderConditionView.getCustomer_name()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getCustomer_name() + "%");

			// if(StringUtil.isNotEmpty(xyz))
			// preparedStatement.setObject(parameterIndex++ , xyz);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + OrderConditionView.toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				OrderQueryView OrderQueryView = new OrderQueryView();
				OrderQueryView.setOrder_id(resultSet.getString("order_id"));
				OrderQueryView.setOrder_code(resultSet.getString("order_code"));
				OrderQueryView.setAddress_name(resultSet.getString("address_name"));
				OrderQueryView.setAddress_id(resultSet.getString("address_id"));
				OrderQueryView.setCustomer_name(resultSet.getString("customer_name"));
				OrderQueryView.setCustomer_id(resultSet.getString("customer_id"));
				OrderQueryView.setOrder_date(resultSet.getTimestamp("order_date"));
				OrderQueryView.setOrder_paydate(resultSet.getTimestamp("order_paydate"));
				OrderQueryView.setOrder_status(resultSet.getString("order_status"));
				OrderQueryView.setDataDictonary_detail_label(resultSet.getString("dataDictonary_detail_label"));
				;
				OrderQueryView
						.setOrder_sum_money(StringUtil.stringToBigdecimal(resultSet.getString("order_sum_money")));

				listOrder.add(OrderQueryView);

				System.out.println(OrderQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listOrder;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}

	}
	public ArrayList<Order> listorder(String customer_id){
		ArrayList<Order> listOrder = new ArrayList<Order>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(" select ord_order.*  from ord_order ");
			sql.append(" where customer_id=? ");

			

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			preparedStatement.setObject(parameterIndex++, customer_id);
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
				Order Order= new Order();
				Order.setOrder_id(resultSet.getString("order_id"));
				Order.setOrder_code(resultSet.getString("order_code"));
				
				Order.setAddress_id(resultSet.getString("address_id"));
				
				Order.setCustomer_id(resultSet.getString("customer_id"));
				Order.setOrder_date(resultSet.getTimestamp("order_date"));
				Order.setOrder_paydate(resultSet.getTimestamp("order_paydate"));
				Order.setOrder_status(resultSet.getString("order_status"));
				
				Order
						.setOrder_sum_money(StringUtil.stringToBigdecimal(resultSet.getString("order_sum_money")));
			

				listOrder.add(Order);

				System.out.println(Order.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listOrder;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}
		
	}
	public ArrayList<MyOrderQueryView> list(String order_id) {
		ArrayList<MyOrderQueryView> listMyOrder = new ArrayList<MyOrderQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select ord_order.* ,ord_order_detail.order_detail_id, pro_product.product_name,pro_product_sku.product_sku_img_small ,pro_product_sku.product_sku_code,ord_order_detail.order_detail_amount,usr_address.address_consignee,pro_product_sku.product_sku_realPrice,bas_datadictonary_detail.dataDictonary_detail_label,pro_color.color_name    from ord_order ");
			sql.append(" JOIN ord_order_detail");
			sql.append(" on ord_order.order_id = ord_order_detail.order_id");
			sql.append(" JOIN pro_product_sku");
			sql.append(" on ord_order_detail.product_sku_id = pro_product_sku.product_sku_id");
			sql.append(" JOIN pro_product");
			sql.append(" on pro_product_sku.product_id = pro_product.product_id");
			sql.append(" JOIN usr_address");
			sql.append(" on ord_order.address_id = usr_address.address_id");
			sql.append(" JOIN bas_datadictonary_detail");
			sql.append(" on ord_order.order_status = bas_datadictonary_detail.dataDictonary_detail_code");
			sql.append(" JOIN pro_color");
			sql.append(" on pro_product_sku.color_id = pro_color.color_id");
			sql.append(" where bas_datadictonary_detail.dataDictonary_code ='order_status'");
			sql.append(" and ord_order.order_id=?");
			sql.append(" order by ord_order.order_id");

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			preparedStatement.setObject(parameterIndex++, order_id);
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
				MyOrderQueryView MyOrderQueryView = new MyOrderQueryView();
				MyOrderQueryView.setOrder_id(resultSet.getString("order_id"));
				MyOrderQueryView.setOrder_code(resultSet.getString("order_code"));
				
				MyOrderQueryView.setOrder_detail_id(resultSet.getString("order_detail_id"));
				
				MyOrderQueryView.setAddress_id(resultSet.getString("address_id"));
				MyOrderQueryView.setColor_name(resultSet.getString("color_name"));
				MyOrderQueryView.setProduct_sku_code(resultSet.getString("product_sku_code"));
				MyOrderQueryView.setCustomer_id(resultSet.getString("customer_id"));
				MyOrderQueryView.setOrder_date(resultSet.getTimestamp("order_date"));
				MyOrderQueryView.setOrder_paydate(resultSet.getTimestamp("order_paydate"));
				MyOrderQueryView.setOrder_status(resultSet.getString("order_status"));
				MyOrderQueryView.setDataDictonary_detail_label(resultSet.getString("dataDictonary_detail_label"));
				;
				MyOrderQueryView
						.setOrder_sum_money(StringUtil.stringToBigdecimal(resultSet.getString("order_sum_money")));
				MyOrderQueryView.setAddress_consignee(resultSet.getString("address_consignee"));
				MyOrderQueryView.setProduct_name(resultSet.getString("product_name"));
				MyOrderQueryView.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(resultSet.getString("product_sku_realPrice")));
				MyOrderQueryView.setProduct_sku_img_small(resultSet.getString("product_sku_img_small"));
				MyOrderQueryView.setOrder_detail_amount(resultSet.getString("order_detail_amount"));

				listMyOrder.add(MyOrderQueryView);

				System.out.println(MyOrderQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listMyOrder;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}
		
	}

	@Override
	public ArrayList<OrderQueryView> listOrd(OrderConditionView OrderConditionView, int pageIndex, int pageSize) {

		ArrayList<OrderQueryView> listOrder = new ArrayList<OrderQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select ord_order.* , usr_address.address_name ,usr_customer.customer_name,bas_datadictonary_detail.dataDictonary_detail_label  from ord_order ");
			sql.append(" JOIN usr_address");
			sql.append(" on ord_order.address_id = usr_address.address_id");
			sql.append(" JOIN usr_customer");
			sql.append(" on ord_order.customer_id = usr_customer.customer_id");
			sql.append(" JOIN bas_datadictonary_detail");
			sql.append(" on ord_order.order_status = bas_datadictonary_detail.dataDictonary_detail_code");
			sql.append(" where bas_datadictonary_detail.dataDictonary_code ='order_status'");

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_code())) {
				sql.append(" and ord_order.order_code like ?");
			}

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_status())) {
				sql.append(" and ord_order.order_status like ?");
			}

			if (!StringUtil.isEmpty(OrderConditionView.getCustomer_name())) {
				sql.append(" and usr_customer.customer_name like ?");
			}

			sql.append(" limit ").append(pageIndex * pageSize).append(pageSize);
			
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_code()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getOrder_code() + "%");

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_status()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getOrder_status() + "%");

			if (!StringUtil.isEmpty(OrderConditionView.getCustomer_name()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getCustomer_name() + "%");

			// if(StringUtil.isNotEmpty(xyz))
			// preparedStatement.setObject(parameterIndex++ , xyz);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + OrderConditionView.toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				OrderQueryView OrderQueryView = new OrderQueryView();
				OrderQueryView.setOrder_id(resultSet.getString("order_id"));
				OrderQueryView.setOrder_code(resultSet.getString("order_code"));
				OrderQueryView.setAddress_name(resultSet.getString("address_name"));
				OrderQueryView.setAddress_id(resultSet.getString("address_id"));
				OrderQueryView.setCustomer_name(resultSet.getString("customer_name"));
				OrderQueryView.setCustomer_id(resultSet.getString("customer_id"));
				OrderQueryView.setOrder_date(resultSet.getTimestamp("order_date"));
				OrderQueryView.setOrder_paydate(resultSet.getTimestamp("order_paydate"));
				OrderQueryView.setOrder_status(resultSet.getString("order_status"));
				OrderQueryView.setDataDictonary_detail_label(resultSet.getString("dataDictonary_detail_label"));
				;
				OrderQueryView
						.setOrder_sum_money(StringUtil.stringToBigdecimal(resultSet.getString("order_sum_money")));

				listOrder.add(OrderQueryView);

				System.out.println(OrderQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listOrder;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}

	
	}

	@Override
	public int recordCount(OrderConditionView OrderConditionView) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(*) from ord_order where 1=1 ");
			

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_code())) {
				sql.append(" and ord_order.order_code like ?");
			}

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_status())) {
				sql.append(" and ord_order.order_status like ?");
			}

			if (!StringUtil.isEmpty(OrderConditionView.getCustomer_name())) {
				sql.append(" and usr_customer.customer_name like ?");
			}

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_code()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getOrder_code() + "%");

			if (!StringUtil.isEmpty(OrderConditionView.getOrder_status()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getOrder_status() + "%");

			if (!StringUtil.isEmpty(OrderConditionView.getCustomer_name()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderConditionView.getCustomer_name() + "%");

			// if(StringUtil.isNotEmpty(xyz))
			// preparedStatement.setObject(parameterIndex++ , xyz);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + OrderConditionView.toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			if (resultSet.next()) {
				int recordCount = resultSet.getInt(1);
				return recordCount;
			}else {
				throw new RuntimeException("查询失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}
	
	}

}
