package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test1.LoginUser;

/**
 * Servlet implementation class LoginData
 */

public class LoginData extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginUser lg=new LoginUser();
		PrintWriter out=response.getWriter();
			try {
				if(lg.check(uname,pass))
				{
					HttpSession session=request.getSession();
					session.setAttribute("username", uname);
					RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
					rd.include(request, response);
				}
				else
				{
					request.getRequestDispatcher("loginForm.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"Wrong Username and Password\");");
					out.println("</script>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
