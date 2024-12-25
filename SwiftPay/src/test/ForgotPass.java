package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.Email;

public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String subject = "Password Recovery";
		String uemail="", uname="",un="";
		Email ec = new Email();
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			PrintWriter out=response.getWriter();
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where username='"+username+"'");
			while(rs.next())
			{
				uname = rs.getString("name");
				uemail = rs.getString("email");
				un = rs.getString("username");
			}
			if(username.equals(un))
			{
				String msg = "<html><head><style>table{background-color:#25488e;color:white;}</style></head><body>";
				msg+= "<table><tr><td><center><h1>Password Recovery</h1></center></td></tr>";
				msg+= "<tr><td>Hello, "+uname+"</td></tr>";
				msg+= "<tr><td>We have received a request to reset password. If you didn't make a request just ignore this email. Otherwise you can reset your password by clicking below link.</td></tr>";
				msg+= "<tr><td><a style='color:white;' href='https://a8d5646b6e96.ngrok.io/SwiftPay/recovery.jsp?username="+username+"'>Click Here</a></td></tr>";
				msg+= "</table></body></html>";
				Mailer.send(uemail, subject, msg);
				request.getRequestDispatcher("loginForm.jsp").include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"Check Your Email\");");
				out.println("</script>");
			}
			else
			{
				request.getRequestDispatcher("forget.jsp").include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"Username Donot Exist\");");
				out.println("</script>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
