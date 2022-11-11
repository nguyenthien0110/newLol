package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import entity.Account;

/**
 * Servlet implementation class RegisterControl
 */
@WebServlet("/RegisterControl")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControl() {
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
		response.setContentType("text/html");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String Re_pass = request.getParameter("re_password");
		PrintWriter out = response.getWriter();
		
        dao Dao = new dao();
		
		if(!pass.equals(Re_pass)){
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Passwords are not the same');");
			   out.println("location='register.jsp';");
			   out.println("</script>");//2 pass khong trung
		}
		else {

			Account a = Dao.checkAccountExist(user);
			if(a == null)
			{
		        Dao.signUp(user, pass);
		        out.println("<script type=\"text/javascript\">");
				   out.println("alert('Sign Up Success');");
				   out.println("location='index.jsp';");
				   out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Already have this account');");
				   out.println("location='register.jsp';");
				   out.println("</script>");//
			}
		}
	}

}
