package com.ckwl.likemoney.bas.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.bas.dao.IMoneyBank;
import com.ckwl.likemoney.bas.entity.Bank;
import com.ckwl.likemoney.bas.view.BankConditionView;
import com.ckwl.likemoney.bas.view.BankQueryView;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.user.entity.UserCustomer;



public class MoneyBankImp extends BaseDao implements IMoneyBank{

	@Override
	public void insert(Bank bank) {
		PreparedStatement preparedStatement = null;

		try {
			

			// S3.获取statement(执行语句的对象)
			String sql = "insert into bas_bank( bank_id ,bank_name ,bank_num,customer_id,bank_type) values(?,?,?,?,?)";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			// String studentName = "aa2" ;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, bank.getBankName());
			preparedStatement.setObject(paramIndex++, bank.getBankNum());
			preparedStatement.setObject(paramIndex++, bank.getCustomerId());
			preparedStatement.setObject(paramIndex++, bank.getBankType());
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + bank.toString());

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
	public void delete(String bankId) {
		PreparedStatement preparedStatement = null;
      try {
			
			// S3.获取statement(执行语句的对象)
			String sql = "delete from bas_bank where bank_id = ?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, bankId);
			System.out.println("sql:"+sql);
			System.out.println("参数：bankId:"+bankId);

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("影响行数:" + rowCount);
			if(rowCount == 0){
				throw new RuntimeException("卡号不存在:" + bankId);
			}
			

			System.out.println("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("删除失败" ,e) ;
		} 
	}

	@Override
	public void update(Bank bank) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			String sql = "update bas_bank set bank_name = ?,bank_num = ?,bank_type = ?  where bank_id = ?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, bank.getBankName());
			preparedStatement.setObject(paramIndex++, bank.getBankNum());
			preparedStatement.setObject(paramIndex++, bank.getBankType());
			

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
	public ArrayList<Bank> select() {
		ArrayList<Bank> listBank = new ArrayList<Bank>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			
			String sql = "select * from bas_bank";
			preparedStatement = super.prepareStatement(sql);
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + "");
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				Bank bank = new Bank();
				
				String bank_id = resultSet.getString("bank_id");
				String bank_name = resultSet.getString("bank_name");
				String bank_num = resultSet.getString("bank_num");
				String customer_id = resultSet.getString("customer_id");
				String bank_type= resultSet.getString("bank_type");
				
				bank.setBankId(bank_id);
				bank.setBankName(bank_name);
				bank.setBankNum(bank_num);
				bank.setCustomerId(customer_id);
				bank.setBankType(bank_type);
				
				System.out.println("bank_id:" + bank_id + "," + "bank_name:"
						+ bank_name+","+"bank_num:"+bank_num+","+"customer_id:"+customer_id+","+"bank_type:"+bank_type);
				
				listBank.add(bank);

				
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listBank;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		} 
		
		
	}

	@Override
	public Bank load(String bankId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Bank bank = new Bank();

		
			String sql = "select * from bas_bank where bank_id = ?";
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, bankId);

		
			resultSet = preparedStatement.executeQuery();

			
			if (resultSet.next()) {
				bank.setBankId(resultSet.getString("bank_id"));
				bank.setBankName(resultSet.getString("bank_name"));
				bank.setBankNum(resultSet.getString("bank_num"));
				bank.setCustomerId(resultSet.getString("customer_id"));
				bank.setBankType(resultSet.getString("bank_type") );
				
				
				System.out.println(
				"bank_id:" + resultSet.getString("bank_id") + "," + 
				"bank_num:"+ resultSet.getString("bank_name") + "," + 
				"bank_name:"+ resultSet.getString("bank_num") + "," +
				"customer_id:"+ resultSet.getString("customer_id") + "," + 
				"bank_type:"+ resultSet.getString("bank_type"));
			} else {
				System.out.println("ID不存在");
				throw new RuntimeException("查询失败");
			}

			System.out.println("操作成功");
			return bank;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		} 
	}

	@Override
	public ArrayList<BankQueryView> select(BankConditionView conditionView) {
		ArrayList<BankQueryView> listBankQueryView = new ArrayList<BankQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select bas_bank.*,usr_customer.customer_name from bas_bank");
			sql.append(" JOIN usr_customer");
			sql.append(" on bas_bank.customer_id=usr_customer.customer_id");
			
			
			if(StringUtil.isNotEmpty(conditionView.getBankNum())){
				sql.append(" and bas_bank.bank_num like ?") ;
			}
			
			if(StringUtil.isNotEmpty(conditionView.getCustomerId())){
				sql.append(" and bas_bank.customer_id like ?") ;
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			if(StringUtil.isNotEmpty(conditionView.getBankNum()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getBankNum() + "%");
			
			if(StringUtil.isNotEmpty(conditionView.getCustomerId()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getCustomerId() + "%");

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + conditionView.toString());
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				BankQueryView bank = new BankQueryView();
				
				String bank_id = resultSet.getString("bank_id");
				String bank_name = resultSet.getString("bank_name");
				String bank_num = resultSet.getString("bank_num");
				String customer_id = resultSet.getString("customer_id");
				String bank_type= resultSet.getString("bank_type");
				
				bank.setBankId(bank_id);
				bank.setBankName(bank_name);
				bank.setBankNum(bank_num);
				bank.setCustomerId(customer_id);
				bank.setBankType(bank_type);
				
				System.out.println("bank_id:" + bank_id + "," + "bank_name:"
						+ bank_name+","+"bank_num:"+bank_num+","+"customer_id:"+customer_id+","+"bank_type:"+bank_type);
				
				listBankQueryView.add(bank);

				
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listBankQueryView;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		} 
		
	}



}
