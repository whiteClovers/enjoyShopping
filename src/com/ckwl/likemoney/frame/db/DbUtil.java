package com.ckwl.likemoney.frame.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import com.ckwl.likemoney.frame.exception.DbException;

/**
 * 多线程连接优化
 *
 */
public class DbUtil {
	private static Properties prop = new Properties();
	private static ThreadLocal<Connection> threadLocalConnection = new ThreadLocal<Connection>();
	private static Set<PreparedStatement> setpreparedStatement = new LinkedHashSet<PreparedStatement>();
	private static Set<ResultSet> setresultSet = new LinkedHashSet<ResultSet>();
	static {
		try {
			InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("jdbc.properties");
			if (resourceAsStream != null)
				prop.load(resourceAsStream);
			else
				prop.load(DbUtil.class.getResourceAsStream("/jdbc.properties"));

			String driver = prop.getProperty("driver");
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("在classpath下没有找到jdbc.properties文件，系统退出");
			System.exit(0);
		}
	}

	private DbUtil() {
	}

	public static synchronized Connection getConnection() {
		Connection conn = threadLocalConnection.get();
		if (conn == null) {
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");

			try {
				conn = DriverManager.getConnection(url, user, password);
				threadLocalConnection.set(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}

	public synchronized static void close() {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.close();
				System.out.println("关闭数据库连接:"+connection);

				threadLocalConnection.remove();
				System.out.println("清除当前线程副本");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized static void closeAll() {
		for (ResultSet resultSet : setresultSet) {
			closeResultSet(resultSet);
			System.out.println("关闭res:"+resultSet);
		}
		setresultSet.clear();
		for (PreparedStatement preparedStatement : setpreparedStatement) {
			closePreparedStatement(preparedStatement);
			System.out.println("关闭pre:"+preparedStatement);
		}
		setpreparedStatement.clear();
	
		close();
	}

	public static Set<PreparedStatement> getSetpreparedStatement() {
		return setpreparedStatement;
	}

	public static void setSetpreparedStatement(Set<PreparedStatement> setpreparedStatement) {
		DbUtil.setpreparedStatement = setpreparedStatement;
	}

	public static Set<ResultSet> getSetresultSet() {
		return setresultSet;
	}

	public static void setSetresultSet(Set<ResultSet> setresultSet) {
		DbUtil.setresultSet = setresultSet;
	}

	public static synchronized void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static synchronized void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static synchronized PreparedStatement prepareStatement(String sql) throws SQLException {
		PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
		setpreparedStatement.add(preparedStatement);
		return preparedStatement;
	}

	public static synchronized void beginTransaction() throws DbException {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException("开户事务时出现异常", e);
			}
		}
	}

	public static synchronized void rollback() throws DbException {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				throw new DbException("回滚事务时出现异常", e);
			}
		}
	}

	public static synchronized void commit() throws DbException {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.commit(); // 提交事务
				System.out.println("提交事务");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DbException("提交事务时出现异常", e);
			}
		}
	}

}
