package code;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateGuestServlet
 */
@WebServlet("/updateGuestServlet")
public class updateGuestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateGuestServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		String name = "";
		String birthdayYEAR = "";

		String birthdayMONTH = "";

		String birthdayDAY = "";

		String birthday = "";
		String sex = "";
		String id = "";
		try
		{
			name = request.getParameter("guestName");
			birthdayYEAR = request.getParameter("guestBirthdayYEAR");
			

			birthdayMONTH = request.getParameter("guestBirthdayMONTH");
			if(birthdayMONTH.length() == 1){
				birthdayMONTH = "0"+birthdayMONTH;
			}

			birthdayDAY = request.getParameter("guestBirthdayDAY");
			if(birthdayDAY.length() == 1){
				birthdayDAY = "0"+birthdayDAY;
			}
			
			
			
			sex = request.getParameter("guestSex");

			id = request.getParameter("guestId");


			code.info o = (code.info) request.getSession().getAttribute("info");

			dbhandle thisdbhandle = new dbhandle();
			

			birthday =birthdayYEAR+"-"+birthdayMONTH+"-"+birthdayDAY;
			
			
			//THE VALUE IS EITHER Female or Male, but DB wats F // M
			if(sex.equals("Female")){
				sex= "F";
			}else
				sex="M";

			thisdbhandle.editGuest(id, name, birthday, sex);
			thisdbhandle.addEvent(id);
			thisdbhandle.addToLog(o.getAdmin(), id);



			if (o.GetNumberOfUnknows() > 0)
			{
				response.sendRedirect("editor.jsp");
			} else
				response.sendRedirect("welcome.jsp");

		} catch (Exception E)
		{

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

}
