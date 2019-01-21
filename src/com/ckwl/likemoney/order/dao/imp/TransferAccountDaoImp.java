package com.ckwl.likemoney.order.dao.imp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.ckwl.likemoney.bas.entity.Bank;
import com.ckwl.likemoney.bas.view.BankQueryView;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.order.dao.ITransferAccount;
import com.ckwl.likemoney.order.entity.TransferAccount;
import com.ckwl.likemoney.order.view.TransferAccountConditionView;
import com.ckwl.likemoney.order.view.TransferAccountQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;

public class TransferAccountDaoImp  extends BaseDao implements ITransferAccount {

	@Override
	public void insert(TransferAccount transferAccount) {
		PreparedStatement preparedStatement = null;

		try {
			

			// S3.获取statement(执行语句的对象)
			String sql = "insert into ord_transfer( Transfer_accounts_id ,customer_id ,order_id,receivables_id,receivables_name,order_sum_money,order_paydate) "
					+ "values(?,?,?,?,?,?,?)";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			// String studentName = "aa2" ;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, transferAccount.getCustomerId());
			preparedStatement.setObject(paramIndex++, transferAccount.getOrderId());
			preparedStatement.setObject(paramIndex++, transferAccount.getReceivablesId());
			preparedStatement.setObject(paramIndex++, transferAccount.getReceivablesName());
			preparedStatement.setObject(paramIndex++, transferAccount.getOrderSumMoney());
			preparedStatement.setObject(paramIndex++, transferAccount.getOrderPaydate());
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + transferAccount.toString());

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
	public void delete(String transferAccountsId) {
		PreparedStatement preparedStatement = null;
	      try {
				
				// S3.获取statement(执行语句的对象)
				String sql = "delete from ord_transfer where Transfer_accounts_id= ?";
				preparedStatement = super.prepareStatement(sql);

				int paramIndex = 1;
				preparedStatement.setObject(paramIndex++, transferAccountsId);
				System.out.println("sql:"+sql);
				System.out.println("transferAccountsId:"+transferAccountsId);

				// s4-1.执行sql
				int rowCount = preparedStatement.executeUpdate();
				System.out.println("影响行数:" + rowCount);
				if(rowCount == 0){
					throw new RuntimeException("id不存在:" + transferAccountsId);
				}
				

				System.out.println("操作成功");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("操作失败");
				throw new RuntimeException("删除失败" ,e) ;
			} 

	}

	@Override
	public void update(TransferAccount transferAccount) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			String sql = "update ord_transfer set customer_id = ?,order_id= ?,receivables_id = ? ,receivables_name=?,"
					+ "order_sum_money=?,order_paydate=? where  Transfer_accounts_id = ?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, transferAccount.getTransferAccountsId());
			preparedStatement.setObject(paramIndex++, transferAccount.getCustomerId());
			preparedStatement.setObject(paramIndex++, transferAccount.getOrderId());
			preparedStatement.setObject(paramIndex++, transferAccount.getReceivablesId());
			preparedStatement.setObject(paramIndex++, transferAccount.getReceivablesName());
			preparedStatement.setObject(paramIndex++, transferAccount.getOrderSumMoney());
			preparedStatement.setObject(paramIndex++, transferAccount.getOrderPaydate());
			

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
	public ArrayList<TransferAccount> select() {
		ArrayList<TransferAccount> listTransferAccount = new ArrayList<TransferAccount>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			
			String sql = "select * from ord_transfer";
			preparedStatement = super.prepareStatement(sql);
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + "");
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				TransferAccount transferAccount = new TransferAccount();
				
				String Transfer_accounts_id = resultSet.getString("Transfer_accounts_id");
				String customer_id = resultSet.getString("customer_id");
				String order_id = resultSet.getString("order_id");
				String receivables_id = resultSet.getString("receivables_id");
				String receivables_name= resultSet.getString("receivables_name");
				BigDecimal order_sum_money=resultSet.getBigDecimal("order_sum_money");
				Date order_paydate=resultSet.getDate("order_paydate");
				
				transferAccount.setTransferAccountsId(Transfer_accounts_id);
				transferAccount.setCustomerId(customer_id);
				transferAccount.setOrderId(order_id);
				transferAccount.setReceivablesId(receivables_id);
				transferAccount.setReceivablesName(receivables_name);
				transferAccount.setOrderSumMoney(order_sum_money);
				transferAccount.setOrderPaydate(order_paydate);
				
				System.out.println(transferAccount.toString());
				
				listTransferAccount.add(transferAccount);

				
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listTransferAccount;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		} 
	}

	@Override
	public TransferAccount load(String TransferAccountsId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			TransferAccount transferAccount = new TransferAccount();

		
			String sql = "select * from ord_transfer where Transfer_accounts_id = ?";
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, TransferAccountsId);

		
			resultSet = preparedStatement.executeQuery();

			
			if (resultSet.next()) {
				transferAccount.setTransferAccountsId(resultSet.getString("Transfer_accounts_id"));
				transferAccount.setCustomerId(resultSet.getString("customer_id"));
				transferAccount.setOrderId(resultSet.getString("order_id"));
				transferAccount.setReceivablesId(resultSet.getString("receivables_id"));
				transferAccount.setReceivablesName(resultSet.getString("receivables_name"));
				transferAccount.setOrderSumMoney(resultSet.getBigDecimal("order_sum_money"));
				transferAccount.setOrderPaydate(resultSet.getDate("order_paydate"));
				
				
				
				System.out.println(
				"Transfer_accounts_id:" + resultSet.getString("Transfer_accounts_id") + "," + 
				"customer_id:"+ resultSet.getString("customer_id") + "," + 
				"order_id:"+ resultSet.getString("order_id") + "," +
				"receivables_id:"+ resultSet.getString("receivables_id") + "," + 
				"receivables_name:"+ resultSet.getString("receivables_name")+ "," + 
				"order_sum_money:"+ resultSet.getString("order_sum_money")+ "," + 
				"order_paydate:"+ resultSet.getString("order_paydate")
				);
			} else {
				System.out.println("ID不存在");
				throw new RuntimeException("查询失败");
			}

			System.out.println("操作成功");
			return transferAccount;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		} 
	}

	@Override
	public ArrayList<TransferAccountQueryView> select(TransferAccountConditionView conditionView) {
		
		ArrayList<TransferAccountQueryView> listTransferAccountQueryView = new ArrayList<TransferAccountQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select ord_transfer.*,ord_transfer.receivables_name ,ord_order.order_id,usr_customer.customer_id from ord_transfer");
			sql.append(" JOIN usr_customer");
			sql.append(" on ord_transfer.customer_id=usr_customer.customer_id");
			sql.append(" JOIN ord_order");
			sql.append(" on ord_transfer.order_id=ord_order.order_id");
			
			
			if(StringUtil.isNotEmpty(conditionView.getCustomerId())){
				sql.append(" and ord_transfer.customer_id like ?") ;
			}
			
			if(StringUtil.isNotEmpty(conditionView.getOrderId())){
				sql.append(" and ord_transfer.order_id like ?") ;
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			if(StringUtil.isNotEmpty(conditionView.getCustomerId()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getCustomerId() + "%");
			
			if(StringUtil.isNotEmpty(conditionView.getOrderId()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getOrderId() + "%");

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + conditionView.toString());
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				TransferAccountQueryView transferAccount = new TransferAccountQueryView();
				
				String Transfer_accounts_id = resultSet.getString("Transfer_accounts_id");
				String customer_id = resultSet.getString("customer_id");
				String order_id = resultSet.getString("order_id");
				String receivables_id = resultSet.getString("receivables_id");
				String receivables_name= resultSet.getString("receivables_name");
				BigDecimal order_sum_money=resultSet.getBigDecimal("order_sum_money");
				Date order_paydate=resultSet.getDate("order_paydate");
				
				transferAccount.setTransferAccountsId(Transfer_accounts_id);
				transferAccount.setCustomerId(customer_id);
				transferAccount.setOrderId(order_id);
				transferAccount.setReceivablesId(receivables_id);
				transferAccount.setReceivablesName(receivables_name);
				transferAccount.setOrderSumMoney(order_sum_money);
				transferAccount.setOrderPaydate(order_paydate);
				
				System.out.println(transferAccount.toString());
				
				listTransferAccountQueryView.add(transferAccount);

				
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listTransferAccountQueryView;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		} 
	}

	
	}


