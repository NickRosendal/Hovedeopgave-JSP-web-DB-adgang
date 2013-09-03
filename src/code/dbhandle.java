package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.sun.rowset.CachedRowSetImpl;

public class dbhandle
{

	Connection connection = null;
	Statement statement = null;

	public CachedRowSetImpl queryDB(String in)
	{

		CachedRowSetImpl crs = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/nickrosendal/Documents/workspace/dummie/DB/guestDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			// create CachedRowSet and populate
			crs = new CachedRowSetImpl();
			crs.populate(statement.executeQuery(in));

		} catch (SQLException e)
		{

		} catch (ClassNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally
		{
			closeDB();
		}
		return crs;
	}

	public void addToLog(String editor, String subject)
	{

		try
		{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/nickrosendal/Documents/workspace/dummie/DB/logDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			// ResultSet temp =
			// statement.executeQuery("SELECT rowid FROM users where username='"+editor+"'");
			// String editorID = temp.getString("rowid");

			String query = "INSERT INTO events VALUES (datetime(),'" + editor + "','profile edited for id:" + subject + "')";
			statement.executeQuery(query);
		} catch (SQLException e)
		{

		} catch (ClassNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally
		{
			closeDB();
		}

	}

	public ArrayList<String[]> getUsers()
	{
		ArrayList<String[]> admins = new ArrayList<String[]>();
		String[] admin =
		{ "", "" };

		try
		{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/nickrosendal/Documents/workspace/dummie/DB/logDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			// ResultSet temp =
			// statement.executeQuery("SELECT rowid FROM users where username='"+editor+"'");
			// String editorID = temp.getString("rowid");

			String query = "SELECT * from users where type = 'admin'";
			ResultSet rs = statement.executeQuery(query);

			while (rs.next())
			{

				admin[0] = rs.getString("username");
				admin[1] = rs.getString("password");
				admins.add(admin);
			}

		} catch (SQLException e)
		{

		} catch (ClassNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally
		{
			closeDB();
		}
		return admins;

	}

	public void addEvent(String subject)
	{
		String query = "INSERT INTO Event VALUES (datetime(),'" + subject + "','profile edited')";
		queryDB(query);

	}

	public void editGuest(String id, String name, String birthday, String sex)
	{

		/*
		 * ID CANNOT BE NULL (it should never be able to go here if it was
		 * though!)
		 */
		if (id != null)
		{

			String query = "UPDATE Guest SET Name = ";
			if (name != null && !name.equals(""))
			{
				query += "'" + name + "'";
			} else
				query += "null";

			if (birthday != null && !birthday.equals(""))
			{
				query += ", Birthday = '" + birthday + "'";
			} else
				query += ", Birthday = null";

			if (sex != null && !sex.equals(""))
			{
				query += ", Sex = '" + sex + "'";
			} else
				query += ", Sex  = null";

			query += " WHERE ID = " + id;

			queryDB(query);
		}

	}

	/**
	 * 
	 * @param dateIn
	 *            , needs to be "yyyy-mm-dd"
	 * @return list of visitors, THE SEX is unknown!
	 */
	public ArrayList<visit> getNight(String dateIn)
	{
		ArrayList<visit> visitors = new ArrayList<visit>();

		try
		{

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/nickrosendal/Documents/workspace/dummie/DB/guestDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			// String untildate="2011-10-08";//can take any date in current
			// format
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateFormat.parse(dateIn));
			cal.add(Calendar.DATE, 1);
			String dayAfter = dateFormat.format(cal.getTime());

			String start = dateIn + " 16:00:00";
			String end = dayAfter + " 16:00:00";

			String query = "SELECT * from Event where DateTime >= Datetime('" + start + "') and DateTime <= Datetime('" + end + "')";
System.out.println(query);
			ResultSet rs = statement.executeQuery(query);

			while (rs.next())
			{

				String id = rs.getString("Id");
				visitors.add(new visit(id, dateIn));

			}

		} catch (SQLException e)
		{

		} catch (ClassNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			closeDB();
		}

		return visitors;
	}

	public HashMap<String, String> getGuestIdSexMap(){
		
		HashMap<String, String> returnMap = new HashMap<String, String>();
		
		//SELECT Id, Sex from Guest where Id is '3'

		try
		{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/nickrosendal/Documents/workspace/dummie/DB/guestDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			String query = "SELECT Id, Sex from Guest";
			
			ResultSet rs = statement.executeQuery(query);

			while (rs.next())
			{
				System.out.println("found a guest");

				String id = rs.getString("Id");
				String sex = rs.getString("Sex");
				
				returnMap.put(id, sex);

			}

			
			
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	}

	public void closeDB()
	{
		try
		{
			connection.close();
		} catch (SQLException e)
		{
		}
	}
}
