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

public class Flight extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		
		String t="";
		
		Cookie cookie[]=request.getCookies();
		for(Cookie c:cookie)
		{
			if(c.getName().equals("traveller"))
			{
				t=c.getValue();
			}
		}
		
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String fclass=request.getParameter("fclass");
		String fdate=request.getParameter("fdate");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String upi=request.getParameter("upi");
		String rad=request.getParameter("rad");
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		int traveller=Integer.parseInt(t);
		String subject="Flight Ticket";
		String name="",uniquecode="",time="",uemail="";
		int wallet=0,uaccno=0;
		int seat=0;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			PrintWriter out=response.getWriter();
			Statement stmt=con.createStatement();
			ResultSet r=stmt.executeQuery("select * from flight where source='"+from+"' and destination='"+to+"' and fdate='"+fdate+"' and class='"+fclass+"'");
			while(r.next())
			{
				seat=r.getInt("seat");
				time=r.getString("time");
			}
			ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs.next())
			{
				name=rs.getString("name");
				uaccno=rs.getInt("accno");
				wallet=rs.getInt("wallet");
				uniquecode=rs.getString("upi");
				uemail=rs.getString("email");
			}
			if(upi.equals(uniquecode))
			{
				String msg="<html><head><style type=\"text/css\">body{font-family:candara;}table{background-color:#25488e;font-size:15px;color:white;font-family:candara;width:300px}i{color:white;font-size:20px;}</style></head><body>";
				msg+="<table height=\"200\"><tr><td colspan=\"5\"><center><b style=\"font-size:20px;\">Flight Ticket</b></center></td></tr>";
				msg+="<tr><td><center>From: "+from+"</center></td></tr>";
				msg+="<tr><td><center>To: "+to+"</center></td></tr>";
				msg+="<tr><td><center>Date: "+fdate+"</center></td></tr>";
				msg+="<tr><td><center>Time: "+time+"</center></td></tr>";
				msg+="<tr><td><center>Class: "+fclass+"</center></td></tr>";
				msg+="</table></body></html>";
				
				if(rad.equals("debit"))
				{
					String baccno="",dcno="",dcv="";
					ResultSet rs1=stmt.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
					while(rs1.next())
					{
						baccno=rs1.getString("accno");
						dcno=rs1.getString("cno");
						dcv=rs1.getString("cvv");
					}
					if(dcardno.equals(dcno) && dcvv.equals(dcv))
					{
						int bbal=0;
						ResultSet rs2=stmt.executeQuery("select * from bankaccount where accno='"+baccno+"'");
						while(rs2.next())
						{
							bbal=rs2.getInt("balance");
						}
						int btot=bbal-amount;
						if(btot<=0)
						{
							//transaction failed
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							int totseat=seat-traveller;
							stmt.executeUpdate("update bankaccount SET balance="+btot+" where accno='"+baccno+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Flight Ticket','"+dat+"','Debit Card',"+amount+","+uaccno+")");
							stmt.executeUpdate("update flight SET seat="+totseat+" where source='"+from+"' and destination='"+to+"' and class='"+fclass+"' and fdate='"+fdate+"'");
							Mailer.send(uemail, subject, msg);
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("flight.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Card\");");
						out.println("</script>");
					}
				}
				else if(rad.equals("credit"))
				{
					String ccno="",ccv="";
					int cbal=0;
					ResultSet rs3=stmt.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
					while(rs3.next())
					{
						ccno=rs3.getString("cno");
						ccv=rs3.getString("cvv");
						cbal=rs3.getInt("balance");
					}
					if(ccardno.equals(ccno) && ccvv.equals(ccv))
					{
						int ctot=cbal-amount;
						if(ctot<=0)
						{
							//transaction failed
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							int totseat=seat-traveller;
							stmt.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"' and cvv='"+ccvv+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Flight Ticket','"+dat+"','Credit Card',"+amount+","+uaccno+")");
							stmt.executeUpdate("update flight SET seat="+totseat+" where source='"+from+"' and destination='"+to+"' and class='"+fclass+"' and fdate='"+fdate+"'");
							Mailer.send(uemail, subject, msg);
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("flight.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Card\");");
						out.println("</script>");
					}
				}
				else if(rad.equals("wallet"))
				{
					int wtot=wallet-amount;
					if(wtot<=0)
					{
						//transaction failed
						response.sendRedirect("transactionFailed.jsp");
					}
					else
					{
						int totseat=seat-traveller;
						stmt.executeUpdate("update user SET wallet="+wtot+" where username='"+user+"'");
						stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Flight Ticket','"+dat+"','Wallet',"+amount+","+uaccno+")");
						stmt.executeUpdate("update flight SET seat="+totseat+" where source='"+from+"' and destination='"+to+"' and class='"+fclass+"' and fdate='"+fdate+"'");
						Mailer.send(uemail, subject, msg);
						response.sendRedirect("transactionSuccessfull.html");
					}
				}
			}
			else
			{
				//transaction failed
				response.sendRedirect("transactionFailed.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
