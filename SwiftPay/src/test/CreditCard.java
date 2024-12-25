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

public class CreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		String name="";
		int accno=0;
		int billamt=0;
		String cno=request.getParameter("cno");
		int bill=Integer.parseInt(request.getParameter("amount"));
		String debitcard=request.getParameter("dcardno");
		String debitcvv=request.getParameter("dcvv");
		String upi=request.getParameter("upi");
		String uniquecode="";
		String baccno="";
		int dbal=0;
		String dcard="";
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
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
				uniquecode=rs.getString("upi");
			}
			ResultSet rs1=stmt.executeQuery("select * from creditcardbill where cno='"+cno+"'");
			while(rs1.next())
			{
				//creditcard=rs1.getString("cno");
				billamt=rs1.getInt("billamt");
			}
			ResultSet rs2=stmt.executeQuery("select * from debitcard where cno='"+debitcard+"' and cvv='"+debitcvv+"'");
			while(rs2.next())
			{
				dcard=rs2.getString("cno");
				baccno=rs2.getString("accno");
			}
			ResultSet rs3=stmt.executeQuery("select * from bankaccount where accno='"+baccno+"'");
			while(rs3.next())
			{
				dbal=rs3.getInt("balance");
			}
			
			int tot=dbal-bill;

			if(upi.equals(uniquecode))
			{
				if(debitcard.equals(dcard))
				{
					if(tot<=0)
					{
						response.sendRedirect("transactionFailed.jsp");
					}
					else
					{
						stmt.executeUpdate("update creditcardbill SET status='paid' where cno='"+cno+"'");
						stmt.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Credit Card Bill','"+dat+"','Debitcard',"+bill+","+accno+")");
						stmt.executeUpdate("update bankaccount SET balance="+tot+" where accno='"+baccno+"'");
						response.sendRedirect("transactionSuccessfull.html");
					}
				}
				else
				{
					request.getRequestDispatcher("creditcard1.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"Invalid Debit Card\");");
					out.println("</script>");
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
