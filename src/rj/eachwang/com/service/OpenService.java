package rj.eachwang.com.service;

import java.sql.SQLException;

import com.sun.org.apache.regexp.internal.recompile;

import rj.eachwang.com.bean.User;
import rj.eachwang.com.dao.OpenDao;
import rj.eachwang.com.dao.UserDao;

/**
 * 设置开关服务
 * 
 * @author iswgr
 *
 */
public class OpenService {

	/**
	 * 设置开关
	 * 
	 * @param nameCookieStr
	 *            nameCookie
	 * @param uuidCookieStr
	 *            uuidCookie
	 * @param qrb
	 *            确认表开关
	 * @param smh
	 *            说明会开关
	 * @param ds
	 *            大赛开关
	 * @return
	 * @throws SQLException
	 */
	public int setOpen(String nameCookieStr, String uuidCookieStr, int qrb, int smh, int ds) throws SQLException {
		OpenDao openDao = new OpenDao();
		User user = new UserDao().getUserByUuidAndName(nameCookieStr, uuidCookieStr);
		if (user == null) {
			// 用户不存在
			return -1;
		} else if (!("admin".equals(user.getUsername()))) {
			// 非管理员登录
			return -2;
		}
		// 设置确认表
		openDao.setQrb(qrb);
		// 设置说明会
		openDao.setSmh(smh);
		// 设置大赛
		openDao.setDs(ds);

		return 1;
	}

	/**
	 * 获取确认表开关
	 * 
	 * @return int
	 * @throws SQLException
	 */
	public int getConfirm() throws SQLException {
		return new OpenDao().getConfirm();
	}

	/**
	 * 说明会开关
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getShm() throws SQLException {
		return new OpenDao().getShm();
	}

	/**
	 * 大赛回执开关
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getDs() throws SQLException {
		return new OpenDao().getDs();
	}

}
