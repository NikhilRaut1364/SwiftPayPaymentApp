<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SwiftPay Main</title>
<script type="text/javascript">
function search(a)
{
	var find=a.toLowerCase().split(" ").join("");
	if(find=="movie")
	{
		document.location.href="movie.jsp";
	}
	else if(find=="electricity")
	{
		document.location.href="electricity1.jsp";
	}
	else if(find=="mobilerecharge")
	{
		document.location.href="mobileRecharge.jsp";
	}
	else if(find=="postpaid")
	{
		document.location.href="postpaid.jsp";
	}
	else if(find=="dth")
	{
		document.location.href="dth1.jsp";
	}
	else if(find=="landline")
	{
		document.location.href="landline1.jsp";
	}
	else if(find=="broadband")
	{
		document.location.href="broadband1.jsp";
	}
	else if(find=="schoolfees")
	{
		document.location.href="schoolfees.jsp";
	}
	else if(find=="creditcard")
	{
		document.location.href="creditcard1.jsp";
	}
	else if(find=="bus")
	{
		document.location.href="bus.jsp";
	}
	else if(find=="flight")
	{
		document.location.href="flight.jsp";
	}
	else if(find=="train")
	{
		document.location.href="train.jsp";
	}
	else if(find=="event")
	{
		document.location.href="event.jsp";
	}
	else if(find=="endgame")
	{
		document.location.href="endgame1.jsp";
	}
	else if(find=="jumanji")
	{
		document.location.href="jumanji1.jsp";
	}
	else if(find=="thegooddinosaur")
	{
		document.location.href="dino1.jsp";
	}
	else if(find=="justiceleague")
	{
		document.location.href="justice1.jsp";
	}
}

var slideIndex = 0;


function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout("showSlides()", 2000);
}
window.onload=showSlides;
</script>
<style>
*{
margin:0px;
font-family:candara;
}
.heading{
height:180px;
width:100%;
display:flex;
align-items:center;
justify-content:space-around;
}
.plane{
height:120px;
width:220px;
display:flex;
justify-content:center;
align-items:center;
}
.search{
height:100px;
width:550px;
display:flex;
align-items:center;
justify-content:center;
}



.history{
height:130px;
width:130px;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
}

.wallet{
height:130px;
width:130px;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
}

.wallet:hover{
cursor:pointer;
}

.noti{
height:130px;
width:130px;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
}

.noti:hover{
cursor:pointer;
}

.about{
height:100px;
width:190px;
display:flex;
align-items:center;
justify-content:center;
margin-left:30px;
}

.about:hover{
cursor:pointer;
}

.logout{
height:130px;
width:130px;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
}

.logout:hover{
cursor:pointer;
}

input[type=text]{
width:550px;
background-color:white;
background-image:url('search.png');
background-position:10px 10px;
background-size:25px 25px;
background-repeat:no-repeat;
font-size:20px;
padding:12px 20px 12px 40px;
border:none;
border-bottom:2px solid #25488e;
}

.parent{
height:380px;
width:100%;
display:flex;
justify-content:center;
flex-direction:column;
align-items:center;
background-color:#25488e;
}

.child{
height:250px;
width:75%;
display:flex;
justify-content:space-around;
align-items:center;
}

.child-1{
height:150px;
width:150px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
}

.child-1:hover{
cursor:pointer;
background-color:#5d85d5;
}

.parent1{
margin-top:30px;
height:620px;
width:80%;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
background-color:white;
box-shadow: 10px 10px 5px grey;
border-radius:25px;
padding:20px;
}

.child1{
height:550px;
width:70%;
display:flex;
justify-content:center;
align-items:center;
justify-content:space-around;
flex-wrap:wrap;
}

.child-2{
height:150px;
width:150px;
margin-left:50px;
margin-right:50px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
}

.child-2:hover{
cursor:pointer;
background-color:#c2d1ef;
}

.parent2{
height:330px;
width:80%;
margin-top:30px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
background-color:white;
box-shadow: 10px 10px 5px grey;
border-radius:25px;
padding:20px;
}

.child2{
height:230px;
width:75%;
display:flex;
justify-content:space-around;
align-items:center;

}

.child-3{
height:150px;
width:150px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
}

.parent3{
height:300px;
width:80%;
margin-top:30px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
background-color:white;
box-shadow: 10px 10px 5px grey;
border-radius:25px;
padding:20px;
}

.child3{
height:200px;
width:75%;
display:flex;
justify-content:space-around;
align-items:center;
}

.child-4{
height:150px;
width:150px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
}

.parent4{
height:300px;
width:80%;
margin-top:30px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
background-color:white;
box-shadow: 10px 10px 5px grey;
border-radius:25px;
padding:20px;
}

.parent5{
height:600px;
width:80%;
margin-top:30px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
background-color:white;
box-shadow: 10px 10px 5px grey;
border-radius:25px;
padding:20px;
}

.child5{
height:200px;
width:75%;
display:flex;
justify-content:space-around;
align-items:center;
}

.child-6{
height:150px;
width:150px;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
}

.child-3:hover{
cursor:pointer;
background-color:#c2d1ef;
}

.child-4:hover{
cursor:pointer;
background-color:#c2d1ef;
}

.child-5:hover{
cursor:pointer;
background-color:#c2d1ef;
}

.child-6:hover{
cursor:pointer;
background-color:#c2d1ef;
}

.main{
background-color:#c2d1ef;
height:2500px;
width:100%;
display:flex;
justify-content:space-around;
align-items:center;
flex-direction:column;
}

.footer{
height:150px;
width:100%;
background-color:#25488e;
display:flex;
align-items:center;
}

.terms{
height:100px;
width:400px;
display:flex;
align-items:center;
justify-content:center;
margin-left:30px;
}

.terms:hover{
cursor:pointer;
}

.reward{
height:100px;
width:200px;
display:flex;
align-items:center;
justify-content:center;
margin-left:30px;
}

.reward:hover{
cursor:pointer;
}


.mySlides {display: none;}
img {vertical-align: middle;}

.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
</style>
<link href="css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
	String n="";
	Connection con=null;
	String uname=(String)session.getAttribute("username");
	String sql="select name from user where username='"+uname+"'";
	String url="jdbc:ucanaccess://E://Database//swiftpay.accdb";
	
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		con=DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			n=rs.getString(1);
		}
	}
	catch(Exception e)
	{
		
	}
%>
<div class="heading">
	<div class="plane">
	<i class="fas fa-paper-plane" style="color:#25488e; font-size:50px;"></i>
	&nbsp&nbsp&nbsp
	<span style="font-size:35px;">SwiftPay</span>
	</div>
	<div class="search">
	<input type="text" name="search1" placeholder="Search" onkeypress="search(this.value)">
	</div>
	<div class="history">
	<span style="font-size:20px">Welcome,</span>
	<label style="font-size:20px"><% out.println(n); %></label>
	</div>
	<div class="wallet" onclick="document.location.href='profile.jsp'">
	<i class="fas fa-user-tie" style="color:#25488e; font-size:40px;margin-bottom:10px;"></i>
	<span style="font-size:20px;">Profile</span>
	</div>
	<div class="noti" onclick="document.location.href='notification.jsp'">
	<i class="fas fa-bell" style="color:#25488e; font-size:40px;margin-bottom:10px;"></i>
	<span style="font-size:20px;">Notification</span>
	</div>
	<div class="logout" onclick="document.location.href='logout.jsp'">
	<i class="fas fa-sign-out-alt" style="color:#25488e; font-size:40px;margin-bottom:10px;"></i>
	<span style="font-size:20px;">Logout</span>
	</div>
</div>
<div class="parent">
	<span style="font-size:30px;color:white;"><b> MONEY TRANSFER </b></span>
	<div class="child">
		<div class="child-1" onclick="document.location.href='toContact.jsp'">
		<i class="fas fa-external-link-square-alt" style="color:white; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:white;">To Contact</span>
		</div>
		<div class="child-1" onclick="document.location.href='toBank.jsp'">
		<i class="fas fa-university" style="color:white; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:white;">To Account</span>
		</div>
		<div class="child-1" onclick="document.location.href='checkBalance.jsp'">
		<i class="fas fa-rupee-sign" style="color:white; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:white;">Bank Balance</span>
		</div>
		<div class="child-1" onclick="document.location.href='requestMoney.jsp'">
		<i class="fas fa-level-up-alt" style="color:white; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:white;">Request</span>
		</div>
	</div>
</div>
<div class="main">
<div class="parent1">
	<span style="font-size:30px;color:#666666;"><b>PAY BILLS & RECHARGE</b></span>
	<div class="child1">
		<div class="child-2" onclick="document.location.href='mobileRecharge.jsp'">
		<i class="fas fa-mobile" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Mobile</span><span style="font-size:25px;color:#666666;">Recharge</span>
		</div>
		<div class="child-2" onclick="document.location.href='postpaid.jsp'">
		<i class="fas fa-mobile-alt" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">PostPaid</span>
		</div>
		<div class="child-2" onclick="document.location.href='electricity1.jsp'">
		<i class="far fa-lightbulb" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Electricity</span>
		</div>
		<div class="child-2" onclick="document.location.href='dth1.jsp'">
		<i class="fas fa-satellite-dish" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">DTH</span>
		</div>
		<div class="child-2" onclick="document.location.href='landline1.jsp'">
		<i class="fas fa-tty" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">LandLine</span>
		</div>
		<div class="child-2" onclick="document.location.href='broadband1.jsp'">
		<i class="fas fa-wifi" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">BroadBand</span>
		</div>
		<div class="child-2" onclick="document.location.href='schoolfees.jsp'">
		<i class="fas fa-book-open" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">School Fees</span>
		</div>
		<div class="child-2" onclick="document.location.href='creditcard1.jsp'">
		<i class="fas fa-credit-card" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Credit Card</span>
		</div>
	</div>
</div>
<div class="parent2">
<span style="font-size:30px;color:#666666;"><b>TRAVEL</b></span>
	<div class="child2">
		<div class="child-3" onclick="document.location.href='bus.jsp'">
		<i class="fas fa-bus-alt" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Bus</span>
		</div>
		<div class="child-3" onclick="document.location.href='flight.jsp'">
		<i class="fas fa-plane-departure" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Flight</span>
		</div>
		<div class="child-3" onclick="document.location.href='train.jsp'">
		<i class="fas fa-subway" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Train</span>
		</div>
	</div>
</div>
<div class="parent3">
<span style="font-size:30px;color:#666666;"><b>ENTERTAINMENT</b></span>
	<div class="child3">
		<div class="child-4" onclick="document.location.href='event.jsp'">
		<i class="fas fa-theater-masks" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Events</span>
		</div>
		<div class="child-4" onclick="document.location.href='movie.jsp'">
		<i class="fas fa-film" style="color:#25488e; font-size:60px; margin-bottom:10px;"></i>
		<span style="font-size:25px;color:#666666;">Movies</span>
		</div>
	</div>
</div>
<div class="parent5">
	<div class="slideshow-container">

	<div class="mySlides fade">
 	 <img src="images java/coronaad.jpg" style="height:500px;width:100%">
	</div>

	<div class="mySlides fade">
 	 <img src="images java/coronaad1.png" style="height:500px;width:100%">
	</div>

	<div class="mySlides fade">
 	 <img src="images java/ad.png" style="height:500px;width:100%">
	</div>
	
	<div class="mySlides fade">
 	 <img src="images java/ad1.jpg" style="height:500px;width:100%">
	</div>
	
	</div>
	<br>

	<div style="text-align:center;display:none;">
  	<span class="dot"></span> 
  	<span class="dot"></span> 
 	<span class="dot"></span> 
 	<span class="dot"></span>
	</div>
</div>
</div>
<div class="footer">
	<div class="about" onclick="document.location.href='AboutUs.jsp'">
	<span style="font-size:30px;color:white;">About Us</span>
	</div>
	<div class="terms" onclick="document.location.href='Terms.jsp'">
	<span style="font-size:30px;color:white;">Terms & Conditions</span>
	</div>
	<div class="reward">
	<span style="font-size:30px;color:white;"></span>
	</div>
</div>
<%
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("loginForm.jsp");
	}
	
%>
</body>
</html>