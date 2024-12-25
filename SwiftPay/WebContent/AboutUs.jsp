<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
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
.parent{
height:1100px;
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
.child{
height:950px;
width:90%;
background-color: white;
display: flex;
justify-content: space-around;
align-items: center;
flex-direction: column;
border-radius: 25px;
}
.child-1{
height:100px;
width:200px;
display: flex;
justify-content: center;
align-items: center;
}
.child-2{
height:150px;
width:90%;
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}
.child-3{
height:620px;
width:95%;
display: flex;
justify-content: space-around;
align-items: center;
flex-direction: column;
}
.child-4{
height:100px;
width:200px;
display: flex;
justify-content: center;
align-items: center;
}
.child-5{
height:520px;
width: 100%;
display: flex;
justify-content: space-around;
align-items: center;
}
.child-6{
height:500px;
width:400px;
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}
.img1{
height:300px;
width: 300px;
background-image: url("images java/gauriUpdated.jpg");
background-size: 300px 300px;
border-radius: 50%;
}
.img2{
height:300px;
width: 300px;
background-image: url("images java/prajaktaUpdated.jpg");
background-size: 300px 300px;
border-radius: 50%;
}
.img3{
height:300px;
width: 300px;
background-image: url("images java/nikhil.jpg");
background-size: 300px 300px;
border-radius: 50%;
}
.info{
height:120px;
width: 350px;
display: flex;
justify-content: space-around;
align-items: center;
flex-direction: column;
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
	<div class="title">
	</div>
	<div class="home" onclick="document.location.href='main.jsp'">
	<i class="fas fa-home" style="color:white; font-size:40px;"></i>
	<span style="font-size:30px;color:white;">Home</span>
	</div>
</div>
<div class="parent">
	<div class="child">
		<div class="child-1">
			<h1 style="font-size:30px;color:#666666;">About Us</h1>
		</div>
		<div class="child-2">
			<span style="font-size:20px;">Our goal is to make digital payments so easy, safe and universally accepted that people never feel the need to carry cash or cards</span>
			<span style="font-size:20px;">again. We believe India is at the cusp of a new mobile revolution, which will change the way we manage our money on the go. We</span>
			<span style="font-size:20px;">see ourselves facilitating this change, through technology and dogged customer centricity.</span>
		</div>
		<div class="child-3">
			<div class="child-4">
				<span style="font-size:20px;"><b>Leadership Team</b></span>
			</div>
			<div class="child-5">
				<div class="child-6">
					<div class="img1"></div>
					<div class="info">
						<span style="font-size: 20px;"><b>Gauri Patil</b></span>
						<span style="font-size: 20px;">Chief Executive Officer (CEO)</span>
					</div>
				</div>
				<div class="child-6">
					<div class="img2"></div>
					<div class="info">
						<span style="font-size: 20px;"><b>Prajakta Nandawade</b></span>
						<span style="font-size: 20px;">Designer | Java Developer</span>
					</div>
				</div>
				<div class="child-6">
					<div class="img3"></div>
					<div class="info">
						<span style="font-size: 20px;"><b>Nikhil Raut</b></span>
						<span style="font-size: 20px;">Designer | Java Developer</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>