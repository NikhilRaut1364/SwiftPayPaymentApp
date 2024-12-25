<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Payment</title>
<style>
*{
margin:0px;
font-family:candara;
}
.parent{
height:620px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.foot{
height:150px;
width:100%;
background-color:#25488e;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:500px;
width:500px;
background-color:white;
display:flex;
justify-content:center;
align-items:center;
border-radius:20px;
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
.child1{
height:150px;
width:400px;
display:flex;
align-items:center;
justify-content:center;
}
</style>
<script src='javascript/jquery-3.4.1.js'>
</script>
<script>
$(function(){
	$("#r1").click(function(){
	$(".t2").hide();
	$(".t1").toggle("slow");
	});
	$("#r2").click(function(){
	$(".t1").hide();
	$(".t2").toggle("slow");
	});
	});
</script>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="Integrate1" method="POST">
<div class="parent">
	<div class="child">
		<table height="400" width="500">
			<tr>
				<td><center><input type="text" name="amount" placeholder="Amount" value="<%out.println(request.getParameter("amount")); %>" autocomplete="off" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center>
				<h3>Payment Method:</h3><br>
				<input type="radio" id="r1" name="rad" value="debit">&nbsp&nbsp<font style="font-size:20px;">Debit Card</font><br>
				<input type="text" name="dcardno" class="t1" autocomplete="off" placeholder="Card Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">&nbsp&nbsp&nbsp&nbsp<input type="text" name="dcvv" class="t1" placeholder="CVV Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
				<br><br>
				<input type="radio" id="r2" name="rad" value="credit">&nbsp&nbsp<font style="font-size:20px;">Credit Card</font><br>
				<input type="text" name="ccardno" class="t2" autocomplete="off" placeholder="Card Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">&nbsp&nbsp&nbsp&nbsp<input type="text" name="ccvv" class="t2" placeholder="CVV Number" style="height:35px;font-size:20px;border:none;border-bottom:2px solid #25488e;">
				</center></td>
			</tr>
			<tr>
				<td><center><input type="submit" value="Pay" class="b1"></center></td>
			</tr>
		</table>
	</div>
</div>
<div class="foot">
	<div class="child1">
		<span style="color:white">IN PARTNERSHIP WITH</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<i class="fas fa-paper-plane" style="color:white; font-size:50px;">&nbsp</i><h1 style="color:white;">SWIFTPAY</h1>
	</div>
</div>
</form>
</body>
</html>