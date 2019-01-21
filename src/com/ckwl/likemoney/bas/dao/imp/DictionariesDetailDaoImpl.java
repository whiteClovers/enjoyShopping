package com.ckwl.likemoney.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ckwl.likemoney.bas.dao.IDictionariesDetailDao;
import com.ckwl.likemoney.bas.entity.DictionariesDetail;
import com.ckwl.likemoney.bas.view.DictionariesDetailConditionView;
import com.ckwl.likemoney.bas.view.DictionariesDetailQueryView;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;

public class DictionariesDetailDaoImpl extends BaseDao implements IDictionariesDetailDao {

	@Override
	public ArrayList<DictionariesDetail> list() {
		ArrayList<DictionariesDetail> arrayList = new ArrayList<DictionariesDetail>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			// 数据字典的id，英文，对应的中文解释
			String sql = "select * from bas_datadictonary_detail";
			prepareStatement = super.prepareStatement(sql);// 继承BaseDao,创建并添加prepareStatement
			System.out.println(">>>sql:" + sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);// 添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while (result.next()) {
				DictionariesDetail dictionariesDetail = new DictionariesDetail();
				dictionariesDetail.setDetailId(result.getString("dataDictonary_detail_id"));
				dictionariesDetail.setDictonaryId(result.getString("dataDictonary_id"));// 外键
				dictionariesDetail.setCode(result.getString("dataDictonary_detail_code"));
				dictionariesDetail.setLabel(result.getString("dataDictonary_detail_label"));
				dictionariesDetail.setNum(result.getString("dataDictonary_detail_number"));
				dictionariesDetail.setDictCode(result.getString("dataDictonary_code"));

				System.out.println("detailId:" + result.getString("dataDictonary_detail_id"));
				System.out.println("字典Id(外键):" + result.getString("dataDictonary_id"));
				System.out.println("code:" + result.getString("dataDictonary_detail_code"));
				System.out.println("label:" + result.getString("dataDictonary_detail_label"));
				System.out.println("num:" + result.getString("dataDictonary_detail_number"));
				System.out.println("dictCode:" + result.getString("dataDictonary_code"));
				arrayList.add(dictionariesDetail);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典明细查询失败", e);
		}
	}

	@Override
	public void insert(DictionariesDetail dictionariesDetail) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "insert into bas_datadictonary_detail(dataDictonary_detail_id,dataDictonary_id,dataDictonary_detail_code,dataDictonary_detail_label,dataDictonary_detail_number,dataDictonary_code) values(?,?,?,?,?,?)";
			prepareStatement = super.prepareStatement(sql);// 继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, dictionariesDetail.getDetailId());
			prepareStatement.setString(parameter++, dictionariesDetail.getDictonaryId());// 外键
			// prepareStatement.setString(parameter++, "1");
			prepareStatement.setString(parameter++, dictionariesDetail.getCode());
			prepareStatement.setString(parameter++, dictionariesDetail.getLabel());
			prepareStatement.setString(parameter++, dictionariesDetail.getNum());
			prepareStatement.setString(parameter++, dictionariesDetail.getDictCode());
			System.out.println(">>>sql:" + sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:" + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典明细插入失败", e);
		}
	}

	@Override
	public void update(DictionariesDetail dictionariesDetail) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "update bas_datadictonary_detail set dataDictonary_id=?,dataDictonary_detail_code=?,dataDictonary_detail_label=?,dataDictonary_detail_number=?,dataDictonary_code=? where dataDictonary_detail_id=?";
			prepareStatement = super.prepareStatement(sql);// 继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, dictionariesDetail.getDictonaryId());// 把表的外键恒设置为“1”,方便测试
			// prepareStatement.setString(parameter++, "1");
			prepareStatement.setString(parameter++, dictionariesDetail.getCode());
			prepareStatement.setString(parameter++, dictionariesDetail.getLabel());
			prepareStatement.setString(parameter++, dictionariesDetail.getNum());
			prepareStatement.setString(parameter++, dictionariesDetail.getDictCode());
			prepareStatement.setString(parameter++, dictionariesDetail.getDetailId());
			System.out.println(">>>sql:" + sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:" + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典明细插入失败", e);
		}
	}

	@Override
	public void delete(String detailId) {
		PreparedStatement prepareStatement = null;
		try {
			String sql = "delete from bas_datadictonary_detail where dataDictonary_detail_id = ?";
			prepareStatement = super.prepareStatement(sql);// 继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, detailId);
			System.out.println(">>>sql:" + sql);
			int rowCount = prepareStatement.executeUpdate();
			System.out.println("影响行数:" + rowCount);
			if (rowCount == 0) {
				throw new RuntimeException("数据字典明细id不存在");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典明细删除失败", e);
		}
	}

	@Override
	public DictionariesDetail load(String detailId) {
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			// 数据字典的id，英文，对应的中文解释
			String sql = "select * from bas_datadictonary_detail where dataDictonary_detail_id = ?";
			prepareStatement = super.prepareStatement(sql);// 继承BaseDao,创建并添加prepareStatement
			int parameter = 1;
			prepareStatement.setString(parameter++, detailId);
			System.out.println(">>>sql:" + sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);// 添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			DictionariesDetail dictionariesDetail = new DictionariesDetail();
			while (result.next()) {
				dictionariesDetail.setDetailId(result.getString("dataDictonary_detail_id"));
				dictionariesDetail.setDictonaryId(result.getString("dataDictonary_id"));// 外键
				dictionariesDetail.setCode(result.getString("dataDictonary_detail_code"));
				dictionariesDetail.setLabel(result.getString("dataDictonary_detail_label"));
				dictionariesDetail.setNum(result.getString("dataDictonary_detail_number"));
				dictionariesDetail.setDictCode(result.getString("dataDictonary_code"));

				System.out.println("detailId:" + result.getString("dataDictonary_detail_id"));
				System.out.println("字典Id(外键):" + result.getString("dataDictonary_id"));
				System.out.println("code:" + result.getString("dataDictonary_detail_code"));
				System.out.println("label:" + result.getString("dataDictonary_detail_label"));
				System.out.println("num:" + result.getString("dataDictonary_detail_number"));
				System.out.println("dictCode:" + result.getString("dataDictonary_code"));
			}
			System.out.println(">>>输出结果end.");
			return dictionariesDetail;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典明细查询失败", e);
		}
	}

	@Override
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView) {
		ArrayList<DictionariesDetailQueryView> arrayList = new ArrayList<DictionariesDetailQueryView>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			// 数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select bas_datadictonary_detail.* , bas_datadictonary.dataDictonary_label from bas_datadictonary_detail");
			sql.append(" JOIN bas_datadictonary");
			sql.append(" ON bas_datadictonary_detail.dataDictonary_id = bas_datadictonary.dataDictonary_id");

			if (!StringUtil.isEmpty(conditionView.getCode())) {
				sql.append(" and bas_datadictonary_detail.dataDictonary_detail_code like ?");
			}
			if (!StringUtil.isEmpty(conditionView.getLabel())) {
				sql.append(" and bas_datadictonary_detail.dataDictonary_detail_label like ?");
			}
			prepareStatement = super.prepareStatement(sql.toString());// 继承BaseDao,创建并添加prepareStatement

			int parameterIndex = 1;
			if (!StringUtil.isEmpty(conditionView.getCode())) {
				prepareStatement.setString(parameterIndex++, "%" + conditionView.getCode() + "%");
			}
			if (!StringUtil.isEmpty(conditionView.getLabel())) {
				prepareStatement.setString(parameterIndex++, "%" + conditionView.getLabel() + "%");
			}
			System.out.println(">>>sql:" + sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);// 添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while (result.next()) {
				DictionariesDetailQueryView dictionariesQueryView = new DictionariesDetailQueryView();
				dictionariesQueryView.setDetailId(result.getString("dataDictonary_detail_id"));
				dictionariesQueryView.setDictonaryId(result.getString("dataDictonary_id"));// 外键
				dictionariesQueryView.setCode(result.getString("dataDictonary_detail_code"));
				dictionariesQueryView.setLabel(result.getString("dataDictonary_detail_label"));
				dictionariesQueryView.setNum(result.getString("dataDictonary_detail_number"));
				dictionariesQueryView.setDictCode(result.getString("dataDictonary_code"));

				dictionariesQueryView.setDictLabel(result.getString("bas_datadictonary.dataDictonary_label"));

				System.out.println("detailId:" + result.getString("dataDictonary_detail_id"));
				System.out.println("detailCode:" + result.getString("dataDictonary_code"));

				System.out.println("字典Id(外键):" + result.getString("dataDictonary_id"));
				System.out.println("code:" + result.getString("dataDictonary_detail_code"));
				System.out.println("label:" + result.getString("dataDictonary_detail_label"));
				System.out.println("num:" + result.getString("dataDictonary_detail_number"));
				System.out.println("label(外键):" + result.getString("bas_datadictonary.dataDictonary_label"));
				arrayList.add(dictionariesQueryView);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败", e);
		}
	}

	@Override
	public List<DictionariesDetailQueryView> findByDictCode(String dictCode) {
		List<DictionariesDetailQueryView> arrayList = new ArrayList<DictionariesDetailQueryView>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			// 数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from bas_datadictonary_detail where bas_datadictonary_detail.dataDictonary_code = ?");
			prepareStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			prepareStatement.setString(parameterIndex++, dictCode);
			System.out.println(">>>sql:" + sql);
			result = prepareStatement.executeQuery();
			System.out.println(">>>输出结果start:");
			while (result.next()) {
				DictionariesDetailQueryView dictionariesQueryView = new DictionariesDetailQueryView();
				dictionariesQueryView.setDetailId(result.getString("dataDictonary_detail_id"));
				dictionariesQueryView.setDictonaryId(result.getString("dataDictonary_id"));// 外键
				dictionariesQueryView.setCode(result.getString("dataDictonary_detail_code"));
				dictionariesQueryView.setDictCode(result.getString("dataDictonary_code"));
				dictionariesQueryView.setLabel(result.getString("dataDictonary_detail_label"));
				dictionariesQueryView.setNum(result.getString("dataDictonary_detail_number"));

				System.out.println("detailId:" + result.getString("dataDictonary_detail_id"));
				System.out.println("detailCode:" + result.getString("dataDictonary_code"));
				System.out.println("字典Id(外键):" + result.getString("dataDictonary_id"));
				System.out.println("code:" + result.getString("dataDictonary_detail_code"));
				System.out.println("label:" + result.getString("dataDictonary_detail_label"));
				System.out.println("num:" + result.getString("dataDictonary_detail_number"));
				arrayList.add(dictionariesQueryView);

			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败", e);
		}
	}

	@Override
	public ArrayList<DictionariesDetailQueryView> list(DictionariesDetailConditionView conditionView, int pageIndex,
			int pageSize) {

		ArrayList<DictionariesDetailQueryView> arrayList = new ArrayList<DictionariesDetailQueryView>();
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			// 数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select bas_datadictonary_detail.* , bas_datadictonary.dataDictonary_label from bas_datadictonary_detail");
			sql.append(" JOIN bas_datadictonary");
			sql.append(" ON bas_datadictonary_detail.dataDictonary_id = bas_datadictonary.dataDictonary_id where 1 = 1 ");

			if (!StringUtil.isEmpty(conditionView.getCode())) {
				sql.append(" and bas_datadictonary_detail.dataDictonary_detail_code like ?");
			}
			if (!StringUtil.isEmpty(conditionView.getLabel())) {
				sql.append(" and bas_datadictonary_detail.dataDictonary_detail_label like ?");
			}
			
			sql.append(" limit ").append(pageIndex * pageSize).append(",").append(pageSize);
			
			prepareStatement = super.prepareStatement(sql.toString());// 继承BaseDao,创建并添加prepareStatement

			int parameterIndex = 1;
			if (!StringUtil.isEmpty(conditionView.getCode())) {
				prepareStatement.setString(parameterIndex++, "%" + conditionView.getCode() + "%");
			}
			if (!StringUtil.isEmpty(conditionView.getLabel())) {
				prepareStatement.setString(parameterIndex++, "%" + conditionView.getLabel() + "%");
			}
			System.out.println(">>>sql:" + sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);// 添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			while (result.next()) {
				DictionariesDetailQueryView dictionariesQueryView = new DictionariesDetailQueryView();
				dictionariesQueryView.setDetailId(result.getString("dataDictonary_detail_id"));
				dictionariesQueryView.setDictonaryId(result.getString("dataDictonary_id"));// 外键
				dictionariesQueryView.setCode(result.getString("dataDictonary_detail_code"));
				dictionariesQueryView.setLabel(result.getString("dataDictonary_detail_label"));
				dictionariesQueryView.setNum(result.getString("dataDictonary_detail_number"));
				dictionariesQueryView.setDictCode(result.getString("dataDictonary_code"));

				dictionariesQueryView.setDictLabel(result.getString("bas_datadictonary.dataDictonary_label"));

				System.out.println("detailId:" + result.getString("dataDictonary_detail_id"));
				System.out.println("detailCode:" + result.getString("dataDictonary_code"));

				System.out.println("字典Id(外键):" + result.getString("dataDictonary_id"));
				System.out.println("code:" + result.getString("dataDictonary_detail_code"));
				System.out.println("label:" + result.getString("dataDictonary_detail_label"));
				System.out.println("num:" + result.getString("dataDictonary_detail_number"));
				System.out.println("label(外键):" + result.getString("bas_datadictonary.dataDictonary_label"));
				arrayList.add(dictionariesQueryView);
			}
			System.out.println(">>>输出结果end.");
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败", e);
		}
	
	}

	@Override
	public int recordCount(DictionariesDetailConditionView conditionView) {
		PreparedStatement prepareStatement = null;
		ResultSet result = null;
		try {
			// 数据字典的id，英文，对应的中文解释
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(*) from bas_datadictonary_detail where 1 = 1 ");
			

			if (!StringUtil.isEmpty(conditionView.getCode())) {
				sql.append(" and bas_datadictonary_detail.dataDictonary_detail_code like ?");
			}
			if (!StringUtil.isEmpty(conditionView.getLabel())) {
				sql.append(" and bas_datadictonary_detail.dataDictonary_detail_label like ?");
			}
			prepareStatement = super.prepareStatement(sql.toString());// 继承BaseDao,创建并添加prepareStatement

			int parameterIndex = 1;
			if (!StringUtil.isEmpty(conditionView.getCode())) {
				prepareStatement.setString(parameterIndex++, "%" + conditionView.getCode() + "%");
			}
			if (!StringUtil.isEmpty(conditionView.getLabel())) {
				prepareStatement.setString(parameterIndex++, "%" + conditionView.getLabel() + "%");
			}
			System.out.println(">>>sql:" + sql);
			result = prepareStatement.executeQuery();
			DbUtil.getSetresultSet().add(result);// 添加到resultSet集合中
			System.out.println(">>>输出结果start:");
			
			if (result.next()) {
				int recordCount = result.getInt(1);
				return recordCount;
			}else{
				throw new RuntimeException("查询记录数失败") ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据字典查询失败", e);
		}
	}
}
