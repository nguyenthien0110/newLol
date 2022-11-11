package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import entity.newsPost;
import entity.typeNews;

/**
 * Servlet implementation class categoryControl
 */
@WebServlet("/categoryControl")
public class categoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public categoryControl() {
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
		String typeString = request.getParameter("type");
		String index = request.getParameter("index");
		int total;
		if (index == null) {
			total = 1;
		} else {
			total = Integer.parseInt(index);
		}

		dao Dao = new dao();
		List<newsPost> listCategory = Dao.getListCategory(typeString);
		List<newsPost> listTrendding = Dao.trenddinList();
		int totalCount = Dao.totalPageCategory(typeString);
		List<newsPost> listPagingCate = Dao.pagingListCate(typeString, total);
		typeNews type = Dao.getOneTypeNews(typeString);
		if (totalCount == 0) {
			totalCount++;
		}
		int up = total;
		int down = total;
		if (total == totalCount) {
			up = 1;
		} else {
			up = total + 1;
		}

		if (total == 1) {
			down = totalCount;
		} else {
			down = total - 1;
		}
		request.setAttribute("up", up);
		request.setAttribute("down", down);
		request.setAttribute("total", total);

		request.setAttribute("nameCategory", typeString);
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listTrendding", listTrendding);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("listPagingCate", listPagingCate);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
