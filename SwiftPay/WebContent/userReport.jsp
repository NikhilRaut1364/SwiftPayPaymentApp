<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>User Report</title>
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
		<h1 style="margin-bottom:15px;margin-top:20px;font-size:30px;color:#666666;">USER REPORT</h1>
		<table width="1200">
		
			<tr>
				<th style="font-size:20px;"><center>ACCNO</center></th>
				<th style="font-size:20px;"><center>NAME</center></th>
				<th style="font-size:20px;"><center>EMAIL</center></th>
				<th style="font-size:20px;"><center>PHONE NO.</center></th>
				<th style="font-size:20px;"><center>WALLET</center></th>
				<th style="font-size:20px;"><center>USERNAME</center></th>
				<th style="font-size:20px;"><center>PASSWORD</center></th>
				<th style="font-size:20px;"><center>UPI</center></th>
			</tr>
		
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%

	Connection con=null;
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();		
			ResultSet rs2=stmt.executeQuery("select * from user");
				while(rs2.next())
				{
%>

			
			<tr>
				<td style="font-size:20px;"><center><%out.println(rs2.getInt("accno")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getString("name")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getString("email")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getString("phno")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getInt("wallet")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getString("username")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getString("password")); %></center></td>
				<td style="font-size:20px;"><center><%out.println(rs2.getString("upi")); %></center></td>
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