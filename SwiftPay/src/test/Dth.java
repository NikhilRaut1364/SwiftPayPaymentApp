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

public class Dth extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		
		String name="";
		int accno=0;
		int bal=0;
		int baccno=0;
		int bbal=0;
		int cbal=0;
		int wallet=0;
		String uniquecode="";
		
		String sid=request.getParameter("sid");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String payment=request.getParameter("rad");
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		String upi=request.getParameter("upi");
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			PrintWriter out=response.getWriter();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs.next())
			{
				name=rs.getString("name");
				accno=rs.getInt("accno");
				wallet=rs.getInt("wallet");
				uniquecode=rs.getString("upi");
			}
			
				if(upi.equals(uniquecode))
				{
					String dcno="",dcv="";
					if(payment.equals("debit"))
					{
						ResultSet rs1=stmt.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
						while(rs1.next())
						{
							baccno=rs1.getInt("accno");
							dcno=rs1.getString("cno");
							dcv=rs1.getString("cvv");
						}
						if(dcardno.equals(dcno) && dcvv.equals(dcv))
						{
							ResultSet rs2=stmt.executeQuery("select * from bankaccount where accno="+baccno+"");
							while(rs2.next())
							{
								bbal=rs2.getInt("balance");
							}
							int tot=bbal-amount;
							if(tot<=0)
							{
								//low balance
								response.sendRedirect("transactionFailed.jsp");
							}
							else
							{
								stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','DTH Recharge','"+dat+"','Debit Card',"+amount+","+accno+")");
								stmt.executeUpdate("update bankaccount SET balance="+tot+" where accno='"+baccno+"'");
								response.sendRedirect("transactionSuccessfull.html");
							}
						}
						else
						{
							//invalid card
							request.getRequestDispatcher("dth1.jsp").include(request, response);
							out.println("<script type=\"text/javascript\">");
							out.println("alert(\"Invalid Card\");");
							out.println("</script>");
						}
						
					}
					else if(payment.equals("credit"))
					{
						String ccno="",ccv="";
						ResultSet rs3=stmt.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
						while(rs3.next())
						{
							cbal=rs3.getInt("balance");
							ccno=rs3.getString("cno");
							ccv=rs3.getString("cvv");
						}
						if(ccardno.equals(ccno) && ccvv.equals(ccv))
						{
							int ctot=cbal-amount;
							if(ctot<=0)
							{
								//insufficient balance
								response.sendRedirect("transactionFailed.jsp");
							}
							else
							{
								stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','DTH Recharge','"+dat+"','Credit Card',"+amount+","+accno+")");
								stmt.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"' and cvv='"+ccvv+"'");
								response.sendRedirect("transactionSuccessfull.html");
							}
						}
						else
						{
							//invalid card
							request.getRequestDispatcher("dth1.jsp").include(request, response);
							out.println("<script type=\"text/javascript\">");
							out.println("alert(\"Invalid Card\");");
							out.println("</script>");
						}
						
					}
					else if(payment.equals("wallet"))
					{
						int walltot=wallet-amount;
						if(walltot<=0)
						{
							//insufficient balance
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','DTH Recharge','"+dat+"','Credit Card',"+amount+","+accno+")");
							stmt.executeUpdate("update user SET wallet="+walltot+" where username='"+user+"'");
							response.sendRedirect("transactionSuccessfull.html");
						}
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
