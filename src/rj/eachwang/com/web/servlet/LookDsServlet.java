package rj.eachwang.com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.eachwang.com.bean.Ds;
import rj.eachwang.com.bean.User;
import rj.eachwang.com.service.FormService;
import rj.eachwang.com.service.UserService;

/**
 * 大赛回执查看
 */
public class LookDsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取cookie, username和uuid
		String nameCookieStr = null;
		String uuidCookieStr = null;
		try {
			nameCookieStr = getCookie(request, "username");
			uuidCookieStr = getCookie(request, "uuid");
		} catch (Exception e) {
			request.setAttribute("msg", "您尚未登录, 请登录, 错误代码:10061");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 是否是管理员
		User user = null;
		try {
			user = new UserService().getUserByUuidAndName(nameCookieStr, uuidCookieStr);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "服务器发生错误, 错误代码:10062");
			request.setAttribute("result", 2);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if (nameCookieStr == null || uuidCookieStr == null) {
			request.setAttribute("msg", "您尚未登录, 请登录, 错误代码:10051");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if (user == null || !(user.getUsername().equals("admin"))) {
			// 不是管理员
			request.setAttribute("msg", "抱歉, 您不是管理员, 错误代码:10063");
			request.setAttribute("result", 3);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 获取大赛数据
		List<Ds> list = null;
		try {
			list = new FormService().queryDs();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/lookDs.jsp").forward(request, response);
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
