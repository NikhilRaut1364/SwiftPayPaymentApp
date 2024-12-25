<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Notification</title>
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
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height: 600px;
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
		<h1 style="margin-bottom:15px;margin-top:20px;font-size:30px;color:#666666;">Notification</h1>
		<table width="600">
		
			<tr>
				<th style="font-size:20px;"><center>Date</center></th>
				<th style="font-size:20px;"><center>Message</center></th>
				<th style="font-size:20px;"><center>From</center></th>
			</tr>
		
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
	int uaccno=0;
	int recaccno=0;
	String dat="";
	String message="";
	String from="";
	Connection con=null;
	String uname=(String)session.getAttribute("username");
	String sql="select * from user where username='"+uname+"'";
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			uaccno=rs.getInt("accno");
		}
		ResultSet rs1=stmt.executeQuery("select * from notification where recaccno="+uaccno+"");
		while(rs1.next())
		{
			recaccno=rs1.getInt("recaccno");
		}
		if(uaccno==recaccno)
		{
			ResultSet rs2=stmt.executeQuery("select * from notification where recaccno="+uaccno+" ORDER BY ID DESC");
				while(rs2.next())
				{
					dat=rs2.getString("ndate");
					message=rs2.getString("message");
					from=rs2.getString("from");
%>

			
			<tr>
				<td style="font-size:20px;"><center><%out.println(dat); %></center></td>
				<td style="font-size:20px;"><center><%out.println(message); %></center></td>
				<td style="font-size:20px;"><center><%out.println(from); %></center></td>
			</tr>
		
<%
				
			}
			
				
		}
		else
		{
			//no notification
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