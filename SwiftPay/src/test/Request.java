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

public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("username");
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		String name=request.getParameter("name");
		String amount=request.getParameter("amount");
		String emailid=request.getParameter("email");
		int uaccno=0;
		String recemail="";
		String recname="";
		int recaccno=0;
		String uname="";
		
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";

		Connection con=null;
		PrintWriter out=response.getWriter();
		try {
			con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs.next())
			{
				uaccno=rs.getInt("accno");
				//uemail=rs.getString("email");
				uname=rs.getString("name");
			}
			ResultSet rs1=stmt.executeQuery("select * from user where email='"+emailid+"'");
			while(rs1.next())
			{
				recemail=rs1.getString("email");
				recname=rs1.getString("name");
				recaccno=rs1.getInt("accno");
			}
			if(emailid.equals(recemail))
			{
				String to=emailid;
				String subject="Payment Request"; 
				String message="Payment outstanding of Rs."+amount;
				
				//String msg="<h1>Hello</h1><br>";
				//msg+="<h6>welcome</h6>";
				String msg="<html><head><style type=\"text/css\">body{font-family:candara;}table{background-color:#25488e;font-size:15px;color:white;font-family:candara;}i{color:white;font-size:20px;}</style></head><body>";
				msg+="<table height=\"300\"><tr><td><center><b style=\"font-size:20px;\">Payment Reminder</b></center></td></tr>";
				msg+="<tr><td>Dear "+recname+",</td></tr>";
				msg+="<tr><td>Please remember that the balance on your account of Rs."+amount+" remains unpaid. If you haven't already sent the payment, please do as soon as possible</td></tr>";
				msg+="<tr><td><br>"+uname+"</td></tr>";
				msg+="</table></body></html>";
				
				stmt.executeUpdate("insert into notification(ndate,message,uaccno,recaccno,from)values('"+dat+"','"+message+"',"+uaccno+","+recaccno+",'"+uname+"')");
				Mailer.send(to, subject, msg);
				response.sendRedirect("done.html");
			}
			else
			{
				//user donot exist
				request.getRequestDispatcher("requestMoney.jsp").include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"User Donot Exist in SwiftPay Family\");");
				out.println("</script>");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}