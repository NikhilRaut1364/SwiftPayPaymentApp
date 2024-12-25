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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Bank extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baccname="";
		String bifsc="";
		String baccno="";
		String name="";
		int accno=0;
		String aaccname=request.getParameter("aaccname");
		String aaccno=request.getParameter("aaccno");
		String aifsc=request.getParameter("ifsc");
		int amount=Integer.parseInt(request.getParameter("amount"));
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		
		Cookie cookie[]=request.getCookies();
		for(Cookie c:cookie)
		{
			if(c.getName().equals("baccname"))
			{
				baccname=c.getValue();
			}
			if(c.getName().equals("bifsc"))
			{
				bifsc=c.getValue();
			}
			if(c.getName().equals("baccno"))
			{
				baccno=c.getValue();
			}
		}
		int bbal=0,abal=0;
		String bano="",aano="";
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			PrintWriter out=response.getWriter();
			Statement stmt=con.createStatement();
			ResultSet rs2=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs2.next())
			{
				name=rs2.getString("name");
				accno=rs2.getInt("accno");
			}
			ResultSet rs=stmt.executeQuery("select balance,accno from bankaccount where accno='"+baccno+"' and ifsc='"+bifsc+"'");
			while(rs.next())
			{
				bbal=rs.getInt(1);
				bano=rs.getString(2);
			}
			int btot=bbal+amount;
			ResultSet rs1=stmt.executeQuery("select balance,accno from bankaccount where accno='"+aaccno+"' and ifsc='"+aifsc+"'");
			while(rs1.next())
			{
				abal=rs1.getInt(1);
				aano=rs1.getString(2);
			}
			int atot=abal-amount;
			
			if(bano.equals(baccno))
			{
				if(aano.equals(aaccno))
				{
					if(btot<=0)
					{
						response.sendRedirect("transactionFailed.jsp");
					}
					else
					{
						if(atot<=0)
						{
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("update bankaccount SET balance="+btot+" where accno='"+baccno+"' and ifsc='"+bifsc+"'");
							stmt.executeUpdate("update bankaccount SET balance="+atot+" where accno='"+aaccno+"' and ifsc='"+aifsc+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Bank Transfer','"+dat+"','Bank Account',"+amount+","+accno+")");
							response.sendRedirect("done.html");
						}
					}
					
				}
				else
				{
					response.sendRedirect("transactionFailed.jsp");
				}
			}
			else
			{
				response.sendRedirect("transactionFailed.jsp");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
