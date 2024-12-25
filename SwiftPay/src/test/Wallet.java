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

public class Wallet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		
		int amount=Integer.parseInt(request.getParameter("amount"));
		String payment=request.getParameter("rad");
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		String upi=request.getParameter("upi");
		String creditcardno="";
		String creditcvv="";
		int cbal=0;
		String baccno="";
		String name="";
		String debitcardno="";
		String debitcvv="";
		String uniquecode="";
		int wallet=0;
		int bbal=0;
		int accno=0;
		
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
				if(payment.equals("debit"))
				{
					ResultSet rs1=stmt.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
					while(rs1.next())
					{
						debitcardno=rs1.getString("cno");
						debitcvv=rs1.getString("cvv");
						baccno=rs1.getString("accno");
					}
					ResultSet rs2=stmt.executeQuery("select * from bankaccount where accno='"+baccno+"'");
					while(rs2.next())
					{
						bbal=rs2.getInt("balance");
					}
					if(dcardno.equals(debitcardno) && dcvv.equals(debitcvv))
					{
						int tot=bbal-amount;
						int wal=wallet+amount;
						if(tot<=0)
						{
							//invalid balance
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("update bankaccount SET balance="+tot+" where accno='"+baccno+"'");
							stmt.executeUpdate("update user SET wallet="+wal+" where username='"+user+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Add Money To Wallet','"+dat+"','Debitcard',"+amount+","+accno+")");
							response.sendRedirect("done.html");
							
						}
					}
					else
					{
						// invalid card number
						request.getRequestDispatcher("addmoneywallet.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Debit Card\");");
						out.println("</script>");
					}
				}
				else if(payment.equals("credit"))
				{
					ResultSet rs3=stmt.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
					while(rs3.next())
					{
						cbal=rs3.getInt("balance");
						creditcardno=rs3.getString("cno");
						creditcvv=rs3.getString("cvv");
					}
					if(creditcardno.equals(ccardno) && creditcvv.equals(ccvv))
					{
						int ctot=cbal-amount;
						int wal=wallet+amount;
						if(ctot<=0)
						{
							//no balance
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							stmt.executeUpdate("update user SET wallet="+wal+" where username='"+user+"'");
							stmt.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"' and cvv='"+ccvv+"'");
							stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Add Money To Wallet','"+dat+"','Credit Card',"+amount+","+accno+")");
							response.sendRedirect("done.html");
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("addmoneywallet.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Debit Card\");");
						out.println("</script>");
					}
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
