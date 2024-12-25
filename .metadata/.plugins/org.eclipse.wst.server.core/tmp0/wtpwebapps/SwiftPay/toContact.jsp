<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Transfer</title>
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
justify-content:space-around;
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
.t1{
display:none;
}
.t2{
display:none;
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
<script src='javascript/jquery-3.4.1.js'>
</script>
<script type="text/javascript">
var i=0;
var path=new Array();

path[0]="images java/money1.jpg";
path[1]="images java/money7.jpg";
path[2]="images java/money3.png";
path[3]="images java/money10.jpg";
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

$(function(){
$("#r1").click(function(){
$(".t2").hide();
$(".t1").toggle("slow");
});
$("#r2").click(function(){
$(".t1").hide();
$(".t2").toggle("slow");
});
$("#r3").click(function(){
$(".t1").hide();
$(".t2").hide();
});
});
</script>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color:#c2d1ef;">
<form method="POST" action="Contact">
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
	<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Transfer Money</h1>
	<table style="height:420px;width:500px;">
		<tr>
			<td><center><input type="text" autocomplete="off" name="contact" placeholder="Contact Number" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
		</tr>
		<tr>
			<td><center><input type="text" autocomplete="off" name="amount" placeholder="Amount" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
		</tr>
		<tr>
			<td><center>
			<h3>Payment Method:</h3><br>
			<input type="radio" id="r1" name="rad" value="debit">&nbsp&nbsp<font style="font-size:20px;">Debit Card</font><br>
			<input type="text" autocomplete="off" name="dcardno" class="t1" placeholder="Card Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">&nbsp&nbsp&nbsp&nbsp<input type="text" autocomplete="off" name="dcvv" class="t1" placeholder="CVV Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
			<br><br>
			<input type="radio" id="r2" name="rad" value="credit">&nbsp&nbsp<font style="font-size:20px;">Credit Card</font><br>
			<input type="text" autocomplete="off" name="ccardno" class="t2" placeholder="Card Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">&nbsp&nbsp&nbsp&nbsp<input type="text" autocomplete="off" name="ccvv" class="t2" placeholder="CVV Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
			<br><br>
			<input type="radio" id="r3" name="rad" value="wallet">&nbsp&nbsp<font style="font-size:20px;">Wallet</font><br>
			</center></td>
		</tr>
		<tr>
			<td><center><input type="text" autocomplete="off" name="upi" placeholder="4-Digit Code" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
		</tr>
		<tr>
			<td><center><input type="submit" value="Transfer" class="b1"></center></td>
		</tr>
	</table>
	</div>
</div>
</form>
<%
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("loginForm.jsp");
	}
	
%>
</body>
</html>