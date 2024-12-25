package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecoveryPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String npass = request.getParameter("npass");
		String cpass = request.getParameter("cpass");
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			PrintWriter out=response.getWriter();
			Statement stmt=con.createStatement();
			if(npass.equals(cpass))
			{
				stmt.executeUpdate("update user SET password='"+npass+"' where username='"+username+"'");
				response.sendRedirect("login.jsp");
			}
			else
			{
				request.getRequestDispatcher("forgot.jsp").include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"Please go back to Mail and Try again\");");
				out.println("</script>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
