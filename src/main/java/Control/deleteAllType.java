package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;

/**
 * Servlet implementation class deleteAllType
 */
@WebServlet("/deleteAllType")
public class deleteAllType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAllType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao Dao = new dao();
		for(String id : request.getParameterMap().keySet()){ //https://stackoverflow.com/questions/36331510/how-to-post-multiple-input-type-checkbox-as-array-to-java-servlet
		      for(String value : request.getParameterValues(id)){
		          System.out.println(value);    
		          Dao.deleteType(value);
		      }
		    }
		response.sendRedirect("CRUDTypeNewsControl");
	}

}
