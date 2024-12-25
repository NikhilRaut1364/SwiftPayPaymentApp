<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Heritage Transaction Report</title>
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
height:800px;
width:100%;
background-color:white;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height: 600px;
width: 80%;
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
	<div class="home" onclick="document.location.href='adminDash.jsp'">
	<i class="fas fa-home" style="color:white; font-size:40px;"></i>
	<span style="font-size:30px;color:white;">Home</span>
	</div>
</div>
<div class="parent">
	<div class="child">
		<h1 style="margin-bottom:15px;margin-top:20px;font-size:30px;color:#666666;">HERITAGE TRANSACTION REPORT</h1>
		<table width="1200">
		
			<tr>
				<th style="font-size:20px;"><center>TID</center></th>
				<th style="font-size:20px;"><center>PAYMENT</center></th>
				<th style="font-size:20px;"><center>AMOUNT</center></th>
			</tr>
		
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%

	Connection con=null;
	String url="jdbc:ucanaccess://E://Database//heritage.accdb";
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();		
			ResultSet rs2=stmt.executeQuery("select * from transaction");
				while(rs2.next())
				{
%>

			
			<tr>
				<td style="font-size:20px;"><center><%out.println(rs2.getInt("tid")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getString("payment")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getInt("amount")); %></center></td>
			</tr>
		
<%
				
			}
			
				
		
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