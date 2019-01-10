package counter;

public final class Model
{
	static final int INSET_SIZE = 2;
	
	private static final String[][] oneS2DArrayTheLabels =
	{
		{ "back space", "clean", "clean all", "square root" },
		{ "seven", "eight", "nine", "divide" },
		{ "four", "five", "six", "multiply" },
		{ "one", "two", "three", "lose" },
		{ "zero", "dot", "count", "add" }
		
	};
	
	private static int thePreviouslyPressedButtonOrderFew = -1;
	private static boolean theSignOfGoEnterANumber = false;
	private static boolean theSignOfGoEnterCountData = false;
	public static final int icon( String theButtonSign )
	{
		for( int aRowOrdinalNumber = 0, aColumnOrdinalNumber;
				aRowOrdinalNumber < 5;
				++aRowOrdinalNumber )
		{
			for( aColumnOrdinalNumber = 0;
					aColumnOrdinalNumber < 4; ++aColumnOrdinalNumber )
			{
				if( oneS2DArrayTheLabels[aRowOrdinalNumber][aColumnOrdinalNumber]
						.equals(theButtonSign) )
					return 4 * aRowOrdinalNumber + aColumnOrdinalNumber;
			}
			
		}
		
		return -1;
		
	}
	
	public static final String[][] getOneS2DArrayTheLabels()
	{
		return oneS2DArrayTheLabels;
	}
	
	public static final void
			setThePreviouslyPressedButtonOrderFew( int thePreviouslyPressedButtonOrderFew )
	{
		Model.thePreviouslyPressedButtonOrderFew = thePreviouslyPressedButtonOrderFew;
	}
	
	public static final int getThePreviouslyPressedButtonOrderFew()
	{
		return thePreviouslyPressedButtonOrderFew;
	}
	
	public static void setTheSignOfGoEnterCountData( boolean theSignOfGoEnterCountData )
	{
		Model.theSignOfGoEnterCountData = theSignOfGoEnterCountData;
	}
	
	public static boolean getTheSignOfGoEnterCountData()
	{
		return theSignOfGoEnterCountData;
	}
	
	public static boolean getTheSignOfGoEnterANumber()
	{
		return theSignOfGoEnterANumber;
	}

	public static void setTheSignOfGoEnterANumber( boolean theSignOfGoEnterANumber )
	{
		Model.theSignOfGoEnterANumber = theSignOfGoEnterANumber;
	}
	
}