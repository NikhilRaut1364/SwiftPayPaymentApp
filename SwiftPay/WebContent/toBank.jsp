<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Bank Transfer</title>
<script type="text/javascript">
var i=0;
var path=new Array();

path[0]="images java/money5.jpeg";
path[1]="images java/money6.png";
path[2]="images java/money8.png";
path[3]="images java/money9.jpg";
path[4]="images java/mobile11.jpg";

function swapImage()
{
	document.slide.src=path[i];
	if(i<path.length-1)
	{
		i++;
	}
	else
	{
		i=0;
	}
	setTimeout("swapImage()",3000);
}
window.onload=swapImage;
</script>
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
background-color:white;
}
.child2{
height:500px;
width:600px;
background-color:white;
display:flex;
justify-content:center;
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
<body style="background-color:#c2d1ef;">
<form method="POST" action="bankTransfer.jsp">
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
	<img src="" height="500" width="600" name="slide">
	</div>
	<div class="child2">
	<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Beneficiary Details</h1>
	<table style="height:400px;width:500px;">
	<tr>
		<td><center><input type="text" autocomplete="off" name="aname" placeholder="Account Holder Name" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
	</tr>
	<tr>
		<td><center><input type="text" autocomplete="off" name="ifsc" placeholder="IFSC Code" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
	</tr>
	<tr>
		<td><center><input type="text" autocomplete="off" name="ano" placeholder="Account Number" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
	</tr>
	<tr>
		<td><center><input type="submit" value="Transfer" class="b1"></center></td>
	</tr>
	</table>
	</div>
</div>
</form>

</body>
</html>