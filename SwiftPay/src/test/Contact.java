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

public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("username");
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		Connection con=null;
		PrintWriter out=response.getWriter();
		
		String contact=request.getParameter("contact");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String rad=request.getParameter("rad");
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		String upi=request.getParameter("upi");
		String uniquecode="";
		int uaccno=0;
		String uname="";
		String recname="";
		int recaccno=0;
		int recwall=0;
		int uwall=0;
		String phno="";
		/*if(contact.equals("") && amount==0 && rad.equals("") && upi.equals(""))
		{
			request.getRequestDispatcher("toContact.jsp").include(request, response);
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Fields are empty\");");
			out.println("</script>");
		}*/
		try {
			con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs.next())
			{
				uaccno=rs.getInt("accno");
				uname=rs.getString("name");
				uwall=rs.getInt("wallet");
				uniquecode=rs.getString("upi");
			}
			ResultSet rs1=stmt.executeQuery("select * from user where phno='"+contact+"'");
			while(rs1.next())
			{
				recaccno=rs1.getInt("accno");
				recname=rs1.getString("name");
				recwall=rs1.getInt("wallet");
				phno=rs1.getString("phno");
			}
			if(upi.equals(uniquecode))
			{
				if(contact.equals(phno))
				{
					if(rad.equals("debit"))
					{
						String baccno="",dcno="",dcv="";
						int bbal=0;
						ResultSet rs2=stmt.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
						while(rs2.next())
						{
							baccno=rs2.getString("accno");
							dcno=rs2.getString("cno");
							dcv=rs2.getString("cvv");
						}
						
						ResultSet rs3=stmt.executeQuery("select * from bankaccount where accno='"+baccno+"'");
						while(rs3.next())
						{
							bbal=rs3.getInt("balance");
						}
						if(dcardno.equals(dcno) && dcvv.equals(dcv))
						{
							int tot=bbal-amount;
							if(tot<=0)
							{
								//low balance
								response.sendRedirect("transactionFailed.jsp");
							}
							else
							{
								int recwallet=recwall+amount;
								stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+uname+"','Contact Transfer','"+dat+"','Debit Card',"+amount+","+uaccno+") ");
								stmt.executeUpdate("update bankaccount SET balance="+tot+" where accno='"+baccno+"'");
								stmt.executeUpdate("update user SET wallet="+recwallet+" where phno='"+contact+"'");
								stmt.executeUpdate("insert into notification(ndate,message,uaccno,recaccno,from)values('"+dat+"','Received Money Rs."+amount+"',"+uaccno+","+recaccno+",'"+uname+"')");
								response.sendRedirect("done.html");
							}
						}
						else
						{
							request.getRequestDispatcher("toContact.jsp").include(request, response);
							out.println("<script type=\"text/javascript\">");
							out.println("alert(\"Invalid Card\");");
							out.println("</script>");
						}
						
						
					}
					else if(rad.equals("credit"))
					{
						int cbal=0;
						String ccno="",ccv="";
						ResultSet rs4=stmt.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
						while(rs4.next())
						{
							cbal=rs4.getInt("balance");
							ccno=rs4.getString("cno");
							ccv=rs4.getString("cvv");
						}
						if(ccardno.equals(ccno) && ccvv.equals(ccv))
						{
							int ctot=cbal-amount;
							if(ctot<=0)
							{
								//low balance
								response.sendRedirect("transactionFailed.jsp");
							}
							else
							{
								int recwallet=recwall+amount;
								stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+uname+"','Contact Transfer','"+dat+"','Credit Card',"+amount+","+uaccno+") ");
								stmt.executeUpdate("update user SET wallet="+recwallet+" where phno='"+contact+"'");
								stmt.executeUpdate("insert into notification(ndate,message,uaccno,recaccno,from)values('"+dat+"','Received Money Rs."+amount+"',"+uaccno+","+recaccno+",'"+uname+"')");
								stmt.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"'");
								response.sendRedirect("done.html");
							}
						}
						else
						{
							request.getRequestDispatcher("toContact.jsp").include(request, response);
							out.println("<script type=\"text/javascript\">");
							out.println("alert(\"Invalid Card\");");
							out.println("</script>");
						}
						
					}
					else if(rad.equals("wallet"))
					{
						int utot=uwall-amount;
						int recwallet=recwall+amount;
						if(utot<=0)
						{
							//insufficient balance
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+uname+"','Contact Transfer','"+dat+"','Wallet',"+amount+","+uaccno+") ");
							stmt.executeUpdate("update user SET wallet="+recwallet+" where phno='"+contact+"'");
							stmt.executeUpdate("update user SET wallet="+utot+" where username='"+user+"'");
							stmt.executeUpdate("insert into notification(ndate,message,uaccno,recaccno,from)values('"+dat+"','Received Money Rs."+amount+"',"+uaccno+","+recaccno+",'"+uname+"')");
							response.sendRedirect("done.html");
						}
					}
				}
				else
				{
					//not contact available
					request.getRequestDispatcher("toContact.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"No account Linked with this contact\");");
					out.println("</script>");
				}
			}
			else
			{
				//upi error
				response.sendRedirect("transactionFailed.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
