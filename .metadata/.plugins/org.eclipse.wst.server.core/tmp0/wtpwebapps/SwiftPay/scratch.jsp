<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Scratch Card</title>
<link rel="stylesheet" href="css/scratchcard.css">
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/scratchcard.js"></script>
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
height: 500px;
width: 800px;
background-color: white;
display: flex;
align-items: center;
flex-direction: column;
justify-content:center;
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
<form action="Scratch" method="POST">
<%@ page import="java.util.*" %>
<%
int num;
Random rmd=new Random();
num=rmd.nextInt(99);
%>
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
		<h1 style="margin-bottom:15px;margin-top:20px;font-size:30px;color:#666666;">Scratch Card</h1>
		<div class="container" id="scratch-container">
		<canvas class="canvas" id="scratch-canvas" width="500" height="200"></canvas>
		<div class="winner-box">
			<h2 class="blinker">CONGRATULATION!</h2>
			<h1><%if(num%3==0){ out.println("Better luck next time");%><input type="hidden" name="scratch" value="0"><% }else{%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspRs.<input type="text" value="<% out.println(num);%>" name="scratch" style="border:none;font-size:35px;background-color: #09c;width:60px;color:white;font-weight:bold;"><%} %></h1>
		</div>
		</div>
		<br>
		<input type="submit" value="Proceed" class="b1">
	</div>
</div>
</form>
</body>
</html>