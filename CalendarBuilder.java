//******************************************************************************
//	CalendarBuilder.java		Author: Ian Nobile
//
//	Allows a user to create a list of events by entering names and dates and 
//	handles errors by displaying an appropriate message and skipping the 
//	creation of the object in question if a custom exception is thrown. This 
//	program displays an appropriate message when a Calendar object is created 
//	successfully and the list of all accepted dates at the end.
//	
//******************************************************************************

import java.util.Scanner;

public class CalendarBuilder
{
	//--------------------------------------------------------------------------
	//	<<main method>>
	//--------------------------------------------------------------------------
	public static void main(String[] args)
	{
		Calendar[] aCalendar = new Calendar[10];
		int iEventCount = 0;
		String sName = "";
		String sDate = "";
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		char cContinue = 'Y';
		
		//Program begins with a friendly greeting:
		System.out.print("Hello and welcome to the date planner. "); 
		
		//for(int i=0; i<11; i++){break;}	//(unexplored possibility)
		while(cContinue!='N'&&cContinue!='n')
		{
			System.out.print("Please enter the name of your event: ");
			sName = scan.next();
			System.out.print("And on what day will your event be held? (format:"
								+ " \"June 24, 2018\" or \"6/24/2018\") "); 
			sDate = scan.next();
			
			try //attempt to create Calendar object and add it to event array
			{
				Calendar cEvent = new Calendar(sDate, sName);
				aCalendar[iEventCount] = cEvent; 
			}
			//------------------------------------------------------------------
			//	A catch for each possible type of exception; skips creation of  
			//	object if user month, day or year contained an error without  
			//	incrementing the iEventCount var:
			//------------------------------------------------------------------
			catch(MonthException eMonthProb) 
			{
				System.out.println("Apologies, but the month you entered was "
										+ "invalid.\n");
				continue;
			}
			catch(YearException eYearProb)
			{
				System.out.println("Apologies, but the year you entered was "
										+ "invalid.\n");
				continue;
			}
			catch(DayException eDayProb)
			{
				System.out.println("Apologies, but the day you entered was "
										+ "invalid.\n");
				continue;
			}
			finally
			{
				//there's nothing here!
			}
			if(iEventCount==11) {break;}	//allows only ten Calendar objects 
											//to be created.
			
			iEventCount++; //increments created event count
			
			System.out.print("Very good, your event has been created. Would you "
								+ "like to create another? (y/n) ");
			cContinue = scan.next().charAt(0);
		
		} //end while
		
		scan.close(); //prevents data leakage
		
		//----------------------------------------------------------------------
		//	Displays the list of all accepted dates
		//----------------------------------------------------------------------
		System.out.println("Alright, here is your list of events: ");
		for(int i = 0; i<iEventCount; i++)
		{
			System.out.println(aCalendar[i].getEventDate("word"));
			//or, optionally:
			//System.out.println(aCalendar[i].getEventDate("digit"));
			//but I think the "word" format looks nicer.
			
		} //end for
		
	} //end main
	
} //end class

