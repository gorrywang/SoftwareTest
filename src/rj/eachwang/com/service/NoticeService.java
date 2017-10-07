package rj.eachwang.com.service;

import java.sql.SQLException;
import java.util.List;

import rj.eachwang.com.bean.Notice;
import rj.eachwang.com.bean.User;
import rj.eachwang.com.dao.NoticeDao;
import rj.eachwang.com.dao.OpenDao;
import rj.eachwang.com.dao.UserDao;

/**
 * 文章服务
 * 
 * @author iswgr
 *
 */
public class NoticeService {

	/**
	 * 获取文章
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Notice> getNoticeAll() throws SQLException {
		return new NoticeDao().getNoticeAll();
	}

	/**
	 * 发布通知
	 * 
	 * @param title
	 *            文章标题
	 * @param content
	 *            文章内容
	 * @param content2
	 * @param title2
	 * @return
	 * @throws SQLException
	 */
	public int nextNotice(String title, String content, String nameCookieStr, String uuidCookieStr)
			throws SQLException {
		User user = new UserDao().getUserByUuidAndName(nameCookieStr, uuidCookieStr);
		if (user == null) {
			// 用户不存在
			return -1;
		} else if (!("admin".equals(user.getUsername()))) {
			// 非管理员登录
			return -2;
		}
		return new NoticeDao().nextNotice(title, content);
	}

	/**
	 * 根据id获取文章
	 * 
	 * @param id
	 *            识别码
	 * @return 文章实体类
	 * @throws SQLException
	 */
	public Notice getNotice(int id) throws SQLException {
		return new NoticeDao().getNotiec(id);
	}

}
