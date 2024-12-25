<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Payment</title>
<style type="text/css">
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
height:650px;
width:600px;
background-color:white;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
}
.t1{
display:none;
}
.t2{
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
	$(".t2").hide();
	$(".t1").toggle("slow");
	});
	$("#r2").click(function(){
	$(".t1").hide();
	$(".t2").toggle("slow");
	});
	$("#r3").click(function(){
	$(".t1").hide();
	$(".t2").hide();
	});
	});
</script>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="Train" method="POST">
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
Connection con=null;
String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
String from=request.getParameter("from");
String to=request.getParameter("to");
String fclass=request.getParameter("fclass");
String fdate=request.getParameter("fdate");
int traveller=Integer.parseInt(request.getParameter("traveller"));
Cookie cookie23=new Cookie("traveller",traveller+"");
response.addCookie(cookie23);
String f="",t="",fda="",fc="";
int tot=0;
if(traveller==0)
{
	//Value cannot be zero
}
try{
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	con=DriverManager.getConnection(url);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from train where source='"+from+"' and destination='"+to+"' and tdate='"+fdate+"' and class='"+fclass+"'");
	while(rs.next())
	{
		f=rs.getString("source");
		t=rs.getString("destination");
		fda=rs.getString("tdate");
		fc=rs.getString("class");
	}
	if(from.equals(f) && to.equals(t) && fdate.equals(fda) && fclass.equals(fc))
	{
		if(fclass.equals("GC"))
		{
			int amt=100;
			tot=amt*traveller;
		}
		else if(fclass.equals("2S"))
		{
			int amt=250;
			tot=amt*traveller;
		}
		else if(fclass.equals("CC"))
		{
			int amt=500;
			tot=amt*traveller;
		}
	}
	else
	{%>
		<script type="text/javascript">
		alert("No Flight Available");
		document.location.href="flight.jsp";
		</script>
	<%}
}
catch(Exception e)
{
	
}
%>
<div class="header">
	<div class="plane">
	<i class="fas fa-paper-plane" style="color:white; font-size:50px;"></i>
	&nbsp&nbsp&nbsp
	<span style="font-size:35px;color:white;">SwiftPay</span>
	</div>
</div>
<div class="parent">
	<div class="child">
	<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Train Payment</h1>
		<table height="550" width="500">
			<tr>
				<td><center><input type="text" name="from" value="<%out.println(f); %>" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="to" value="<%out.println(t); %>" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="fclass" value="<%out.println(fclass); %>" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="fdate" value="<%out.println(fdate); %>" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="amount" value="<%out.println(tot); %>" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center>
					<h3>Payment Method:</h3><br>
					<input type="radio" id="r1" name="rad" value="debit">&nbsp&nbsp<font style="font-size:20px;">Debit Card</font><br>
					<input type="text" autocomplete="off" name="dcardno" class="t1" placeholder="Card Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">&nbsp&nbsp&nbsp&nbsp<input type="text" autocomplete="off" name="dcvv" class="t1" placeholder="CVV Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
					<br><br>
					<input type="radio" id="r2" name="rad" value="credit">&nbsp&nbsp<font style="font-size:20px;">Credit Card</font><br>
					<input type="text" autocomplete="off" name="ccardno" class="t2" placeholder="Card Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">&nbsp&nbsp&nbsp&nbsp<input type="text" autocomplete="off" name="ccvv" class="t2" placeholder="CVV Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
					<br><br>
					<input type="radio" id="r3" name="rad" value="wallet">&nbsp&nbsp<font style="font-size:20px;">Wallet</font><br>
				</center></td>
			</tr>
			<tr>
				<td><center><input type="text" autocomplete="off" name="upi" placeholder="4-Digit Code" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="submit" value="Check Flight" class="b1"></center></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>