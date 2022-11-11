package Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import entity.Account;

/**
 * Servlet implementation class AddAccControl
 */
@WebServlet("/AddAccControl")
public class AddAccControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAccControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("CRUDaccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userString = request.getParameter("usernameAdd");
		String passString = request.getParameter("passwordAdd");
		String checkAdmin = request.getParameter("checkAdminAdd");
		if (checkAdmin == null) {
			checkAdmin = "0";
		} else {
			checkAdmin = "1";
		}
		System.out.println(checkAdmin);
		dao Dao = new dao();
		Account a = Dao.checkAccountExist(userString);
		if (a == null) {
			Dao.insertAcc(userString, passString, checkAdmin);
			response.sendRedirect("CRUDaccount");
		} else {
			request.getRequestDispatcher("addEmployeeModal").forward(request, response);
		}
	}

}
