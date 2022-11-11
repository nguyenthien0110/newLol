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
 * Servlet implementation class CRUDTypeNewsControl
 */
@WebServlet("/CRUDTypeNewsControl")
public class CRUDTypeNewsControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDTypeNewsControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		dao Dao = new dao();
		String totaltString = request.getParameter("index");
		int total;
		 
		 if(totaltString == null)
		 {
			 total = 1;
		 }
		 else {
			 total = Integer.parseInt(totaltString);
		}
		List<typeNews> listtypeNews = Dao.listTypeNewTotal(total);
		int totalCount = Dao.totalRStype();
		int Count = Dao.countRStype();
		int showingType = Dao.showingType(total);
		if(totalCount == 0)
		{
			totalCount++;
		}
		int next;
		int previous = total - 1;
		if (total == totalCount) {
			next = 1;
		} else {
			next = total + 1;
		}
		
        request.setAttribute("listtypeNews", listtypeNews);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("Count", Count);
        request.setAttribute("showingType", showingType);
        request.setAttribute("next", next);
        request.setAttribute("previous", previous);
        request.setAttribute("total", total);
        request.getRequestDispatcher("/CRUDtypeNews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
