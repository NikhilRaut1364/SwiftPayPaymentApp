<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Check Balance</title>
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
height:605px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:500px;
width:500px;
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
</style>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
String ifsc=request.getParameter("ifsc");
String ano=request.getParameter("ano");
String acccno="",bifsc="",name="";
int bal=0;

Connection con=null;
String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";

try{
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	con=DriverManager.getConnection(url);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from bankaccount where accno='"+ano+"' and ifsc='"+ifsc+"'");
	while(rs.next())
	{
		acccno=rs.getString("accno");
		name=rs.getString("name");
		bifsc=rs.getString("ifsc");
		bal=rs.getInt("balance");
	}
	if(!ano.equals(acccno) && !ifsc.equals(bifsc))
	{%>
		<script type="text/javascript">
		alert("Enter Correct Account Number And Ifsc Code");
		document.location.href="broadband1.jsp";
		</script>
	<% }
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
		<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Bank Balance</h1>
		<table width="400" height="300">
			<tr>
				<td><span style="font-size:20px;">Account Number:&nbsp&nbsp<%out.println(acccno); %></span></td>
			</tr>
			<tr>
				<td><span style="font-size:20px;">Name:&nbsp&nbsp<%out.println(name); %></span></td>
			</tr>
			<tr>
				<td><span style="font-size:20px;">Balance:&nbsp&nbsp<%out.println(bal); %></span></td>
			</tr>
			<tr>
				<td><center><input type="button" value="Back" class="b1" onclick="document.location.href='main.jsp'"></center></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>