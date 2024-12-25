package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.Email;

/**
 * Servlet implementation class Verify
 */
public class Verify extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		//String username="root";
		//String password="";
		
		int k = 0;
		String n="",em="",ph="";
		Cookie cookie[]=request.getCookies();
		for(Cookie c:cookie)
		{
			if(c.getName().equals("otp"))
			{
				k=Integer.parseInt(c.getValue());
			}
			if(c.getName().equals("name"))
			{
				n=c.getValue();
			}
			if(c.getName().equals("email"))
			{
				em=c.getValue();
			}
			if(c.getName().equals("phoneno"))
			{
				ph=c.getValue();
			}
		}
		int enterotp=Integer.parseInt(request.getParameter("otp"));
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String upi=request.getParameter("upi");
		
		PrintWriter out=response.getWriter();
		
		if(enterotp!=k)
		{
			request.getRequestDispatcher("Emailverify.jsp").include(request, response);
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Enter Correct OTP\");");
			out.println("</script>");
		}
		else
		{
			Email ec=new Email();
			if(pass.equals(cpass))
			{
				try {
					if(ec.check(uname))
					{
						request.getRequestDispatcher("Emailverify.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Username Already Exists\");");
						out.println("</script>");
					}
					else
					{
						try {
							Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
							con=DriverManager.getConnection(url);
							Statement stmt=con.createStatement();
							stmt.executeUpdate("insert into user(Name,email,phno,wallet,username,password,upi)values('"+n+"','"+em+"','"+ph+"',0,'"+uname+"','"+pass+"','"+upi+"')");
							
							response.sendRedirect("main.jsp");
						}
						catch(Exception e){
							System.out.println(e);
						}
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			else
			{
				request.getRequestDispatcher("Emailverify.jsp").include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"Password Do not match\");");
				out.println("</script>");
			}
		}
		
	}

}
