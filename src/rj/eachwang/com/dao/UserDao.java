package rj.eachwang.com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import rj.eachwang.com.bean.User;
import rj.eachwang.com.utils.DataSourceUtils;

/**
 * 用户数据库操作
 * 
 * @author iswgr
 *
 */
public class UserDao {

	/**
	 * 网页用户数据库登录操作
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户实体类
	 * @throws SQLException
	 */
	public User webLogin(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		return runner.query(sql, new BeanHandler<>(User.class), username, password);
	}

	/**
	 * 根据name属性和uuid获取用户
	 * 
	 * @param nameCookieStr
	 *            名字
	 * @param uuidCookieStr
	 *            唯一识别码
	 * @return
	 * @throws SQLException
	 */
	public User getUserByUuidAndName(String nameCookieStr, String uuidCookieStr) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and uuid = ?";
		return runner.query(sql, new BeanHandler<>(User.class), nameCookieStr, uuidCookieStr);
	}

}
