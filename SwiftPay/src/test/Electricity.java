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

public class Electricity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		int bal=0;
		String name="";
		int accno=0;
		int w=0;
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		String bankaccno="";
		int bankbal=0;
		String uniquecode="";
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		String cno=request.getParameter("cno");
		String scode=request.getParameter("scode");
		String provider=request.getParameter("provider");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String pay=request.getParameter("rad");
		String upi=request.getParameter("upi");
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
			PrintWriter out=response.getWriter();
			
			
			ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
			while(rs.next())
			{
				name=rs.getString("name");
				accno=rs.getInt("accno");
				w=rs.getInt("wallet");
				uniquecode=rs.getString("upi");
			}
			//System.out.println(name+" "+accno);
			if(upi.equals(uniquecode))
			{
				if(pay.equals("credit"))
				{
					String ccno="",ccv="";
					ResultSet rs1=stmt.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
					while(rs1.next())
					{
						bal=rs1.getInt("balance");
						ccno=rs1.getString("cno");
						ccv=rs1.getString("cvv");
					}
					if(ccardno.equals(ccno) && ccvv.equals(ccv))
					{
						if(bal<=0)
						{
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							int tot=bal-amount;
							if(tot<=0)
							{
								response.sendRedirect("transactionFailed.jsp");
							}
							else
							{
								stmt.executeUpdate("update creditcard SET balance="+tot+" where cno='"+ccardno+"'");
								stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Electricity','"+dat+"','credit card',"+amount+","+accno+")");
								stmt.executeUpdate("update electricity SET status='paid' where cno='"+cno+"' and sdcode='"+scode+"'");
								response.sendRedirect("transactionSuccessfull.html");
							}
						}
					}
					else
					{
						//invalid card
					}
					
					
				}
				else if(pay.equals("debit"))
				{
					//System.out.println("debit");
					String dcno="",dcv="";
					ResultSet rs2=stmt.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
					
					while(rs2.next())
					{
						bankaccno=rs2.getString("accno");
						dcno=rs2.getString("cno");
						dcv=rs2.getString("cvv");
					}
					//System.out.println(bankaccno);
					if(dcardno.equals(dcno) && dcvv.equals(dcv))
					{
						ResultSet rs3=stmt.executeQuery("select * from bankaccount where accno='"+bankaccno+"'");
						while(rs3.next())
						{
							bankbal=rs3.getInt("balance");
						}
						if(bankbal<=0)
						{
							//transaction failed
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							int tot=bankbal-amount;
							if(tot<=0)
							{
								response.sendRedirect("transactionFailed.jsp");
							}
							else
							{
								stmt.executeUpdate("update bankaccount SET balance="+tot+" where accno='"+bankaccno+"'");
								stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Electricity','"+dat+"','Debit Card',"+amount+","+accno+")");
								stmt.executeUpdate("update electricity SET status='paid' where cno='"+cno+"' and sdcode='"+scode+"'");
								response.sendRedirect("transactionSuccessfull.html");
							}
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("electricity1.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Card\");");
						out.println("</script>");
					}
					
				}
				else if(pay.equals("wallet"))
				{
					if(w<=0)
					{
						response.sendRedirect("transactionFailed.jsp");
					}
					else
					{
						int tot=w-amount;
						if(tot<=0)
						{
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("update user SET wallet="+tot+" where username='"+user+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Electricity','"+dat+"','wallet',"+amount+","+accno+")");
							stmt.executeUpdate("update electricity SET status='paid' where cno='"+cno+"' and sdcode='"+scode+"'");
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
				}
			}
			else
			{
				//upi error
				response.sendRedirect("transactionFailed.jsp");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
