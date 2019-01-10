package counter.the_stuff_of_the_controller;

public final class Counter extends Doer
{
	final void work()
	{
		if( Operator.getThSecond() != null
				&& Operator.getThSecond()
						.getTheSignAtWhetherTheOnlyMinusSignIsNo()
				|| Operator.getThFirst() != null
				&& Operator.getThFirst()
						.getTheSignAtWhetherTheOnlyMinusSignIsNo() )
		{
			switch(theIconAtTheInterSign)
			{
			case 18:
				switch( Operator.getThState() )
				{
				case ThStart:
					theAfterRow = null;
					break;
				case ThFirst:
					theAfterRow = null;
					break;
				case ThOperator:
					theAfterRow = null;
					break;
				case ThSecond:
					double theFirst, theSecond, theFruit;
					try
					{
						theFirst = Double.valueOf( Operator.getThFirst().getThNumber() );
						theSecond = Double.valueOf( Operator.getThSecond().getThNumber() );
						
						switch( Operator.getThIconAtTheOperator() )
						{
						case 7:
							theFruit = theFirst / theSecond;
							break;
						case 11:
							theFruit = theFirst * theSecond;
							break;
						case 15:
							theFruit = theFirst - theSecond;
							break;
						case 19:
							theFruit = theFirst + theSecond;
							break;
						default:
							theFruit = Math.sqrt(-1);
						}
						
						theAfterRow = theFruit == (int) theFruit ?
								String.valueOf( (int) theFruit )
								: String.valueOf(theFruit);
						
						Number thNOne = Operator.getThFirst();
						thNOne.setThNumber(theAfterRow);
						thNOne.setTheSignAtWhetherTheDotIsNotEntered
								( ! theAfterRow.contains(".") );
						thNOne.setTheSignAtWhetherTheOnlyMinusSignIsNo(true);
						thNOne.setTheSignAtWhetherTheOnlyOneZeroIsNo
								( ! theAfterRow.equals("0") );
						
						Operator.setThState( State.ThFirst );
						
					}
					catch( NumberFormatException ex )
					{
						theAfterRow = "Error";
						Operator.setThState( State.ThStart );
						ex.printStackTrace();
						
					}
					
					break;
				}
				
				break;
			case 3:
				switch( Operator.getThState() )
				{
				case ThStart:
					theAfterRow = null;
					break;
				case ThFirst:
					double theFruit = Math.sqrt( Double.valueOf
							( Operator.getThFirst().getThNumber() ) );
					
					theAfterRow = theFruit == (int) theFruit ?
							String.valueOf( (int) theFruit )
							: String.valueOf(theFruit);
					
					Operator.getThFirst().setThNumber(theAfterRow);
					
					break;
				case ThOperator:
					theAfterRow = null;
					break;
				case ThSecond:
					theAfterRow = null;
					break;
				}
				
				break;
			case 7:
				switch( Operator.getThState() )
				{
				case ThStart:
					theAfterRow = null;
					break;
				case ThFirst:
					Operator.setThIconAtTheOperator(theIconAtTheInterSign);
					theAfterRow = transform(theIconAtTheInterSign);
					break;
				case ThOperator:
					theAfterRow = null;
					break;
				case ThSecond:
					theAfterRow = null;
					break;
				}
				
				break;
			case 11:
				switch( Operator.getThState() )
				{
				case ThStart:
					theAfterRow = null;
					break;
				case ThFirst:
					Operator.setThIconAtTheOperator(theIconAtTheInterSign);
					theAfterRow = transform(theIconAtTheInterSign);
					break;
				case ThOperator:
					theAfterRow = null;
					break;
				case ThSecond:
					theAfterRow = null;
					break;
				}
				
				break;
			case 15:
				switch( Operator.getThState() )
				{
				case ThStart:
					theAfterRow = null;
					break;
				case ThFirst:
					Operator.setThIconAtTheOperator(theIconAtTheInterSign);
					theAfterRow = transform(theIconAtTheInterSign);
					break;
				case ThOperator:
					Operator.setThSecond( new Number() );
					Operator.getThSecond().setTheSignAtWhetherTheOnlyMinusSignIsNo(false);
					theAfterRow = "-";
					
					break;
				case ThSecond:
					theAfterRow = null;
					break;
				}
				
				break;
			case 19:
				switch( Operator.getThState() )
				{
				case ThStart:
					theAfterRow = null;
					break;
				case ThFirst:
					Operator.setThIconAtTheOperator(theIconAtTheInterSign);
					theAfterRow = transform(theIconAtTheInterSign);
					break;
				case ThOperator:
					theAfterRow = null;
					break;
				case ThSecond:
					theAfterRow = null;
					break;
				}
				
				break;
			}
		
		}
		else if( Operator.getThState() == State.ThStart && theIconAtTheInterSign == 15 )
		{
			Operator.setThFirst( new Number() );
			Operator.getThFirst().setTheSignAtWhetherTheOnlyMinusSignIsNo(false);
			theAfterRow = "-";
			
		}
		else if( Operator.getThState() == State.ThOperator && theIconAtTheInterSign == 15 )
		{
			Operator.setThSecond( new Number() );
			Operator.getThSecond().setTheSignAtWhetherTheOnlyMinusSignIsNo(false);
			theAfterRow = "-";
			
		}
		
	}
	
}
