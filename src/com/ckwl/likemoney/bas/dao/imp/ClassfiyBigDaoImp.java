package com.ckwl.likemoney.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.bas.dao.IClassfiySmallDao;
import com.ckwl.likemoney.bas.dao.IclassfiyBigDao;
import com.ckwl.likemoney.bas.entity.ClassfiyBig;
import com.ckwl.likemoney.bas.view.ClassfiyBigConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallConditionView;
import com.ckwl.likemoney.bas.view.ClassfiySmallQueryView;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.front.view.ClassfiyBigView;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ClassfiyBigDaoImp extends BaseDao implements IclassfiyBigDao {
	
	@Override
	public ArrayList<ClassfiyBigView> listView() {
		IClassfiySmallDao classfiySmallDao = new ClassfiySmallDaoImp();
		
		ArrayList<ClassfiyBigView> listBig = new ArrayList<ClassfiyBigView>();
		ArrayList<ClassfiyBig> Big = this.list(new ClassfiyBigConditionView());
		
		for (ClassfiyBig classfiyBig : Big) {
			ClassfiyBigView bigView = new ClassfiyBigView();
			
			bigView.setClassfiyBigId(classfiyBig.getClassfiyBigId());
			bigView.setClassfiyBigName(classfiyBig.getClassfiyBigName());
			
			ClassfiySmallConditionView classfiySmallConditionView = new ClassfiySmallConditionView();
			classfiySmallConditionView.setClassfiyBigId(classfiyBig.getClassfiyBigId());
			ArrayList<ClassfiySmallQueryView> listQuery = classfiySmallDao.list(classfiySmallConditionView);
			
			bigView.setListSmall(listQuery);
			listBig.add(bigView);
		}
		
		return listBig;
	}
	
	@Override
	public ArrayList<ClassfiyBig> list(ClassfiyBigConditionView classfiyBigConditionView) {
		ArrayList<ClassfiyBig> listClassfiyBigs = new ArrayList<ClassfiyBig>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder();

			sql.append("select bas_classfiy_big.* from bas_classfiy_big where 1=1");
			if (!StringUtil.isEmpty(classfiyBigConditionView.getClassfiyBigName())) {
				sql.append(" and bas_classfiy_big.classfiy_big_name like ?");
			}
			
			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql.toString());
			
			int parameterIndex = 1;
			if (!StringUtil.isEmpty(classfiyBigConditionView.getClassfiyBigName())) {
				preparedStatement.setObject(parameterIndex++,
						"%" + classfiyBigConditionView.getClassfiyBigName() + "%");
			}
			resultSet = preparedStatement.executeQuery();
			DbUtil.getSetresultSet().add(resultSet);

			while (resultSet.next()) {
				ClassfiyBig classfiyBig = new ClassfiyBig();
				String classfiyBigId = resultSet.getString("classfiy_big_id");
				String classfiyBigName = resultSet.getString("classfiy_big_name");

				classfiyBig.setClassfiyBigId(classfiyBigId);
				classfiyBig.setClassfiyBigName(classfiyBigName);
				System.out.println(classfiyBig.toString());

				listClassfiyBigs.add(classfiyBig);
			}
			return listClassfiyBigs;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("员工信息查询失败", ex);
		}
	}

	@Override
	public void insert(ClassfiyBig classfiyBig) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into bas_classfiy_big (classfiy_big_id,classfiy_big_name) values(?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + classfiyBig.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			classfiyBig.setClassfiyBigId(uuid);
			int paramIndex = 1;
			preparedStatement.setObject(paramIndex++, uuid);
			preparedStatement.setObject(paramIndex++, classfiyBig.getClassfiyBigName());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + uuid + "," + classfiyBig.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("新增保存成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("新增保存失败");
		}

	}

	@Override
	public void delete(String classfiyBigId) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from bas_classfiy_big where classfiy_big_id=?";
			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;
			String uuid = classfiyBigId;
			preparedStatement.setObject(paramIndex++, uuid);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:删除id:" + classfiyBigId);

			// s4-1.执行sql
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("学生不存在!ID:" + classfiyBigId);
			}
			System.out.println("***影响行数:" + rowCount);

			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败");
		}

	}

	@Override
	public void update(ClassfiyBig classfiyBig) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update bas_classfiy_big set classfiy_big_name=? where classfiy_big_id=?";
			System.out.println("update sql:" + sql);

			preparedStatement = super.prepareStatement(sql);

			int paramIndex = 1;

			preparedStatement.setObject(paramIndex++, classfiyBig.getClassfiyBigName());
			preparedStatement.setObject(paramIndex++, classfiyBig.getClassfiyBigId());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("params:" + classfiyBig.toString());
			System.out.println("影响行数" + rowCount);

			System.out.println("更新成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("更新失败");
		}

	}

	@Override
	public ClassfiyBig load(String classfiyBigId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClassfiyBig classfiyBig = new ClassfiyBig();
		try {

			// S3.获取statement(执行语句的对象)
			String sql = "select * from bas_classfiy_big where classfiy_big_id = ?";
			preparedStatement = super.prepareStatement(sql);

			preparedStatement.setObject(1, classfiyBigId);

			System.out.println("***SQL:" + sql);
			System.out.println("***param:id=" + classfiyBigId);

			// s4-1.执行sql
			resultSet = preparedStatement.executeQuery();
			// super.addResultSet(resultSet);// 待封装

			// s4-1.遍历resultSet

			System.out.println("***SQL查询结果begin");
			if (resultSet.next()) {

				classfiyBig.setClassfiyBigId(resultSet.getString("classfiy_big_id"));
				classfiyBig.setClassfiyBigName(resultSet.getString("classfiy_big_name"));

				System.out.println(classfiyBig.toString());
			} else {
				System.out.println("ID不存在");
			}
			System.out.println("***SQL查询结果end");
			System.out.println("操作成功");
			return classfiyBig;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作失败");
			throw new RuntimeException("查询失败", e);
		}
	}

	

}
