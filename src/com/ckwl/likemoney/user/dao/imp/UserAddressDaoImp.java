package com.ckwl.likemoney.user.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.user.dao.IUserAddressDao;
import com.ckwl.likemoney.user.entity.UserAddress;
import com.ckwl.likemoney.user.view.ReceivingAddressQueryView;
import com.ckwl.likemoney.user.view.UserAddressConditionView;
import com.ckwl.likemoney.user.view.UserAddressQueryView;

public class UserAddressDaoImp extends BaseDao implements IUserAddressDao {

	@Override
	public void insert(UserAddress userAddress) {
		PreparedStatement preparedStatement = null;

		try {
			

			// S3.获取statement(执行语句的对象)
			String sql = "insert into usr_address( address_id ,address_name ,address_phone,address_consignee,address_email,"
					+ "address_code,customer_id,address_region,address_default) values(?,?,?,?,?,?,?,?,?)";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			// String studentName = "aa2" ;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, userAddress.getAddressName());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressPhone());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressConsignee());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressEmail());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressCode());
			preparedStatement.setObject(paramIndex++, userAddress.getCustomerId());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressRegion());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressDefault());
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + userAddress.toString());

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
	public void delete(String addressId) {
		PreparedStatement preparedStatement = null;
	      try {
				
				// S3.获取statement(执行语句的对象)
				String sql = "delete from usr_address where address_id = ?";
				preparedStatement = super.prepareStatement(sql);

				int paramIndex = 1;
				preparedStatement.setObject(paramIndex++, addressId);
				System.out.println("sql:"+sql);
				System.out.println("参数：bankId:"+addressId);

				// s4-1.执行sql
				int rowCount = preparedStatement.executeUpdate();
				System.out.println("影响行数:" + rowCount);
				if(rowCount == 0){
					throw new RuntimeException("卡号不存在:" + addressId);
				}
				

				System.out.println("操作成功");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("操作失败");
				throw new RuntimeException("删除失败" ,e) ;
			} 

	}

	@Override
	public void update(UserAddress userAddress) {
		PreparedStatement preparedStatement = null;
		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			String sql = "update usr_address set address_id=? ,address_name=?,address_phone=?,address_consignee=?,address_email=?,"
					+ "address_code=？,customer_id=？,address_region=？,address_default=？";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, userAddress.getAddressId());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressName());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressPhone());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressConsignee());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressEmail());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressCode());
			preparedStatement.setObject(paramIndex++, userAddress.getCustomerId());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressRegion());
			preparedStatement.setObject(paramIndex++, userAddress.getAddressDefault());

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
	public ArrayList<UserAddress> select() {
		ArrayList<UserAddress> listBank = new ArrayList<UserAddress>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			
			String sql = "select * from usr_address";
			preparedStatement = super.prepareStatement(sql);
			

			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + "");
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				UserAddress userAddress = new UserAddress();
				
				String address_id = resultSet.getString("address_id");
				String address_name = resultSet.getString("address_name");
				String address_phone = resultSet.getString("address_phone");
				String address_consignee = resultSet.getString("address_consignee");
				String address_email= resultSet.getString("address_email");
				String address_code= resultSet.getString("address_code");
				String customer_id= resultSet.getString("customer_id");
				String address_region= resultSet.getString("address_region");
				String address_default= resultSet.getString("address_default");
				
				userAddress.setAddressId(address_id);
				userAddress.setAddressName(address_name);
				userAddress.setAddressPhone(address_phone);
				userAddress.setAddressConsignee(address_consignee);
				userAddress.setAddressEmail(address_email);
				userAddress.setAddressCode(address_code);
				userAddress.setCustomerId(customer_id);
				userAddress.setAddressRegion(address_region);
				userAddress.setAddressDefault(address_default);
				
				System.out.println(userAddress.toString());
				
				listBank.add(userAddress);

				
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
	public UserAddress load(String addressId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			UserAddress userAddress = new UserAddress();

		
			String sql = "select * from usr_address where address_id = ?";
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, addressId);

		
			resultSet = preparedStatement.executeQuery();

			
			if (resultSet.next()) {

				userAddress.setAddressId(resultSet.getString("address_id"));
				userAddress.setAddressName(resultSet.getString("address_name"));
				userAddress.setAddressPhone(resultSet.getString("address_phone"));
				userAddress.setAddressConsignee(resultSet.getString("address_consignee"));
				userAddress.setAddressEmail(resultSet.getString("address_email"));
				userAddress.setAddressCode(resultSet.getString("address_code"));
				userAddress.setCustomerId(resultSet.getString("customer_id"));
				userAddress.setAddressRegion(resultSet.getString("address_region"));
				userAddress.setAddressDefault(resultSet.getString("address_default"));
				
			
				
				System.out.println(
				"address_id:" + resultSet.getString("address_id") + "," + 
				"address_name:"+ resultSet.getString("address_name") + "," + 
				"address_phone:"+ resultSet.getString("address_phone") + "," +
				"address_consignee:"+ resultSet.getString("address_consignee") + "," + 
				"address_email:"+ resultSet.getString("address_email")+ "," +
                "address_code:"+ resultSet.getString("address_code")+ "," + 
                "customer_id:"+ resultSet.getString("customer_id")+ "," +
                "address_region:"+ resultSet.getString("address_region")+ "," +
                "address_default:"+ resultSet.getString("address_default"));
			} else {
				System.out.println("ID不存在");
				throw new RuntimeException("查询失败");
			}

			System.out.println("操作成功");
			return userAddress;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		} 
	}

	@Override
	public ArrayList<UserAddressQueryView> select(UserAddressConditionView conditionView) {
		ArrayList<UserAddressQueryView> listAddressQueryView = new ArrayList<UserAddressQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select usr_address.*,usr_address.address_id from usr_address");
			sql.append(" JOIN usr_customer");
			sql.append(" on usr_address.customer_id = usr_customer.customer_id");
			
			if(StringUtil.isNotEmpty(conditionView.getAddressConsignee())){
				sql.append(" and usr_address.address_consignee like ?") ;
			}
			
			if(StringUtil.isNotEmpty(conditionView.getAddressName())){
				sql.append(" and usr_address.address_name like ?") ;
			}
			if(StringUtil.isNotEmpty(conditionView.getCustomerId())){
				sql.append(" and usr_address.customer_id = ?") ;
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			
			if(StringUtil.isNotEmpty(conditionView.getAddressConsignee()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getAddressConsignee() + "%");
			if(StringUtil.isNotEmpty(conditionView.getAddressName()))
				preparedStatement.setObject(parameterIndex++ ,  "%"+conditionView.getAddressName() + "%");
			if(StringUtil.isNotEmpty(conditionView.getCustomerId()))
				preparedStatement.setObject(parameterIndex++ , conditionView.getCustomerId());
			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + "");
			
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			
			
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				UserAddressQueryView userAddress = new UserAddressQueryView();
				
				String address_id = resultSet.getString("address_id");
				String address_name = resultSet.getString("address_name");
				String address_phone = resultSet.getString("address_phone");
				String address_consignee = resultSet.getString("address_consignee");
				String address_email= resultSet.getString("address_email");
				String address_code= resultSet.getString("address_code");
				String customer_id= resultSet.getString("customer_id");
				String address_region= resultSet.getString("address_region");
				String address_default= resultSet.getString("address_default");
				
				userAddress.setAddressId(address_id);
				userAddress.setAddressName(address_name);
				userAddress.setAddressPhone(address_phone);
				userAddress.setAddressConsignee(address_consignee);
				userAddress.setAddressEmail(address_email);
				userAddress.setAddressCode(address_code);
				userAddress.setCustomerId(customer_id);
				userAddress.setAddressRegion(address_region);
				userAddress.setAddressDefault(address_default);
				
				System.out.println(userAddress.toString());
				
				listAddressQueryView.add(userAddress);

				
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listAddressQueryView;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("查询失败", e);
		} 
	}
	@Override
	public ArrayList<ReceivingAddressQueryView> listView(String userCustomerId) {
		//创建页面需要的List集合
		ArrayList<ReceivingAddressQueryView> listView = new ArrayList<ReceivingAddressQueryView>();
		//通过传入的Id得到相应的用户集合(同一个AttentionId会有多个userCustomerId)
		UserAddressConditionView attention = new UserAddressConditionView();
		attention.setCustomerId(userCustomerId);
		ArrayList<UserAddressQueryView> arrayList = this.select(attention);
		ReceivingAddressQueryView receivingAddressQueryView = new ReceivingAddressQueryView();
		receivingAddressQueryView.setUserCustomers(arrayList);
		listView.add(receivingAddressQueryView);
		return listView;
	}
}


