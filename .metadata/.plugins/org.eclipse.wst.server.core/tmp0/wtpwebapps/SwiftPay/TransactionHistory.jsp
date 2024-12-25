<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>
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
justify-content:space-around;
align-items:center;
}
.plane{
height:100px;
width:250px;
display:flex;
justify-content:center;
align-items:center;
}
.title{
height:120px;
width:700px;
}
.home{
height:120px;
width:120px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
}
.home:hover{
cursor:pointer;
}
.parent{
height:900px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height: 800px;
width: 800px;
background-color: white;
display: flex;

align-items: center;
flex-direction: column;
}
</style>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form>
<div class="header">
	<div class="plane">
	<i class="fas fa-paper-plane" style="color:white; font-size:50px;"></i>
	&nbsp&nbsp&nbsp
	<span style="font-size:35px;color:white;">SwiftPay</span>
	</div>
	<div class="title">
	</div>
	<div class="home" onclick="document.location.href='main.jsp'">
	<i class="fas fa-home" style="color:white; font-size:40px;"></i>
	<span style="font-size:30px;color:white;">Home</span>
	</div>
</div>
<div class="parent">
	<div class="child">
		<h1 style="margin-bottom:15px;margin-top:20px;font-size:30px;color:#666666;">Transaction History</h1>
		<table width="600">
		
			<tr>
				<th style="font-size:20px;"><center>Date</center></th>
				<th style="font-size:20px;"><center>Transaction</center></th>
				<th style="font-size:20px;"><center>Payment Method</center></th>
				<th style="font-size:20px;"><center>Amount</center></th>
			</tr>
		
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
int uaccno=0;
String tname="",tdate="",pmethod="";
int amount=0;
Connection con=null;
String user=(String)session.getAttribute("username");
String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
try{
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	con=DriverManager.getConnection(url);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from user where username='"+user+"'");
	while(rs.next())
	{
		uaccno=rs.getInt("accno");
	}
	ResultSet rs1=stmt.executeQuery("select * from transaction where accno="+uaccno+" ORDER BY tid DESC");
	while(rs1.next())
	{
		tname=rs1.getString("tname");
		tdate=rs1.getString("tdate");
		pmethod=rs1.getString("pmethod");
		amount=rs1.getInt("amount");
		%>
		
			<tr>
				<td style="font-size:20px;"><center><%out.println(tdate); %></center></td>
				<td style="font-size:20px;"><center><%out.println(tname); %></center></td>
				<td style="font-size:20px;"><center><%out.println(pmethod); %></center></td>
				<td style="font-size:20px;"><center><%out.println(amount); %></center></td>
			</tr>
		
	<%}
	
}
catch(Exception e)
{
	
}
%>
		
		
		
		
		</table>
	</div>
</div>
</form>
</body>
</html>