<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Profile</title>
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
justify-content:space-around;
align-items:center;
}
.parent{
height:900px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;;
align-items:center;
flex-direction:column;

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
.child{
height:650px;
width:70%;
background-color:white;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
border-radius:20px;
}
.profile{
height:150px;
width:100%;
border-radius:20px;
display:flex;
justify-content:center;
align-items:center;
}
.desc{
height:500px;
width:100%;
border-radius:20px;
display:flex;
justify-content:center;
align-items:center;
}
.img{
height:250px;
width:250px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
margin-bottom:100px;
background-color:white;
border-radius:50%;
}
.personal{
height:450px;
width:500px;
display:flex;
align-items:center;
justify-content:center;
}
.info{
height:450px;
width:500px;
display:flex;
align-items:center;
justify-content:space-around;
flex-direction:column;
}
.icon{
height:80px;
width:350px;
display:flex;
justify-content:center;
align-items:center;
}
.icon-1{
height:80px;
width:150px;
display:flex;
justify-content:center;
align-items:center;
}
</style>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
	String n="";
	String e="";
	String ph="";
	int w=0;
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
			n=rs.getString("name");
			e=rs.getString("email");
			ph=rs.getString("phno");
			w=rs.getInt("wallet");
		}
	}
	catch(Exception exc)
	{
		
	}
%>
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
		<div class="profile">
			<div class="img">
				<i class="fas fa-user-alt" style="font-size:120px;color:#25488e;margin-bottom:20px;"></i>
				<label style="font-size:30px;">Hello, <% out.println(n); %></label>
			</div>
		</div>
		<div class="desc">
			<div class="personal">
				<table style="height:400px;width:450px;">
					<tr>
						<td colspan="2" style="font-size:23px;"><center>Personal Information</center></td>
					</tr>
					<tr>
						<td><span style="font-size:23px;">Name</span></td>
						<td><span style="font-size:23px;"><% out.println(n); %></span></td>
					</tr>
					<tr>
						<td><span style="font-size:23px;">Email Id</span></td>
						<td><span style="font-size:23px;"><% out.println(e); %></span></td>
					</tr>
					<tr>
						<td><span style="font-size:23px;">Contact Number</span></td>
						<td><span style="font-size:23px;"><% out.println(ph); %></span></td>
					</tr>
				</table>
			</div>
			<div class="info">
				<div class="icon">
					<div class="icon-1">
						<i class="fas fa-history" style="font-size:50px;color:#25488e;"></i>
					</div>
					<div class="icon-1">
						<span style="font-size:23px;cursor:pointer;" onclick="document.location.href='TransactionHistory.jsp'">History</span>
					</div>
				</div>
				<div class="icon">
				<div class="icon-1">
					<i class="fas fa-wallet" style="font-size:50px;color:#25488e;"></i>
				</div>
				<div class="icon-1">
					<i class="fas fa-rupee-sign" style="font-size:23px;margin-right:5px;"></i>
					<span style="font-size:23px;"><% out.println(w); %></span>
				</div>
				</div>
				<div class="icon">
				<div class="icon-1">
					<i class="fas fa-coins" style="font-size:50px;color:#25488e;"></i>
				</div>
				<div class="icon-1">
					<span style="font-size:23px;cursor:pointer;" onclick="document.location.href='addmoneywallet.jsp'">Add Money</span>
				</div>
				</div>
				<div class="icon">
					<span style="font-size:23px;cursor:pointer;" onclick="document.location.href='changePass.jsp'">Change Password</span>
				</div>
			</div>
		</div>
	</div>
</div>
</form>
</body>
</html>