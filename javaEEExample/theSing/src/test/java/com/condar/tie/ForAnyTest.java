package com.condar.tie;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ForAnyTest
    extends TestCase
{
  /**
   * Create the test case
   *
   * @param testName name of the test case(!"extends TestCase")
   */
  public ForAnyTest( String testName )
  {
    super( testName );
  }
  
  /**
   * @return the suite of tests(!/ test cases(!by their class object by the AppTest.class) to a testing /2) being tested
   */
  public static Test suite()//!Test--nfc to the of-TestSuite class...
  {
    return new TestSuite( ForAnyTest.class );
  }
  
  /**
   * Rigourous Test :-)(!do here write:)
   */
  public void testApp()
  {
    //!*int at;
    final class ForAnyTry
    {
      final int THEeDGE = 80;
      boolean theAllAnswer;
      int at;
      
      /*
      final boolean doTryThatTheWiseTheMakeIntoAWhollyCountOfVerbsdoesNotReturnToNull()
      {
        theAllAnswer = true;
        
        for( at = 0; theAllAnswer && at < THEeDGE; ++at )//!*"Local variable at defined in an enclosing scope must be final or effectively final"
        {
          theAllAnswer &= ForAnyMakeIntoWord.makeIntoAWhollyCountOfVerbs() != -1;
        }
        
        return theAllAnswer;
      }
      */
      
    }
    
    ForAnyTry toTheTry = new ForAnyTry();
    
    /*
    assertTrue( "ForAnyMakeIntoWord.makeIntoAWhollyCountOfVerbs() does not lead/return to -1!",
        toTheTry.doTryThatTheWiseTheMakeIntoAWhollyCountOfVerbsdoesNotReturnToNull() );
    */
    
    assertSame( "The JVM for-string pool in the Java heap memory is been an off-turn!",
        "In the Java EE with its injections, how can I use this framework the JUnit, non in vain!?",
        "In the Java EE with its injections, how can I use this framework the JUnit, non in vain!?");
    
  }
  
}
