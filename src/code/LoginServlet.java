package code;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet()
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
		String pass = "";
		try
		{
			name = request.getParameter("LoginName");
			pass = request.getParameter("LoginPassword");
		} catch (Exception E)
		{

		}
		dbhandle thisdbhandle = new dbhandle();

		ArrayList<String[]> admins = thisdbhandle.getUsers();
		
		String redirectAddress = "Main2.jsp";
		
		for(String[] admin : admins){
			if (name.equals(admin[0]) && pass.equals(admin[1]))
			{

				//response.sendRedirect("welcome.jsp");
				redirectAddress = "welcome.jsp";
				ResultSet missing = thisdbhandle.queryDB("SELECT * FROM Guest where Name IS NULL");
				

				HttpSession session = request.getSession();

				info thisInfo = new info(missing, name, pass);

				
				session.setAttribute("info", thisInfo);
				//break;
			}
			response.sendRedirect(redirectAddress);

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
