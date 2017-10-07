package rj.eachwang.com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import rj.eachwang.com.bean.Confirm;
import rj.eachwang.com.bean.Ds;
import rj.eachwang.com.bean.Smh;
import rj.eachwang.com.utils.DataSourceUtils;

/**
 * 表 数据操作
 * 
 * @author iswgr
 *
 */
public class FormDao {

	/**
	 * 获取信息确认表数据
	 * 
	 * @param uuidCookieStr
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Confirm getConfirm(String uuidCookieStr) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from confirm where uuid = ?";
		return runner.query(sql, new BeanHandler<>(Confirm.class), uuidCookieStr);
	}

	/**
	 * 提交数据
	 * 
	 * @param schoolname
	 * @param lead
	 * @param tea1
	 * @param tea2
	 * @param tel1
	 * @param tel2
	 * @param stu1
	 * @param stu2
	 * @param stu3
	 * @param uuidCookieStr
	 * @return
	 * @throws SQLException
	 */
	public int setConfirmData(String schoolname, String lead, String tea1, String tea2, String tel1, String tel2,
			String stu1, String stu2, String stu3, String uuidCookieStr) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update confirm set schoolname = ? , lead = ? ,  teacher1 = ? , teacher2 = ? ,tel1 = ? , tel2 = ? , stu1 = ? , stu2 = ? , stu3 = ? , ok = 1";
		return runner.update(sql, schoolname, lead, tea1, tea2, tel1, tel2, stu1, stu2, stu3);
	}

	/**
	 * 获取是否提交过说明会数据了
	 * 
	 * @param uuidCookieStr
	 * @return
	 * @throws SQLException
	 */
	public int getPostSmh(String uuidCookieStr) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from briefing where uuid = ?";
		Map<String, Object> query = runner.query(sql, new MapHandler(), uuidCookieStr);
		if (query == null) {
			return 0;
		}
		return 1;
	}

	/**
	 * 说明会提交数据
	 * 
	 * @param uuidCookieStr
	 * @param schoolname
	 * @param lead
	 * @param tel
	 * @param stay
	 * @param mannum
	 * @param woman
	 * @param djnum
	 * @param bjnum
	 * @param cometime
	 * @param gotime
	 * @return
	 */
	/**
	 * CREATE TABLE briefing( id INT PRIMARY KEY AUTO_INCREMENT, UUID VARCHAR(36),
	 * schoolname VARCHAR(36), NAME VARCHAR(10), tel VARCHAR(25), stay INT, malenum
	 * INT, femalenum INT, djnum INT, bjnum INT, cometime DATE, gotime DATE, timp
	 * TEXT );
	 * 
	 * @throws SQLException
	 */
	public int postSmh(String uuidCookieStr, String schoolname, String lead, String tel, String stay, String mannum,
			String woman, String djnum, String bjnum, String cometime, String gotime, String bz) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into briefing values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		return runner.update(sql, uuidCookieStr, schoolname, lead, tel, stay, mannum, woman, djnum, bjnum, cometime,
				gotime, bz);
	}

	/**
	 * 是否提交过大赛回执
	 * 
	 * @param uuidCookieStr
	 * @return
	 * @throws SQLException
	 */
	public int getPostDs(String uuidCookieStr) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from com where uuid = ?";
		Map<String, Object> query = runner.query(sql, new MapHandler(), uuidCookieStr);
		if (query == null) {
			return 0;
		}
		return 1;
	}

	/**
	 * 提交大赛回执
	 * 
	 * @param uuidCookieStr
	 * @param schoolname
	 * @param lead
	 * @param zw
	 * @param tel
	 * @param addrs
	 * @param stay
	 * @param mannum
	 * @param woman
	 * @param djnum
	 * @param bjnum
	 * @param cometime
	 * @param gotime
	 * @param car
	 * @param jz
	 * @param bz
	 * @return
	 * @throws SQLException
	 */
	public int postDs(String uuidCookieStr, String schoolname, String lead, String zw, String tel, String addrs,
			String stay, String mannum, String woman, String djnum, String bjnum, String cometime, String gotime,
			String car, String jz, String bz) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into com values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return runner.update(sql, uuidCookieStr, schoolname, lead, zw, tel, addrs, stay, mannum, woman, djnum, bjnum,
				cometime, car, gotime, jz, bz);
	}

	/**
	 * 获取已提交的说明会
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Smh> querySmh() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from briefing";
		return runner.query(sql, new BeanListHandler<>(Smh.class));
	}

	/**
	 * 获取已提交的大赛回执
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Ds> queryDs() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from com";
		return runner.query(sql, new BeanListHandler<>(Ds.class));
	}

	/**
	 * 获取已提交的确认信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Confirm> queryQr() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from confirm";
		return runner.query(sql, new BeanListHandler<>(Confirm.class));
	}

}
