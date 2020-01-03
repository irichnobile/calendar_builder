//******************************************************************************
//	MonthException.java		Author: Ian Nobile
//
//	Represents an exceptional condition in which an invalid Month value is 
//	detected.
//	
//******************************************************************************

//import 

@SuppressWarnings("serial")
public class MonthException extends Exception
{
	//--------------------------------------------------------------------------
	//	<<constructor>>; Sets up the exception object with a particular message.
	//--------------------------------------------------------------------------
	MonthException(String message)
	{
		super(message);
	}
	
}

