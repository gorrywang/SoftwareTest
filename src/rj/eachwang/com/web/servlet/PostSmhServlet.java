package rj.eachwang.com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.eachwang.com.service.FormService;

/**
 * 说明会信息提交
 */
public class PostSmhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取cookie
		String uuidCookieStr = null;
		try {
			uuidCookieStr = getCookie(request, "uuid");
		} catch (Exception e) {

		}
		if (uuidCookieStr == null || uuidCookieStr.equals("")) {
			request.setAttribute("msg", "请您登录, 错误代码:10022");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}

		// 获取数据
		String schoolname = request.getParameter("schoolname");
		String lead = request.getParameter("lead");
		String tel = request.getParameter("tea1");
		String stay = request.getParameter("stay");
		String mannum = request.getParameter("mannum");
		String woman = request.getParameter("woman");
		String djnum = null;
		String bjnum = null;
		if (stay.equals("1")) {
			djnum = request.getParameter("djnum");
			bjnum = request.getParameter("bjnum");
		}
		String cometime = request.getParameter("cometime");
		String gotime = request.getParameter("gotime");
		String bz = request.getParameter("bz");
		int i = 0;
		try {
			i = new FormService().postSmh(uuidCookieStr, schoolname, lead, tel, stay, mannum, woman, djnum, bjnum,
					cometime, gotime, bz);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "服务器异常, 错误代码:10023");
			request.setAttribute("result", 5);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if (i > 0) {
			System.out.println("提交成功");
			request.setAttribute("msg", "您已提交成功");
			request.setAttribute("result", 3);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else if (i == -1) {
			System.out.println("数据已提交过");
			request.setAttribute("msg", "您已提交过说明会回执, 无法再次提交, 错误代码:10024");
			request.setAttribute("result", 3);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
	}

	/**
	 * 获取cookie
	 * 
	 * @param request
	 *            请求
	 * 
	 * @param string
	 *            cookie名称
	 * @return
	 */
	private String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
