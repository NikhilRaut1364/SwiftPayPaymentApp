package test;

import java.io.IOException;
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

public class Scratch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		int wallet=0,uaccno=0;
		String name="";
		int scratch=Integer.parseInt(request.getParameter("scratch"));
		if(scratch==0)
		{
			response.sendRedirect("main.jsp");
		}
		else
		{
			Connection con=null;
			String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
			
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				con=DriverManager.getConnection(url);
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
				while(rs.next())
				{
					name=rs.getString("name");
					uaccno=rs.getInt("accno");
					wallet=rs.getInt("wallet");
				}
				int wtot=wallet+scratch;
				stmt.executeUpdate("update user SET wallet="+wtot+" where username='"+user+"'");
				stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Scratch Card','"+dat+"','Reward',"+scratch+","+uaccno+")");
				response.sendRedirect("main.jsp");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		
	}

}
