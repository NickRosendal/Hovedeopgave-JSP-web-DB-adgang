package code;

import java.util.Date;

public class visit
{

	public String getGender()
	{
		return gender;
	}
 
	public String getDate()
	{
		return date;
	}

	public visit(String id, String date)
	{
		super();
		this.id = id;
		this.date = date; 
	}

	public void setGender(String string)
	{
		this.gender = string;
	}

	private String gender;
	private String date;
	private String id;
	public String getId()
	{
		return id;
	}

}
