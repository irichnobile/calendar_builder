//******************************************************************************
//	DayException.java		Author: Ian Nobile
//
//	Represents an exceptional condition in which an invalid day value is 
//	detected.
//	
//******************************************************************************

//import 

@SuppressWarnings("serial")
public class DayException extends Exception
{
	//--------------------------------------------------------------------------
	//	<<constructor>>; Sets up the exception object with a particular message.
	//--------------------------------------------------------------------------
	DayException(String message)
	{
		super(message);
	}
	
}

