package Control;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;

/**
 * Servlet implementation class EditAccControl
 */
@WebServlet("/EditAccControl")
public class EditAccControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAccControl() {
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
		
		request.getRequestDispatcher("CRUDaccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao Dao = new dao();

		String userString = request.getParameter("usernameEdit");
		String passString = request.getParameter("passwordEdit");
		boolean checkEditString = request.getParameter("checkEdit") != null;
		String checkEdit;
		if (checkEditString==true) {
			checkEdit = "1";
		} else {
			checkEdit = "0";
		}
		System.out.println(checkEdit);
		Dao.updateAcc(userString, passString, checkEdit);

//		Dao.updateAcc(userString, passString);
		response.sendRedirect("CRUDaccount");

	}

}
