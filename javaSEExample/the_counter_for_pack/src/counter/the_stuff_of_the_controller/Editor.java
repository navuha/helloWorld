package counter.the_stuff_of_the_controller;

public final class Editor extends Doer
{
	final void work()
	{
		switch( Operator.getThState() )
		{
		case ThStart:
			theAfterRow = null;
			break;
		case ThFirst:
			{
				final Number thNOne = Operator.getThFirst();
				if( theIconAtTheInterSign == 0 )
				{
					if( theInterRow.length() == 1 )
					{
						Operator.setThState( State.ThStart );
						theAfterRow = "";
						
					}
					else if( theInterRow.endsWith(".") )
					{
						thNOne.setTheSignAtWhetherTheDotIsNotEntered(true);
						theAfterRow = theInterRow.substring( 0, theInterRow.length() - 1 );
						
						if( ! thNOne.getTheSignAtWhetherTheOnlyMinusSignIsNo() )
						{
							theAfterRow = theAfterRow.substring(1);
						}
						
						if( theAfterRow.equals("0") )
							thNOne.setTheSignAtWhetherTheOnlyOneZeroIsNo(false);
						
						if( ! thNOne.getTheSignAtWhetherTheOnlyMinusSignIsNo() )
						{
							theAfterRow = "-" + theAfterRow;
						}
						
						thNOne.setThNumber(theAfterRow);
						
					}
					else
					{
						theAfterRow = theInterRow.substring( 0, theInterRow.length() - 1 );
						thNOne.setThNumber(theAfterRow);
						
					}
					
				}
				else if( theIconAtTheInterSign == 1 || theIconAtTheInterSign == 2 )
				{
					Operator.setThState( State.ThStart );
					theAfterRow = "";
					
				}
				
			}
			break;
		case ThOperator:
			if( theIconAtTheInterSign == 0 || theIconAtTheInterSign == 1 )
			{
				Operator.setThState( State.ThFirst );
				theAfterRow = Operator.getThFirst().getThNumber();
				
			}
			else if( theIconAtTheInterSign == 2 )
			{
				Operator.setThState( State.ThStart );
				theAfterRow = "";
				
			}
			break;
		case ThSecond:
			final Number thNOne = Operator.getThSecond();
			if( theIconAtTheInterSign == 0 )
			{
				if( theInterRow.length() == 1 )
				{
					Operator.setThState( State.ThOperator );
					theAfterRow = transform( Operator.getThIconAtTheOperator() );
					
				}
				else if( theInterRow.endsWith(".") )
				{
					thNOne.setTheSignAtWhetherTheDotIsNotEntered(true);
					theAfterRow = theInterRow.substring( 0, theInterRow.length() - 1 );
					
					if( ! thNOne.getTheSignAtWhetherTheOnlyMinusSignIsNo() )
					{
						theAfterRow = theAfterRow.substring(1);
					}
					
					if( theAfterRow.equals("0") )
						thNOne.setTheSignAtWhetherTheOnlyOneZeroIsNo(false);
					
					if( ! thNOne.getTheSignAtWhetherTheOnlyMinusSignIsNo() )
					{
						theAfterRow = "-" + theAfterRow;
					}
					
					thNOne.setThNumber(theAfterRow);
					
				}
				else
				{
					theAfterRow = theInterRow.substring( 0, theInterRow.length() - 1 );
					thNOne.setThNumber(theAfterRow);
					
				}
				
			}
			else if( theIconAtTheInterSign == 1 )
			{
				Operator.setThState( State.ThOperator );
				theAfterRow = transform( Operator.getThIconAtTheOperator() );
				
			}
			else if( theIconAtTheInterSign == 2 )
			{
				Operator.setThState( State.ThStart );
				theAfterRow = "";
				
			}
			break;
		}
		
	}
	
}