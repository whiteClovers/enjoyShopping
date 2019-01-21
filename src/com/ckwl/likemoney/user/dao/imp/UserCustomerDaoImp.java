package com.ckwl.likemoney.user.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.user.dao.IUserCustomerDao;
import com.ckwl.likemoney.user.entity.UserCustomer;
import com.ckwl.likemoney.user.service.IUserCustomerService;
import com.ckwl.likemoney.user.view.UserCustomerConditionView;

public class UserCustomerDaoImp extends BaseDao implements IUserCustomerDao {

	@Override
	public void insert(UserCustomer userCustomer) {
		PreparedStatement preparedStatement = null;

		try {

			// S3.获取statement(执行语句的对象)
			String sql = "insert into usr_customer( customer_id ,customer_edu ,customer_name,customer_pwd,customer_payPwd,customer_phone,"
					+ "customer_email,customer_sex,customer_vip,customer_birthday,customer_hobby,customer_nickName,customer_img,"
					+ "customer_balance,customer_income,customer_idCard,customer_marital_status,customer_available_status)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			String uuid = UUID.randomUUID().toString().replaceAll("-", "");

			// String studentName = "aa2" ;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerEd());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerName());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerPwd());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerPayPwd());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerPhone());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerEmail());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerSex());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerVip());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerBirthday());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerHobby());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerNickName());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerImg());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerBalance());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerIncome());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerIdCard());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerMaritalStatus());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerAvailableStatus());

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + userCustomer.toString());

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
	public void delete(String customerId) {
		PreparedStatement preparedStatement = null;
		try {

			// S3.获取statement(执行语句的对象)
			String sql = "delete from usr_customer where customer_id = ?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, customerId);
			System.out.println("sql:" + sql);
			System.out.println("参数：customerId:" + customerId);

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("影响行数:" + rowCount);
			if (rowCount == 0) {
				throw new RuntimeException("卡号不存在:" + customerId);
			}

			System.out.println("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("删除失败", e);
		}

	}

	@Override
	public void update(UserCustomer userCustomer) {
		PreparedStatement preparedStatement = null;

		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			String sql = "update usr_customer set customer_id=？ ,customer_edu=？ ,customer_name=？,customer_pwd=？,customer_paypwd=？,customer_phone=？,"
					+ "customer_email=？,customer_sex=？,customer_vip=？,customer_birthday=？,customer_hobby=？,customer_nickName=？,customer_img=？,"
					+ "customer_balance=？,customer_income=？,customer_idCard=？,customer_marital_status=？,customer_available_status=？";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerId());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerEd());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerName());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerPwd());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerPayPwd());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerPhone());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerEmail());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerSex());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerVip());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerBirthday());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerHobby());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerNickName());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerImg());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerBalance());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerIncome());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerIdCard());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerMaritalStatus());
			preparedStatement.setObject(paramIndex++, userCustomer.getCustomerAvailableStatus());

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
	public ArrayList<UserCustomer> select(UserCustomerConditionView conditionView) {
		ArrayList<UserCustomer> listUserCustomer = new ArrayList<UserCustomer>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select usr_customer.*,bas_datadictonary_detail_customer_edu.dataDictonary_detail_label,bas_datadictonary_detail_customer_sex.dataDictonary_detail_label, ");
			sql.append(
					" bas_datadictonary_detail_customer_marital_status.dataDictonary_detail_label,bas_datadictonary_detail_customer_available_status.dataDictonary_detail_label ");
			sql.append(" from usr_customer ");
			sql.append(" inner join bas_datadictonary_detail as  bas_datadictonary_detail_customer_edu ");
			sql.append(
					" on usr_customer.customer_edu=bas_datadictonary_detail_customer_edu.dataDictonary_detail_code ");
			sql.append(" inner join bas_datadictonary_detail as bas_datadictonary_detail_customer_sex ");
			sql.append(
					" on usr_customer.customer_sex=bas_datadictonary_detail_customer_sex.dataDictonary_detail_code ");
			sql.append(" INNER JOIN bas_datadictonary_detail as bas_datadictonary_detail_customer_marital_status ");
			sql.append(
					" on usr_customer.customer_marital_status=bas_datadictonary_detail_customer_marital_status.dataDictonary_detail_code ");
			sql.append(" INNER JOIN bas_datadictonary_detail as bas_datadictonary_detail_customer_available_status ");
			sql.append(
					" on usr_customer.customer_available_status=bas_datadictonary_detail_customer_available_status.dataDictonary_detail_code ");
			sql.append(" where bas_datadictonary_detail_customer_edu.dataDictonary_code='customer_edu' ");
			sql.append(" and bas_datadictonary_detail_customer_sex.dataDictonary_code='customer_sex' ");
			sql.append(
					" and bas_datadictonary_detail_customer_marital_status.dataDictonary_code='customer_marital_status' ");
			sql.append(
					" and bas_datadictonary_detail_customer_available_status.dataDictonary_code='customer_available_status' ");

			if (StringUtil.isNotEmpty(conditionView.getCustomerId())) {
				sql.append(" and usr_customer.customer_id like ?");
			}
			if (StringUtil.isNotEmpty(conditionView.getCustomerName())) {
				sql.append(" and usr_customer.customer_name like ?");
			}
			if (StringUtil.isNotEmpty(conditionView.getCustomerSex())) {
				sql.append(" and usr_customer.customer_sex like ?");
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			if (StringUtil.isNotEmpty(conditionView.getCustomerId()))
				preparedStatement.setObject(parameterIndex++, "%" + conditionView.getCustomerId() + "%");
			if (StringUtil.isNotEmpty(conditionView.getCustomerName()))
				preparedStatement.setObject(parameterIndex++, "%" + conditionView.getCustomerName() + "%");
			if (StringUtil.isNotEmpty(conditionView.getCustomerSex()))
				preparedStatement.setObject(parameterIndex++, "%" + conditionView.getCustomerSex() + "%");

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + "UserCustomer.toString()");

			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);

			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				UserCustomer userCustomer = new UserCustomer();

				String customer_id = resultSet.getString("customer_id");
				String customer_edu = resultSet.getString("customer_edu");
				String customer_name = resultSet.getString("customer_name");
				String customer_pwd = resultSet.getString("customer_pwd");
				String customer_payPwd = resultSet.getString("customer_payPwd");
				String customer_phone = resultSet.getString("customer_phone");
				String customer_email = resultSet.getString("customer_email");
				String customer_sex = resultSet.getString("customer_sex");
				String customer_vip = resultSet.getString("customer_vip");
				String customer_birthday = resultSet.getString("customer_birthday");
				String customer_hobby = resultSet.getString("customer_hobby");
				String customer_nickName = resultSet.getString("customer_nickName");
				String customer_img = resultSet.getString("customer_img");
				String customer_balance = resultSet.getString("customer_balance");
				String customer_income = resultSet.getString("customer_income");
				String customer_idCard = resultSet.getString("customer_idCard");
				String customer_marital_status = resultSet.getString("customer_marital_status");
				String customer_available_status = resultSet.getString("customer_available_status");

				userCustomer.setCustomerId(customer_id);
				userCustomer.setCustomerEd(customer_edu);
				userCustomer.setCustomerName(customer_name);
				userCustomer.setCustomerPwd(customer_pwd);
				userCustomer.setCustomerPayPwd(customer_payPwd);
				userCustomer.setCustomerPhone(customer_phone);
				userCustomer.setCustomerEmail(customer_email);
				userCustomer.setCustomerSex(customer_sex);
				userCustomer.setCustomerVip(customer_vip);
				userCustomer.setCustomerBirthday(StringUtil.stringToDate(customer_birthday));
				userCustomer.setCustomerHobby(customer_hobby);
				userCustomer.setCustomerNickName(customer_nickName);
				userCustomer.setCustomerImg(customer_img);
				userCustomer.setCustomerBalance(StringUtil.stringToBigdecimal(customer_balance));
				userCustomer.setCustomerIncome(StringUtil.stringToBigdecimal(customer_income));
				userCustomer.setCustomerIdCard(customer_idCard);
				userCustomer.setCustomerMaritalStatus(customer_marital_status);
				userCustomer.setCustomerAvailableStatus(customer_available_status);

				System.out.println(userCustomer.toString());

				listUserCustomer.add(userCustomer);

			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listUserCustomer;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		}
	}

	@Override
	public UserCustomer load(String customerId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			UserCustomer userCustomer = new UserCustomer();

			String sql = "select * from usr_customer where customer_id = ?";
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, customerId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userCustomer.setCustomerId(resultSet.getString("customer_id"));
				userCustomer.setCustomerEd(resultSet.getString("customer_edu"));
				userCustomer.setCustomerName(resultSet.getString("customer_name"));
				userCustomer.setCustomerPwd(resultSet.getString("customer_pwd"));
				userCustomer.setCustomerPayPwd(resultSet.getString("customer_payPwd"));
				userCustomer.setCustomerPhone(resultSet.getString("customer_phone"));
				userCustomer.setCustomerEmail(resultSet.getString("customer_email"));
				userCustomer.setCustomerSex(resultSet.getString("customer_sex"));
				userCustomer.setCustomerVip(resultSet.getString("customer_vip"));
				userCustomer.setCustomerBirthday(StringUtil.stringToDate(resultSet.getString("customer_birthday").substring(0, 19)));
				userCustomer.setCustomerHobby(resultSet.getString("customer_hobby"));
				userCustomer.setCustomerNickName(resultSet.getString("customer_nickName"));
				userCustomer.setCustomerImg(resultSet.getString("customer_img"));
				userCustomer.setCustomerBalance(StringUtil.stringToBigdecimal(resultSet.getString("customer_balance")));
				userCustomer.setCustomerIncome(StringUtil.stringToBigdecimal(resultSet.getString("customer_income")));
				userCustomer.setCustomerIdCard(resultSet.getString("customer_idCard"));
				userCustomer.setCustomerMaritalStatus(resultSet.getString("customer_marital_status"));
				userCustomer.setCustomerAvailableStatus(resultSet.getString("customer_available_status"));

				System.out.println("customer_id:" + resultSet.getString("customer_id") + "," + "customer_edu:"
						+ resultSet.getString("customer_edu") + "," + "customer_name:"
						+ resultSet.getString("customer_name") + "," + "customer_pwd:"
						+ resultSet.getString("customer_pwd") + "," + "customer_payPwd:"
						+ resultSet.getString("customer_payPwd") + "," + "customer_phone:"
						+ resultSet.getString("customer_phone") + "," + "customer_email:"
						+ resultSet.getString("customer_email") + "," + "customer_sex:"
						+ resultSet.getString("customer_sex") + "," + "customer_vip:"
						+ resultSet.getString("customer_vip") + "," + "customer_birthday:"
						+ resultSet.getString("customer_birthday").substring(0, 19) + "," + "customer_hobby:"
						+ resultSet.getString("customer_hobby") + "," + "customer_nickName:"
						+ resultSet.getString("customer_nickName") + "," + "customer_img:"
						+ resultSet.getString("customer_img") + "," + "customer_balance:"
						+ resultSet.getString("customer_balance") + "," + "customer_income:"
						+ resultSet.getString("customer_income") + "," + "customer_idCard:"
						+ resultSet.getString("customer_idCard") + "," + "customer_marital_status:"
						+ resultSet.getString("customer_marital_status") + "," + "customer_available_status:"
						+ resultSet.getString("customer_available_status"));
			} else {
				System.out.println("ID不存在");
				throw new RuntimeException("查询失败");
			}

			System.out.println("操作成功");
			return userCustomer;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		}
	}

	@Override
	public UserCustomer login(String customerPhone, String customerPwd) {
		if (StringUtil.isEmpty(customerPhone) || StringUtil.isEmpty(customerPwd) || customerPhone.trim().length()!=11) {
			return null;
		}
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" select usr_customer.* ");
			sql.append(" from usr_customer  ");
			sql.append(" where usr_customer.customer_phone = ? ");
			
			preparedStatement = super.prepareStatement(sql.toString());
			
			int parameterIndex = 1;
			preparedStatement.setObject(parameterIndex++ , customerPhone);
			
			resultSet = preparedStatement.executeQuery();
			
			UserCustomer customer = new UserCustomer();
			while(resultSet.next()){
				String customerId = resultSet.getString("customer_id");
				String pwd = resultSet.getString("customer_pwd");
				
				String customerNickName = resultSet.getString("customer_nickName");
				
				if (!pwd.equals(customerPwd)) {
					return null;
				}
				customer.setCustomerId(customerId);
				customer.setCustomerPhone(customerPhone);
				customer.setCustomerPwd(customerPwd);
				
				customer.setCustomerNickName(customerNickName);
			}
			
			return customer;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("没有该用户", e);
		}
	}


	@Override
	public boolean register(UserCustomer customer) {
		String customerName = customer.getCustomerName();
		String customerPwd = customer.getCustomerPwd();
		String customerPhone = customer.getCustomerPhone();
		if (StringUtil.isEmpty(customerName)||StringUtil.isEmpty(customerPwd)||customerPhone.trim().length()!=11) {
			return false;
		}
		insert(customer);
		
		return true;
	}

	@Override
	public boolean checkPhone(String customerPhone) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean checkName(String customerName) {
		PreparedStatement preparedStatement = null;

		try {

			// S3.获取statement(执行语句的对象)
			String sql = "SELECT usr_customer.* from usr_customer WHERE usr_customer.customer_name = ? ";
			
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, customerName);
			
			System.out.println("customerName:" + customerName);

			// s4-1.执行sql
			ResultSet resultSet = preparedStatement.executeQuery();
			String id = null;
			if(resultSet.next()){
				System.out.println("查询成功");
				return true ;
			}else {
				System.out.println("查询失败");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出现异常");
			return false;	
		}
		
	}

	@Override
	public boolean checkNickName(String customerNickName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPassword(String customerPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkIdCard(String customerIdCard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEmail(String customerEmail) {
		// TODO Auto-generated method stub
		return false;
	}

}
