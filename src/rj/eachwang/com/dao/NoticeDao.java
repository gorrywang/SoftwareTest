package rj.eachwang.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import rj.eachwang.com.bean.Notice;
import rj.eachwang.com.utils.DataSourceUtils;

/**
 * 数据库操作：文章
 * 
 * @author iswgr
 *
 */
public class NoticeDao {

	/**
	 * 获取文章
	 * 
	 * @return 文章bean列表
	 * @throws SQLException
	 */
	public List<Notice> getNoticeAll() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from notice order by createtime desc";
		return runner.query(sql, new BeanListHandler<>(Notice.class));
	}

	/**
	 * 写入文章
	 * 
	 * @param title
	 *            文章标题
	 * @param content
	 *            文章内容
	 * @return
	 * @throws SQLException
	 */
	public int nextNotice(String title, String content) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into notice values(null,?,?,null,null)";
		return runner.update(sql, title, content);
	}

	/**
	 * 根据id获取文章
	 * 
	 * @param id
	 *            通知识别码
	 * @return
	 * @throws SQLException
	 */
	public Notice getNotiec(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from notice where id = ?";
		return runner.query(sql, new BeanHandler<>(Notice.class), id);
	}

}
