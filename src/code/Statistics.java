package code;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Statistics
{
	public ArrayList<night> getNightscollection()
	{
		return nightscollection;
	}

	private HashMap<String, String> guestSex;
	private dbhandle thisdbhandle;
	private ArrayList<night> nightscollection;

	public Statistics()
	{
		super();
		/*
		 * HERE I SHOULD ask dp for some info.
		 */
		thisdbhandle = new dbhandle();
		nightscollection = new ArrayList<night>();

		guestSex = thisdbhandle.getGuestIdSexMap();

		for (String date : ThrursdaysToGet())
		{

			int total = 0;
			int female = 0;
			int male = 0;

			ArrayList<visit> guests = thisdbhandle.getNight(date);
			for (visit one : guests)
			{
				one.setGender(guestSex.get(one.getId()));
				total++;
				String sex = one.getGender();
				try
				{
					if (sex.equals("M"))
					{
						male++;
					} else if (sex.equals("F"))
					{
						female++;
					}
				} catch (NullPointerException E)
				{

				}
			}
			nightscollection.add(new night(date, "Thursday", total, male, female));

		}

		for (String date : FridaysToGet())
		{
			int total = 0;
			int female = 0;
			int male = 0;

			ArrayList<visit> guests = thisdbhandle.getNight(date);
			for (visit one : guests)
			{
				one.setGender(guestSex.get(one.getId()));
				total++;
				String sex = one.getGender();
				if (sex.equals("M"))
				{
					male++;
				} else if (sex.equals("F"))
				{
					female++;
				}
			}
			nightscollection.add(new night(date, "Friday", total, male, female));
		}

		for (String date : SaturdaysToGet())
		{
			int total = 0;
			int female = 0;
			int male = 0;

			ArrayList<visit> guests = thisdbhandle.getNight(date);
			for (visit one : guests)
			{
				one.setGender(guestSex.get(one.getId()));
				total++;
				String sex = one.getGender();
				if (sex.equals("M"))
				{
					male++;
				} else if (sex.equals("F"))
				{
					female++;
				}
			}
			nightscollection.add(new night(date, "Saturday", total, male, female));
		}

	}

	private String[] ThrursdaysToGet()
	{

		String[] returnStrings = new String[5];

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar today = Calendar.getInstance();
		today.setFirstDayOfWeek(Calendar.MONDAY);
		int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);

		// OKAY FAT SØNDAG = 1
		if (dayOfWeek != 5)
		{
			if (dayOfWeek > 5)
			{

				today.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			} else
			{

				today.add(Calendar.DATE, -5);
				today.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

			}
		}
		returnStrings[0] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[1] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[2] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[3] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[4] = dateFormat.format(today.getTime());

		return returnStrings;
	}

	private String[] FridaysToGet()
	{

		String[] returnStrings = new String[5];

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar today = Calendar.getInstance();
		today.setFirstDayOfWeek(Calendar.MONDAY);
		int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);

		// OKAY FAT SØNDAG = 1
		if (dayOfWeek != 6)
		{
			if (dayOfWeek > 6)
			{

				today.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			} else
			{

				today.add(Calendar.DATE, -6);
				today.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

			}
		}
		returnStrings[0] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[1] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[2] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[3] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[4] = dateFormat.format(today.getTime());

		return returnStrings;
	}

	private String[] SaturdaysToGet()
	{
		String[] returnStrings = new String[5];

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar today = Calendar.getInstance();
		today.setFirstDayOfWeek(Calendar.MONDAY);
		int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);

		// OKAY FAT SØNDAG = 1
		if (dayOfWeek != 7)
		{

			today.add(Calendar.DATE, -7);
			today.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		}
		returnStrings[0] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[1] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[2] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[3] = dateFormat.format(today.getTime());
		today.add(Calendar.DATE, -7);
		returnStrings[4] = dateFormat.format(today.getTime());

		return returnStrings;
	}

}
