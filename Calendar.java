//******************************************************************************
//	Calendar.java		Author: Ian Nobile
//
//	Represents a scheduled event, with its own name and specific date. 
//	
//******************************************************************************


public class Calendar
{
	int iDay = 0;
	int iMonth = 0;
	int iYear = 0;
	String sEventName = "";
	MonthException eMonthProb = new MonthException("eMonthProb");
	YearException eYearProb = new YearException("eYearProb");
	DayException eDayProb = new DayException("eDayProb");
	//list of English month names:
	String[] saMonths = new String[] {"","January","February","March","April",
									"May","June","July","August","September",
									"October","November","December"};
	//list of number of days for each month:
	int[] saDays = new int[] {0,31,29,31,30,31,30,31,31,30,31,30,31};
	
	
	//--------------------------------------------------------------------------
	//	<<constructor>>; Creates the default Calendar event (which was a long   
	//	time ago!)
	//--------------------------------------------------------------------------
	public Calendar()
	{
		iDay = 1;
		iMonth = 1;
		iYear = 1900;
		sEventName = null;
	}
	
	
	//--------------------------------------------------------------------------
	//	<<constructor>>; Creates Calendar event using date and name parametres
	//--------------------------------------------------------------------------
	public Calendar(String date, String name) throws DayException, 
			MonthException, YearException
	{
		setDate(date);
		sEventName = name;	
	}
	
	
	//--------------------------------------------------------------------------
	//	<<accessors>>; Below are getters for day, year, event name and 
	//	month(word):
	//--------------------------------------------------------------------------
	public int getDay()
	{
		return iDay;
	}
	
	
	public int getYear()
	{
		return iYear;
	}
	
	
	public String getEventName()
	{
		return sEventName;
	}
	
	
	public String getMonth()
	{	
		return saMonths[iMonth];
	}
	
	
	//--------------------------------------------------------------------------
	//	<<mutators>>; Below are mutators for date and event name
	//--------------------------------------------------------------------------
	public void setDate(String date) throws DayException, MonthException, 
				YearException
	{
		//takes user input and enters it into a String array, splitting it if  
		//slashes, spaces or comma-space combinations are detected:
		String saDate[]=date.split("\\s|,\\s|\\n|/");
		
		//attempts to read the month variable as a number before trying to check
		//it against the months listed above:
		try
		{
			iMonth=Integer.parseInt(saDate[0]);
		}
		catch(NumberFormatException e) //if it's not a number
		{
			for(int i=1; i<13; i++)
			{
				if(saDate[0].compareTo(saMonths[i])==0)
				{
					iMonth=i;
					break;
				} //end if
			} //end for
		} //end try
		catch(NullPointerException e) //if there's nothing there
		{
			throw eMonthProb;
		}
		if(iMonth<1||iMonth>12){throw eMonthProb;} //if it's not a valid month
		
		
		//attempts to read year as a number:
		try
		{
			iYear=Integer.parseInt(saDate[2]);
		}
		catch(NumberFormatException e) //if it's a word
		{
			throw eYearProb;
		}
		catch(NullPointerException e) //if it wasn't entered
		{
			throw eYearProb;
		}
		
		//attempts to read day as a number:
		try
		{
			iDay=Integer.parseInt(saDate[1]);	
		}
		catch(NumberFormatException e) //if it's not a number
		{
			throw eDayProb;
		}
		catch(NullPointerException e) //if wasn't entered at all
		{
			throw eDayProb;
		}
		
		//keeps users from entering invalid days or claiming Feb. 29th in any 
		//year not a leap year:
		if((iDay < 01) || (iDay > saDays[iMonth]) || 
		((iMonth == 02 && iDay == 29) && ((iYear % 400 != 0) || 
		(iYear % 100 = 0) || (iYear % 4 != 0)))){throw eDayProb;}
		
	} //end setDate
	
	
	public void setEvent(String name)
	{
		sEventName = name;
	}
	
	//--------------------------------------------------------------------------
	//	Returns date in specific format (digit or word) 
	//--------------------------------------------------------------------------
	public String getEventDate(String format)
	{
		if(format.compareTo("digit")==0)
		{
			return iMonth + "/" + iDay + "/" + iYear + "\t" + getEventName();
		}
		else if(format.compareTo("word")==0)
		{
			return getMonth() + " " + iDay + ", " + iYear + "\t" 
					+ getEventName();
		}
		return null; //Satisfies the "This method must return a result of type 
					 //String" error in the Eclipse code editor
		
	} //end getEventDate
	
} //end main

