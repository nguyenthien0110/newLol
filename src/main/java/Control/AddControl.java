package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import entity.typeNews;

/**
 * Servlet implementation class AddControl
 */
@WebServlet("/AddControl")
public class AddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		dao Dao = new dao();

		List<typeNews> listType = Dao.getAllTypeNews();

		request.setAttribute("listType", listType);
		request.getRequestDispatcher("addNews.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String dayNews = request.getParameter("dayNews");
		String titleName = request.getParameter("titleName");
		String imageLink = request.getParameter("imageLink");
		String content = request.getParameter("content");
		String typeNews = request.getParameter("typeNews");
		String trend = request.getParameter("Trend");

		dao Dao = new dao();
		Dao.insertNews(dayNews, titleName, imageLink, content, typeNews, trend);
		response.sendRedirect("CRUDcontrol?index=1");
	}

}
