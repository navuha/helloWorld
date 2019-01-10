package counter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;

final class AloneFrame extends JFrame
{
	private static AloneFrame one;
	
	private AloneFrame( String theNameOfTheFrame )
	{
		super(theNameOfTheFrame);
	}
	
	public static final AloneFrame getOne( String theNameOfTheFrame )
	{
		if( one == null )
			one = new AloneFrame(theNameOfTheFrame);
		return one;
		
	}
	
}

final class View
{
	private static final JTextField oneJTF;
	private static final JButton[][] oneJB2DArray = new JButton[5][4];
	
	static
	{
		final String[][] oneS2DArrayTheLabels = Model.getOneS2DArrayTheLabels();
		for( int aRowOrdinalNumber = 0, aColumnOrdinalNumber; aRowOrdinalNumber < 5;
				++aRowOrdinalNumber )
		{
			for( aColumnOrdinalNumber = 0; aColumnOrdinalNumber < 4;
					++aColumnOrdinalNumber )
			{
				oneJB2DArray[aRowOrdinalNumber][aColumnOrdinalNumber]
						= new JButton( oneS2DArrayTheLabels
								[aRowOrdinalNumber][aColumnOrdinalNumber] );
				
				oneJB2DArray[aRowOrdinalNumber][aColumnOrdinalNumber]
						.setBackground( new Color( 0, 0, 0 ) );
				
				oneJB2DArray[aRowOrdinalNumber][aColumnOrdinalNumber]
						.setPreferredSize( new Dimension( 114, 26 ) );
				
				if( ( aRowOrdinalNumber == 1 || aRowOrdinalNumber == 2
						|| aRowOrdinalNumber == 3 )
						&& ( aColumnOrdinalNumber == 0 || aColumnOrdinalNumber == 1
								|| aColumnOrdinalNumber == 2 )
						|| aRowOrdinalNumber == 4 && aColumnOrdinalNumber == 0 )
				{
					oneJB2DArray[aRowOrdinalNumber][aColumnOrdinalNumber]
							.setForeground( new Color( 100, 204, 0 ) );
				}
				else if( aRowOrdinalNumber == 0 && aColumnOrdinalNumber == 3
						|| aRowOrdinalNumber == 3 && aColumnOrdinalNumber == 3 )
				{
					oneJB2DArray[aRowOrdinalNumber][aColumnOrdinalNumber]
							.setForeground( new Color( 100, 204, 180 ) );
				}
				else
				{
					oneJB2DArray[aRowOrdinalNumber][aColumnOrdinalNumber]
							.setForeground( new Color( 100, 204, 100 ) );
				}
				
			}
			
		}
		
		final int INSET_SIZE = Model.INSET_SIZE;
		final GridBagLayout ONE_GBL_RF = new GridBagLayout();
		
		final JPanel ONE_JP_REF = new JPanel();
		ONE_JP_REF.setLayout(ONE_GBL_RF);
		ONE_JP_REF.setBackground( new Color( 0, 0, 0 ) );
		
		final GridBagConstraints ONE_GBC_REF = new GridBagConstraints();
		
		ONE_GBC_REF.gridwidth = ONE_GBC_REF.REMAINDER;
		ONE_GBC_REF.fill = ONE_GBC_REF.HORIZONTAL;
		ONE_GBC_REF.insets = new Insets( INSET_SIZE, INSET_SIZE,
				2 * INSET_SIZE, INSET_SIZE );
		oneJTF = new JTextField( "", 30 );
		oneJTF.setHorizontalAlignment( JTextField.RIGHT );
		oneJTF.setEditable(false);
		oneJTF.setBackground( new Color( 0, 0, 0 ) );
		oneJTF.setForeground( new Color( 0, 204, 0 ) );
		oneJTF.setFont( oneJTF.getFont().deriveFont(15.0f) );
		ONE_GBL_RF.setConstraints( oneJTF, ONE_GBC_REF );
		ONE_JP_REF.add(oneJTF);
		
		ONE_GBC_REF.gridwidth = 1;
		ONE_GBC_REF.insets = new Insets( INSET_SIZE, INSET_SIZE, INSET_SIZE, INSET_SIZE );
		for( int aRowOrdinalNumber = 0, aColumnOrdinalNumber; aRowOrdinalNumber < 5;
				++aRowOrdinalNumber)
		{
			for(aColumnOrdinalNumber = 0; aColumnOrdinalNumber < 4; ++aColumnOrdinalNumber)
			{
				ONE_GBC_REF.gridx = aColumnOrdinalNumber;
				
				ONE_GBL_RF.setConstraints( oneJB2DArray
						[aRowOrdinalNumber][aColumnOrdinalNumber], ONE_GBC_REF );
				ONE_JP_REF.add( oneJB2DArray[aRowOrdinalNumber][aColumnOrdinalNumber] );
			
			}
			
		}
		
		JFrame oneJFrameRef = AloneFrame.getOne("Counter");
		oneJFrameRef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oneJFrameRef.setContentPane(ONE_JP_REF);
		oneJFrameRef.pack();
		oneJFrameRef.setResizable(false);
		oneJFrameRef.setLocation(100, 35);
		oneJFrameRef.setAlwaysOnTop(true);
		oneJFrameRef.setVisible(true);
		
	}
	
	View()
	{
		final Controller oneController = new Controller(this);
		for( JButton[] oneJB1DArray : oneJB2DArray )
		{
			for( JButton oneJB : oneJB1DArray )
			{
				oneJB.addActionListener(oneController);
			}
			
		}
		
	}
	
	public static final void setOneJTF( String v )
	{
		oneJTF.setText(v);
	}
	
	public static final String getOneJTF()
	{
		return oneJTF.getText();
	}
	
	public static final JButton[][] getOneJB2DArray()
	{
		return oneJB2DArray;
	}
	
	public static final void main( String[] args )
	{
		new View();
	}
	
}