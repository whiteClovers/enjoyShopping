package com.ckwl.likemoney.frame.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao {
	protected Connection getConnection() {
		return DbUtil.getConnection();
	}

	protected void close() {
		DbUtil.close();
	}
	protected void closeAll() {
		DbUtil.closeAll();
	}
	protected PreparedStatement prepareStatement(String sql) throws SQLException{
		return DbUtil.prepareStatement(sql);
		
	}
	protected void closeResultSet(ResultSet resultSet) {
		DbUtil.closeResultSet(resultSet);
	}
	protected void closePreparedStatement(PreparedStatement preparedStatement) {
		DbUtil.closePreparedStatement(preparedStatement);
	}
	protected void beginTransaction() {
		DbUtil.beginTransaction();
	}
	protected void rollback() {
		DbUtil.rollback();
	}
	protected void commit() {
		DbUtil.commit();
	}
}
