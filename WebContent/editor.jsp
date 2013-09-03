<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	
	<script src="main.js"></script>
	



<link rel="stylesheet" type="text/css" href="MobileLayout.css">

<title>Doorfilter Web Acces</title>
</head>
<body onload="runOnEditorJsp()">


	<div id="container">



		<%
			code.info o = (code.info) request.getSession().getAttribute("info");
			String imageSrc = null;
			String id = null;
			try {
				code.unknowGuest temp = o.getNextResult();

				id = temp.getId();
				imageSrc = temp.getPictureId();
			} catch (Exception E) {
				/*
				if some one click refresh, the upper statement askes to get the next unknown element, if the last how ever
				where the last, it is asked to get an element that does not excist.
				
				it should be forced back to the login screen, so the process can be started over
				 */
				response.sendRedirect("Main2.jsp");
				return;
			}
		%>

		<div id="imgContainer">
			<img alt="" src="<%=imageSrc%>" class="myimageclass" alt="">

		</div>



		<div id="formContainer">
	

			<form action="updateGuestServlet" style="height: 100%">

				<input type="hidden" name="guestId" value=" <%=id%> ">

				<div id="test">


					<input type="text" id="nameForm" name="guestName" class="formInput" 
						placeholder="Full name, Jens Magnus Pedersen" />

				</div>
				<div id="test">

					<input type="number" name="guestBirthdayYEAR" id="yearInput"
						 class="dateForm" placeholder="YYYY" />


					<input type="number" name="guestBirthdayMONTH" class="dateForm" id="monthInput"
						placeholder="MM" /> 
						
						
						
						
						<input type="number" name="guestBirthdayDAY" class="dateForm" placeholder="DD" 
						id="dayInput" />





				</div>
				<div id="test">
					<input type="hidden" name="guestSex" value="Female" id="gender">
					<input type="button" id="formSexButton" value="Female" />






				</div>
				<div id="test">

					<input type="submit" value="Save & Next" id="formSaveButton" disabled />
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>