package code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class info
{
	public info(ResultSet peopleMissingInfo, String admin, String password)
	{
		super();
		Admin = admin;
		Password = password;
		unknowns = resultSet_ToLinkedList(peopleMissingInfo);
	}

	private LinkedList<unknowGuest> unknownGuests = new LinkedList<unknowGuest>();
	private ArrayList<night> information;
	public ArrayList<night> getInformation()
	{
		return information;
	}

	public void setInformation(ArrayList<night> information)
	{
		this.information = information;
	}

	private int unknowns;

	private String Admin = null;
	public String getAdmin()
	{
		return Admin;
	}


	private String Password = null;

	public unknowGuest getNextResult()
	{
		try{
		return unknownGuests.pop();
		}catch(NoSuchElementException E){
			return null;
		}

	}

	private int resultSet_ToLinkedList(ResultSet in)
	{
		int count = 0;
		try
		{
			while (in.next())
			{
				unknownGuests.add(new unknowGuest(in.getString("Id"), in.getString("DocumentationImagePath")));
				count++;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int GetNumberOfUnknows()
	{

		try
		{
			return unknownGuests.size();
		} catch (NoSuchElementException E)
		{
			return 0;
		}
	}

}
