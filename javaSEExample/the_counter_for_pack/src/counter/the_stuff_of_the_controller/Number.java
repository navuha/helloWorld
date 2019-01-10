package counter.the_stuff_of_the_controller;

public final class Number extends Doer
{
	private String thNumber;
	private boolean theSignAtWhetherTheDotIsNotEntered = true;
	private boolean theSignAtWhetherTheOnlyOneZeroIsNo = true;
	private boolean theSignAtWhetherTheOnlyMinusSignIsNo = true;
	
	final static String transform( int theIcon )
	{
		switch(theIcon)
		{
			case 16 : return "0";
			case 12 : return "1";
			case 13 : return "2";
			case 14 : return "3";
			case 8 : return "4";
			case 9 : return "5";
			case 10 : return "6";
			case 4 : return "7";
			case 5 : return "8";
			case 6 : return "9";
			case 17 : return ".";
			default : return null;
		}
	
	}
	
	final void work()
	{
		if( Operator.getThState() == State.ThStart )
		{
			Operator.setThFirst(this);
		}
		else if( Operator.getThState() == State.ThOperator )
		{
			Operator.setThSecond(this);
			theInterRow = "";
			
		}
		
		if( theInterRow != null && ( theInterRow.equals("NaN")
				|| theInterRow.equals("Infinity") ) )
		{
			theInterRow = "";
		}
		
		if( ! theSignAtWhetherTheOnlyMinusSignIsNo )
		{
			theInterRow = theInterRow.substring(1);
		}
		
		if( theIconAtTheInterSign != 17 && theIconAtTheInterSign != 16 )
		{
			theAfterRow = theInterRow.isEmpty() ?
					transform(theIconAtTheInterSign)
					: theSignAtWhetherTheOnlyOneZeroIsNo ?
							theInterRow + transform(theIconAtTheInterSign)
							: transform(theIconAtTheInterSign);
			theSignAtWhetherTheOnlyOneZeroIsNo = true;
			
		}
		else if( theIconAtTheInterSign == 17 )
		{
			if(theSignAtWhetherTheDotIsNotEntered)
			{
				theSignAtWhetherTheDotIsNotEntered = false;
				theSignAtWhetherTheOnlyOneZeroIsNo = true;
				theAfterRow = theInterRow.isEmpty() ?
						"0."
						: theInterRow + ".";
				
			}
			else
			{
				theAfterRow = null;
			}
			
		}
		else if( theIconAtTheInterSign == 16 )
		{
			if(theSignAtWhetherTheOnlyOneZeroIsNo)
			{
				if( theInterRow.isEmpty() )
				{
					theSignAtWhetherTheOnlyOneZeroIsNo = false;
					theAfterRow = "0";
					
				}
				else
				{
					theAfterRow = theInterRow + "0";
				}
				
			}
			else
			{
				theAfterRow = null;
			}
			
		}
		
		if( ! theSignAtWhetherTheOnlyMinusSignIsNo )
		{
			theAfterRow = "-" + theAfterRow;
			theSignAtWhetherTheOnlyMinusSignIsNo = true;
		}
		
		if( theAfterRow != null )
		{
			thNumber = theAfterRow;
		}
		
	}
	
	public void setTheSignAtWhetherTheDotIsNotEntered
			( boolean theSignAtWhetherTheDotIsNotEntered )
	{
		this.theSignAtWhetherTheDotIsNotEntered = theSignAtWhetherTheDotIsNotEntered;
	}
	
	public void setTheSignAtWhetherTheOnlyOneZeroIsNo
			( boolean theSignAtWhetherTheOnlyOneZeroIsNo )
	{
		this.theSignAtWhetherTheOnlyOneZeroIsNo = theSignAtWhetherTheOnlyOneZeroIsNo;
	}
	
	public String getThNumber()
	{
		return thNumber;
	}
	
	public void setThNumber( String thNumber )
	{
		this.thNumber = thNumber;
	}
	
	public boolean getTheSignAtWhetherTheOnlyMinusSignIsNo()
	{
		return theSignAtWhetherTheOnlyMinusSignIsNo;
	}
	
	public void setTheSignAtWhetherTheOnlyMinusSignIsNo
			(boolean theSignAtWhetherTheOnlyMinusSignIsNo)
	{
		this.theSignAtWhetherTheOnlyMinusSignIsNo = theSignAtWhetherTheOnlyMinusSignIsNo;
	}
	
}