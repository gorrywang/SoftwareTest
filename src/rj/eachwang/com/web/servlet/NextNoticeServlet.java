package rj.eachwang.com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.eachwang.com.service.NoticeService;

/**
 * 下通知服务
 */
public class NextNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取cookie, username和uuid
		String nameCookieStr = null;
		String uuidCookieStr = null;
		try {
			nameCookieStr = getCookie(request, "username");
			uuidCookieStr = getCookie(request, "uuid");
		} catch (Exception e) {
			request.setAttribute("msg", "您尚未登录, 请登录");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 获取数据
		// 标题
		String title = request.getParameter("title");
		// 内容
		String content = request.getParameter("content");
		content = content.replace("\n", "<br/>");
		// 保存到数据库
		int i = 0;
		try {
			i = new NoticeService().nextNotice(title, content, nameCookieStr, uuidCookieStr);
		} catch (SQLException e) {
			e.printStackTrace();
			// 出现错误
			request.setAttribute("msg", "服务器出现错误, 请稍后再试");
			request.setAttribute("result", 2);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if (i > 0) {
			// 成功
			request.setAttribute("msg", "文章添加成功");
			request.setAttribute("result", 2);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else if (i == -1) {
			// 用户不存在
			request.setAttribute("msg", "您尚未登录, 请登录");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else if (i == -2) {
			// 非管理员
			request.setAttribute("msg", "您不是管理员, 无法使用");
			request.setAttribute("result", 2);
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
