package rj.eachwang.com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rj.eachwang.com.bean.Notice;
import rj.eachwang.com.service.NoticeService;

/**
 * 获取通知
 */
public class WebNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取文章
		List<Notice> list = null;
		try {
			list = new NoticeService().getNoticeAll();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("服务器繁忙");
			request.setAttribute("msg", "服务器繁忙, 错误代码:10003");
			request.setAttribute("result", 2);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/notice.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
