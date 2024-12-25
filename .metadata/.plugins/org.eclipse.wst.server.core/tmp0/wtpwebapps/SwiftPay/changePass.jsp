<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
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
height:750px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:550px;
width:600px;
background-color:white;
display:flex;
justify-content:center;
align-items:center;
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

<form method="POST" action="ChangePassword">
<div class="header">
	<div class="plane">
	<i class="fas fa-paper-plane" style="color:white; font-size:50px;"></i>
	&nbsp&nbsp&nbsp
	<span style="font-size:35px;color:white;">SwiftPay</span>
	</div>
</div>
<div class="parent">
	<div class="child">
		<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Change Password</h1>
		<table style="height:400px;width:400px;">
			<tr>
				<td><center><input type="password" name="previouspass" placeholder="Enter Previous Password" autocomplete="off" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="password" name="newpass" placeholder="Enter New Password" autocomplete="off" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="password" name="confirmnewpass" placeholder="Confirm New Password" autocomplete="off" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="submit" value="Confirm" class="b1"></center></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>