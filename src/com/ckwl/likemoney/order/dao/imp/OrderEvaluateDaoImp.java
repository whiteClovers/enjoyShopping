package com.ckwl.likemoney.order.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.order.dao.IOrderEvaluateDaoImp;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.entity.OrderEvaluate;
import com.ckwl.likemoney.order.view.OrderEvaluateQueryView;
import com.ckwl.likemoney.order.view.OrderEvaluateConditionView;
import com.ckwl.likemoney.order.view.OrderEvaluateQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;

public class OrderEvaluateDaoImp extends BaseDao implements IOrderEvaluateDaoImp{
	public void insert(OrderEvaluate OrderEvaluate) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into ord_evaluate(evaluate_id,evaluate_time,evaluate_message,evaluate_img,evaluate_service,evaluate_amount,evaluate_bad,evaluate_good,evaluate_common,order_detail_id,evaluate_speed,evaluate_describe,customer_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + OrderEvaluate.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			preparedStatement.setObject(1, uuid);
			preparedStatement.setObject(2, OrderEvaluate.getEvaluate_time());
			preparedStatement.setObject(3, OrderEvaluate.getEvaluate_message());
			preparedStatement.setObject(4, OrderEvaluate.getEvaluate_img());
			preparedStatement.setObject(5, OrderEvaluate.getEvaluate_service());
			
			preparedStatement.setObject(6, OrderEvaluate.getEvaluate_amount());
			preparedStatement.setObject(7, OrderEvaluate.getEvaluate_bad());
			preparedStatement.setObject(8, OrderEvaluate.getEvaluate_good());
			preparedStatement.setObject(9, OrderEvaluate.getEvaluate_common());
			preparedStatement.setObject(10, OrderEvaluate.getOrder_detail_id());
			preparedStatement.setObject(11, OrderEvaluate.getEvaluate_speed());
			preparedStatement.setObject(12, OrderEvaluate.getEvaluate_describe());
			preparedStatement.setObject(13, OrderEvaluate.getCustomer_id());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();

			System.out.println("影响行数" + count);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void delete(OrderEvaluate OrderEvaluate) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from ord_evaluate where evaluate_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + OrderEvaluate.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, OrderEvaluate.getEvaluate_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void update(OrderEvaluate OrderEvaluate) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  ord_evaluate set evaluate_time=?,evaluate_message=?,evaluate_img=?,evaluate_service=?, evaluate_amount=?, evaluate_bad=?, evaluate_good=?, evaluate_common=?, order_detail_id=?, evaluate_speed=?, evaluate_describe=?,customer_id=? where evaluate_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + OrderEvaluate.toString());
			preparedStatement = super.prepareStatement(sql);

			
			preparedStatement.setObject(1, OrderEvaluate.getEvaluate_time());
			preparedStatement.setObject(2, OrderEvaluate.getEvaluate_message());
			preparedStatement.setObject(3, OrderEvaluate.getEvaluate_img());
			preparedStatement.setObject(4, OrderEvaluate.getEvaluate_service());
			
			preparedStatement.setObject(5, OrderEvaluate.getEvaluate_amount());
			preparedStatement.setObject(6, OrderEvaluate.getEvaluate_bad());
			preparedStatement.setObject(7, OrderEvaluate.getEvaluate_good());
			preparedStatement.setObject(8, OrderEvaluate.getEvaluate_common());
			preparedStatement.setObject(9, OrderEvaluate.getOrder_detail_id());
			preparedStatement.setObject(10, OrderEvaluate.getEvaluate_speed());
			preparedStatement.setObject(11, OrderEvaluate.getEvaluate_describe());
			preparedStatement.setObject(12, OrderEvaluate.getCustomer_id());
			preparedStatement.setObject(13, OrderEvaluate.getEvaluate_id());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	@Override
	public ArrayList<OrderEvaluateQueryView> list(OrderEvaluateConditionView OrderEvaluateConditionView) {
		// TODO Auto-generated method stub
		ArrayList<OrderEvaluateQueryView> listOrderEvaluateQueryView = new ArrayList<OrderEvaluateQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder() ;
			sql.append(" select ord_evaluate.* , ord_order_detail.order_detail_code ,usr_customer.customer_name  from ord_evaluate ") ;
			sql.append(" JOIN ord_order_detail");
			sql.append(" on ord_evaluate.order_detail_id = ord_order_detail.order_detail_id");
		
			sql.append(" JOIN usr_customer");
			sql.append(" on ord_evaluate.customer_id = usr_customer.customer_id");
			
			if(!StringUtil.isEmpty(OrderEvaluateConditionView.getOrder_code())){
				sql.append(" and ord_order.order_code like ?") ;
			}
			
			if(!StringUtil.isEmpty(OrderEvaluateConditionView.getCustomer_name())){
				sql.append(" and usr_customer.customer_name like ?") ;
			}
			
			if(!StringUtil.isEmpty(OrderEvaluateConditionView.getEvaluate_time())){
//				sql.append(" and ord_order_detail.order_detail_out like ?") ;
			}
			
			
	
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(!StringUtil.isEmpty(OrderEvaluateConditionView.getOrder_code()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+OrderEvaluateConditionView.getOrder_code() + "%");
			
			if(!StringUtil.isEmpty(OrderEvaluateConditionView.getCustomer_name()))
				preparedStatement.setObject(parameterIndex++ , "%"+OrderEvaluateConditionView.getCustomer_name()+ "%");
			
//			if(!StringUtil.isEmpty(OrderEvaluateConditionView.getEvaluate_time()))
//				preparedStatement.setObject(parameterIndex++ , "%"+OrderEvaluateConditionView.getEvaluate_time()+ "%");
			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + OrderEvaluateConditionView.toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
			
			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");
			while (resultSet.next()) {
				OrderEvaluateQueryView OrderEvaluateQueryView = new OrderEvaluateQueryView();
				String evaluate_id = resultSet.getString("evaluate_id");
				Date evaluate_time = resultSet.getTimestamp("evaluate_time");
				String evaluate_message = resultSet.getString("evaluate_message");
				String evaluate_img = resultSet.getString("evaluate_img");
				String evaluate_service = resultSet.getString("evaluate_service");
				String evaluate_amount = resultSet.getString("evaluate_amount");
				String evaluate_bad = resultSet.getString("evaluate_bad");
				String evaluate_good = resultSet.getString("evaluate_good");
				String evaluate_common = resultSet.getString("evaluate_common");
				String order_detail_id = resultSet.getString("order_detail_id");
				String evaluate_speed = resultSet.getString("evaluate_speed");
				String evaluate_describe = resultSet.getString("evaluate_describe");
				String customer_id = resultSet.getString("customer_id");
				String order_detail_code = resultSet.getString("order_detail_code");
				String customer_name = resultSet.getString("customer_name");
			
				OrderEvaluateQueryView.setOrder_detail_id(order_detail_id);
				OrderEvaluateQueryView.setEvaluate_id(evaluate_id);
				OrderEvaluateQueryView.setEvaluate_time(evaluate_time);
				OrderEvaluateQueryView.setEvaluate_message(evaluate_message);
				OrderEvaluateQueryView.setEvaluate_img(evaluate_img);
				OrderEvaluateQueryView.setEvaluate_service(evaluate_service);
				OrderEvaluateQueryView.setEvaluate_amount(StringUtil.stringToInteger(evaluate_amount));
				OrderEvaluateQueryView.setEvaluate_bad(StringUtil.stringToInteger(evaluate_bad));
				OrderEvaluateQueryView.setEvaluate_good(StringUtil.stringToInteger(evaluate_good));
				OrderEvaluateQueryView.setEvaluate_common(StringUtil.stringToInteger(evaluate_common));
				OrderEvaluateQueryView.setEvaluate_speed(evaluate_speed);
				OrderEvaluateQueryView.setOrder_detail_code(order_detail_code);
				OrderEvaluateQueryView.setEvaluate_describe(evaluate_describe);

				OrderEvaluateQueryView.setCustomer_id(customer_id);

				OrderEvaluateQueryView.setCustomer_name(customer_name);

			
		
//
//				System.out.println("identity:" + id + "code:" + code + "address_id:" + address_id + "customer_id:"
//						+ customer_id + "OrderEvaluateQueryView_date:" + OrderEvaluateQueryView_date + "OrderEvaluateQueryView_status:"
//						+ OrderEvaluateQueryView_status + "OrderEvaluateQueryView_sum_money:" + OrderEvaluateQueryView_sum_money + "OrderEvaluateQueryView_paydate:"
//						+ OrderEvaluateQueryView_paydate);

				listOrderEvaluateQueryView.add(OrderEvaluateQueryView);
				System.out.println(OrderEvaluateQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");
			return listOrderEvaluateQueryView;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}

	
	
}
