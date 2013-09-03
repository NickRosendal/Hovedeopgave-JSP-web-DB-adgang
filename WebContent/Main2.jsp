<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<script src="main.js"></script>

<link rel="stylesheet" type="text/css" href="MobileLayout.css">
<title>Doorfilter Web Acces</title>
</head>
<body onload="runOnMainJsp()">
	<div id="container">
		<h1>Please submit login information</h1>

		<form action="LoginServlet" id="loginInForm">
		
		<div id=mainFormDiv>
		<!-- 
		
		
		Value should be change to:
		placeholder="Username" 
		
		-->
	
			<input type="text" name="LoginName" value="Kim" class="formInput"/> 
			</div>
	
	
			<!--
			Value should be change to
			placeholder="Password" 
			-->
			<div id=mainFormDiv>
			<input type="password" name="LoginPassword" value="123" class="formInput"/> 
			</div>
		
			<!--
			add some validation that somthing has been put into both username and password
			-->
			<div id=mainFormDiv>
			<input type="submit" value="Submit" id="formSaveButton"/>
			</div>

		</form>

	</div>
</body>
</html>
