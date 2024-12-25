package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Integrate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rad=request.getParameter("rad");
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		int amount=Integer.parseInt(request.getParameter("amount"));
		
		Connection con=null;
		Connection con1=null;
		String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		String url1="jdbc:ucanaccess://E://Database//olx.accdb";
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			con1=DriverManager.getConnection(url1);
			PrintWriter out=response.getWriter();
			Statement stmt=con.createStatement();
			Statement stmt1=con1.createStatement();
			if(rad.equals("debit"))
			{
				String dcno="",dcv="",baccno="";
				ResultSet rs=stmt.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
				while(rs.next())
				{
					dcno=rs.getString("cno");
					dcv=rs.getString("cvv");
					baccno=rs.getString("accno");
				}
				if(dcardno.equals(dcno) && dcv.equals(dcv))
				{
					int bal=0;
					ResultSet rs1=stmt.executeQuery("select * from bankaccount where accno='"+baccno+"'");
					while(rs1.next())
					{
						bal=rs1.getInt("balance");
					}
					int btot=bal-amount;
					if(btot<=0)
					{
						//transaction failed
						response.sendRedirect("Failed.jsp");
					}
					else
					{
						stmt.executeUpdate("update bankaccount SET balance="+btot+" where accno='"+baccno+"'");
						stmt1.executeUpdate("insert into transaction(payment,amount)values('Debit Card',"+amount+")");
						response.sendRedirect("https://b4d61d42d3f2.ngrok.io/BechDe/accept.php?balance="+amount+"");
					}
				}
				else
				{
					//invalid card
					request.getRequestDispatcher("integrate.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"Invalid Card\");");
					out.println("</script>");
				}
			}
			else if(rad.equals("credit"))
			{
				String ccno="",ccv="";
				int cbal=0;
				ResultSet rs2=stmt.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
				while(rs2.next())
				{
					ccno=rs2.getString("cno");
					ccv=rs2.getString("cvv");
					cbal=rs2.getInt("balance");
				}
				int ctot=cbal-amount;
				if(ccardno.equals(ccno) && ccvv.equals(ccv))
				{
					if(ctot<=0)
					{
						//transaction failed
						response.sendRedirect("Failed.jsp");
					}
					else
					{
						stmt.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"'");
						stmt1.executeUpdate("insert into transaction(payment,amount)values('Credit Card',"+amount+")");
						response.sendRedirect("https://b4d61d42d3f2.ngrok.io/BechDe/accept.php?balance="+amount+"");
					}
				}
				else
				{
					//invalid card
					request.getRequestDispatcher("integrate.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"Invalid Card\");");
					out.println("</script>");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
