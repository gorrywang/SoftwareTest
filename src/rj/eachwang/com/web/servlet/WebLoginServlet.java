package rj.eachwang.com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.eachwang.com.bean.User;
import rj.eachwang.com.service.UserService;
import rj.eachwang.com.utils.MD5Utils;

/**
 * 网页登录
 */
public class WebLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ((password == null) || (username == null) || username == "" || password == "") {
			// *****缺少参数，请重新登录
			System.out.println("请填写完整登录信息");
			request.setAttribute("msg", "请填写完整登录信息");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 数据库查询
		User user = null;
		try {
			user = new UserService().webLogin(username, MD5Utils.MD5(password));
		} catch (SQLException e) {
			e.printStackTrace();
			// 出错误,稍后再试
			System.out.println("数据库出现错误, 请稍后再试");
			request.setAttribute("msg", "数据库出现错误, 请稍后再试");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		if (user == null) {
			// 没有此用户
			System.out.println("请检查用户名或密码是否正确");
			request.setAttribute("msg", "请检查用户名或密码是否正确");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		Cookie cookie = new Cookie("username", user.getUsername());
		cookie.setPath(request.getContextPath() + "/");
		response.addCookie(cookie);
		cookie = null;
		cookie = new Cookie("uuid", user.getUuid());
		cookie.setPath(request.getContextPath() + "/");
		response.addCookie(cookie);
		// 登录成功,判断管理员还是普通用户
		if ("admin".equals(user.getUsername())) {
			// 管理登录
			System.out.println("管理员登录成功");
			request.setAttribute("msg", "管理员登录成功");
			request.setAttribute("result", 2);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 普通用户登录
		System.out.println("普通用户登录成功");
		request.setAttribute("msg", user.getSchoolname() + ", 欢迎登录");
		request.setAttribute("result", 3);
		request.getRequestDispatcher("/msg.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
