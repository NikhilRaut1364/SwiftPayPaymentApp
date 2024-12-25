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

public class Sport extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		
		String edate=request.getParameter("edate");
		String time=request.getParameter("time");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		String rad=request.getParameter("rad");
		String upi=request.getParameter("upi");
		String name="",uniquecode="";
		int uaccno=0,wallet=0;
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			PrintWriter out=response.getWriter();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs.next())
			{
				name=rs.getString("name");
				uaccno=rs.getInt("accno");
				wallet=rs.getInt("wallet");
				uniquecode=rs.getString("upi");
			}
			if(upi.equals(uniquecode))
			{
				if(rad.equals("debit"))
				{
					String ano="",dcno="",dcv="";
					ResultSet rs1=stmt.executeQuery("select * from debitcard where cno='"+dcardno+"'and cvv='"+dcvv+"'");
					while(rs1.next())
					{
						ano=rs1.getString("accno");
						dcno=rs1.getString("cno");
						dcv=rs1.getString("cvv");
					}
					if(dcardno.equals(dcno) && dcvv.equals(dcv))
					{
						ResultSet rs2=stmt.executeQuery("select * from bankaccount where accno='"+ano+"' ");
						int bal=0;
						while(rs2.next())
						{
							bal=rs2.getInt("balance");
						}
						int tot=bal-amount;
						if(tot<0)
						{
							//payment failed
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("update bankaccount SET balance="+tot+" where accno='"+ano+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Event Ticket','"+dat+"','Debit Card',"+amount+","+uaccno+")");
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("sport.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Card\");");
						out.println("</script>");
					}
				}
				else if(rad.equals("credit"))
				{
					int cbal=0;
					String cno="",ccv="";
					ResultSet rs3=stmt.executeQuery("select * from creditcard where cno='"+ccardno+"'and cvv='"+ccvv+"'");
					while(rs3.next())
					{
						cbal=rs3.getInt("balance");
						cno=rs3.getString("cno");
						ccv=rs3.getString("cvv");
					}
					if(ccardno.equals(cno) && ccvv.equals(ccv))
					{
						int ctot=cbal-amount;
						if(ctot<0)
						{
							//payment failed
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"' and cvv='"+ccvv+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Event Ticket','"+dat+"','Credit Card',"+amount+","+uaccno+")");
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("sport.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Card\");");
						out.println("</script>");
					}
				}
				else if(rad.equals("wallet"))
				{
					int wtot=wallet-amount;
					if(wtot<0)
					{
						//payment failed
						response.sendRedirect("transactionFailed.jsp");
					}
					else
					{
						stmt.executeUpdate("update user SET wallet="+wtot+" where username='"+user+"'");
						stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Event Ticket','"+dat+"','Wallet',"+amount+","+uaccno+")");
						response.sendRedirect("transactionSuccessfull.html");
					}
				} 
				
			}
			else
			{
				//transaction failed
				response.sendRedirect("transactionFailed.jsp");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}