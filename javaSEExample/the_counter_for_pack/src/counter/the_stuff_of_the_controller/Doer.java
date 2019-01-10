package counter.the_stuff_of_the_controller;

import counter.Model;

abstract class Doer implements TheCounterShape
{
	static String theInterRow, theAfterRow;
	static int theIconAtTheInterSign;
	
	private static final void setTheInterDatums
			( String theInterRow, int theConOfTheInterSign )
	{
		Doer.theInterRow = theInterRow;
		Doer.theIconAtTheInterSign = theConOfTheInterSign;
		
	}
	
	static String transform( int thIconAtTheOperator )
	{
		return Model.getOneS2DArrayTheLabels()
				[ thIconAtTheOperator / 4 ][ thIconAtTheOperator % 4 ];
	}
	
	abstract void work();
	
	public final String doTheAfterRow
			( String theInterRow, int theConOfTheInterSign )
	{
		setTheInterDatums( theInterRow, theConOfTheInterSign );
		work();
		return theAfterRow;
		
	}
	
}