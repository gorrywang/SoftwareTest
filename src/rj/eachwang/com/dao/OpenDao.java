package rj.eachwang.com.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import rj.eachwang.com.utils.DataSourceUtils;

/**
 * 配置数据库
 * 
 * @author iswgr
 *
 */
public class OpenDao {

	/**
	 * 设置开关
	 * 
	 * @param qrb
	 *            确认表
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int setQrb(int qrb) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update def set open = ? where id = 1";
		return runner.update(sql, qrb);
	}

	/**
	 * 设置开关
	 * 
	 * @param smh
	 *            说明会
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int setSmh(int smh) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update def set open = ? where id = 2";
		return runner.update(sql, smh);
	}

	/**
	 * 设置开关
	 * 
	 * @param ds
	 *            大赛
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int setDs(int ds) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update def set open = ? where id = 3";
		return runner.update(sql, ds);
	}

	/**
	 * 获取确认信息开关
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getConfirm() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select open from def where id = 1";
		Map<String, Object> query = runner.query(sql, new MapHandler());
		int object = (int) query.get("open");
		return object;
	}

	/**
	 * 说明会开关
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getShm() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select open from def where id = 2";
		Map<String, Object> query = runner.query(sql, new MapHandler());
		int object = (int) query.get("open");
		return object;
	}

	/**
	 * 大赛回执开关
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getDs() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select open from def where id = 3";
		Map<String, Object> query = runner.query(sql, new MapHandler());
		int object = (int) query.get("open");
		return object;
	}

}
