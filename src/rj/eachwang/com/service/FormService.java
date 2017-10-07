package rj.eachwang.com.service;

import java.sql.SQLException;
import java.util.List;

import rj.eachwang.com.bean.Confirm;
import rj.eachwang.com.bean.Ds;
import rj.eachwang.com.bean.Smh;
import rj.eachwang.com.dao.FormDao;

/**
 * 表服务
 * 
 * @author iswgr
 *
 */
public class FormService {

	/**
	 * 获取信息确认表实体类
	 * 
	 * @param uuidCookieStr
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Confirm getConfirm(String uuidCookieStr) throws SQLException {
		return new FormDao().getConfirm(uuidCookieStr);
	}

	/**
	 * 修改数据
	 * 
	 * @param schoolname
	 *            学校名称
	 * @param lead
	 *            领队
	 * @param tea1
	 *            老师1
	 * @param tea2
	 *            老师2
	 * @param tel1
	 *            老师1电话
	 * @param tel2
	 *            老师2电话
	 * @param stu1
	 *            学生1
	 * @param stu2
	 *            学生2
	 * @param stu3
	 *            学生3
	 * @param uuidCookieStr
	 * @return
	 * @throws SQLException
	 */
	public int setConfirmData(String schoolname, String lead, String tea1, String tea2, String tel1, String tel2,
			String stu1, String stu2, String stu3, String uuidCookieStr) throws SQLException {
		return new FormDao().setConfirmData(schoolname, lead, tea1, tea2, tel1, tel2, stu1, stu2, stu3, uuidCookieStr);
	}

	/**
	 * 提交说明会
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
	 * @param bz
	 * @return
	 * @throws SQLException
	 */
	public int postSmh(String uuidCookieStr, String schoolname, String lead, String tel, String stay, String mannum,
			String woman, String djnum, String bjnum, String cometime, String gotime, String bz) throws SQLException {
		// 首先检查是否存在提交记录
		boolean b = getPostSmh(uuidCookieStr);
		if (b) {
			// 已经提交过数据了
			return -1;
		}
		int i = new FormDao().postSmh(uuidCookieStr, schoolname, lead, tel, stay, mannum, woman, djnum, bjnum, cometime,
				gotime, bz);
		return i;
	}

	/**
	 * 查看是否提交过数据
	 * 
	 * @param uuidCookieStr
	 * @return
	 * @throws SQLException
	 */
	public boolean getPostSmh(String uuidCookieStr) throws SQLException {
		int i = new FormDao().getPostSmh(uuidCookieStr);
		if (i > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 是否提交过大赛回执
	 * 
	 * @param uuidCookieStr
	 * @return
	 * @throws SQLException
	 */
	public boolean getPostDs(String uuidCookieStr) throws SQLException {
		int i = new FormDao().getPostDs(uuidCookieStr);
		if (i > 0) {
			return true;
		}
		return false;
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
		// 首先检查是否存在提交记录
		boolean b = getPostDs(uuidCookieStr);
		if (b) {
			// 已经提交过数据了
			return -1;
		}
		int i = new FormDao().postDs(uuidCookieStr, schoolname, lead, zw, tel, addrs, stay, mannum, woman, djnum, bjnum,
				cometime, gotime, car, jz, bz);
		return i;
	}

	/**
	 * 查找说明会提交的数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Smh> querySmh() throws SQLException {
		return new FormDao().querySmh();
	}

	/**
	 * 查找大赛提交的数据
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Ds> queryDs() throws SQLException {
		return new FormDao().queryDs();
	}

	/**
	 * 
	 * 查看确认信息
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Confirm> queryQr() throws SQLException {
		return new FormDao().queryQr();
	}

}
