package rj.eachwang.com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.eachwang.com.bean.Notice;
import rj.eachwang.com.service.NoticeService;

/**
 * 显示文章内容
 */
public class ShowNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取id
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		// 数据库获取文章
		Notice notice = null;
		try {
			notice = new NoticeService().getNotice(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("notice", notice);
		// 请求转发
		request.getRequestDispatcher("/shownotice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
