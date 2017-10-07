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
 * 提交确认信息
 */
public class PostConfirmServlet extends HttpServlet {
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
			request.setAttribute("msg", "请您登录, 错误代码:10013");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 获取数据
		String schoolname = request.getParameter("schoolname");
		String lead = request.getParameter("lead");
		String tea1 = request.getParameter("tea1");
		String tel1 = request.getParameter("tel1");
		String tea2 = request.getParameter("tea2");
		String tel2 = request.getParameter("tel2");
		String stu1 = request.getParameter("stu1");
		String stu2 = request.getParameter("stu2");
		String stu3 = request.getParameter("stu3");

		int i;
		try {
			i = new FormService().setConfirmData(schoolname, lead, tea1, tea2, tel1, tel2, stu1, stu2, stu3,
					uuidCookieStr);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "服务器异常, 请稍后再试, 错误代码:10014");
			request.setAttribute("result", 3);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}

		if (i > 0) {
			request.setAttribute("msg", "修改成功");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "修改失败, 错误代码:10015");
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
