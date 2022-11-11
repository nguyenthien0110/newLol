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
 * Servlet implementation class CRUDcontrol
 */
@WebServlet("/CRUDcontrol")
public class CRUDcontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDcontrol() {
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
		int totalCount = Dao.totalPage();
		int countList = Dao.countList();
        List<newsPost> listTotal = Dao.pagingListCRUD(total);
        int countBack =  Dao.countBackList(total);
        List<typeNews> listtypeNews = Dao.getAllTypeNews();
        int up;
        int down;
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
        
        List<newsPost> list = Dao.getAllNewsPost();


        request.setAttribute("list", list);
        request.setAttribute("listTotal", listTotal);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("index", totaltString);
        request.setAttribute("up", up);
        request.setAttribute("down", down);
        request.setAttribute("countList", countList);
        request.setAttribute("countBack", countBack);
        request.setAttribute("listtypeNews", listtypeNews);
        request.getRequestDispatcher("/CRUD.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
