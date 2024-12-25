<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Endgame</title>
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
height:750px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:space-around;
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
.abstract{
height:300px;
width:100%;
position:relative;
}
.poster{
height:350px;
width:300px;
background-color:white;
display:flex;
position:absolute;
bottom:-180px;
left:80px;
}
.img{
display:block;
height:300px;
width:100%;
}
.synopsis{
height:150px;
width:700px;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:500px;
width:80%;
background-color:white;
display:flex;
justify-content:space-around;
align-items:center;
}
.child1{
height:500px;
width:80%;
background-color:white;
display:flex;
justify-content:space-around;
align-items:center;
}
.child-1{
height:450px;
width:600px;
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
.t1{
display:none;
}
.t2{
display:none;
}
.seatname{
height:450px;
width:220px;
display:flex;
align-items:center;
justify-content:center;
}
.seat{
height:450px;
width:900px;
background-color:lightgreen;
display:flex;
align-items:center;
justify-content:space-around;
flex-direction:column;
}
.test{
height:30px;
width:30px;
}
</style>

<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="endgame2.jsp" method="POST">
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
<div class="abstract">
	<img src="images java/abstract.jpg" class="img">
	<div class="poster">
		<img src="images java/endgame.jpg" height="350" width="300">
	</div>
</div>
<div class="parent">
	<div class="synopsis">
		<h1 style="margin-bottom:15px;font-size:30px;color:black;">Avengers Endgame</h1>
	</div>
	
	<div class="child1">
		<div class="child-1">
			<span style="margin-bottom:15px;font-size:30px;color:black;">Movie Booking</span>
			<table height="350" width="400">
				<tr>
					<td><center>
					<span style="font-size:20px;">Select Theater:&nbsp&nbsp</span>
					<select name="theater" style="height:35px;width:160px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
						<option value="PVR">PVR</option>
						<option value="Cinepolis">Cinepolis</option>
						<option value="INOX">INOX</option>
					</select>
					</center></td>
				</tr>
				<tr>
					<td><center>
					<span style="font-size:20px;">Select Date:&nbsp&nbsp</span>
					<input type="date" name="mdate" min="2020-09-19" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
					</center></td>
				</tr>
				<tr>
					<td><center>
						<span style="font-size:20px;">Time:&nbsp&nbsp</span>
						<select name="time" style="height:35px;width:160px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
							<option value="9:00A.M">9:00 A.M</option>
							<option value="7:00P.M">7:00 P.M</option>
						</select>
					</center></td>
				</tr>
				<tr>
					<td><center><input type="submit" value="Proceed" class="b1"></center></td>
				</tr>
			</table>
		</div>
	</div>
</div>
</form>
</body>
</html>