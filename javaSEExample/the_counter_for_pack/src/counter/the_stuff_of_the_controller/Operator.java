package counter.the_stuff_of_the_controller;

public abstract class Operator
{
	private static State thState;
	private static Number thFirst;
	private static int thIconAtTheOperator;
	private static Number thSecond;
	
	static
	{
		thState = State.ThStart;
		thFirst = null;
		thIconAtTheOperator = -1;
		thSecond = null;
		
	}
	
	public static State getThState()
	{
		return thState;
	}
	
	public static void setThState( State thState )
	{
		State thOld = Operator.thState;
		Operator.thState = thState;
		if( thOld.ordinal() + 1 != thState.ordinal() )
		{
			switch(thState)
			{
			case ThStart:
				thFirst = null;
				thIconAtTheOperator = -1;
				thSecond = null;
				break;
			case ThFirst:
				thIconAtTheOperator = -1;
				thSecond = null;
				break;
			case ThOperator:
				thSecond = null;
				break;
			case ThSecond:
				break;
				
			}
			
		}
		
	}
	
	public static Number getThFirst()
	{
		return thFirst;
	}
	
	public static void setThFirst( Number thFirst )
	{
		Operator.thFirst = thFirst;
		thState = State.ThFirst;
		
	}
	
	public static int getThIconAtTheOperator()
	{
		return thIconAtTheOperator;
	}
	
	public static void setThIconAtTheOperator( int thIconAtTheOperator )
	{
		Operator.thIconAtTheOperator = thIconAtTheOperator;
		thState = State.ThOperator;
		
	}
	
	public static Number getThSecond()
	{
		return thSecond;
	}
	
	public static void setThSecond( Number thSecond )
	{
		Operator.thSecond = thSecond;
		thState = State.ThSecond;
	}
	
}