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

public class Dino extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date dateobj=new Date();
		String dat=df.format(dateobj);
		
		HttpSession session= request.getSession();
		String user=(String) session.getAttribute("username");
		
		PrintWriter out=response.getWriter();
		String var="";
		
		String A1=request.getParameter("A1");
		String A2=request.getParameter("A2");
		String A3=request.getParameter("A3");
		String A4=request.getParameter("A4");
		String A5=request.getParameter("A5");
		String A6=request.getParameter("A6");
		
		String B1=request.getParameter("B1");
		String B2=request.getParameter("B2");
		String B3=request.getParameter("B3");
		String B4=request.getParameter("B4");
		String B5=request.getParameter("B5");
		String B6=request.getParameter("B6");
		
		String C1=request.getParameter("C1");
		String C2=request.getParameter("C2");
		String C3=request.getParameter("C3");
		String C4=request.getParameter("C4");
		String C5=request.getParameter("C5");
		String C6=request.getParameter("C6");
		
		String D1=request.getParameter("D1");
		String D2=request.getParameter("D2");
		String D3=request.getParameter("D3");
		String D4=request.getParameter("D4");
		String D5=request.getParameter("D5");
		String D6=request.getParameter("D6");
		
		String E1=request.getParameter("E1");
		String E2=request.getParameter("E2");
		String E3=request.getParameter("E3");
		String E4=request.getParameter("E4");
		String E5=request.getParameter("E5");
		String E6=request.getParameter("E6");
		
		String F1=request.getParameter("F1");
		String F2=request.getParameter("F2");
		String F3=request.getParameter("F3");
		String F4=request.getParameter("F4");
		String F5=request.getParameter("F5");
		String F6=request.getParameter("F6");
		
		Connection con=null;
		Connection con1=null;
		String url="jdbc:ucanaccess://E://Database//movie.accdb";
		String url1="jdbc:ucanaccess://E://Database//swiftpay.accdb";
		
		String etheater="",etime="",emdate="",tname="";
		String name="",uniquecode="",useremail="";
		int wallet=0,saccno=0;
		int amount=Integer.parseInt(request.getParameter("amount"));
		String upi=request.getParameter("upi");
		String rad=request.getParameter("rad");
		String dcardno=request.getParameter("dcardno");
		String dcvv=request.getParameter("dcvv");
		String ccardno=request.getParameter("ccardno");
		String ccvv=request.getParameter("ccvv");
		String subject="Movie Ticket";
		
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con=DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			
			con1=DriverManager.getConnection(url1);
			Statement stmt1 = con1.createStatement();
			
			Cookie cookie[]=request.getCookies();
			for(Cookie c:cookie)
			{
				if(c.getName().equals("dtheater"))
				{
					etheater=c.getValue();
				}
				if(c.getName().equals("dtime"))
				{
					etime=c.getValue();
				}
				if(c.getName().equals("dmdate"))
				{
					emdate=c.getValue();
				}
			}
			
			ResultSet rs=stmt.executeQuery("select * from dino where theater='"+etheater+"' and time='"+etime+"' and mdate='"+emdate+"'");
			while(rs.next())
			{
				tname=rs.getString("tname");
			}
			
			ResultSet rsn=stmt1.executeQuery("select * from user where username='"+user+"'");
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
				String[] arr=new String[37];
				int cnt=0;
				
				if(rad.equals("debit"))
				{
					String baccno="",dcno="",dcv="";
					int bbal=0;
					ResultSet rs2=stmt1.executeQuery("select * from debitcard where cno='"+dcardno+"' and cvv='"+dcvv+"'");
					while(rs2.next())
					{
						dcno=rs2.getString("cno");
						dcv=rs2.getString("cvv");
						baccno=rs2.getString("accno");
					}
					ResultSet rs3=stmt1.executeQuery("select * from bankaccount where accno='"+baccno+"'");
					while(rs3.next())
					{
						bbal=rs3.getInt("balance");
					}
					int btot=bbal-amount;
					if(dcardno.equals(dcno) && dcvv.equals(dcv))
					{
						if(btot<=0)
						{
							//transaction failed
							response.sendRedirect("transactionFailed.jsp");
						}
						else
						{
							if(A1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A1+"'");
								ps.executeUpdate();
								arr[0]=A1;
								cnt++;
							}
							if(A2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A2+"'");
								ps.executeUpdate();
								arr[1]=A2;
								cnt++;
							}
							if(A3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A3+"'");
								ps.executeUpdate();
								arr[2]=A3;
								cnt++;
							}
							if(A4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A4+"'");
								ps.executeUpdate();
								arr[3]=A4;
								cnt++;
							}
							if(A5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A5+"'");
								ps.executeUpdate();
								arr[4]=A5;
								cnt++;
							}
							if(A6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A6+"'");
								ps.executeUpdate();
								arr[5]=A6;
								cnt++;
							}
							
							
							if(B1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B1+"'");
								ps.executeUpdate();
								arr[6]=B1;
								cnt++;
							}
							if(B2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B2+"'");
								ps.executeUpdate();
								arr[7]=B2;
								cnt++;
							}
							if(B3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B3+"'");
								ps.executeUpdate();
								arr[8]=B3;
								cnt++;
							}
							if(B4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B4+"'");
								ps.executeUpdate();
								arr[9]=B4;
								cnt++;
							}
							if(B5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B5+"'");
								ps.executeUpdate();
								arr[10]=B5;
								cnt++;
							}
							if(B6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B6+"'");
								ps.executeUpdate();
								arr[11]=B6;
								cnt++;
							}
							
							
							if(C1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C1+"'");
								ps.executeUpdate();
								arr[12]=C1;
								cnt++;
							}
							if(C2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C2+"'");
								ps.executeUpdate();
								arr[13]=C2;
								cnt++;
							}
							if(C3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C3+"'");
								ps.executeUpdate();
								arr[14]=C3;
								cnt++;
							}
							if(C4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C4+"'");
								ps.executeUpdate();
								arr[15]=C4;
								cnt++;
							}
							if(C5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C5+"'");
								ps.executeUpdate();
								arr[16]=C5;
								cnt++;
							}
							if(C6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C6+"'");
								ps.executeUpdate();
								arr[17]=C6;
								cnt++;
							}
							
							
							if(D1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D1+"'");
								ps.executeUpdate();
								arr[18]=D1;
								cnt++;
							}
							if(D2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D2+"'");
								ps.executeUpdate();
								arr[19]=D2;
								cnt++;
							}
							if(D3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D3+"'");
								ps.executeUpdate();
								arr[20]=D3;
								cnt++;
							}
							if(D4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D4+"'");
								ps.executeUpdate();
								arr[21]=D4;
								cnt++;
							}
							if(D5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D5+"'");
								ps.executeUpdate();
								arr[22]=D5;
								cnt++;
							}
							if(D6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D6+"'");
								ps.executeUpdate();
								arr[23]=D6;
								cnt++;
							}
							
							
							if(E1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E1+"'");
								ps.executeUpdate();
								arr[24]=E1;
								cnt++;
							}
							if(E2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E2+"'");
								ps.executeUpdate();
								arr[25]=E2;
								cnt++;
							}
							if(E3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E3+"'");
								ps.executeUpdate();
								arr[26]=E3;
								cnt++;
							}
							if(E4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E4+"'");
								ps.executeUpdate();
								arr[27]=E4;
								cnt++;
							}
							if(E5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E5+"'");
								ps.executeUpdate();
								arr[28]=E5;
								cnt++;
							}
							if(E6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E6+"'");
								ps.executeUpdate();
								arr[29]=E6;
								cnt++;
							}
							
							
							if(F1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F1+"'");
								ps.executeUpdate();
								arr[30]=F1;
								cnt++;
							}
							if(F2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F2+"'");
								ps.executeUpdate();
								arr[31]=F2;
								cnt++;
							}
							if(F3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F3+"'");
								ps.executeUpdate();
								arr[32]=F3;
								cnt++;
							}
							if(F4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F4+"'");
								ps.executeUpdate();
								arr[33]=F4;
								cnt++;
							}
							if(F5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F5+"'");
								ps.executeUpdate();
								arr[34]=F5;
								cnt++;
							}
							if(F6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F6+"'");
								ps.executeUpdate();
								arr[35]=F6;
								cnt++;
							}
							
							for(int i=0;i<arr.length;i++)
							{
								if(arr[i]!=null) {
								 var=var+" "+arr[i];
								}
							}
							
							String msg="<html><head><style type=\"text/css\">body{font-family:candara;}table{background-color:#25488e;font-size:15px;color:white;font-family:candara;width:300px}i{color:white;font-size:20px;}</style></head><body>";
							msg+="<table height=\"300\"><tr><td><center><b style=\"font-size:20px;\">Movie Ticket</b></center></td></tr>";
							msg+="<tr><td>Movie Name: The Good Dinosaur</td></tr>";
							msg+="<tr><td>Date: "+emdate+"</td></tr>";
							msg+="<tr><td>Time: "+etime+"</td></tr>";
							msg+="<tr><td>Seat: "+var+"</td></tr>";
							msg+="</table></body></html>";
							
							stmt1.executeUpdate("update bankaccount SET balance="+btot+" where accno='"+baccno+"'");
							stmt1.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','"+cnt+" Movie Ticket','"+dat+"','Debit Card',"+amount+","+saccno+")");
							Mailer.send(useremail, subject, msg);
							response.sendRedirect("transactionSuccessfull.html");
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("dino1.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Debitcard\");");
						out.println("</script>");
					}
				}
				else if(rad.equals("credit"))
				{
					String ccno="",ccv="";
					int cbal=0;
					ResultSet rs4=stmt1.executeQuery("select * from creditcard where cno='"+ccardno+"' and cvv='"+ccvv+"'");
					while(rs4.next())
					{
						ccno=rs4.getString("cno");
						ccv=rs4.getString("cvv");
						cbal=rs4.getInt("balance");
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
							if(A1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A1+"'");
								ps.executeUpdate();
								arr[0]=A1;
								cnt++;
							}
							if(A2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A2+"'");
								ps.executeUpdate();
								arr[1]=A2;
								cnt++;
							}
							if(A3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A3+"'");
								ps.executeUpdate();
								arr[2]=A3;
								cnt++;
							}
							if(A4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A4+"'");
								ps.executeUpdate();
								arr[3]=A4;
								cnt++;
							}
							if(A5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A5+"'");
								ps.executeUpdate();
								arr[4]=A5;
								cnt++;
							}
							if(A6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A6+"'");
								ps.executeUpdate();
								arr[5]=A6;
								cnt++;
							}
							
							
							if(B1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B1+"'");
								ps.executeUpdate();
								arr[6]=B1;
								cnt++;
							}
							if(B2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B2+"'");
								ps.executeUpdate();
								arr[7]=B2;
								cnt++;
							}
							if(B3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B3+"'");
								ps.executeUpdate();
								arr[8]=B3;
								cnt++;
							}
							if(B4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B4+"'");
								ps.executeUpdate();
								arr[9]=B4;
								cnt++;
							}
							if(B5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B5+"'");
								ps.executeUpdate();
								arr[10]=B5;
								cnt++;
							}
							if(B6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B6+"'");
								ps.executeUpdate();
								arr[11]=B6;
								cnt++;
							}
							
							
							if(C1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C1+"'");
								ps.executeUpdate();
								arr[12]=C1;
								cnt++;
							}
							if(C2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C2+"'");
								ps.executeUpdate();
								arr[13]=C2;
								cnt++;
							}
							if(C3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C3+"'");
								ps.executeUpdate();
								arr[14]=C3;
								cnt++;
							}
							if(C4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C4+"'");
								ps.executeUpdate();
								arr[15]=C4;
								cnt++;
							}
							if(C5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C5+"'");
								ps.executeUpdate();
								arr[16]=C5;
								cnt++;
							}
							if(C6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C6+"'");
								ps.executeUpdate();
								arr[17]=C6;
								cnt++;
							}
							
							
							if(D1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D1+"'");
								ps.executeUpdate();
								arr[18]=D1;
								cnt++;
							}
							if(D2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D2+"'");
								ps.executeUpdate();
								arr[19]=D2;
								cnt++;
							}
							if(D3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D3+"'");
								ps.executeUpdate();
								arr[20]=D3;
								cnt++;
							}
							if(D4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D4+"'");
								ps.executeUpdate();
								arr[21]=D4;
								cnt++;
							}
							if(D5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D5+"'");
								ps.executeUpdate();
								arr[22]=D5;
								cnt++;
							}
							if(D6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D6+"'");
								ps.executeUpdate();
								arr[23]=D6;
								cnt++;
							}
							
							
							if(E1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E1+"'");
								ps.executeUpdate();
								arr[24]=E1;
								cnt++;
							}
							if(E2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E2+"'");
								ps.executeUpdate();
								arr[25]=E2;
								cnt++;
							}
							if(E3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E3+"'");
								ps.executeUpdate();
								arr[26]=E3;
								cnt++;
							}
							if(E4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E4+"'");
								ps.executeUpdate();
								arr[27]=E4;
								cnt++;
							}
							if(E5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E5+"'");
								ps.executeUpdate();
								arr[28]=E5;
								cnt++;
							}
							if(E6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E6+"'");
								ps.executeUpdate();
								arr[29]=E6;
								cnt++;
							}
							
							
							if(F1!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F1+"'");
								ps.executeUpdate();
								arr[30]=F1;
								cnt++;
							}
							if(F2!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F2+"'");
								ps.executeUpdate();
								arr[31]=F2;
								cnt++;
							}
							if(F3!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F3+"'");
								ps.executeUpdate();
								arr[32]=F3;
								cnt++;
							}
							if(F4!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F4+"'");
								ps.executeUpdate();
								arr[33]=F4;
								cnt++;
							}
							if(F5!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F5+"'");
								ps.executeUpdate();
								arr[34]=F5;
								cnt++;
							}
							if(F6!=null)
							{
								PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F6+"'");
								ps.executeUpdate();
								arr[35]=F6;
								cnt++;
							}
							
							for(int i=0;i<arr.length;i++)
							{
								if(arr[i]!=null) {
								 var=var+" "+arr[i];
								}
							}
							
							String msg="<html><head><style type=\"text/css\">body{font-family:candara;}table{background-color:#25488e;font-size:15px;color:white;font-family:candara;width:300px}i{color:white;font-size:20px;}</style></head><body>";
							msg+="<table height=\"300\"><tr><td><center><b style=\"font-size:20px;\">Movie Ticket</b></center></td></tr>";
							msg+="<tr><td>Movie Name: The Good Dinosaur</td></tr>";
							msg+="<tr><td>Date: "+emdate+"</td></tr>";
							msg+="<tr><td>Time: "+etime+"</td></tr>";
							msg+="<tr><td>Seat: "+var+"</td></tr>";
							msg+="</table></body></html>";
							
							stmt1.executeUpdate("update creditcard SET balance="+ctot+" where cno='"+ccardno+"'");
							stmt1.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','"+cnt+" Movie Ticket','"+dat+"','Credit Card',"+amount+","+saccno+")");
							Mailer.send(useremail, subject, msg);
							response.sendRedirect("transactionSuccessfull.html");
							
						}
					}
					else
					{
						//invalid card
						request.getRequestDispatcher("dino1.jsp").include(request, response);
						out.println("<script type=\"text/javascript\">");
						out.println("alert(\"Invalid Debitcard\");");
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
						if(A1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A1+"'");
							ps.executeUpdate();
							arr[0]=A1;
							cnt++;
						}
						if(A2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A2+"'");
							ps.executeUpdate();
							arr[1]=A2;
							cnt++;
						}
						if(A3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A3+"'");
							ps.executeUpdate();
							arr[2]=A3;
							cnt++;
						}
						if(A4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A4+"'");
							ps.executeUpdate();
							arr[3]=A4;
							cnt++;
						}
						if(A5!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A5+"'");
							ps.executeUpdate();
							arr[4]=A5;
							cnt++;
						}
						if(A6!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+A6+"'");
							ps.executeUpdate();
							arr[5]=A6;
							cnt++;
						}
						
						
						if(B1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B1+"'");
							ps.executeUpdate();
							arr[6]=B1;
							cnt++;
						}
						if(B2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B2+"'");
							ps.executeUpdate();
							arr[7]=B2;
							cnt++;
						}
						if(B3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B3+"'");
							ps.executeUpdate();
							arr[8]=B3;
							cnt++;
						}
						if(B4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B4+"'");
							ps.executeUpdate();
							arr[9]=B4;
							cnt++;
						}
						if(B5!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B5+"'");
							ps.executeUpdate();
							arr[10]=B5;
							cnt++;
						}
						if(B6!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+B6+"'");
							ps.executeUpdate();
							arr[11]=B6;
							cnt++;
						}
						
						
						if(C1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C1+"'");
							ps.executeUpdate();
							arr[12]=C1;
							cnt++;
						}
						if(C2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C2+"'");
							ps.executeUpdate();
							arr[13]=C2;
							cnt++;
						}
						if(C3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C3+"'");
							ps.executeUpdate();
							arr[14]=C3;
							cnt++;
						}
						if(C4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C4+"'");
							ps.executeUpdate();
							arr[15]=C4;
							cnt++;
						}
						if(C5!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C5+"'");
							ps.executeUpdate();
							arr[16]=C5;
							cnt++;
						}
						if(C6!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+C6+"'");
							ps.executeUpdate();
							arr[17]=C6;
							cnt++;
						}
						
						
						if(D1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D1+"'");
							ps.executeUpdate();
							arr[18]=D1;
							cnt++;
						}
						if(D2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D2+"'");
							ps.executeUpdate();
							arr[19]=D2;
							cnt++;
						}
						if(D3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D3+"'");
							ps.executeUpdate();
							arr[20]=D3;
							cnt++;
						}
						if(D4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D4+"'");
							ps.executeUpdate();
							arr[21]=D4;
							cnt++;
						}
						if(D5!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D5+"'");
							ps.executeUpdate();
							arr[22]=D5;
							cnt++;
						}
						if(D6!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+D6+"'");
							ps.executeUpdate();
							arr[23]=D6;
							cnt++;
						}
						
						
						if(E1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E1+"'");
							ps.executeUpdate();
							arr[24]=E1;
							cnt++;
						}
						if(E2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E2+"'");
							ps.executeUpdate();
							arr[25]=E2;
							cnt++;
						}
						if(E3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E3+"'");
							ps.executeUpdate();
							arr[26]=E3;
							cnt++;
						}
						if(E4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E4+"'");
							ps.executeUpdate();
							arr[27]=E4;
							cnt++;
						}
						if(E5!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E5+"'");
							ps.executeUpdate();
							arr[28]=E5;
							cnt++;
						}
						if(E6!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+E6+"'");
							ps.executeUpdate();
							arr[29]=E6;
							cnt++;
						}
						
						
						if(F1!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F1+"'");
							ps.executeUpdate();
							arr[30]=F1;
							cnt++;
						}
						if(F2!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F2+"'");
							ps.executeUpdate();
							arr[31]=F2;
							cnt++;
						}
						if(F3!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F3+"'");
							ps.executeUpdate();
							arr[32]=F3;
							cnt++;
						}
						if(F4!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F4+"'");
							ps.executeUpdate();
							arr[33]=F4;
							cnt++;
						}
						if(F5!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F5+"'");
							ps.executeUpdate();
							arr[34]=F5;
							cnt++;
						}
						if(F6!=null)
						{
							PreparedStatement ps=con.prepareStatement("update "+tname+" SET status='booked' where seat='"+F6+"'");
							ps.executeUpdate();
							arr[35]=F6;
							cnt++;
						}
						
						for(int i=0;i<arr.length;i++)
						{
							if(arr[i]!=null) {
							 var=var+" "+arr[i];
							}
						}
						
						String msg="<html><head><style type=\"text/css\">body{font-family:candara;}table{background-color:#25488e;font-size:15px;color:white;font-family:candara;width:300px}i{color:white;font-size:20px;}</style></head><body>";
						msg+="<table height=\"300\"><tr><td><center><b style=\"font-size:20px;\">Movie Ticket</b></center></td></tr>";
						msg+="<tr><td>Movie Name: The Good Dinosaur</td></tr>";
						msg+="<tr><td>Date: "+emdate+"</td></tr>";
						msg+="<tr><td>Time: "+etime+"</td></tr>";
						msg+="<tr><td>Seat: "+var+"</td></tr>";
						msg+="</table></body></html>";
						
						stmt1.executeUpdate("update user SET wallet="+wtot+" where username='"+user+"'");
						stmt1.executeUpdate("insert into transaction(uname,tname,tdate,pmethod,amount,accno)values('"+name+"','"+cnt+" Movie Ticket','"+dat+"','Wallet',"+amount+","+saccno+")");
						Mailer.send(useremail, subject, msg);
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
			System.out.println(e);
		}
	}

}
