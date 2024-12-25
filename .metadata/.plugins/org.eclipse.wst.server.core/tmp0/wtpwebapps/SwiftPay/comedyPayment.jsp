<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Comedy Payment</title>
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
height:800px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:700px;
width:600px;
background-color:white;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
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
.t1{
display:none;
}
.t2{
display:none;
}
</style>
<script src='javascript/jquery-3.4.1.js'>
</script>
<script type="text/javascript">
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
<form method="POST" action="Comedy">
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
Connection con=null;
String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";

String edate=request.getParameter("edate");
String time=request.getParameter("time");
int quantity=Integer.parseInt(request.getParameter("quantity"));
int amt=500;
int amount=0;
String ed="",t="";

try{
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	con=DriverManager.getConnection(url);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from event where edate='"+edate+"' and time='"+time+"'and ename='Comedy'");
	while(rs.next())
	{
		ed=rs.getString("edate");
		t=rs.getString("time");
	}
	if(ed.equals(edate) && t.equals(time) && quantity!=0)
	{
		amount=amt*quantity;
	}
	else
	{%>
		<script type="text/javascript">
		alert("Wrong Input");
		document.location.href="comedy.jsp";
		</script>
	<%}
	
}catch(Exception e)
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
		<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Payment</h1>
		<table style="height:600px;width:500px;">
		<tr>
			<td><center><input type="text" name="edate" value='<% out.println(request.getParameter("edate")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
		</tr>
		<tr>
			<td><center><input type="text" name="time" value='<% out.println(request.getParameter("time")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
		</tr>
		<tr>
			<td><center><input type="text" name="quantity" value='<% out.println(request.getParameter("quantity")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
		</tr>
		<tr>
			<td><center><input type="text" name="amount" value='<%out.println(amount); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
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
			<td><center><input type="submit" value="Pay" class="b1"></center></td>
		</tr>
		</table>
	</div>
</div>

</form>
</body>
</html>