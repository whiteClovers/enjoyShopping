package com.ckwl.likemoney.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.bas.dao.IClassfiySmallDao;
import com.ckwl.likemoney.bas.entity.ClassfiySmall;
import com.ckwl.likemoney.bas.view.ClassfiySmallConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;

public class ClassfiySmallDaoImp extends BaseDao implements IClassfiySmallDao {

	@Override
	public ArrayList<ClassfiySmall> list() {
		ArrayList<ClassfiySmall> listClassfiySmall = new ArrayList<ClassfiySmall>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from bas_classfiy_small";
			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {
				/*
				 * employee_id employee_name employee_pwd employee_phone
				 * employee_sex employee_status employee_birthday
				 * employee_information
				 */
				ClassfiySmall classfiySmall = new ClassfiySmall();
				String classfiySmallId = resultSet.getString("classfiy_small_id");
				String classfiyBigId = resultSet.getString("classfiy_big_id");
				String classfiySmallName = resultSet.getString("classfiy_small_name");

				classfiySmall.setClassfiySmallId(classfiySmallId);
				classfiySmall.setClassfiyBigId(classfiyBigId);
				classfiySmall.setClassfiySmallName(classfiySmallName);

				System.out.println(classfiySmall.toString());

				listClassfiySmall.add(classfiySmall);
			}
			return listClassfiySmall;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("员工信息查询失败", ex);
		}
	}

	@Override
	public void insert(ClassfiySmall classfiySmall) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into bas_classfiy_small(classfiy_small_id,classfiy_big_id,classfiy_small_name) values(?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + classfiySmall.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			classfiySmall.setClassfiySmallId(uuid);
			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, classfiySmall.getClassfiyBigId());
			preparedStatement.setObject(paramIndex++, classfiySmall.getClassfiySmallName());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + classfiySmall.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("新增保存成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("新增保存失败");
		}

	}

	@Override
	public void delete(String classSmallId) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from bas_classfiy_small where classfiy_small_id=?";

			preparedStatement = super.prepareStatement(sql);
			int paramIndex = 1;
			String uuid = classSmallId;
			preparedStatement.setObject(paramIndex++, uuid);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:删除id:" + classSmallId);

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("小类不存在!ID:" + classSmallId);
			}
			System.out.println("***影响行数:" + rowCount);

			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}
	}

	@Override
	public void update(ClassfiySmall classfiySmall) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update bas_classfiy_small set classfiy_big_id=?,classfiy_small_name=? where classfiy_small_id=?";
			System.out.println("update sql:" + sql);

			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, classfiySmall.getClassfiyBigId());
			preparedStatement.setObject(paramIndex++, classfiySmall.getClassfiySmallName());
			preparedStatement.setObject(paramIndex++, classfiySmall.getClassfiySmallId());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + classfiySmall.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("更新成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("更新失败");
		}

	}

	@Override
	public ClassfiySmall load(String classfiySmallId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			ClassfiySmall classfiySmall = new ClassfiySmall();

			// S3.获取statement(执行语句的对象)
			String sql = "select * from bas_classfiy_small where classfiy_small_id = ?";
			preparedStatement = super.prepareStatement(sql);

			preparedStatement.setObject(1, classfiySmallId);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:id=" + classfiySmallId);

			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
			// super.addResultSet(resultSet);// 待封装

			// s4-1.遍历resultSet

			System.out.println("***SQL查询结果begin");
			if (resultSet.next()) {

				classfiySmall.setClassfiySmallId(resultSet.getString("classfiy_small_id"));
				classfiySmall.setClassfiyBigId(resultSet.getString("classfiy_big_id"));
				classfiySmall.setClassfiySmallName(resultSet.getString("classfiy_small_name"));

				System.out.println(classfiySmall.toString());
			} else {
				System.out.println("ID不存在");
			}
			System.out.println("***SQL查询结果end");
			System.out.println("操作成功");
			return classfiySmall;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		}
	}

	@Override
	public ArrayList<ClassfiySmallQueryView> list(ClassfiySmallConditionView classfiySmallConditionView) {

		ArrayList<ClassfiySmallQueryView> listClassfiySmall = new ArrayList<ClassfiySmallQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 获取Connection

			// S3.获取statement(执行语句的对象)
			StringBuilder sql = new StringBuilder();
			
			sql.append(" select bas_classfiy_small.* , bas_classfiy_big.classfiy_big_name as classfiy_big_name from bas_classfiy_small ");
			sql.append(" JOIN bas_classfiy_big");
			sql.append(" on bas_classfiy_small.classfiy_big_id = bas_classfiy_big.classfiy_big_id");

			if (!StringUtil.isEmpty(classfiySmallConditionView.getClassfiyBigId())) {
				sql.append(" and bas_classfiy_big.classfiy_big_id like ?");
			}
			if (!StringUtil.isEmpty(classfiySmallConditionView.getClassfiyBigName())) {
				sql.append(" and bas_classfiy_big.classfiy_big_name like ?");
			}
			if (!StringUtil.isEmpty(classfiySmallConditionView.getClassfiySmallName())) {
				sql.append(" and bas_classfiy_small.classfiy_small_name like ?");
			}
			System.out.println("bigname"+classfiySmallConditionView.getClassfiyBigName());
			System.out.println("***SQL:" + sql);
			System.out.println("***param:" + classfiySmallConditionView.toString());

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(classfiySmallConditionView.getClassfiyBigId()))
				preparedStatement.setObject(parameterIndex++, "%" +classfiySmallConditionView.getClassfiyBigId()+ "%");
			
			if (!StringUtil.isEmpty(classfiySmallConditionView.getClassfiyBigName()))
				preparedStatement.setObject(parameterIndex++, "%" +classfiySmallConditionView.getClassfiyBigName()+ "%");
			
			if (!StringUtil.isEmpty(classfiySmallConditionView.getClassfiySmallName()))
				preparedStatement.setObject(parameterIndex++, "%" + classfiySmallConditionView.getClassfiySmallName() + "%");

			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);
	
			System.out.println("***SQL查询结果 begin");

			while (resultSet.next()) {
				ClassfiySmallQueryView classfiySmall = new ClassfiySmallQueryView();
				classfiySmall.setClassfiySmallId(resultSet.getString("classfiy_small_id"));
				classfiySmall.setClassfiyBigId(resultSet.getString("classfiy_big_id"));
				classfiySmall.setClassfiySmallName(resultSet.getString("classfiy_small_name"));
				classfiySmall.setClassfiyBigName(resultSet.getString("classfiy_big_name"));

				listClassfiySmall.add(classfiySmall);

				System.out.println(classfiySmall.toString());
			}
			System.out.println("***SQL查询结果 end");
			System.out.println("操作成功");

			return listClassfiySmall;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");

			throw new RuntimeException("学生查询失败", e);
		}

	}

}
