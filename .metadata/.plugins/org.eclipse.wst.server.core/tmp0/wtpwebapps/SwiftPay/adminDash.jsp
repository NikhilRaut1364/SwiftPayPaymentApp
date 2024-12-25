<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin Dashboard</title>
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
height:800px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:space-around;
align-items:center;
flex-wrap:wrap;
}
.child{
height: 500px;
width: 65%;
background-color: white;
display: flex;
justify-content:space-around;
align-items: center;
flex-wrap:wrap;
}
.child-1{
height:200px;
width:250px;
display:flex;
justify-content:center;
align-items:center;
cursor:pointer;
}
</style>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">
	<div class="plane">
	<i class="fas fa-paper-plane" style="color:white; font-size:50px;"></i>
	&nbsp&nbsp&nbsp
	<span style="font-size:35px;color:white;">SwiftPay</span>
	</div>
</div>
<div class="parent">
	<div class="child">
		<div class="child-1" onclick="document.location.href='userReport.jsp'">
			<h1>User Report</h1>
		</div>
		<div class="child-1" onclick="document.location.href='transactionReport.jsp'">
			<h1>Transaction</h1>
		</div>
		<div class="child-1" onclick="document.location.href='bankaccountReport.jsp'">
			<h1>Bank Account</h1>
		</div>
		<div class="child-1" onclick="document.location.href='busticketReport.jsp'">
			<h1>Bus Ticket</h1>
		</div>
		<div class="child-1" onclick="document.location.href='bechdeReport.jsp'">
			<h1>BechDe</h1>
		</div>
		<div class="child-1" onclick="document.location.href='triptagesReport.jsp'">
			<h1>Triptages</h1>
		</div>
	</div>	
</div>
</body>
</html>