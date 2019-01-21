package com.ckwl.likemoney.order.dao.imp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.front.view.OrderDetailFrontQueryView;
import com.ckwl.likemoney.order.dao.IOrderDetailDaoImp;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.view.OrderDetailConditionView;
import com.ckwl.likemoney.order.view.OrderDetailQueryView;

public class OrderDetailDaoImp extends BaseDao implements IOrderDetailDaoImp {
	
	public OrderDetailFrontQueryView listByDetailId(String orderDetailId){
		OrderDetailFrontQueryView listOrderDetailFront = new OrderDetailFrontQueryView();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" ");
			sql.append(" JOIN ord_order_detail");
			sql.append(" on ord_order.order_id = ord_order_detail.order_id");
			
			sql.append(" JOIN pro_product_sku");
			sql.append(" on ord_order_detail.product_sku_id = pro_product_sku.product_sku_id");
			
			
			sql.append(" JOIN usr_address");
			sql.append(" on ord_order.address_id = usr_address.address_id");
		
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_order_status");
			sql.append(" on ord_order.order_status  = bas_datadictonary_detail_order_status.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_send");
			sql.append(
					" on ord_order_detail.order_detail_send = bas_datadictonary_detail_send.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_logistics");
			sql.append(
					" on ord_order_detail.order_detail_logistics = bas_datadictonary_detail_logistics.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_receive");
			sql.append(
					" on ord_order_detail.order_detail_receive = bas_datadictonary_detail_receive.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_evaluate");
			sql.append(
					" on ord_order_detail.order_detail_evaluate = bas_datadictonary_detail_evaluate.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_out");
			sql.append(
					" on ord_order_detail.order_detail_out = bas_datadictonary_detail_out.dataDictonary_detail_code");
			
			sql.append(" where bas_datadictonary_detail_order_status.dataDictonary_code='order_status'");
			sql.append(" and bas_datadictonary_detail_send.dataDictonary_code='order_detail_send'");
			sql.append(" and bas_datadictonary_detail_logistics.dataDictonary_code='order_detail_logistics'");
			sql.append(" and bas_datadictonary_detail_receive.dataDictonary_code='order_detail_receive'");
			sql.append(" and bas_datadictonary_detail_evaluate.dataDictonary_code='order_detail_evaluate'");
			sql.append(" and bas_datadictonary_detail_out.dataDictonary_code='order_detail_out'");
			sql.append(" and ord_order.order_id=?");
			sql.append(" order by ord_order.order_id LIMIT 1");
			

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			preparedStatement.setObject(parameterIndex++, orderDetailId);
			System.out.println("***SQL:" + sql);
			// System.out.println("***param:" + .toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				OrderDetailFrontQueryView OrderDetailFrontQueryView = new OrderDetailFrontQueryView();
				String product_sku_realPrice = resultSet.getString("product_sku_realPrice");
				String order_detail_amount = resultSet.getString("order_detail_amount");
				String order_code = resultSet.getString("order_code");
				String order_sum_money = resultSet.getString("order_sum_money");
				String address_name = resultSet.getString("address_name");
				String address_consignee = resultSet.getString("address_consignee");
				String address_phone = resultSet.getString("address_phone");
				String product_sku_img_mid = resultSet.getString("product_sku_img_mid");
				String product_sku_img_small  = resultSet.getString("product_sku_img_small");
				BigDecimal order_detail_sumPrice  = StringUtil.stringToBigdecimal(resultSet.getString("order_detail_sumPrice"));
				Date order_date = resultSet.getTimestamp("order_date");
				Date order_paydate = resultSet.getTimestamp("order_paydate");
				String dataDictonary_detail_label_order_status = resultSet
						.getString("dataDictonary_detail_label_order_status");
				Date order_detail_outTime = resultSet.getTimestamp("order_detail_outTime");
				Date order_detail_logistics_time = resultSet.getTimestamp("order_detail_logistics_time");
				Date order_detail_receive_time = resultSet.getTimestamp("order_detail_receive_time");
				String dataDictonary_detail_label_send = resultSet.getString("dataDictonary_detail_label_send");
				String dataDictonary_detail_label_logistics = resultSet
						.getString("dataDictonary_detail_label_logistics");
						String dataDictonary_detail_label_receive = resultSet.getString("dataDictonary_detail_label_receive");
				String dataDictonary_detail_label_evaluate = resultSet.getString("dataDictonary_detail_label_evaluate");
				String dataDictonary_detail_label_out = resultSet.getString("dataDictonary_detail_label_out");
				OrderDetailFrontQueryView
						.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));
				OrderDetailFrontQueryView.setOrder_detail_amount(StringUtil.stringToInteger(order_detail_amount));
				OrderDetailFrontQueryView.setOrder_id(orderDetailId);
				OrderDetailFrontQueryView.setOrder_code(order_code);
				OrderDetailFrontQueryView.setOrder_date(order_date);
				OrderDetailFrontQueryView.setOrder_sum_money(StringUtil.stringToBigdecimal(order_sum_money));
				OrderDetailFrontQueryView.setAddress_phone(address_phone);
				OrderDetailFrontQueryView.setAddress_name(address_name);
				OrderDetailFrontQueryView.setProduct_sku_img_small(product_sku_img_small);
				OrderDetailFrontQueryView.setProduct_sku_img_mid(product_sku_img_mid);
				OrderDetailFrontQueryView.setOrder_paydate(order_paydate);
				OrderDetailFrontQueryView.setAddress_consignee(address_consignee);
				
				OrderDetailFrontQueryView.setOrder_detail_sumPrice(order_detail_sumPrice);
				
				OrderDetailFrontQueryView.setDataDictonary_detail_label_send(dataDictonary_detail_label_send);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_logistics(dataDictonary_detail_label_logistics);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_receive(dataDictonary_detail_label_receive);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_evaluate(dataDictonary_detail_label_evaluate);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_out(dataDictonary_detail_label_out);
				OrderDetailFrontQueryView
						.setDataDictonary_detail_label_order_status(dataDictonary_detail_label_order_status);
				OrderDetailFrontQueryView.setOrder_detail_outTime(order_detail_outTime);

				OrderDetailFrontQueryView.setOrder_detail_logistics_time(order_detail_logistics_time);
				OrderDetailFrontQueryView.setOrder_detail_receive_time(order_detail_receive_time);


				System.out.println(listOrderDetailFront.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listOrderDetailFront;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}
	}
	
	public int findMax(){
		PreparedStatement preparedStatement = null;
		int maxCode = 0;
		
		try {
			String sql = "SELECT max(ord_order_detail.order_detail_code+0) as maxCode from ord_order_detail " ;
			
			preparedStatement = super.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				maxCode = Integer.valueOf(resultSet.getString("maxCode"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return maxCode;
	}
	
	public void insert(OrderDetail OrderDetail) {
		PreparedStatement preparedStatement = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into ord_order_detail(order_detail_id,order_code,product_sku_id,");
			sql.append(" product_sku_realPrice,order_detail_amount,order_detail_send,order_detail_logistics,");
			sql.append(" order_detail_receive,order_detail_evaluate_time,order_detail_evaluate,order_id,product_sku_price,");
			sql.append(" order_detail_out,order_detail_outTime,order_detail_logistics_time,order_detail_receive_time,order_detail_code)");
			sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + OrderDetail.toString());
			preparedStatement = super.prepareStatement(sql.toString());
			
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			int parameterIndex = 1;
			
			int indexCode = findMax();
			String code = String.valueOf(indexCode++);
			
			preparedStatement.setObject(parameterIndex++, uuid);
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_code());
			
			preparedStatement.setObject(parameterIndex++, OrderDetail.getProduct_sku_id());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getProduct_sku_realPrice());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_amount());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_send());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_logistics());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_receive());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_evaluate_time());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_evaluate());
			
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_id());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getProduct_sku_price());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_out());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_outTime());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_logistics_time());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_receive_time());
			preparedStatement.setObject(parameterIndex++, code);
			
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();

			System.out.println("影响行数" + count);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void delete(OrderDetail OrderDetail) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from ord_order_detail where order_detail_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + OrderDetail.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, OrderDetail.getOrder_detail_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void update(OrderDetail OrderDetail) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  ord_order_detail set order_code=?,product_sku_id=?,product_sku_realPrice=?,order_detail_amount=?,order_detail_send=?,order_detail_logistics=?, order_detail_receive=?, order_detail_evaluate_time=?, order_detail_evaluate=?,order_id=?, product_sku_price=?, order_detail_out=?, order_detail_outTime=?, order_detail_logistics_time=?,order_detail_receive_time=?,order_detail_code=? where order_detail_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + OrderDetail.toString());
			preparedStatement = super.prepareStatement(sql);
			int parameterIndex = 1;
			
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_code());
			
			preparedStatement.setObject(parameterIndex++, OrderDetail.getProduct_sku_id());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getProduct_sku_realPrice());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_amount());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_send());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_logistics());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_receive());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_evaluate_time());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_evaluate());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_id());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getProduct_sku_price());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_out());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_outTime());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_logistics_time());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_receive_time());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_code());
			preparedStatement.setObject(parameterIndex++, OrderDetail.getOrder_detail_id());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public ArrayList<OrderDetailQueryView> list(OrderDetailConditionView OrderDetailConditionView) {
		ArrayList<OrderDetailQueryView> listOrderDetailQueryView = new ArrayList<OrderDetailQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select ord_order_detail.* , ord_order.order_code ,pro_product_sku.product_sku_code,bas_datadictonary_detail_send.dataDictonary_detail_label as dataDictonary_detail_label_send,bas_datadictonary_detail_logistics.dataDictonary_detail_label as dataDictonary_detail_label_logistics,bas_datadictonary_detail_receive.dataDictonary_detail_label as dataDictonary_detail_label_receive,bas_datadictonary_detail_evaluate.dataDictonary_detail_label as dataDictonary_detail_label_evaluate,bas_datadictonary_detail_out.dataDictonary_detail_label as dataDictonary_detail_label_out from ord_order_detail ");
			sql.append(" JOIN ord_order");
			sql.append(" on ord_order_detail.order_id = ord_order.order_id");
			sql.append(" JOIN pro_product_sku");
			sql.append(" on ord_order_detail.product_sku_id = pro_product_sku.product_sku_id");
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_send");
			sql.append(
					" on ord_order_detail.order_detail_send = bas_datadictonary_detail_send.dataDictonary_detail_code");
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_logistics");
			sql.append(
					" on ord_order_detail.order_detail_logistics = bas_datadictonary_detail_logistics.dataDictonary_detail_code");
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_receive");
			sql.append(
					" on ord_order_detail.order_detail_receive = bas_datadictonary_detail_receive.dataDictonary_detail_code");
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_evaluate");
			sql.append(
					" on ord_order_detail.order_detail_evaluate = bas_datadictonary_detail_evaluate.dataDictonary_detail_code");
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_out");
			sql.append(
					" on ord_order_detail.order_detail_out = bas_datadictonary_detail_out.dataDictonary_detail_code");
			sql.append(" where bas_datadictonary_detail_send.dataDictonary_code='order_detail_send'");
			sql.append(" and bas_datadictonary_detail_logistics.dataDictonary_code='order_detail_logistics'");
			sql.append(" and bas_datadictonary_detail_receive.dataDictonary_code='order_detail_receive'");
			sql.append(" and bas_datadictonary_detail_evaluate.dataDictonary_code='order_detail_evaluate'");
			sql.append(" and bas_datadictonary_detail_out.dataDictonary_code='order_detail_out'");

			if (!StringUtil.isEmpty(OrderDetailConditionView.getOrder_code())) {
				sql.append(" and ord_order.order_code like ?");
			}

			if (!StringUtil.isEmpty(OrderDetailConditionView.getProduct_sku_code())) {
				sql.append(" and pro_product_sku.product_sku_code like ?");
			}

			if (!StringUtil.isEmpty(OrderDetailConditionView.getOrder_detail_out())) {
				sql.append(" and ord_order_detail.order_detail_out like ?");
			}

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(OrderDetailConditionView.getOrder_code()))
				preparedStatement.setObject(parameterIndex++, "%" + OrderDetailConditionView.getOrder_code() + "%");

			if (!StringUtil.isEmpty(OrderDetailConditionView.getProduct_sku_code()))
				preparedStatement.setObject(parameterIndex++,
						"%" + OrderDetailConditionView.getProduct_sku_code() + "%");

			if (!StringUtil.isEmpty(OrderDetailConditionView.getOrder_detail_out()))
				preparedStatement.setObject(parameterIndex++,
						"%" + OrderDetailConditionView.getOrder_detail_out() + "%");
			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + OrderDetailConditionView.toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");
			while (resultSet.next()) {
				OrderDetailQueryView OrderDetailQueryView = new OrderDetailQueryView();
				
				String order_detail_id = resultSet.getString("order_detail_id");
				String product_sku_id = resultSet.getString("product_sku_id");
				String product_sku_code = resultSet.getString("product_sku_code");
				String product_sku_realPrice = resultSet.getString("product_sku_realPrice");
				String order_detail_amount = resultSet.getString("order_detail_amount");
				String order_detail_send = resultSet.getString("order_detail_send");
				String order_detail_logistics = resultSet.getString("order_detail_logistics");
				String order_detail_receive = resultSet.getString("order_detail_receive");
				Date order_detail_evaluate_time = resultSet.getTimestamp("order_detail_evaluate_time");
				String order_detail_evaluate = resultSet.getString("order_detail_evaluate");
				String order_id = resultSet.getString("order_id");
				String order_code = resultSet.getString("order_code");
				String product_sku_price = resultSet.getString("product_sku_price");
				String order_detail_out = resultSet.getString("order_detail_out");
				Date order_detail_outTime = resultSet.getTimestamp("order_detail_outTime");
				Date order_detail_logistics_time = resultSet.getTimestamp("order_detail_logistics_time");
				Date order_detail_receive_time = resultSet.getTimestamp("order_detail_receive_time");
				String order_detail_code = resultSet.getString("order_detail_code");
				String dataDictonary_detail_label_send = resultSet.getString("dataDictonary_detail_label_send");
				String dataDictonary_detail_label_logistics = resultSet
						.getString("dataDictonary_detail_label_logistics");
				String dataDictonary_detail_label_receive = resultSet.getString("dataDictonary_detail_label_receive");
				String dataDictonary_detail_label_evaluate = resultSet.getString("dataDictonary_detail_label_evaluate");
				String dataDictonary_detail_label_out = resultSet.getString("dataDictonary_detail_label_out");
				OrderDetailQueryView.setOrder_detail_id(order_detail_id);
				OrderDetailQueryView.setProduct_sku_id(product_sku_id);
				OrderDetailQueryView.setProduct_sku_code(product_sku_code);
				OrderDetailQueryView.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));
				OrderDetailQueryView.setOrder_detail_amount(StringUtil.stringToInteger(order_detail_amount));
				OrderDetailQueryView.setOrder_detail_send(order_detail_send);
				OrderDetailQueryView.setOrder_detail_logistics(order_detail_logistics);
				OrderDetailQueryView.setOrder_detail_receive(order_detail_receive);
				OrderDetailQueryView.setOrder_detail_evaluate_time(order_detail_evaluate_time);
				OrderDetailQueryView.setOrder_detail_evaluate(order_detail_evaluate);
				OrderDetailQueryView.setOrder_id(order_id);
				OrderDetailQueryView.setOrder_code(order_code);
				OrderDetailQueryView.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
				OrderDetailQueryView.setDataDictonary_detail_label_send(dataDictonary_detail_label_send);
				OrderDetailQueryView.setDataDictonary_detail_label_logistics(dataDictonary_detail_label_logistics);
				OrderDetailQueryView.setDataDictonary_detail_label_receive(dataDictonary_detail_label_receive);
				OrderDetailQueryView.setDataDictonary_detail_label_evaluate(dataDictonary_detail_label_evaluate);
				OrderDetailQueryView.setDataDictonary_detail_label_out(dataDictonary_detail_label_out);
				OrderDetailQueryView.setOrder_detail_out(order_detail_out);

				OrderDetailQueryView.setOrder_detail_outTime(order_detail_outTime);

				OrderDetailQueryView.setOrder_detail_logistics_time(order_detail_logistics_time);
				OrderDetailQueryView.setOrder_detail_receive_time(order_detail_receive_time);
				OrderDetailQueryView.setOrder_detail_code(order_detail_code);

				//
				// System.out.println("identity:" + id + "code:" + code +
				// "address_id:" + address_id + "customer_id:"
				// + customer_id + "OrderDetailQueryView_date:" +
				// OrderDetailQueryView_date + "OrderDetailQueryView_status:"
				// + OrderDetailQueryView_status +
				// "OrderDetailQueryView_sum_money:" +
				// OrderDetailQueryView_sum_money +
				// "OrderDetailQueryView_paydate:"
				// + OrderDetailQueryView_paydate);

				listOrderDetailQueryView.add(OrderDetailQueryView);
				System.out.println(OrderDetailQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");
			return listOrderDetailQueryView;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}

	public ArrayList<OrderDetailFrontQueryView> list(String order_id) {
		ArrayList<OrderDetailFrontQueryView> listOrderDetailFront = new ArrayList<OrderDetailFrontQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select ord_order.* ,ord_order_detail.order_detail_amount,ord_order_detail.order_detail_receive_time ,ord_order_detail.order_detail_outTime,ord_order_detail.order_detail_logistics_time,pro_product_sku.product_sku_img_small,pro_product_sku.product_sku_img_mid,usr_address.address_consignee,usr_address.address_phone,usr_address.address_name,ord_order_detail.product_sku_realPrice,bas_datadictonary_detail_send.dataDictonary_detail_label as dataDictonary_detail_label_send,bas_datadictonary_detail_logistics.dataDictonary_detail_label as dataDictonary_detail_label_logistics,bas_datadictonary_detail_receive.dataDictonary_detail_label as dataDictonary_detail_label_receive,bas_datadictonary_detail_evaluate.dataDictonary_detail_label as dataDictonary_detail_label_evaluate,bas_datadictonary_detail_out.dataDictonary_detail_label as dataDictonary_detail_label_out,bas_datadictonary_detail_order_status.dataDictonary_detail_label as dataDictonary_detail_label_order_status,sum(ord_order_detail.order_detail_amount*ord_order_detail.product_sku_realPrice) as order_detail_sumPrice     from ord_order ");
			sql.append(" JOIN ord_order_detail");
			sql.append(" on ord_order.order_id = ord_order_detail.order_id");
			
			sql.append(" JOIN pro_product_sku");
			sql.append(" on ord_order_detail.product_sku_id = pro_product_sku.product_sku_id");
			
			
			sql.append(" JOIN usr_address");
			sql.append(" on ord_order.address_id = usr_address.address_id");
		
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_order_status");
			sql.append(" on ord_order.order_status  = bas_datadictonary_detail_order_status.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_send");
			sql.append(
					" on ord_order_detail.order_detail_send = bas_datadictonary_detail_send.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_logistics");
			sql.append(
					" on ord_order_detail.order_detail_logistics = bas_datadictonary_detail_logistics.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_receive");
			sql.append(
					" on ord_order_detail.order_detail_receive = bas_datadictonary_detail_receive.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_evaluate");
			sql.append(
					" on ord_order_detail.order_detail_evaluate = bas_datadictonary_detail_evaluate.dataDictonary_detail_code");
			
			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_out");
			sql.append(
					" on ord_order_detail.order_detail_out = bas_datadictonary_detail_out.dataDictonary_detail_code");
			
			sql.append(" where bas_datadictonary_detail_order_status.dataDictonary_code='order_status'");
			sql.append(" and bas_datadictonary_detail_send.dataDictonary_code='order_detail_send'");
			sql.append(" and bas_datadictonary_detail_logistics.dataDictonary_code='order_detail_logistics'");
			sql.append(" and bas_datadictonary_detail_receive.dataDictonary_code='order_detail_receive'");
			sql.append(" and bas_datadictonary_detail_evaluate.dataDictonary_code='order_detail_evaluate'");
			sql.append(" and bas_datadictonary_detail_out.dataDictonary_code='order_detail_out'");
			sql.append(" and ord_order.order_id=?");
			sql.append(" order by ord_order.order_id LIMIT 1");
			

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			preparedStatement.setObject(parameterIndex++, order_id);
			System.out.println("***SQL:" + sql);
			// System.out.println("***param:" + .toString());
			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();

			// s4-1.遍历resultSet

			/*
			 * student_id student_name start_date max_count remark
			 * 
			 */
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				OrderDetailFrontQueryView OrderDetailFrontQueryView = new OrderDetailFrontQueryView();
				String product_sku_realPrice = resultSet.getString("product_sku_realPrice");
				String order_detail_amount = resultSet.getString("order_detail_amount");
				String order_code = resultSet.getString("order_code");
				String order_sum_money = resultSet.getString("order_sum_money");
				String address_name = resultSet.getString("address_name");
				String address_consignee = resultSet.getString("address_consignee");
				String address_phone = resultSet.getString("address_phone");
				String product_sku_img_mid = resultSet.getString("product_sku_img_mid");
				String product_sku_img_small  = resultSet.getString("product_sku_img_small");
				BigDecimal order_detail_sumPrice  = StringUtil.stringToBigdecimal(resultSet.getString("order_detail_sumPrice"));
				Date order_date = resultSet.getTimestamp("order_date");
				Date order_paydate = resultSet.getTimestamp("order_paydate");
				String dataDictonary_detail_label_order_status = resultSet
						.getString("dataDictonary_detail_label_order_status");
				Date order_detail_outTime = resultSet.getTimestamp("order_detail_outTime");
				Date order_detail_logistics_time = resultSet.getTimestamp("order_detail_logistics_time");
				Date order_detail_receive_time = resultSet.getTimestamp("order_detail_receive_time");
				String dataDictonary_detail_label_send = resultSet.getString("dataDictonary_detail_label_send");
				String dataDictonary_detail_label_logistics = resultSet
						.getString("dataDictonary_detail_label_logistics");
						String dataDictonary_detail_label_receive = resultSet.getString("dataDictonary_detail_label_receive");
				String dataDictonary_detail_label_evaluate = resultSet.getString("dataDictonary_detail_label_evaluate");
				String dataDictonary_detail_label_out = resultSet.getString("dataDictonary_detail_label_out");
				OrderDetailFrontQueryView
						.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));
				OrderDetailFrontQueryView.setOrder_detail_amount(StringUtil.stringToInteger(order_detail_amount));
				OrderDetailFrontQueryView.setOrder_id(order_id);
				OrderDetailFrontQueryView.setOrder_code(order_code);
				OrderDetailFrontQueryView.setOrder_date(order_date);
				OrderDetailFrontQueryView.setOrder_sum_money(StringUtil.stringToBigdecimal(order_sum_money));
				OrderDetailFrontQueryView.setAddress_phone(address_phone);
				OrderDetailFrontQueryView.setAddress_name(address_name);
				OrderDetailFrontQueryView.setProduct_sku_img_small(product_sku_img_small);
				OrderDetailFrontQueryView.setProduct_sku_img_mid(product_sku_img_mid);
				OrderDetailFrontQueryView.setOrder_paydate(order_paydate);
				OrderDetailFrontQueryView.setAddress_consignee(address_consignee);
				
				OrderDetailFrontQueryView.setOrder_detail_sumPrice(order_detail_sumPrice);
				
				OrderDetailFrontQueryView.setDataDictonary_detail_label_send(dataDictonary_detail_label_send);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_logistics(dataDictonary_detail_label_logistics);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_receive(dataDictonary_detail_label_receive);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_evaluate(dataDictonary_detail_label_evaluate);
				OrderDetailFrontQueryView.setDataDictonary_detail_label_out(dataDictonary_detail_label_out);
				OrderDetailFrontQueryView
						.setDataDictonary_detail_label_order_status(dataDictonary_detail_label_order_status);
				OrderDetailFrontQueryView.setOrder_detail_outTime(order_detail_outTime);

				OrderDetailFrontQueryView.setOrder_detail_logistics_time(order_detail_logistics_time);
				OrderDetailFrontQueryView.setOrder_detail_receive_time(order_detail_receive_time);

				listOrderDetailFront.add(OrderDetailFrontQueryView);

				System.out.println(OrderDetailFrontQueryView.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listOrderDetailFront;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}

	}

}
