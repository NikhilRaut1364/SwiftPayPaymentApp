<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.out{
font-family:candara;
font-size:90px;
color:white;
}
</style>
<meta charset="ISO-8859-1">
<title>Logout</title>
<script type="text/javascript">
setTimeout(function(){
    window.location.href = "loginForm.jsp";
  }, 5000);
</script>
</head>
<body style="background-color:#25488e">
<form method="POST">
<center>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<span class="out">You Are Successfully Logged Out!</span>
</center>
</form>
<% 
	session.invalidate();
%>

</body>
</html>