<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Movie Booking</title>
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
height:1500px;
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
.movie{
height:600px;
width:95%;
display:flex;
align-items:center;
justify-content:space-around;
}
.image{
height:550px;
width:550px;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
}
.img{
height:450px;
width:550px;
}
.desc{
height:100px;
width:550px;
background-color:white;
display:flex;
justify-content:center;
flex-direction:column;
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
	<h1>Movie Booking</h1>
	<div class="movie">
		<div class="image">
			<div class="img">
				<img src="images java/endgame.jpg" height="450" width="550">
			</div>
			<div class="desc">
				<span style="font-size:25px;color:#666666;margin-left:20px;margin-bottom:8px;">Endgame</span>
				<span style="font-size:20px;margin-left:20px;">English | UA</span>
				<span style="font-size:20px;color:#25488e;margin-left:430px;cursor:pointer;" onclick="document.location.href='endgame1.jsp'">Book Now</span>
			</div>
		</div>
		<div class="image">
			<div class="img">
				<img src="images java/jumanji.jpg" height="450" width="550">
			</div>
			<div class="desc">
				<span style="font-size:25px;color:#666666;margin-left:20px;margin-bottom:8px;">Jumanji: Welcome To The Jungle</span>
				<span style="font-size:20px;margin-left:20px;">English | UA</span>
				<span style="font-size:20px;color:#25488e;margin-left:430px;cursor:pointer;" onclick="document.location.href='jumanji1.jsp'">Book Now</span>
			</div>
		</div>
	</div>
	<div class="movie">
		<div class="image">
			<div class="img">
				<img src="images java/dino.jpg" height="450" width="550">
			</div>
			<div class="desc">
				<span style="font-size:25px;color:#666666;margin-left:20px;margin-bottom:8px;">The Good Dinosaur</span>
				<span style="font-size:20px;margin-left:20px;">English | UA</span>
				<span style="font-size:20px;color:#25488e;margin-left:430px;cursor:pointer;" onclick="document.location.href='dino1.jsp'">Book Now</span>
			</div>
		</div>
		<div class="image">
			<div class="img">
				<img src="images java/justiceleague.jpg" height="450" width="550">
			</div>
			<div class="desc">
				<span style="font-size:25px;color:#666666;margin-left:20px;margin-bottom:8px;">Justice League</span>
				<span style="font-size:20px;margin-left:20px;">English | UA</span>
				<span style="font-size:20px;color:#25488e;margin-left:430px;cursor:pointer;" onclick="document.location.href='justice1.jsp'">Book Now</span>
			</div>
		</div>
	</div>
</div>
</form>
</body>
</html>