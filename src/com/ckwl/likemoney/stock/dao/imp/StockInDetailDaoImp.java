package com.ckwl.likemoney.stock.dao.imp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.stock.dao.IStockInDetailDao;
import com.ckwl.likemoney.stock.entity.StockInDetail;
import com.ckwl.likemoney.stock.view.StockInDetailConditionView;
import com.ckwl.likemoney.stock.view.StockInDetailQueryView;

public class StockInDetailDaoImp extends BaseDao implements IStockInDetailDao{

	@Override
	public void insert(StockInDetail stockInDetail) {
		try {
			PreparedStatement preparedStatement = null;
			String sql = "insert into sto_stockin_detail(stockIn_detail_id,product_sku_id,stockIn_detail_amount,stockIn_detail_price,stockIn_id) values(?,?,?,?,?)";
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			int parameterIndex = 1;
			preparedStatement.setObject(parameterIndex++, uuid);
			preparedStatement.setObject(parameterIndex++, stockInDetail.getProduct_sku_id());
			preparedStatement.setObject(parameterIndex++, stockInDetail.getStockIn_detail_amount());
			preparedStatement.setObject(parameterIndex++, stockInDetail.getStockIn_detail_price());
			preparedStatement.setObject(parameterIndex++, stockInDetail.getStockIn_id());
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + stockInDetail.toString());
			super.prepareStatement(sql);
			int count = preparedStatement.executeUpdate();
			System.out.println("影响行数：" + count);
		} catch (SQLException e) {
			System.out.println("SIDDaoInse:"+"插入失败");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String stockIn_detail_id) {
		try {
			PreparedStatement preparedStatement=null;
			String sql = "delete from sto_stockin_detail where stockIn_detail_id = ?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + stockIn_detail_id);
			preparedStatement = super.prepareStatement(sql);
			int parameterIndex = 1;
			preparedStatement.setObject(parameterIndex++,stockIn_detail_id);
			int  count = preparedStatement.executeUpdate();
			System.out.println("影响行数：" + count);
		} catch (SQLException e) {
			System.out.println("删除失败");
			e.printStackTrace();
		}
	}

	@Override
	public void update(StockInDetail stockInDetail) {
		try {
			PreparedStatement preparedStatement=null;
			String sql = "update sto_stockin_detail set product_sku_id=?,stockIn_detail_amount=?,stockIn_detail_price=?,stockIn_id=? where stockIn_detail_id=?";
			System.out.println("insert sql:" + sql);
			preparedStatement = super.prepareStatement(sql);
			int parameterIndex = 1;
			preparedStatement.setObject(parameterIndex++ , stockInDetail.getProduct_sku_id());
			preparedStatement.setObject(parameterIndex++ , stockInDetail.getStockIn_detail_amount());
			preparedStatement.setObject(parameterIndex++ , stockInDetail.getStockIn_detail_price());
			preparedStatement.setObject(parameterIndex++ , stockInDetail.getStockIn_id());
			preparedStatement.setObject(parameterIndex++ , stockInDetail.getStockIn_detail_id());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int  count = preparedStatement.executeUpdate();
			System.out.println("影响行数：" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<StockInDetail> list() {
		ArrayList<StockInDetail> listStockInDetail = new ArrayList<StockInDetail>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from sto_stockin_detail";
			System.out.println("select sql:" + sql);
			preparedStatement = super.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();//結果集
			while(resultSet.next()){
				StockInDetail stockInDetail =new StockInDetail();
				String stockIn_detail_id = resultSet.getString("stockIn_detail_id");
				String product_sku_id =resultSet.getString("product_sku_id");
				String stockIn_detail_amount =resultSet.getString("stockIn_detail_amount");
				BigDecimal stockIn_detail_price =resultSet.getBigDecimal("stockIn_detail_price");
				String stockIn_id =resultSet.getString("stockIn_id");
				stockInDetail.setStockIn_detail_id(stockIn_detail_id);
				stockInDetail.setProduct_sku_id(product_sku_id);
				stockInDetail.setStockIn_detail_amount(stockIn_detail_amount);
				stockInDetail.setStockIn_detail_price(stockIn_detail_price);
				stockInDetail.setStockIn_id(stockIn_id);
				
				listStockInDetail.add(stockInDetail);
			}
			return listStockInDetail;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有失败", e);
		}
	}

	@Override
	public StockInDetail load(String stockIn_detail_id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from sto_stockin_detail where stockIn_detail_id = ?";
			preparedStatement = super.prepareStatement(sql);
			int parameterIndex = 1;
			preparedStatement.setString(parameterIndex++ , stockIn_detail_id);
			System.out.println("select sql:" + sql);
			resultSet = preparedStatement.executeQuery();//結果集
			StockInDetail stockInDetail =new StockInDetail();
			while(resultSet.next()){
				stockIn_detail_id = resultSet.getString("stockIn_detail_id");
				String product_sku_id =resultSet.getString("product_sku_id");
				String stockIn_detail_amount =resultSet.getString("stockIn_detail_amount");
				BigDecimal stockIn_detail_price =resultSet.getBigDecimal("stockIn_detail_price");
				String stockIn_id =resultSet.getString("stockIn_id");
				
				stockInDetail.setStockIn_detail_id(stockIn_detail_id);
				stockInDetail.setProduct_sku_id(product_sku_id);
				stockInDetail.setStockIn_detail_amount(stockIn_detail_amount);
				stockInDetail.setStockIn_detail_price(stockIn_detail_price);
				stockInDetail.setStockIn_id(stockIn_id);
				
			}
			System.out.println("param:"+stockInDetail.toString());
			return stockInDetail;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询个人失败", e);
		}
	}

	@Override
	public ArrayList<StockInDetailQueryView> list(StockInDetailConditionView stockInDetailConditionView) {
		ArrayList<StockInDetailQueryView> listStockInDetail = new ArrayList<StockInDetailQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select sto_stockin_detail.*,sto_stockin.stockIn_code,pro_product_sku.product_sku_code from sto_stockin_detail");
			sql.append(" JOIN sto_stockin");
			sql.append(" ON sto_stockin_detail.stockIn_id = sto_stockin.stockIn_id");
			sql.append(" JOIN pro_product_sku");
			sql.append(" ON sto_stockin_detail.product_sku_id = pro_product_sku.product_sku_id");
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getProductSkuCode())){
				sql.append(" AND pro_product_sku.product_sku_code like ?");
			}
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getMinPrice())){
				sql.append(" AND sto_stockin_detail.stockIn_detail_price >= ?");
			}
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getMaxPrice())){
				sql.append(" AND sto_stockin_detail.stockIn_detail_price <= ?");
			}
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getStockInCode())){
				sql.append(" AND sto_stockin.stockIn_code like ?");
			}
			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getProductSkuCode())){
				preparedStatement.setString(parameterIndex++,"%"+ stockInDetailConditionView.getProductSkuCode()+"%");
			}
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getMinPrice())){
				preparedStatement.setString(parameterIndex++, stockInDetailConditionView.getMinPrice());
			}
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getMaxPrice())){
				preparedStatement.setString(parameterIndex++, stockInDetailConditionView.getMaxPrice());
			}
			if(StringUtil.isNotEmpty(stockInDetailConditionView.getStockInCode())){
				preparedStatement.setString(parameterIndex++,"%"+ stockInDetailConditionView.getStockInCode()+"%");
			}
			resultSet = preparedStatement.executeQuery();//結果集
			System.out.println("select sql:" + sql);
			while(resultSet.next()){
				StockInDetailQueryView stockInDetailQueryView =new StockInDetailQueryView();
				String stockIn_detail_id = resultSet.getString("sto_stockin_detail.stockIn_detail_id");
				String product_sku_id =resultSet.getString("sto_stockin_detail.product_sku_id");
				String stockIn_detail_amount =resultSet.getString("sto_stockin_detail.stockIn_detail_amount");
				BigDecimal stockIn_detail_price =resultSet.getBigDecimal("sto_stockin_detail.stockIn_detail_price");
				String stockIn_id =resultSet.getString("sto_stockin_detail.stockIn_id");
				String stockIn_stockIn_code = resultSet.getString("sto_stockin.stockIn_code");
				String product_sku_product_sku_code = resultSet.getString("pro_product_sku.product_sku_code");
				stockInDetailQueryView.setStockIn_detail_id(stockIn_detail_id);
				stockInDetailQueryView.setProduct_sku_id(product_sku_id);
				stockInDetailQueryView.setStockIn_detail_amount(stockIn_detail_amount);
				stockInDetailQueryView.setStockIn_detail_price(stockIn_detail_price);
				stockInDetailQueryView.setStockIn_id(stockIn_id);
				stockInDetailQueryView.setProductSkuCode(product_sku_product_sku_code);
				stockInDetailQueryView.setStockInCode(stockIn_stockIn_code);
				
				System.out.println("param:"+stockInDetailQueryView.toString());
				listStockInDetail.add(stockInDetailQueryView);
			}
			return listStockInDetail;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有失败", e);
		}
	}

}
