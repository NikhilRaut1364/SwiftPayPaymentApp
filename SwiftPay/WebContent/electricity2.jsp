<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Electricity Payment</title>
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
height:700px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:600px;
width:600px;
background-color:white;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
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
	$("#r3").click(function(){
	$(".t1").hide();
	$(".t2").hide();
	});
	});
</script>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
	int flag=0;
	String consumerno="";
	String subdivisioncode="";
	String p="";
	String eamt="";
	//String pend="pending";
	Connection con=null;
	String cno=request.getParameter("cno");
	String scode=request.getParameter("scode");
	String connum=cno;
	String subcd=scode;
	String provider=request.getParameter("provider");
	String sql="select * from electricity where cno='"+cno+"' and sdcode='"+scode+"' and provider='"+provider+"'";
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			//p=rs.getString("status");
			consumerno=rs.getString("cno");
			subdivisioncode=rs.getString("sdcode");
			if(consumerno.equals(connum) && subdivisioncode.equals(subcd))
			{
				flag=1;
				break;
			}
			else
			{
				flag=0;
			}
		}
		if(flag==1)
		{
			ResultSet rs1=stmt.executeQuery(sql);
			while(rs1.next())
			{
				p=rs1.getString("status");
				if(p.equals("pending"))
				{
					eamt=rs1.getString("amount");
					//out.println(eamt);
				}
				else if(p.equals("paid"))
				{%>
					<script type="text/javascript">
						alert("No Pending Bills");
						document.location.href="electricity1.jsp";
					</script>
				<%
				
				 }
			}
		}
		else if(flag==0)
		{%>
				<script type="text/javascript">
					alert("Invalid Input");
					document.location.href="electricity1.jsp";
				</script>
		<%}
	}
	catch(Exception e)
	{
		
	}
%>
<form action="Electricity" method="POST">

<div class="header">
	<div class="plane">
	<i class="fas fa-paper-plane" style="color:white; font-size:50px;"></i>
	&nbsp&nbsp&nbsp
	<span style="font-size:35px;color:white;">SwiftPay</span>
	</div>
</div>
<div class="parent">
	<div class="child">
	<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Electricity Payment</h1>
		<table style="height:500px;width:500px;">
			<tr>
				<td><center><input type="text" name="cno" value='<% out.println(request.getParameter("cno")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="scode" value='<% out.println(request.getParameter("scode")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="provider" value='<% out.println(request.getParameter("provider")); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="amount" value='<% out.println(eamt); %>' style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
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
				<td><center><input type="text" autocomplete="off" name="upi" placeholder="4-Digit Unique Code" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="submit" value="Pay" class="b1"></center></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>