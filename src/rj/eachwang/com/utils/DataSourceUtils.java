package rj.eachwang.com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库DataSource操作辅助类
 * 
 * @author iswgr
 *
 */
public class DataSourceUtils {
	/**
	 * 配置对象
	 */
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> local = new ThreadLocal<>();

	/**
	 * 返回数据源
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * 从线程里获取链接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = local.get();
		if (connection == null) {
			connection = ds.getConnection();
			local.set(connection);
		}
		return connection;
	}

	/**
	 * 释放资源
	 * 
	 * @param connection
	 *            链接
	 * @param statement
	 *            语句执行者
	 * @param set
	 *            结果集
	 */
	public static void closeResult(Connection connection, PreparedStatement statement, ResultSet set) {
		closeResultSet(set);
		closeStatement(statement);
		closeConnection(connection);
	}

	/**
	 * 释放链接
	 * 
	 * @param connection
	 *            链接
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}

	/**
	 * 释放语句执行者
	 * 
	 * @param statement
	 *            语句执行者
	 */
	public static void closeStatement(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			statement = null;
		}
	}

	/**
	 * 释放结果集
	 * 
	 * @param set
	 *            结果集
	 */
	public static void closeResultSet(ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			set = null;
		}
	}

	/**
	 * 开启事务
	 * 
	 * @throws SQLException
	 */
	public static void startTranscation() throws SQLException {
		getConnection().setAutoCommit(false);
	}

	/**
	 * 提交事务并且释放资源
	 * 
	 * @throws SQLException
	 */
	public static void commitAndClose() throws SQLException {
		Connection connection = getConnection();
		// 提交事务
		connection.commit();
		// 释放链接
		closeConnection(connection);
		// 解除绑定
		local.remove();
		// 提示
		System.out.println("提交事务并且释放资源");
	}

	/**
	 * 回滚事务并且释放资源
	 * 
	 * @throws SQLException
	 */
	public static void rollbackAndClose() throws SQLException {
		Connection connection = getConnection();
		// 提交事务
		connection.rollback();
		// 释放链接
		closeConnection(connection);
		// 解除绑定
		local.remove();
		// 提示
		System.out.println("回滚事务并且释放资源");
	}
}
