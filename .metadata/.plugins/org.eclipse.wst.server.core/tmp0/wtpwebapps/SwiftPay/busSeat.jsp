<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title></title>
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
height:1400px;
width:100%;
background-color:#c2d1ef;
display:flex;
justify-content:center;
align-items:center;
}
.child{
height:1100px;
width:700px;
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
.test{
height:30px;
width:30px;
 color: green;
  background-color: green;
}
.seat{
height:550px;
width:500px;
display:flex;
justify-content: center;
align-items: center;
border:solid black 1px;
flex-direction: column;
}
.t1{
display:none;
}
.t2{
display:none;
}
</style>
<script src='javascript/jquery-3.4.1.js'>
</script>
<script type="text/javascript">
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
	
function display(id)
{
	var total = document.getElementById('ammt').value;
	if(document.getElementById(id).checked == true)
	{
		var result = new XMLHttpRequest();
		result.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200)
			{
				var x = document.getElementById("ammt");
				x.value = this.responseText;
			}
		};
		result.open("GET","CheckSeat.jsp?total="+total,true);
		result.send();
	}
	else
	{
		var result = new XMLHttpRequest();
		result.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200)
			{
				var x = document.getElementById("ammt");
				x.value = this.responseText;
			}
		};
		result.open("GET","CheckSeat1.jsp?total="+total,true);
		result.send();
	}
}
</script>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="BusSeat" method="POST">
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
String from=request.getParameter("from");
String to=request.getParameter("to");
String bdate=request.getParameter("bdate");

Cookie cookie7=new Cookie("bfrom",from+"");
Cookie cookie8=new Cookie("bto",to+"");
Cookie cookie9=new Cookie("bdate",bdate+"");
response.addCookie(cookie7);
response.addCookie(cookie8);
response.addCookie(cookie9);
%>
<%
	if(from.equals(to))
	{%>
		<script type="text/javascript">
					alert("No Bus Available");
					document.location.href="bus.jsp";
				</script>
	<% }
	String bname="";
	String busdate="";
	String sa1="",sa2="",sa3="",sa4="";
	String sb1="",sb2="",sb3="",sb4="";
	String sc1="",sc2="",sc3="",sc4="";
	String sd1="",sd2="",sd3="",sd4="";
	String se1="",se2="",se3="",se4="";
	Connection con=null;
	String url="jdbc:ucanaccess://E://Database//bus.accdb";
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from bus where source='"+from+"' and destination='"+to+"'");
		while(rs.next())
		{
			bname=rs.getString("busname");
			busdate=rs.getString("bdate");
		}
		if(busdate.equals(bdate))
		{
			PreparedStatement ps1=con.prepareStatement("SELECT status from "+bname+" where seat='A1'");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				sa1=rs1.getString("status");
			}
			
			PreparedStatement ps2=con.prepareStatement("SELECT status from "+bname+" where seat='A2'");
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				sa2=rs2.getString("status");
			}
			
			PreparedStatement ps3=con.prepareStatement("SELECT status from "+bname+" where seat='A3'");
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next())
			{
				sa3=rs3.getString("status");
			}
			
			PreparedStatement ps4=con.prepareStatement("SELECT status from "+bname+" where seat='A4'");
			ResultSet rs4=ps4.executeQuery();
			while(rs4.next())
			{
				sa4=rs4.getString("status");
			}
			
			PreparedStatement ps5=con.prepareStatement("SELECT status from "+bname+" where seat='B1'");
			ResultSet rs5=ps5.executeQuery();
			while(rs5.next())
			{
				sb1=rs5.getString("status");
			}
			
			PreparedStatement ps6=con.prepareStatement("SELECT status from "+bname+" where seat='B2'");
			ResultSet rs6=ps6.executeQuery();
			while(rs6.next())
			{
				sb2=rs6.getString("status");
			}
			
			PreparedStatement ps7=con.prepareStatement("SELECT status from "+bname+" where seat='B3'");
			ResultSet rs7=ps7.executeQuery();
			while(rs7.next())
			{
				sb3=rs7.getString("status");
			}
			
			PreparedStatement ps8=con.prepareStatement("SELECT status from "+bname+" where seat='B4'");
			ResultSet rs8=ps8.executeQuery();
			while(rs8.next())
			{
				sb4=rs8.getString("status");
			}
			
			PreparedStatement ps9=con.prepareStatement("SELECT status from "+bname+" where seat='C1'");
			ResultSet rs9=ps9.executeQuery();
			while(rs9.next())
			{
				sc1=rs9.getString("status");
			}
			
			PreparedStatement ps10=con.prepareStatement("SELECT status from "+bname+" where seat='C2'");
			ResultSet rs10=ps10.executeQuery();
			while(rs10.next())
			{
				sc2=rs10.getString("status");
			}
			
			PreparedStatement ps11=con.prepareStatement("SELECT status from "+bname+" where seat='C3'");
			ResultSet rs11=ps11.executeQuery();
			while(rs11.next())
			{
				sc3=rs11.getString("status");
			}
			
			PreparedStatement ps12=con.prepareStatement("SELECT status from "+bname+" where seat='C4'");
			ResultSet rs12=ps12.executeQuery();
			while(rs12.next())
			{
				sc4=rs12.getString("status");
			}
			
			PreparedStatement ps13=con.prepareStatement("SELECT status from "+bname+" where seat='D1'");
			ResultSet rs13=ps13.executeQuery();
			while(rs13.next())
			{
				sd1=rs13.getString("status");
			}
			
			PreparedStatement ps14=con.prepareStatement("SELECT status from "+bname+" where seat='D2'");
			ResultSet rs14=ps14.executeQuery();
			while(rs14.next())
			{
				sd2=rs14.getString("status");
			}
			
			PreparedStatement ps15=con.prepareStatement("SELECT status from "+bname+" where seat='D3'");
			ResultSet rs15=ps15.executeQuery();
			while(rs15.next())
			{
				sd3=rs15.getString("status");
			}
			
			PreparedStatement ps16=con.prepareStatement("SELECT status from "+bname+" where seat='D4'");
			ResultSet rs16=ps16.executeQuery();
			while(rs16.next())
			{
				sd4=rs16.getString("status");
			}
			
			PreparedStatement ps17=con.prepareStatement("SELECT status from "+bname+" where seat='E1'");
			ResultSet rs17=ps17.executeQuery();
			while(rs17.next())
			{
				se1=rs17.getString("status");
			}
			
			PreparedStatement ps18=con.prepareStatement("SELECT status from "+bname+" where seat='E2'");
			ResultSet rs18=ps18.executeQuery();
			while(rs18.next())
			{
				se2=rs18.getString("status");
			}
			
			PreparedStatement ps19=con.prepareStatement("SELECT status from "+bname+" where seat='E3'");
			ResultSet rs19=ps19.executeQuery();
			while(rs19.next())
			{
				se3=rs19.getString("status");
			}
			
			PreparedStatement ps20=con.prepareStatement("SELECT status from "+bname+" where seat='E4'");
			ResultSet rs20=ps20.executeQuery();
			while(rs20.next())
			{
				se4=rs20.getString("status");
			}
		}
		else
		{%>
			<script type="text/javascript">
					alert("No Bus Available On Selected Date");
					document.location.href="bus.jsp";
				</script>
		<% }
		
	}
	catch(Exception e)
	{
		
	}	
		%>
		
			
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
		<h1 style="margin-bottom:15px;font-size:30px;color:#666666;">Select Seat</h1>
		<div class="seat">
		<table height="450" width="500">
		
			<tr>
				<td><center><%if(se1.equals("notbooked")){ %><input type="checkbox" class="test" name="E1" value="E1" id="E1" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="E1" value="E1" id="E1" style="cursor:no-drop" disabled><%} %><br><span>E1</span></center></td>
				<td><center><%if(se2.equals("notbooked")){ %><input type="checkbox" class="test" name="E2" value="E2" id="E2" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="E2" value="E2" id="E2" style="cursor:no-drop" disabled><%} %><br><span>E2</span></center></td>
				<td>&nbsp&nbsp</td>
				<td><center><%if(se3.equals("notbooked")){ %><input type="checkbox" class="test" name="E3" value="E3" id="E3" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="E3" value="E3" id="E3" style="cursor:no-drop" disabled><%} %><br><span>E3</span></center></td>
				<td><center><%if(se4.equals("notbooked")){ %><input type="checkbox" class="test" name="E4" value="E4" id="E4" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="E4" value="E4" id="E4" style="cursor:no-drop" disabled><%} %><br><span>E4</span></center></td>
			</tr>
			<tr>
				<td><center><%if(sd1.equals("notbooked")){ %><input type="checkbox" class="test" name="D1" value="D1" id="D1" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="D1" value="D1" id="D1" style="cursor:no-drop" disabled><%} %><br><span>D1</span></center></td>
				<td><center><%if(sd2.equals("notbooked")){ %><input type="checkbox" class="test" name="D2" value="D2" id="D2" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="D2" value="D2" id="D2" style="cursor:no-drop" disabled><%} %><br><span>D2</span></center></td>
				<td></td>
				<td><center><%if(sd3.equals("notbooked")){ %><input type="checkbox" class="test" name="D3" value="D3" id="D3" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="D3" value="D3" id="D3" style="cursor:no-drop" disabled><%} %><br><span>D3</span></center></td>
				<td><center><%if(sd4.equals("notbooked")){ %><input type="checkbox" class="test" name="D4" value="D4" id="D4" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="D4" value="D4" id="D4" style="cursor:no-drop" disabled><%} %><br><span>D4</span></center></td>
			</tr>
			<tr>
				<td><center><%if(sc1.equals("notbooked")){ %><input type="checkbox" class="test" name="C1" value="C1" id="C1" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="C1" value="C1" id="C1" style="cursor:no-drop" disabled><%} %><br><span>C1</span></center></td>
				<td><center><%if(sc2.equals("notbooked")){ %><input type="checkbox" class="test" name="C2" value="C2" id="C2" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="C2" value="C2" id="C2" style="cursor:no-drop" disabled><%} %><br><span>C2</span></center></td>
				<td></td>
				<td><center><%if(sc3.equals("notbooked")){ %><input type="checkbox" class="test" name="C3" value="C3" id="C3" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="C3" value="C3" id="C3" style="cursor:no-drop" disabled><%} %><br><span>C3</span></center></td>
				<td><center><%if(sc4.equals("notbooked")){ %><input type="checkbox" class="test" name="C4" value="C4" id="C4" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="C4" value="C4" id="C4" style="cursor:no-drop" disabled><%} %><br><span>C4</span></center></td>
			</tr>
			<tr>
				<td><center><%if(sb1.equals("notbooked")){ %><input type="checkbox" class="test" name="B1" value="B1" id="B1" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="B1" value="B1" id="B1" style="cursor:no-drop" disabled><%} %><br><span>B1</span></center></td>
				<td><center><%if(sb2.equals("notbooked")){ %><input type="checkbox" class="test" name="B2" value="B2" id="B2" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="B2" value="B2" id="B2" style="cursor:no-drop" disabled><%} %><br><span>B2</span></center></td>
				<td></td>
				<td><center><%if(sb3.equals("notbooked")){ %><input type="checkbox" class="test" name="B3" value="B3" id="B3" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="B3" value="B3" id="B3" style="cursor:no-drop" disabled><%} %><br><span>B3</span></center></td>
				<td><center><%if(sb4.equals("notbooked")){ %><input type="checkbox" class="test" name="B4" value="B4" id="B4" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="B4" value="B4" id="B4" style="cursor:no-drop" disabled><%} %><br><span>B4</span></center></td>
			</tr>
			<tr>
				<td><center><%if(sa1.equals("notbooked")){ %><input type="checkbox" class="test" name="A1" value="A1" id="A1" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="A1" value="A1" id="A1" style="cursor:no-drop" disabled><%} %><br><span>A1</span></center></td>
				<td><center><%if(sa2.equals("notbooked")){ %><input type="checkbox" class="test" name="A2" value="A2" id="A2" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="A2" value="A2" id="A2" style="cursor:no-drop" disabled><%} %><br><span>A2</span></center></td>
				<td></td>
				<td><center><%if(sa3.equals("notbooked")){ %><input type="checkbox" class="test" name="A3" value="A3" id="A3" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="A3" value="A3" id="A3" style="cursor:no-drop" disabled><%} %><br><span>A3</span></center></td>
				<td><center><%if(sa4.equals("notbooked")){ %><input type="checkbox" class="test" name="A4" value="A4" id="A4" onclick="display(this.id)"><%}else{ %><input type="checkbox" class="test" name="A4" value="A4" id="A4" style="cursor:no-drop" disabled><%} %><br><span>A4</span></center></td>
			</tr>
			
		</table>
		
		<table width="500" height="100">	
			<tr>
				<td><label><img src="images java/steering.png" height="50" width="50"  style="margin-left:80px;"></label></td>
			</tr>
		</table>
		</div>
		<table height="450" width="500">
			<tr>
				<td><center><div><label style="font-size:20px;margin-left:30px;">Rs.</label><input type="text" name="amount" value="0" id="ammt" style="font-size:20px;border:none;"></div></center></td>
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
				</center></td>
			</tr>
			<tr>
				<td><center><input type="text" name="upi" placeholder="4-Digit Unique Code" style="height:35px;width:300px;font-size:20px;border:none;border-bottom:2px solid #25488e;"></center></td>
			</tr>
			<tr>
				<td><center><input type="submit" value="Proceed" class="b1"></center></td>
			</tr>
		</table>
	</div>
</div>
</form>
</body>
</html>