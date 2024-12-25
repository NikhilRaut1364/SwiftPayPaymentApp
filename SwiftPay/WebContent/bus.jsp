<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Bus Booking</title>
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
height:700px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;;
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
.child{
height:500px;
width:600px;
}
.child1{
height:500px;
width:600px;
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
<form action="busSeat.jsp" method="POST">
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
		<img src="images java/bus1.gif" height="500" width="600">
	</div>
	<div class="child1">
		<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Bus Booking</h1>
		<table height="300" width="400">
			<tr>
				<td><center>
					<span style="font-size:20px;">From:&nbsp&nbsp</span>
					<select name="from" style="height:35px;width:160px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
						<option value="Pune">Pune</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Goa">Goa</option>
					</select>
				</center></td>
			</tr>
			<tr>
				<td><center>
					<span style="font-size:20px;">To:&nbsp&nbsp</span>
					<select name="to" style="height:35px;width:160px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
						<option value="Pune">Pune</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Goa">Goa</option>
					</select>
				</center></td>
			</tr>
			<tr>
				<td><center>
				<span style="font-size:20px;">Select Date:&nbsp&nbsp</span>
				<input type="date" name="bdate" min="2020-09-19" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
				</center></td>
			</tr>
			<tr>
				<td><center><input type="submit" value="Book" class="b1"></center></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>