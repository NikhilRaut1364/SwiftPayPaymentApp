<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Failed</title>
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
background-color:white;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:450px;
width:700px;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
position: relative;
animation-name: example;
animation-duration: 5s;
animation-delay: 2s;
animation-timing-function:ease;
animation-fill-mode: forwards;
border-radius:25px;
}
@keyframes example {
100% {background-color:tomato; left:0px; top:0px;font-size:65px;}
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
</div>
<div class="parent">
	<div class="child" style="font-size:0px;">
		<i class="far fa-times-circle" style="color:white;margin-bottom:10px"></i>
		<label style="color:white;">Transaction Failed</label>
	</div>
</div>
</form>
</body>
</html>