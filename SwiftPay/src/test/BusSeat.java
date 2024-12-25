package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class BusSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		PrintWriter out=response.getWriter();
		String var="";
		
		
		String bfrom="",bto="",bdate="",time="",bno="";
		String bname="";
		
		String A1=request.getParameter("A1");
		String A2=request.getParameter("A2");
		String A3=request.getParameter("A3");
		String A4=request.getParameter("A4");
		
		String B1=request.getParameter("B1");
		String B2=request.getParameter("B2");
		String B3=request.getParameter("B3");
		String B4=request.getParameter("B4");
		
		String C1=request.getParameter("C1");
		String C2=request.getParameter("C2");
		String C3=request.getParameter("C3");
		String C4=request.getParameter("C4");
		
		String D1=request.getParameter("D1");
		String D2=request.getParameter("D2");
		String D3=request.getParameter("D3");
		String D4=request.getParameter("D4");
		
		String E1=request.getParameter("E1");
		String E2=request.getParameter("E2");
		String E3=request.getParameter("E3");
		String E4=request.getParameter("E4");
		
		Connection con=null;
		String url="jdbc:ucanaccess://E://Database//bus.accdb";
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			
			Cookie cookie[]=request.getCookies();
			for(Cookie c:cookie)
			{
				if(c.getName().equals("bfrom"))
				{
					bfrom=c.getValue();
				}
				if(c.getName().equals("bto"))
				{
					bto=c.getValue();
				}
				if(c.getName().equals("bdate"))
				{
					bdate=c.getValue();
				}
			}
			ResultSet rs=stmt.executeQuery("select * from bus where source='"+bfrom+"' and destination='"+bto+"'");
			while(rs.next())
			{
				bname=rs.getString("busname");
				time=rs.getString("time");
				bno=rs.getString("busno");
			}
			
			String amount=request.getParameter("amount");
			int amt=Integer.parseInt(amount);
			String url1="jdbc:ucanaccess://E://Database//swiftpay.accdb";
			Connection con1=DriverManager.getConnection(url1);
			Statement s=con1.createStatement();
			String dcardno=request.getParameter("dcardno");
			String dcvv=request.getParameter("dcvv");
			String ccardno=request.getParameter("ccardno");
			String ccvv=request.getParameter("ccvv");
			String rad=request.getParameter("rad");
			String upi=request.getParameter("upi");
			String bacc="";
			int bal=0;
			String dbdcard="",dbdcvv="";
			String name="",uniquecode="";
			int saccno=0,wallet=0;
			String useremail="";
			
			HttpSession session= request.getSession();
			String user=(String) session.getAttribute("username");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			ResultSet rsn=s.executeQuery("select * from user where username='"+user+"'");
			while(rsn.next())
			{
				name=rsn.getString("name");
				saccno=rsn.getInt("accno");
				wallet=rsn.getInt("wallet");
				uniquecode=rsn.getString("upi");
				useremail=rsn.getString("email");
			}
			if(upi.equals(uniquecode))
			{
				String[] arr=new String[21];
				int cnt=0;
				
				
				if(rad.equals("debit"))
				{
					
					ResultSet rs1=s.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
					while(rs1.next())
					{
						bacc=rs1.getString("accno");
						dbdcard=rs1.getString("cno");
						dbdcvv=rs1.getString("cvv");
					}
					
					ResultSet rs2=s.executeQuery("select * from bankaccount where accno='"+bacc+"'");
					while(rs2.next())
					{
						bal=rs2.getInt("balance");
					}
					int tot=bal-amt;
					String subject="Bus Ticket";
					
					
					if(dcardno.equals(dbdcard) && dcvv.equals(dbdcvv))
					{
						if(tot<=0)
						{
							//insufficient balance
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							if(A1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A1+"' ");
								ps.executeUpdate();
								arr[0]=A1;
								cnt++;
							}
							if(A2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A2+"' ");
								ps.executeUpdate();
								arr[1]=A2;
								cnt++;
							}
							if(A3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A3+"' ");
								ps.executeUpdate();
								arr[3]=A3;
								cnt++;
							}
							if(A4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A4+"' ");
								ps.executeUpdate();
								arr[4]=A4;
								cnt++;
							}
							
							
							
							if(B1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B1+"' ");
								ps.executeUpdate();
								arr[5]=B1;
								cnt++;
							}
							if(B2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B2+"' ");
								ps.executeUpdate();
								arr[6]=B2;
								cnt++;
							}
							if(B3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B3+"' ");
								ps.executeUpdate();
								arr[7]=B3;
								cnt++;
							}
							if(B4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B4+"' ");
								ps.executeUpdate();
								arr[8]=B4;
								cnt++;
							}
							
							
							
							if(C1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C1+"' ");
								ps.executeUpdate();
								arr[9]=C1;
								cnt++;
							}
							if(C2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C2+"' ");
								ps.executeUpdate();
								arr[10]=C2;
								cnt++;
							}
							if(C3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C3+"' ");
								ps.executeUpdate();
								arr[11]=C3;
								cnt++;
							}
							if(C4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C4+"' ");
								ps.executeUpdate();
								arr[12]=C4;
								cnt++;
							}
							
							
							
							if(D1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D1+"' ");
								ps.executeUpdate();
								arr[13]=D1;
								cnt++;
							}
							if(D2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D2+"' ");
								ps.executeUpdate();
								arr[14]=D2;
								cnt++;
							}
							if(D3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D3+"' ");
								ps.executeUpdate();
								arr[15]=D3;
								cnt++;
							}
							if(D4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D4+"' ");
								ps.executeUpdate();
								arr[16]=D4;
								cnt++;
							}
							
							
							
							if(E1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E1+"' ");
								ps.executeUpdate();
								arr[17]=E1;
								cnt++;
							}
							if(E2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E2+"' ");
								ps.executeUpdate();
								arr[18]=E2;
								cnt++;
							}
							if(E3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E3+"' ");
								ps.executeUpdate();
								arr[19]=E3;
								cnt++;
							}
							if(E4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E4+"' ");
								ps.executeUpdate();
								arr[20]=E4;
								cnt++;
							}
							
							for(int i=0;i<arr.length;i++)
							{
								if(arr[i]!=null) {
								 var=var+" "+arr[i];
								}
							}
							
							
							stmt.executeUpdate("insert into ticket(from,to,bdate,time,passenger,bno)values('"+bfrom+"','"+bto+"','"+bdate+"','"+time+"',"+cnt+",'"+bno+"')");
							
							String msg="<html><head></head><body>";
							msg+="<table height=\"300\" width=\"300\" style=\"background-color:#ff8080;\"><tr style=\"background-color:#ff3333;color:white;\"><td><b style=\"font-size:20px;\"><center>Passesger Ticket</center><br>Bus No.:"+bno+"</b></td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Date:"+bdate+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Time:"+time+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>From:"+bfrom+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>To:"+bto+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Seat No.:"+var+"</td></tr>";
							msg+="<tr style=\"background-color:#ff3333;color:white;\"><td><center><b style=\"font-size:20px;\">Bus Ticket</center></td></tr>";
							
							s.executeUpdate("update bankaccount SET balance="+tot+" where accno='"+bacc+"'");
							s.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Bus Ticket','"+dat+"','Debit Card',"+amt+","+saccno+")");
							Mailer.send(useremail, subject, msg);
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
					else
					{
						//no debit card found
						request.getRequestDispatcher("bus.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Debitcard\");");
						out.println("</script>");
					}
				}
				else if(rad.equals("credit"))
				{
					
					String subject="Bus Booking";
					int cbal=0;
					String ccno="";
					ResultSet rs3=s.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
					while(rs3.next())
					{
						cbal=rs3.getInt("balance");
						ccno=rs3.getString("cno");
					}
					if(ccno.equals(ccardno))
					{
						int ctot=cbal-amt;
						if(ctot<=0)
						{
							//invalid amount
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{

							if(A1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A1+"' ");
								ps.executeUpdate();
								arr[0]=A1;
								cnt++;
							}
							if(A2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A2+"' ");
								ps.executeUpdate();
								arr[1]=A2;
								cnt++;
							}
							if(A3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A3+"' ");
								ps.executeUpdate();
								arr[3]=A3;
								cnt++;
							}
							if(A4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A4+"' ");
								ps.executeUpdate();
								arr[4]=A4;
								cnt++;
							}
							
							
							
							if(B1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B1+"' ");
								ps.executeUpdate();
								arr[5]=B1;
								cnt++;
							}
							if(B2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B2+"' ");
								ps.executeUpdate();
								arr[6]=B2;
								cnt++;
							}
							if(B3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B3+"' ");
								ps.executeUpdate();
								arr[7]=B3;
								cnt++;
							}
							if(B4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B4+"' ");
								ps.executeUpdate();
								arr[8]=B4;
								cnt++;
							}
							
							
							
							if(C1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C1+"' ");
								ps.executeUpdate();
								arr[9]=C1;
								cnt++;
							}
							if(C2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C2+"' ");
								ps.executeUpdate();
								arr[10]=C2;
								cnt++;
							}
							if(C3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C3+"' ");
								ps.executeUpdate();
								arr[11]=C3;
								cnt++;
							}
							if(C4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C4+"' ");
								ps.executeUpdate();
								arr[12]=C4;
								cnt++;
							}
							
							
							
							if(D1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D1+"' ");
								ps.executeUpdate();
								arr[13]=D1;
								cnt++;
							}
							if(D2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D2+"' ");
								ps.executeUpdate();
								arr[14]=D2;
								cnt++;
							}
							if(D3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D3+"' ");
								ps.executeUpdate();
								arr[15]=D3;
								cnt++;
							}
							if(D4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D4+"' ");
								ps.executeUpdate();
								arr[16]=D4;
								cnt++;
							}
							
							
							
							if(E1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E1+"' ");
								ps.executeUpdate();
								arr[17]=E1;
								cnt++;
							}
							if(E2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E2+"' ");
								ps.executeUpdate();
								arr[18]=E2;
								cnt++;
							}
							if(E3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E3+"' ");
								ps.executeUpdate();
								arr[19]=E3;
								cnt++;
							}
							if(E4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E4+"' ");
								ps.executeUpdate();
								arr[20]=E4;
								cnt++;
							}
							
							for(int i=0;i<arr.length;i++)
							{
								if(arr[i]!=null) {
								 var=var+" "+arr[i];
								}
							}
							
							
							stmt.executeUpdate("insert into ticket(from,to,bdate,time,passenger,bno)values('"+bfrom+"','"+bto+"','"+bdate+"','"+time+"',"+cnt+",'"+bno+"')");
							String msg="<html><head></head><body>";
							msg+="<table height=\"300\" width=\"300\" style=\"background-color:#ff8080;\"><tr style=\"background-color:#ff3333;color:white;\"><td><b style=\"font-size:20px;\"><center>Passesger Ticket</center><br>Bus No.:"+bno+"</b></td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Date:"+bdate+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Time:"+time+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>From:"+bfrom+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>To:"+bto+"</td></tr>";
							msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Seat No.:"+var+"</td></tr>";
							msg+="<tr style=\"background-color:#ff3333;color:white;\"><td><center><b style=\"font-size:20px;\">Bus Ticket</center></td></tr>";
							
							s.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"' and cvv='"+ccvv+"'");
							s.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Bus Ticket','"+dat+"','Credit Card',"+amt+","+saccno+")");
							Mailer.send(useremail, subject, msg);
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("bus.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Debitcard\");");
						out.println("</script>");
					}
					
					
				}
				else if(rad.equals("wallet"))
				{
					
					String subject="Bus Booking";
					int wtot=wallet-amt;
					if(wtot<=0)
					{
						//insufficient balance	
						response.sendRedirect("transactionFailed.jsp");
					}
					else
					{
						if(A1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A1+"' ");
							ps.executeUpdate();
							arr[0]=A1;
							cnt++;
						}
						if(A2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A2+"' ");
							ps.executeUpdate();
							arr[1]=A2;
							cnt++;
						}
						if(A3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A3+"' ");
							ps.executeUpdate();
							arr[3]=A3;
							cnt++;
						}
						if(A4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+A4+"' ");
							ps.executeUpdate();
							arr[4]=A4;
							cnt++;
						}
						
						
						
						if(B1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B1+"' ");
							ps.executeUpdate();
							arr[5]=B1;
							cnt++;
						}
						if(B2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B2+"' ");
							ps.executeUpdate();
							arr[6]=B2;
							cnt++;
						}
						if(B3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B3+"' ");
							ps.executeUpdate();
							arr[7]=B3;
							cnt++;
						}
						if(B4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+B4+"' ");
							ps.executeUpdate();
							arr[8]=B4;
							cnt++;
						}
						
						
						
						if(C1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C1+"' ");
							ps.executeUpdate();
							arr[9]=C1;
							cnt++;
						}
						if(C2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C2+"' ");
							ps.executeUpdate();
							arr[10]=C2;
							cnt++;
						}
						if(C3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C3+"' ");
							ps.executeUpdate();
							arr[11]=C3;
							cnt++;
						}
						if(C4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+C4+"' ");
							ps.executeUpdate();
							arr[12]=C4;
							cnt++;
						}
						
						
						
						if(D1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D1+"' ");
							ps.executeUpdate();
							arr[13]=D1;
							cnt++;
						}
						if(D2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D2+"' ");
							ps.executeUpdate();
							arr[14]=D2;
							cnt++;
						}
						if(D3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D3+"' ");
							ps.executeUpdate();
							arr[15]=D3;
							cnt++;
						}
						if(D4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+D4+"' ");
							ps.executeUpdate();
							arr[16]=D4;
							cnt++;
						}
						
						
						
						if(E1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E1+"' ");
							ps.executeUpdate();
							arr[17]=E1;
							cnt++;
						}
						if(E2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E2+"' ");
							ps.executeUpdate();
							arr[18]=E2;
							cnt++;
						}
						if(E3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E3+"' ");
							ps.executeUpdate();
							arr[19]=E3;
							cnt++;
						}
						if(E4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+bname+" SET status='booked' where seat='"+E4+"' ");
							ps.executeUpdate();
							arr[20]=E4;
							cnt++;
						}
						
						for(int i=0;i<arr.length;i++)
						{
							if(arr[i]!=null) {
							 var=var+" "+arr[i];
							}
						}
						
						
						stmt.executeUpdate("insert into ticket(from,to,bdate,time,passenger,bno)values('"+bfrom+"','"+bto+"','"+bdate+"','"+time+"',"+cnt+",'"+bno+"')");
						String msg="<html><head></head><body>";
						msg+="<table height=\"300\" width=\"300\" style=\"background-color:#ff8080;\"><tr style=\"background-color:#ff3333;color:white;\"><td><b style=\"font-size:20px;\"><center>Passesger Ticket</center><br>Bus No.:"+bno+"</b></td></tr>";
						msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Date:"+bdate+"</td></tr>";
						msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Time:"+time+"</td></tr>";
						msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>From:"+bfrom+"</td></tr>";
						msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>To:"+bto+"</td></tr>";
						msg+="<tr style=\"background-color:#ff8080;color:white;\"><td>Seat No.:"+var+"</td></tr>";
						msg+="<tr style=\"background-color:#ff3333;color:white;\"><td><center><b style=\"font-size:20px;\">Bus Ticket</center></td></tr>";
						
						s.executeUpdate("update user SET wallet="+wtot+" where username='"+user+"'");
						s.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','Bus Ticket','"+dat+"','Wallet',"+amt+","+saccno+")");
						Mailer.send(useremail, subject, msg);
						response.sendRedirect("transactionSuccessfull.html");
					}
					
				}
			}
			else
			{
				//upi error
				response.sendRedirect("transactionFailed.jsp");
			}

			stmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
