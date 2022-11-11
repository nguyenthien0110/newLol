package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.dao;
import entity.Account;

/**
 * Servlet implementation class adminControlLogin
 */
@WebServlet("/homeAdmin")
public class adminControlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminControlLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("loginError", "Incorrect password");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			dao Dao = new dao();
			Account a = Dao.checkLoginAdmin(user, pass);

			if (a == null) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User or password incorrect');");
				out.println("location='admin.jsp';");
				out.println("</script>");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("account", a);
				response.sendRedirect("homeAdmin.jsp");// nice!
			}
		} catch (Exception e) {

		}
	}

}
