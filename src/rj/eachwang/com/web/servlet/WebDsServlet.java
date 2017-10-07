package rj.eachwang.com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.eachwang.com.service.FormService;
import rj.eachwang.com.service.OpenService;

/**
 * 大赛说明会
 */
public class WebDsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取配置信息
		int i = 0;
		try {
			i = new OpenService().getDs();
		} catch (SQLException e) {
			e.printStackTrace();
			// 错误
			request.setAttribute("msg", "系统繁忙, 错误代码:10030");
			request.setAttribute("result", 3);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if (i == 0) {
			// 关闭中
			request.setAttribute("msg", "该服务暂未开启, 请等待开启, 错误代码:10031");
			request.setAttribute("result", 3);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 获取cookie
		String uuidCookieStr = null;
		try {
			uuidCookieStr = getCookie(request, "uuid");
		} catch (Exception e) {

		}
		if (uuidCookieStr == null || uuidCookieStr.equals("")) {
			request.setAttribute("msg", "请您登录, 错误代码:10032");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}

		// 判断是否提交过
		boolean postDs = false;
		try {
			postDs = new FormService().getPostDs(uuidCookieStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (postDs) {
			request.setAttribute("msg", "您已提交过大赛回执, 无法再次提交, 错误代码:10033");
			request.setAttribute("result", 3);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/ds.jsp").forward(request, response);
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
