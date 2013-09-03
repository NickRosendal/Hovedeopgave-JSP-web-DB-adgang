<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<script src="main.js"></script>

<link rel="stylesheet" type="text/css" href="MobileLayout.css">

<title>Doorfilter Web Acces</title>
</head>
<body onload="runOnWelcomeJsp()">
	<div id="container">
		<div id="top_content">
			<h1>Login Accepted</h1>
			<%
				code.info o = (code.info) request.getSession().getAttribute("info");
				int unknowns = o.GetNumberOfUnknows();

				out.println("we have " + unknowns + " unknown guests");
			%>

			</> <br />

			<%
				if (unknowns > 0) {
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

		<div id="lower_content">
		<%
		 
		code.Statistics thisstatistics = new code.Statistics();
	
		%>
			<article id="art_thursday">
				<header>
					<h1>Thursday's</h1>
					<%
					code.night fifth = thisstatistics.getNightscollection().get(0);
					code.night fourth = thisstatistics.getNightscollection().get(3);
					code.night third = thisstatistics.getNightscollection().get(2);
					code.night second = thisstatistics.getNightscollection().get(1);
					code.night first = thisstatistics.getNightscollection().get(4);
					
					int maxHeight = first.getTotalGuests();
					if(second.getTotalGuests() > maxHeight) maxHeight = second.getTotalGuests();
					if(third.getTotalGuests() > maxHeight) maxHeight = third.getTotalGuests();
					if(fourth.getTotalGuests() > maxHeight) maxHeight = fourth.getTotalGuests();
					if(fifth.getTotalGuests() > maxHeight) maxHeight = fifth.getTotalGuests();

					
					%>
				</header>

				<section>
					<div id="barContainer">
						<div id="notArealBar" class="bar" ></div>
						<div id="barThursday" class="bar" style="height: <%=(100/maxHeight)*first.getTotalGuests()    %>%"></div>
						<div id="barThursday" class="bar" style="height: <%=(100/maxHeight)*second.getTotalGuests()    %>%"></div>
						<div id="barThursday" class="bar" style="height: <%=(100/maxHeight)*third.getTotalGuests()      %>%"></div>
						<div id="barThursday" class="bar" style="height: <%=(100/maxHeight)*fourth.getTotalGuests()     %>%"></div>
						<div id="barThursday" class="bar" style="height: <%=(100/maxHeight)*fifth.getTotalGuests()      %>%"></div>
						<div id="notArealBar" class="bar" style="margin-right: 0px;"></div>

					</div>

					<div id="thur_barInfoContainer" class="barInfoContainer">
						<div id="thur_bar_des" class="bar_info">
							<p>dato:</p>
							<p>total:</p>
							<p>mænd:</p>
							<p>kvinder:</p>
						</div>


						<div id="thur_bar1_info" class="bar_info">
							<p><%=first.getTheDate().substring(5) %></p>
							<p><%=first.getTotalGuests() %></p>
							<p><%=first.getMaleGuests() %></p>
							<p><%=first.getFemaleGuests() %></p>
						</div>
						<div id="thur_bar2_info" class="bar_info">

							<p><%=second.getTheDate().substring(5) %></p>
							<p><%=second.getTotalGuests() %></p>
							<p><%=second.getMaleGuests() %></p>
							<p><%=second.getFemaleGuests() %></p>
						</div>
						<div id="thur_bar3_info" class="bar_info">
							<p><%=third.getTheDate().substring(5) %></p>
							<p><%=third.getTotalGuests() %></p>
							<p><%=third.getMaleGuests() %></p>
							<p><%=third.getFemaleGuests() %></p>
						</div>
						<div id="thur_bar4_info" class="bar_info">
							<p><%=fourth.getTheDate().substring(5) %></p>
							<p><%=fourth.getTotalGuests() %></p>
							<p><%=fourth.getMaleGuests() %></p>
							<p><%=fourth.getFemaleGuests() %></p>
						</div>
						<div id="thur_bar5_info" class="bar_info">
							<p><%=fifth.getTheDate().substring(5) %></p>
							<p><%=fifth.getTotalGuests() %></p>
							<p><%=fifth.getMaleGuests() %></p>
							<p><%=fifth.getFemaleGuests() %></p>
						</div>
						<div class="bar_info" id="thur_showHide"
							style="margin-right: 0px;"></div>
					</div>



				</section>



			</article>

			<article id="art_friday">
				<header>
					<h1>Friday's</h1>
					<%
					code.night fri_fifth = thisstatistics.getNightscollection().get(5);
					code.night fri_fourth = thisstatistics.getNightscollection().get(6);
					code.night fri_third = thisstatistics.getNightscollection().get(7);
					code.night fri_second = thisstatistics.getNightscollection().get(8);
					code.night fri_first = thisstatistics.getNightscollection().get(9);
					
					int fri_maxHeight = first.getTotalGuests();
					if(second.getTotalGuests() > maxHeight) maxHeight = second.getTotalGuests();
					if(third.getTotalGuests() > maxHeight) maxHeight = third.getTotalGuests();
					if(fourth.getTotalGuests() > maxHeight) maxHeight = fourth.getTotalGuests();
					if(fifth.getTotalGuests() > maxHeight) maxHeight = fifth.getTotalGuests();

					
					%>
					
				</header>

				<section>
					<div id="barContainer">
						<div id="notArealBar" class="bar" ></div>
						<div id="barFriday" class="bar" style="height: <%=(100/fri_maxHeight)*fri_first.getTotalGuests()    %>%"></div>
						<div id="barFriday" class="bar" style="height: <%=(100/fri_maxHeight)*fri_second.getTotalGuests()    %>%"></div>
						<div id="barFriday" class="bar" style="height: <%=(100/fri_maxHeight)*fri_third.getTotalGuests()      %>%"></div>
						<div id="barFriday" class="bar" style="height: <%=(100/fri_maxHeight)*fri_fourth.getTotalGuests()     %>%"></div>
						<div id="barFriday" class="bar" style="height: <%=(100/fri_maxHeight)*fri_fifth.getTotalGuests()      %>%"></div>
						<div id="notArealBar" class="bar" style="margin-right: 0px;"></div>

					</div>

					<div id="fri_barInfoContainer" class="barInfoContainer">
						<div id="fri_bar_des" class="bar_info">
							<p>dato:</p>
							<p>total:</p>
							<p>mænd:</p>
							<p>kvinder:</p>
						</div>


						<div id="fri_bar1_info" class="bar_info">
							<p><%=fri_first.getTheDate().substring(5) %></p>
							<p><%=fri_first.getTotalGuests() %></p>
							<p><%=fri_first.getMaleGuests() %></p>
							<p><%=fri_first.getFemaleGuests() %></p>
						</div>
						<div id="fri_bar2_info" class="bar_info">

							<p><%=fri_second.getTheDate().substring(5) %></p>
							<p><%=fri_second.getTotalGuests() %></p>
							<p><%=fri_second.getMaleGuests() %></p>
							<p><%=fri_second.getFemaleGuests() %></p>
						</div>
						<div id="fri_bar3_info" class="bar_info">
							<p><%=fri_third.getTheDate().substring(5) %></p>
							<p><%=fri_third.getTotalGuests() %></p>
							<p><%=fri_third.getMaleGuests() %></p>
							<p><%=fri_third.getFemaleGuests() %></p>
						</div>
						<div id="fri_bar4_info" class="bar_info">
							<p><%=fri_fourth.getTheDate().substring(5) %></p>
							<p><%=fri_fourth.getTotalGuests() %></p>
							<p><%=fri_fourth.getMaleGuests() %></p>
							<p><%=fri_fourth.getFemaleGuests() %></p>
						</div>
						<div id="fri_bar5_info" class="bar_info">
							<p><%=fri_fifth.getTheDate().substring(5) %></p>
							<p><%=fri_fifth.getTotalGuests() %></p>
							<p><%=fri_fifth.getMaleGuests() %></p>
							<p><%=fri_fifth.getFemaleGuests() %></p>
						</div>
						<div class="bar_info" id="fri_showHide" style="margin-right: 0px;"></div>
					</div>


				</section>


			</article>

			<article id="art_saturday">
				<header>
					<h1>Saturday's</h1>
										<%
					code.night sat_fifth = thisstatistics.getNightscollection().get(10);
					code.night sat_fourth = thisstatistics.getNightscollection().get(11);
					code.night sat_third = thisstatistics.getNightscollection().get(12);
					code.night sat_second = thisstatistics.getNightscollection().get(13);
					code.night sat_first = thisstatistics.getNightscollection().get(14);
					
					int sat_maxHeight = first.getTotalGuests();
					if(second.getTotalGuests() > maxHeight) maxHeight = second.getTotalGuests();
					if(third.getTotalGuests() > maxHeight) maxHeight = third.getTotalGuests();
					if(fourth.getTotalGuests() > maxHeight) maxHeight = fourth.getTotalGuests();
					if(fifth.getTotalGuests() > maxHeight) maxHeight = fifth.getTotalGuests();

					
					%>
				</header>

				<section>
					<div id="barContainer">
						<div id="notArealBar" class="bar" ></div>
						<div id="barSaturday" class="bar" style="height: <%=(100/sat_maxHeight)*sat_first.getTotalGuests()    %>%"></div>
						<div id="barSaturday" class="bar" style="height: <%=(100/sat_maxHeight)*sat_second.getTotalGuests()    %>%"></div>
						<div id="barSaturday" class="bar" style="height: <%=(100/sat_maxHeight)*sat_third.getTotalGuests()      %>%"></div>
						<div id="barSaturday" class="bar" style="height: <%=(100/sat_maxHeight)*sat_fourth.getTotalGuests()     %>%"></div>
						<div id="barSaturday" class="bar" style="height: <%=(100/sat_maxHeight)*sat_fifth.getTotalGuests()      %>%"></div>
						<div id="notArealBar" class="bar" style="margin-right: 0px;"></div>

					</div>

					<div id="sat_barInfoContainer" class="barInfoContainer">
						<div id="sat_bar_des" class="bar_info">
							<p>dato:</p>
							<p>total:</p>
							<p>mænd:</p>
							<p>kvinder:</p>
						</div>


						<div id="sat_bar1_info" class="bar_info">
							<p><%=sat_first.getTheDate().substring(5) %></p>
							<p><%=sat_first.getTotalGuests() %></p>
							<p><%=sat_first.getMaleGuests() %></p>
							<p><%=sat_first.getFemaleGuests() %></p>
						</div>
						<div id="sat_bar2_info" class="bar_info">

							<p><%=sat_first.getTheDate().substring(5) %></p>
							<p><%=sat_first.getTotalGuests() %></p>
							<p><%=sat_first.getMaleGuests() %></p>
							<p><%=sat_first.getFemaleGuests() %></p>
						</div>
						<div id="sat_bar3_info" class="bar_info">
							<p><%=sat_first.getTheDate().substring(5) %></p>
							<p><%=sat_first.getTotalGuests() %></p>
							<p><%=sat_first.getMaleGuests() %></p>
							<p><%=sat_first.getFemaleGuests() %></p>
						</div>
						<div id="sat_bar4_info" class="bar_info">
							<p><%=sat_first.getTheDate().substring(5) %></p>
							<p><%=sat_first.getTotalGuests() %></p>
							<p><%=sat_first.getMaleGuests() %></p>
							<p><%=sat_first.getFemaleGuests() %></p>
						</div>
						<div id="sat_bar5_info" class="bar_info">
							<p><%=sat_first.getTheDate().substring(5) %></p>
							<p><%=sat_first.getTotalGuests() %></p>
							<p><%=sat_first.getMaleGuests() %></p>
							<p><%=sat_first.getFemaleGuests() %></p>
						</div>
						<div class="bar_info" id="sat_showHide" style="margin-right: 0px;"></div>
					</div>
				</section>
			</article>
		</div>
	</div>
</body>
</html>