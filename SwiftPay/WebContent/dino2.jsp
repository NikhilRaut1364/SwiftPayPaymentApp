<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>The Good Dinosaur</title>
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
height:600px;
width:80%;
background-color:white;
display:flex;
justify-content:space-around;
align-items:center;
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
height:580px;
width:220px;
display:flex;
align-items:center;
justify-content:center;
}
.seat{
height:550px;
width:900px;
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
	var amount = document.getElementById("ammt").value;
	var result = new XMLHttpRequest();
	
	if(document.getElementById(id).checked == true)
	{
		result.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200)
			{
				var x = document.getElementById('ammt');
				x.value = this.responseText;
			}
		};
		result.open("GET","MovieSelect.jsp?id="+id+"&amount="+amount,true);
		result.send();
	}
	else
	{
		result.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200)
			{
				var x = document.getElementById('ammt');
				x.value = this.responseText;
			}
		};
		result.open("GET","MovieUnselect.jsp?id="+id+"&amount="+amount,true);
		result.send();
	}
}
</script>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="Dino" method="POST">
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
String theater=request.getParameter("theater");
String time=request.getParameter("time");
String mdate=request.getParameter("mdate");

Cookie cookie16=new Cookie("dtheater",theater+"");
Cookie cookie17=new Cookie("dtime",time+"");
Cookie cookie18=new Cookie("dmdate",mdate+"");
response.addCookie(cookie16);
response.addCookie(cookie17);
response.addCookie(cookie18);

String sa1="",sa2="",sa3="",sa4="",sa5="",sa6="";
String sb1="",sb2="",sb3="",sb4="",sb5="",sb6="";
String sc1="",sc2="",sc3="",sc4="",sc5="",sc6="";
String sd1="",sd2="",sd3="",sd4="",sd5="",sd6="";
String se1="",se2="",se3="",se4="",se5="",se6="";
String sf1="",sf2="",sf3="",sf4="",sf5="",sf6="";

Connection con=null;
String url="jdbc:ucanaccess://E://Database//movie.accdb";
String th="",ti="",da="",tname="";
try{
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	con=DriverManager.getConnection(url);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from dino where theater='"+theater+"' and time='"+time+"' and mdate='"+mdate+"'");
	while(rs.next())
	{
		th=rs.getString("theater");
		ti=rs.getString("time");
		da=rs.getString("mdate");
		tname=rs.getString("tname");
	}
	if(theater.equals(th) && time.equals(ti) && mdate.equals(da))
	{
		PreparedStatement ps1=con.prepareStatement("select * from "+tname+" where seat='A1'");
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			sa1=rs1.getString("status");
		}
		PreparedStatement ps2=con.prepareStatement("select * from "+tname+" where seat='A2'");
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next())
		{
			sa2=rs2.getString("status");
		}
		PreparedStatement ps3=con.prepareStatement("select * from "+tname+" where seat='A3'");
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next())
		{
			sa3=rs3.getString("status");
		}
		PreparedStatement ps4=con.prepareStatement("select * from "+tname+" where seat='A4'");
		ResultSet rs4=ps4.executeQuery();
		while(rs4.next())
		{
			sa4=rs4.getString("status");
		}
		PreparedStatement ps5=con.prepareStatement("select * from "+tname+" where seat='A5'");
		ResultSet rs5=ps5.executeQuery();
		while(rs5.next())
		{
			sa5=rs5.getString("status");
		}
		PreparedStatement ps6=con.prepareStatement("select * from "+tname+" where seat='A6'");
		ResultSet rs6=ps6.executeQuery();
		while(rs6.next())
		{
			sa6=rs6.getString("status");
		}
		
		
		
		PreparedStatement ps7=con.prepareStatement("select * from "+tname+" where seat='B1'");
		ResultSet rs7=ps7.executeQuery();
		while(rs7.next())
		{
			sb1=rs7.getString("status");
		}
		PreparedStatement ps8=con.prepareStatement("select * from "+tname+" where seat='B2'");
		ResultSet rs8=ps8.executeQuery();
		while(rs8.next())
		{
			sb2=rs8.getString("status");
		}
		PreparedStatement ps9=con.prepareStatement("select * from "+tname+" where seat='B3'");
		ResultSet rs9=ps9.executeQuery();
		while(rs9.next())
		{
			sb3=rs9.getString("status");
		}
		PreparedStatement ps10=con.prepareStatement("select * from "+tname+" where seat='B4'");
		ResultSet rs10=ps10.executeQuery();
		while(rs10.next())
		{
			sb4=rs10.getString("status");
		}
		PreparedStatement ps11=con.prepareStatement("select * from "+tname+" where seat='B5'");
		ResultSet rs11=ps11.executeQuery();
		while(rs11.next())
		{
			sb5=rs11.getString("status");
		}
		PreparedStatement ps12=con.prepareStatement("select * from "+tname+" where seat='B6'");
		ResultSet rs12=ps12.executeQuery();
		while(rs12.next())
		{
			sb6=rs12.getString("status");
		}
		
		
		PreparedStatement ps13=con.prepareStatement("select * from "+tname+" where seat='C1'");
		ResultSet rs13=ps13.executeQuery();
		while(rs13.next())
		{
			sc1=rs13.getString("status");
		}
		PreparedStatement ps14=con.prepareStatement("select * from "+tname+" where seat='C2'");
		ResultSet rs14=ps14.executeQuery();
		while(rs14.next())
		{
			sc2=rs14.getString("status");
		}
		PreparedStatement ps15=con.prepareStatement("select * from "+tname+" where seat='C3'");
		ResultSet rs15=ps15.executeQuery();
		while(rs15.next())
		{
			sc3=rs15.getString("status");
		}
		PreparedStatement ps16=con.prepareStatement("select * from "+tname+" where seat='C4'");
		ResultSet rs16=ps16.executeQuery();
		while(rs16.next())
		{
			sc4=rs16.getString("status");
		}
		PreparedStatement ps17=con.prepareStatement("select * from "+tname+" where seat='C5'");
		ResultSet rs17=ps17.executeQuery();
		while(rs17.next())
		{
			sc5=rs17.getString("status");
		}
		PreparedStatement ps18=con.prepareStatement("select * from "+tname+" where seat='C6'");
		ResultSet rs18=ps18.executeQuery();
		while(rs18.next())
		{
			sc6=rs18.getString("status");
		}
		
		
		PreparedStatement ps19=con.prepareStatement("select * from "+tname+" where seat='D1'");
		ResultSet rs19=ps19.executeQuery();
		while(rs19.next())
		{
			sd1=rs19.getString("status");
		}
		PreparedStatement ps20=con.prepareStatement("select * from "+tname+" where seat='D2'");
		ResultSet rs20=ps20.executeQuery();
		while(rs20.next())
		{
			sd2=rs20.getString("status");
		}
		PreparedStatement ps21=con.prepareStatement("select * from "+tname+" where seat='D3'");
		ResultSet rs21=ps21.executeQuery();
		while(rs21.next())
		{
			sd3=rs21.getString("status");
		}
		PreparedStatement ps22=con.prepareStatement("select * from "+tname+" where seat='D4'");
		ResultSet rs22=ps22.executeQuery();
		while(rs22.next())
		{
			sd4=rs22.getString("status");
		}
		PreparedStatement ps23=con.prepareStatement("select * from "+tname+" where seat='D5'");
		ResultSet rs23=ps23.executeQuery();
		while(rs23.next())
		{
			sd5=rs23.getString("status");
		}
		PreparedStatement ps24=con.prepareStatement("select * from "+tname+" where seat='D6'");
		ResultSet rs24=ps24.executeQuery();
		while(rs24.next())
		{
			sd6=rs24.getString("status");
		}
		
		
		PreparedStatement ps25=con.prepareStatement("select * from "+tname+" where seat='E1'");
		ResultSet rs25=ps25.executeQuery();
		while(rs25.next())
		{
			se1=rs25.getString("status");
		}
		PreparedStatement ps26=con.prepareStatement("select * from "+tname+" where seat='E2'");
		ResultSet rs26=ps26.executeQuery();
		while(rs26.next())
		{
			se2=rs26.getString("status");
		}
		PreparedStatement ps27=con.prepareStatement("select * from "+tname+" where seat='E3'");
		ResultSet rs27=ps27.executeQuery();
		while(rs27.next())
		{
			se3=rs27.getString("status");
		}
		PreparedStatement ps28=con.prepareStatement("select * from "+tname+" where seat='E4'");
		ResultSet rs28=ps28.executeQuery();
		while(rs28.next())
		{
			se4=rs28.getString("status");
		}
		PreparedStatement ps29=con.prepareStatement("select * from "+tname+" where seat='E5'");
		ResultSet rs29=ps29.executeQuery();
		while(rs29.next())
		{
			se5=rs29.getString("status");
		}
		PreparedStatement ps30=con.prepareStatement("select * from "+tname+" where seat='E6'");
		ResultSet rs30=ps30.executeQuery();
		while(rs30.next())
		{
			se6=rs30.getString("status");
		}
		
		
		PreparedStatement ps31=con.prepareStatement("select * from "+tname+" where seat='F1'");
		ResultSet rs31=ps31.executeQuery();
		while(rs31.next())
		{
			sf1=rs31.getString("status");
		}
		PreparedStatement ps32=con.prepareStatement("select * from "+tname+" where seat='F2'");
		ResultSet rs32=ps32.executeQuery();
		while(rs32.next())
		{
			sf2=rs32.getString("status");
		}
		PreparedStatement ps33=con.prepareStatement("select * from "+tname+" where seat='F3'");
		ResultSet rs33=ps33.executeQuery();
		while(rs33.next())
		{
			sf3=rs33.getString("status");
		}
		PreparedStatement ps34=con.prepareStatement("select * from "+tname+" where seat='F4'");
		ResultSet rs34=ps34.executeQuery();
		while(rs34.next())
		{
			sf4=rs34.getString("status");
		}
		PreparedStatement ps35=con.prepareStatement("select * from "+tname+" where seat='F5'");
		ResultSet rs35=ps35.executeQuery();
		while(rs35.next())
		{
			sf5=rs35.getString("status");
		}
		PreparedStatement ps36=con.prepareStatement("select * from "+tname+" where seat='F6'");
		ResultSet rs36=ps36.executeQuery();
		while(rs36.next())
		{
			sf6=rs36.getString("status");
		}
	}
	else
	{
		//no movie on selected date and time%>
		<script type="text/javascript">
			alert("No movie Available On Selected Date");
			document.location.href="dino1.jsp";
		</script>
	<%}
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
	<div class="home" onclick="">
	<i class="fas fa-home" style="color:white; font-size:40px;"></i>
	<span style="font-size:30px;color:white;">Home</span>
	</div>
</div>
<div class="abstract">
	<img src="images java/abstract.jpg" class="img">
	<div class="poster">
		<img src="images java/dino.jpg" height="350" width="300">
	</div>
</div>
<div class="parent">
	<div class="synopsis">
		<h1 style="margin-bottom:15px;font-size:30px;color:black;">The Good Dinosaur</h1>
	</div>
	<div class="child">
		<div class="seatname">
			<table height="450" width="200" style="margin-bottom:40px;">
				<tr>
					<td><center><span style="font-size:20px;">Premium <br>Rs.300</span></center></td>
				</tr>
				<tr>
					<td><center><span style="font-size:20px;">Executive <br>Rs.200</span></center></td>
				</tr>
				<tr>
					<td><center><span style="font-size:20px;">Normal <br>Rs.100</span></center></td>
				</tr>
			</table>
		</div>
		<div class="seat">
			<table height="130" width="800">
				<tr>
					<td><center><%if(sf1.equals("notbooked")){ %><input type="checkbox" class="test" name="F1" value="F1" id="F1" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="F1" value="F1" id="F1" disabled><%} %><br><span>F1</span></center></td>
					<td><center><%if(sf2.equals("notbooked")){ %><input type="checkbox" class="test" name="F2" value="F2" id="F2" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="F2" value="F2" id="F2" disabled><%} %><br><span>F2</span></center></td>
					<td><center><%if(sf3.equals("notbooked")){ %><input type="checkbox" class="test" name="F3" value="F3" id="F3" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="F3" value="F3" id="F3" disabled><%} %><br><span>F3</span></center></td>
					<td><center><%if(sf4.equals("notbooked")){ %><input type="checkbox" class="test" name="F4" value="F4" id="F4" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="F4" value="F4" id="F4" disabled><%} %><br><span>F4</span></center></td>
					<td><center><%if(sf5.equals("notbooked")){ %><input type="checkbox" class="test" name="F5" value="F5" id="F5" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="F5" value="F5" id="F5" disabled><%} %><br><span>F5</span></center></td>
					<td><center><%if(sf6.equals("notbooked")){ %><input type="checkbox" class="test" name="F6" value="F6" id="F6" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="F6" value="F6" id="F6" disabled><%} %><br><span>F6</span></center></td>
				</tr>
				<tr>
					<td><center><%if(se1.equals("notbooked")){ %><input type="checkbox" class="test" name="E1" value="E1" id="E1" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="E1" value="E1" id="E1" disabled><%} %><br><span>E1</span></center></td>
					<td><center><%if(se2.equals("notbooked")){ %><input type="checkbox" class="test" name="E2" value="E2" id="E2" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="E2" value="E2" id="E2" disabled><%} %><br><span>E2</span></center></td>
					<td><center><%if(se3.equals("notbooked")){ %><input type="checkbox" class="test" name="E3" value="E3" id="E3" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="E3" value="E3" id="E3" disabled><%} %><br><span>E3</span></center></td>
					<td><center><%if(se4.equals("notbooked")){ %><input type="checkbox" class="test" name="E4" value="E4" id="E4" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="E4" value="E4" id="E4" disabled><%} %><br><span>E4</span></center></td>
					<td><center><%if(se5.equals("notbooked")){ %><input type="checkbox" class="test" name="E5" value="E5" id="E5" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="E5" value="E5" id="E5" disabled><%} %><br><span>E5</span></center></td>
					<td><center><%if(se6.equals("notbooked")){ %><input type="checkbox" class="test" name="E6" value="E6" id="E6" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="E6" value="E6" id="E6" disabled><%} %><br><span>E6</span></center></td>
				</tr>
			</table>
			<table height="130" width="800">
				<tr>
					<td><center><%if(sd1.equals("notbooked")){ %><input type="checkbox" class="test" name="D1" value="D1" id="D1" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="D1" value="D1" id="D1" disabled><%} %><br><span>D1</span></center></td>
					<td><center><%if(sd2.equals("notbooked")){ %><input type="checkbox" class="test" name="D2" value="D2" id="D2" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="D2" value="D2" id="D2" disabled><%} %><br><span>D2</span></center></td>
					<td><center><%if(sd3.equals("notbooked")){ %><input type="checkbox" class="test" name="D3" value="D3" id="D3" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="D3" value="D3" id="D3" disabled><%} %><br><span>D3</span></center></td>
					<td><center><%if(sd4.equals("notbooked")){ %><input type="checkbox" class="test" name="D4" value="D4" id="D4" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="D4" value="D4" id="D4" disabled><%} %><br><span>D4</span></center></td>
					<td><center><%if(sd5.equals("notbooked")){ %><input type="checkbox" class="test" name="D5" value="D5" id="D5" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="D5" value="D5" id="D5" disabled><%} %><br><span>D5</span></center></td>
					<td><center><%if(sd6.equals("notbooked")){ %><input type="checkbox" class="test" name="D6" value="D6" id="D6" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="D6" value="D6" id="D6" disabled><%} %><br><span>D6</span></center></td>
				</tr>
				<tr>
					<td><center><%if(sc1.equals("notbooked")){ %><input type="checkbox" class="test" name="C1" value="C1" id="C1" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="C1" value="C1" id="C1" disabled><%} %><br><span>C1</span></center></td>
					<td><center><%if(sc2.equals("notbooked")){ %><input type="checkbox" class="test" name="C2" value="C2" id="C2" onclick="display(this.id);"onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="C2" value="C2" id="C2" disabled><%} %><br><span>C2</span></center></td>
					<td><center><%if(sc3.equals("notbooked")){ %><input type="checkbox" class="test" name="C3" value="C3" id="C3" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="C3" value="C3" id="C3" disabled><%} %><br><span>C3</span></center></td>
					<td><center><%if(sc4.equals("notbooked")){ %><input type="checkbox" class="test" name="C4" value="C4" id="C4" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="C4" value="C4" id="C4" disabled><%} %><br><span>C4</span></center></td>
					<td><center><%if(sc5.equals("notbooked")){ %><input type="checkbox" class="test" name="C5" value="C5" id="C5" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="C5" value="C5" id="C5" disabled><%} %><br><span>C5</span></center></td>
					<td><center><%if(sc6.equals("notbooked")){ %><input type="checkbox" class="test" name="C6" value="C6" id="C6" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="C6" value="C6" id="C6" disabled><%} %><br><span>C6</span></center></td>
				</tr>
			</table>
			<table height="130" width="800">
				<tr>
					<td><center><%if(sb1.equals("notbooked")){ %><input type="checkbox" class="test" name="B1" value="B1" id="B1" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="B1" value="B1" id="B1" disabled><%} %><br><span>B1</span></center></td>
					<td><center><%if(sb2.equals("notbooked")){ %><input type="checkbox" class="test" name="B2" value="B2" id="B2" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="B2" value="B2" id="B2" disabled><%} %><br><span>B2</span></center></td>
					<td><center><%if(sb3.equals("notbooked")){ %><input type="checkbox" class="test" name="B3" value="B3" id="B3" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="B3" value="B3" id="B3" disabled><%} %><br><span>B3</span></center></td>
					<td><center><%if(sb4.equals("notbooked")){ %><input type="checkbox" class="test" name="B4" value="B4" id="B4" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="B4" value="B4" id="B4" disabled><%} %><br><span>B4</span></center></td>
					<td><center><%if(sb5.equals("notbooked")){ %><input type="checkbox" class="test" name="B5" value="B5" id="B5" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="B5" value="B5" id="B5" disabled><%} %><br><span>B5</span></center></td>
					<td><center><%if(sb6.equals("notbooked")){ %><input type="checkbox" class="test" name="B6" value="B6" id="B6" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="B6" value="B6" id="B6" disabled><%} %><br><span>B6</span></center></td>
				</tr>
				<tr>
					<td><center><%if(sa1.equals("notbooked")){ %><input type="checkbox" class="test" name="A1" value="A1" id="A1" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="A1" value="A1" id="A1" disabled><%} %><br><span>A1</span></center></td>
					<td><center><%if(sa2.equals("notbooked")){ %><input type="checkbox" class="test" name="A2" value="A2" id="A2" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="A2" value="A2" id="A2" disabled><%} %><br><span>A2</span></center></td>
					<td><center><%if(sa3.equals("notbooked")){ %><input type="checkbox" class="test" name="A3" value="A3" id="A3" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="A3" value="A3" id="A3" disabled><%} %><br><span>A3</span></center></td>
					<td><center><%if(sa4.equals("notbooked")){ %><input type="checkbox" class="test" name="A4" value="A4" id="A4" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="A4" value="A4" id="A4" disabled><%} %><br><span>A4</span></center></td>
					<td><center><%if(sa5.equals("notbooked")){ %><input type="checkbox" class="test" name="A5" value="A5" id="A5" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="A5" value="A5" id="A5" disabled><%} %><br><span>A5</span></center></td>
					<td><center><%if(sa6.equals("notbooked")){ %><input type="checkbox" class="test" name="A6" value="A6" id="A6" onclick="display(this.id);"><%}else{ %><input type="checkbox" class="test" name="A6" value="A6" id="A6" disabled><%} %><br><span>A6</span></center></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><center><div><label style="font-size:20px;margin-left:30px;">Rs.</label><input type="text" name="amount" value="0" id="ammt" style="font-size:20px;border:none;"></div><div id="res"></div></center></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="child">
			<table height="450" width="550">
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
					<td><center><input type="submit" value="Book Ticket" class="b1"></center></td>
				</tr>
			</table>
		</div>
</div>
</form>
</body>
</html>