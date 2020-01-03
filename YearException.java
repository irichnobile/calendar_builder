//******************************************************************************
//	YearException.java		Author: Ian Nobile
//
//	Represents an exceptional condition in which an invalid year value is 
//	detected.
//	
//******************************************************************************

//import 

@SuppressWarnings("serial")
public class YearException extends Exception
{
	//--------------------------------------------------------------------------
	//	<<constructor>>; Sets up the exception object with a particular message.
	//--------------------------------------------------------------------------
	YearException(String message)
	{
		super(message);
	}
	
}

