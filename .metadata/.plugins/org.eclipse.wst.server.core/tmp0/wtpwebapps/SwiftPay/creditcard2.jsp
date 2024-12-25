<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Credit Card Payment</title>
<style>
*{
margin:0px;
font-family:candara;
}
.header{
height:150px;
width:100%;
background-color:#25488e;
display:flex;
align-items:center;
}
.plane{
height:100px;
width:250px;
display:flex;
justify-content:center;
align-items:center;
margin-left:30px;
}
.parent{
height:750px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:600px;
width:600px;
background-color:white;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
}
.t1{
display:none;
}
.b1{
height:35px;
width:300px;
font-size:20px;
border-radius:4px;
}
.b1:hover{
cursor:pointer;
background-color:#25488e;
color:white;
}
</style>
<script src='javascript/jquery-3.4.1.js'>
</script>
<script>
$(function(){
	$("#r1").click(function(){
	$(".t1").toggle("slow");
	});
	});
</script>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
	int flag=0;
	String bill="";
	String status="";
	Connection con=null;
	String cno=request.getParameter("cno");
	String cvv=request.getParameter("cvv");
	String cardnumber=cno, creditcard="";
	String cardcvv=cvv, creditcvv="";
	String sql="select * from creditcardbill where cno='"+cno+"' and cvv='"+cvv+"'";
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			//status=rs.getString("status");
			creditcard=rs.getString("cno");
			creditcvv=rs.getString("cvv");
			if(cardnumber.equals(creditcard) && cardcvv.equals(creditcvv))
			{
				flag=1;
				break;
			}
			else
			{
				flag=0;
			}
		}
		if(flag==1)
		{
			ResultSet rs1=stmt.executeQuery(sql);
			while(rs1.next())
			{
				status=rs1.getString("status");
				if(status.equals("pending"))
				{
					bill=rs1.getString("billamt");
				}
				else if(status.equals("paid"))
				{
					request.getRequestDispatcher("creditcard1.jsp").include(request, response);
					out.println("<script type=\"text/javascript\">");
					out.println("alert(\"No Pending Bill\");");
					out.println("</script>");
				}
			}
		}
		else
		{
			request.getRequestDispatcher("creditcard1.jsp").include(request, response);
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Record Not Found\");");
			out.println("</script>");
		}
	}
	catch(Exception e)
	{
		
	}
	
%>
<form action="CreditCard" method="POST">
<div class="header">
	<div class="plane">
	<i class="fas fa-paper-plane" style="color:white; font-size:50px;"></i>
	&nbsp&nbsp&nbsp
	<span style="font-size:35px;color:white;">SwiftPay</span>
	</div>
</div>
<div class="parent">
	<div class="child">
		<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Credit Card Bill Payment</h1>
		<table style="height:500px;width:500px;">
			<tr>
				<td><center><input type="text" name="cno" value='<% out.println(request.getParameter("cno")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="cvv" value='<% out.println(request.getParameter("cvv")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="amount" value='<% out.println(bill);%>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
			<td><center>
			<h3>Payment Method:</h3><br>
			<label id="r1" name="rad" value="debit">&nbsp&nbsp<font style="font-size:20px;">Debit Card</font><br></label>
			<input type="text" autocomplete="off" name="dcardno" class="t1" placeholder="Card Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">&nbsp&nbsp&nbsp&nbsp<input type="text" autocomplete="off" name="dcvv" class="t1" placeholder="CVV Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
			</center></td>
		</tr>
		<tr>
				<td><center><input type="text" autocomplete="off" name="upi" placeholder="4-Digit Code" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
		</tr>
		<tr>
			<td><center><input type="submit" value="Pay" class="b1"></center></td>
		</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>