package counter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import counter.the_stuff_of_the_controller.Number;
import counter.the_stuff_of_the_controller.Editor;
import counter.the_stuff_of_the_controller.Operator;
import counter.the_stuff_of_the_controller.State;
import counter.the_stuff_of_the_controller.Counter;

public class Controller implements ActionListener
{
	private final View thVOne;
	
	private static final Editor thEOne
			= new Editor();
	
	private static final Counter thCOne
			= new Counter();
	
	Controller( View thViewOne )
	{
		thVOne = thViewOne;
	}
	
	public void actionPerformed( ActionEvent thAEone )
	{
		final String
				theButtonSign = ( (JButton) thAEone.getSource() ).getText();
		
		final int theIconAtTheButton = Model.icon(theButtonSign);
		
		final String theAfterRow;
		
		if( ! ( theIconAtTheButton < 4
				|| theIconAtTheButton == 7
				|| theIconAtTheButton == 11
				|| theIconAtTheButton == 15
				|| theIconAtTheButton > 17 ) )
		{
			final Number
					thNOne = Operator.getThState() == State.ThSecond ?
							Operator.getThSecond()
							: Operator.getThState() == State.ThOperator ?
									new Number()
									: Operator.getThState() == State.ThFirst ?
											Operator.getThFirst()
											: new Number();
			theAfterRow = thNOne
					.doTheAfterRow( thVOne.getOneJTF(), theIconAtTheButton );
			
			if( theAfterRow != null )
			{
				if( theAfterRow.equals("NaN") || theAfterRow.equals("Infinity") )
				{
					Operator.setThState( State.ThStart );
				}
				
				thVOne.setOneJTF(theAfterRow);
				
			}
			
		}
		else if( theIconAtTheButton < 3 )
		{
			theAfterRow = thEOne
					.doTheAfterRow( thVOne.getOneJTF(), theIconAtTheButton );
			
			if( theAfterRow != null )
			{
				if( theAfterRow.equals("NaN") || theAfterRow.equals("Infinity") )
				{
					Operator.setThState( State.ThStart );
				}
				
				thVOne.setOneJTF(theAfterRow);
				
			}
			
		}
		else
		{
			theAfterRow = thCOne
					.doTheAfterRow( thVOne.getOneJTF(), theIconAtTheButton );
			
			if( theAfterRow != null )
			{
				if( theAfterRow.equals("NaN") || theAfterRow.equals("Infinity") )
				{
					Operator.setThState( State.ThStart );
				}
				
				thVOne.setOneJTF(theAfterRow);
				
			}
			
		}
		
	}
	
}