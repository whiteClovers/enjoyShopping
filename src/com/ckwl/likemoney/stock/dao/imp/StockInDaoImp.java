package com.ckwl.likemoney.stock.dao.imp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.stock.dao.IStockInDao;
import com.ckwl.likemoney.stock.entity.StockIn;
import com.ckwl.likemoney.stock.view.StockInConditionView;
import com.ckwl.likemoney.stock.view.StockInQueryView;

public class StockInDaoImp extends BaseDao implements IStockInDao {

	@Override
	public void insert(StockIn stockIn) {// 增
		try {
			PreparedStatement preparedStatement = null;
			String sql = "insert into sto_stockin(stockIn_id,stockIn_code,stockIn_time,stockIn_pay,employee_id)values(?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			int parameterIndex = 1;
			preparedStatement.setObject(parameterIndex++, uuid);
			preparedStatement.setObject(parameterIndex++, stockIn.getStockInCode());
			preparedStatement.setObject(parameterIndex++, stockIn.getStockInTime());
			preparedStatement.setObject(parameterIndex++, stockIn.getStockInPay());
			preparedStatement.setObject(parameterIndex++,stockIn.getEmployeeId());//外键，暂时都是1
//			preparedStatement.setObject(5, "1");
			int count = preparedStatement.executeUpdate();
			System.out.println("insert sql param:" + stockIn.toString());
			System.out.println("影响行数：" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String stockInId) {// 删
		try {
			PreparedStatement preparedStatement = null;
			String sql = "delete from sto_stockin where stockIn_id = ?";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + stockInId);
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, stockInId);
			int count = preparedStatement.executeUpdate();
			System.out.println("影响行数：" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(StockIn stockIn) {// 該
		try {
			PreparedStatement preparedStatement = null;
			String sql = "update sto_stockin set stockIn_code=?,stockIn_time=?,stockIn_pay=?,employee_id=? where stockIn_id=?";
			System.out.println("insert sql:" + sql);
			preparedStatement = super.prepareStatement(sql);
			int parameterIndex = 1;
			preparedStatement.setObject(parameterIndex++, stockIn.getStockInCode());
			preparedStatement.setObject(parameterIndex++, stockIn.getStockInTime());
			preparedStatement.setObject(parameterIndex++, stockIn.getStockInPay());
			 preparedStatement.setObject(parameterIndex++, stockIn.getEmployeeId());//外键
//			preparedStatement.setObject(4, "1");
			preparedStatement.setObject(parameterIndex++, stockIn.getStockInId());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();
			System.out.println("影响行数：" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public StockIn load(String stockInId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from sto_stockin where stockIn_id =?";
			preparedStatement = super.prepareStatement(sql);
			int parameterIndex = 1;
			preparedStatement.setString(parameterIndex, stockInId);
			System.out.println("select sql:" + sql);
			resultSet = preparedStatement.executeQuery();// 結果集
			StockIn stockIn = new StockIn();
			while (resultSet.next()) {
				stockInId = resultSet.getString("stockIn_id");
				String stockInCode = resultSet.getString("stockIn_code");
				String stockInTime = resultSet.getString("stockIn_time");
				BigDecimal stockInPay = resultSet.getBigDecimal("stockIn_pay");
				String employeeId = resultSet.getString("employee_id");
				stockIn.setStockInId(stockInId);
				stockIn.setStockInCode(stockInCode);
				stockIn.setStockInTime(stockInTime);
				stockIn.setStockInPay(stockInPay);
				stockIn.setEmployeeId(employeeId);
				System.out.println("stockInId" + stockInId + "stockInCode" + stockInCode + "stockInTime" + stockInTime
						+ "stockInPay" + stockInPay + "employeeId" + employeeId);
			}
			return stockIn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询个人失败", e);
		}
	}

	@Override
	public ArrayList<StockIn> list() {
		ArrayList<StockIn> listStockIn = new ArrayList<StockIn>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from sto_stockin";
			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();// 結果集
			while (resultSet.next()) {
				StockIn stockIn = new StockIn();
				String stockInId = resultSet.getString("stockIn_id");
				String stockInCode = resultSet.getString("stockIn_code");
				String stockInTime = resultSet.getString("stockIn_time");
				BigDecimal stockInPay = resultSet.getBigDecimal("stockIn_pay");
				String employeeId = resultSet.getString("employee_id");
				stockIn.setStockInId(stockInId);
				stockIn.setStockInCode(stockInCode);
				stockIn.setStockInTime(stockInTime);
				stockIn.setStockInPay(stockInPay);
				stockIn.setEmployeeId(employeeId);
				System.out.println("stockInId" + stockInId + "stockInCode" + stockInCode + "stockInTime" + stockInTime
						+ "stockInPay" + stockInPay + "employeeId" + employeeId);
				listStockIn.add(stockIn);
			}
			return listStockIn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败", e);
		}
	}

	@Override
	public ArrayList<StockInQueryView> list(StockInConditionView stockInConditionView) {
		ArrayList<StockInQueryView> arrayList = new ArrayList<StockInQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT sto_stockin.*,sys_employee.employee_name FROM sto_stockin");
			sql.append(" JOIN sys_employee");
			sql.append(" ON sto_stockin.employee_id = sys_employee.employee_id");
			if(!StringUtil.isEmpty(stockInConditionView.getStockInCode())){
				sql.append(" and sto_stockin.stockIn_code like ?");
			}
			if(!StringUtil.isEmpty(stockInConditionView.getStockInPay())){
				sql.append(" and sto_stockin.stockIn_pay >= ?");
			}
			if(!StringUtil.isEmpty(stockInConditionView.getStartTime())){
				sql.append(" and sto_stockin.stockIn_time >= ?");
			}
			if(!StringUtil.isEmpty(stockInConditionView.getEndTime())){
				sql.append(" and sto_stockin.stockIn_time <= ?");
			}
			if(!StringUtil.isEmpty(stockInConditionView.getEmployeeName())){
				sql.append(" and sys_employee.employee_name like ?");
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			if(!StringUtil.isEmpty(stockInConditionView.getStockInCode())){
				preparedStatement.setString(parameterIndex++, "%"+stockInConditionView.getStockInCode()+"%");
			}
			if(!StringUtil.isEmpty(stockInConditionView.getStockInPay())){
				BigDecimal bigDecimal = StringUtil.stringToBigdecimal(stockInConditionView.getStockInPay());
				preparedStatement.setObject(parameterIndex++, bigDecimal);
			}
			if(!StringUtil.isEmpty(stockInConditionView.getStartTime())){
				try {
					Date date = StringUtil.stringToDate(stockInConditionView.getStartTime());
					preparedStatement.setObject(parameterIndex++, date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(!StringUtil.isEmpty(stockInConditionView.getEndTime())){
				try {
					Date date = StringUtil.stringToDate(stockInConditionView.getEndTime());
					preparedStatement.setObject(parameterIndex++, date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(!StringUtil.isEmpty(stockInConditionView.getEmployeeName())){
				preparedStatement.setString(parameterIndex++,"%"+ stockInConditionView.getEmployeeName()+"%");
			}
			System.out.println("select sql:" + sql);
			resultSet = preparedStatement.executeQuery();// 結果集
			System.out.println("输出结果start:");
			while (resultSet.next()) {
				StockInQueryView stockInQueryView = new StockInQueryView();
				String stockInId = resultSet.getString("sto_stockin.stockIn_id");
				String stockInCode = resultSet.getString("sto_stockin.stockIn_code");
				String stockInTime = resultSet.getString("sto_stockin.stockIn_time");
				BigDecimal stockInPay = resultSet.getBigDecimal("sto_stockin.stockIn_pay");
				String employeeId = resultSet.getString("sto_stockin.employee_id");
				String employeeName = resultSet.getString("sys_employee.employee_name");
				stockInQueryView.setStockInId(stockInId);
				stockInQueryView.setStockInCode(stockInCode);
				stockInQueryView.setStockInTime(stockInTime);
				stockInQueryView.setStockInPay(stockInPay);
				stockInQueryView.setEmployeeId(employeeId);
				stockInQueryView.setEmployeeName(employeeName);
				arrayList.add(stockInQueryView);
				System.out.println(stockInQueryView.toString());
			}
			System.out.println("输出结果end.");
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败", e);
		}
	}

}
