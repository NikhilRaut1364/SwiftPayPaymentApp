package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePassword extends HttpServlet
{
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		Connection con=null;
		PrintWriter out=response.getWriter();
		String upass="";
		
		String pass = request.getParameter("previouspass");
		String npass = request.getParameter("newpass");
		String cpass = request.getParameter("confirmnewpass");
		
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("username");
		
		try {
			con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs.next())
			{
				upass = rs.getString("password");
			}
			if(pass.equals(upass))
			{
				if(npass.equals(cpass))
				{
					stmt.executeUpdate("update user SET password='"+npass+"' where username='"+user+"'");
					request.getRequestDispatcher("changePass.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"Password Changes Successfuly\");");
					out.println("</script>");
				}
				else
				{
					//password donot match
					request.getRequestDispatcher("changePass.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"Password Donot Match\");");
					out.println("</script>");
				}
			}
			else
			{
				//incorrect 
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
		