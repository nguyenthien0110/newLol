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
 * Servlet implementation class homeControl
 */
@WebServlet("/home")
public class homeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		 String totaltString = request.getParameter("index");
		 int total = 0;
		 
		 if(totaltString == null)
		 {
			 total = 1;
		 }
		 else {
			 total = Integer.parseInt(totaltString);
		}
		dao Dao = new dao();
        List<newsPost> list = Dao.getAllNewsPost();
        List<typeNews> listN = Dao.getAllTypeNews();
        newsPost listTop1 = Dao.getTop1News();
        newsPost listTop2 = Dao.getTop2News();
        newsPost listTop3 = Dao.getTop3News();
        newsPost listTop4 = Dao.getTop4News();
        newsPost listTop5 = Dao.getTop5News();
        List<newsPost> listTrendding = Dao.trenddinList();
        int totalCount = Dao.totalPage();
        List<newsPost> listTotal = Dao.pagingList(total);
        
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
        //set data to jsp
        request.setAttribute("listAll", list);//Danh sach all News post
        request.setAttribute("listTypeNews", listN);//Danh sach all type News
        request.setAttribute("listTop1", listTop1); //top 1 news
        request.setAttribute("listTop2", listTop2); //top 2 news
        request.setAttribute("listTop3", listTop3); //top 3 news
        request.setAttribute("listTop4", listTop4); //top 4 news
        request.setAttribute("listTop5", listTop5); //top 5 news
        request.setAttribute("listTrendding", listTrendding); //top trendding
        request.setAttribute("listTotal", listTotal);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("index", totaltString);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
