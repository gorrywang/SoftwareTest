package rj.eachwang.com.service;

import java.sql.SQLException;

import rj.eachwang.com.bean.User;
import rj.eachwang.com.dao.UserDao;

/**
 * 用戶服务
 * 
 * @author iswgr
 *
 */
public class UserService {

	/**
	 * 网页登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户实体类
	 * @throws SQLException
	 */
	public User webLogin(String username, String password) throws SQLException {
		return new UserDao().webLogin(username, password);
	}

	/**
	 * 根据uuid获取user
	 * 
	 * @param nameCookieStr
	 * @param uuidCookieStr
	 * @return
	 * @throws SQLException
	 */
	public User getUserByUuidAndName(String nameCookieStr, String uuidCookieStr) throws SQLException {
		return new UserDao().getUserByUuidAndName(nameCookieStr, uuidCookieStr);
	}

}
