<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link rel="stylesheet" type="text/css" href="MobileLayout.css">

<title>Doorfilter Web Acces</title>
</head>
<body>
	<div id="container">
		<h1>Login Accepted</h1>
		<%
			code.info o = (code.info) request.getSession().getAttribute("info");
			int unknowns = o.GetNumberOfUnknows();

			out.println("we have " + unknowns + " unknown guests");
		%>

		</> <br />

		<%
			if (unknowns > 0)
			{
		%>
		
		
		
		<script type="text/javascript">
		
		/*
		this script is just a href, but it prevents ios web app from leaving fullscreen!
		
		*/
		
		function navigator_Go(url) {
		    window.location.assign(url); // This technique is almost exactly the same as a full <a> page refresh, but it prevents Mobile Safari from jumping out of full-screen mode
		}
		</script>
		
		
		<a href="javascript:navigator_Go('editor.jsp');">
			<button>Start Editing</button>
		</a>
		



		<%
			}
		%>
	</div>
</body>
</html>