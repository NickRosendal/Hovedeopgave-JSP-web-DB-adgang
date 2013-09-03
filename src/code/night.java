package code;

import java.util.Date;

public class night
{

	//the pourpose of this class is to have one single night!
	String theDate;
	String weeknight;
	int totalGuests;
	int maleGuests;
	int femaleGuests;
	
	public night(String theDate, String weeknight, int totalGuests, int maleGuests, int femaleGuests)
	{
		super();
		
		
		if(totalGuests==0){
			totalGuests=1;
		}
//		if(maleGuests==0){
//			maleGuests=1;
//		}
//		if(femaleGuests==0){
//			femaleGuests=1;
//		}
System.out.println(theDate+"   "+ "total"+totalGuests);
		
		this.theDate = theDate;
		this.weeknight = weeknight;
		this.totalGuests=totalGuests;
		this.maleGuests=maleGuests;
		this.femaleGuests=femaleGuests;
	}

	public String getTheDate()
	{
		return theDate;
	}

	public String getWeeknight()
	{
		return weeknight;
	}

	public int getTotalGuests()
	{
		return totalGuests;
	}

	public int getMaleGuests()
	{
		return maleGuests;
	}

	public int getFemaleGuests()
	{
		return femaleGuests;
	}
	
	
}
