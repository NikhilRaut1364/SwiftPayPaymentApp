<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Dth</title>
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
height:605px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child1{
height:500px;
width:600px;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
background-color:white;
}
.child2{
height:500px;
width:600px;
background-color:white;
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
<form action="dth2.jsp">
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
	<div class="child1">
		<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">DTH</h1>
		<table style="height:300px;width:500px;">
			<tr>
				<td><center><input type="text" autocomplete="off" name="sid" placeholder="Subscriber Id" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center>
				<span style="font-size:20px;margin-right:10px;color:#666666;">Select Provider</span>
				<select name="provider" style="height:35px;width:160px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
				<option value="Tatasky">Tatasky</option>
				<option value="DishTV">Dish Tv</option>
				<option value="D2H">D2H</option>
				<option value="Airtel">Airtel</option>
				</select>
				</center></td>
			</tr>
			<tr>
				<td><center><input type="text" autocomplete="off" name="amount" placeholder="Amount" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="submit" value="Proceed" class="b1"></center></td>
			</tr>
		</table>
	</div>
	<div class="child2">
		<img src="images java/dth.gif" height="500" width="600">
	</div>
</div>
</form>
</body>
</html>