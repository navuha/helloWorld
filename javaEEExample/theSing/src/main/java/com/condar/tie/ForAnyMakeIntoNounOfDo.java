package com.condar.tie;

final class ForAnyMakeIntoNounOfDo implements ForAnyOneForShareable
{
  private String toTheNowNoun;
  
  private boolean theOneOfWhetherIsHereWDo,
      theOneOfWhetherIsHereWDoes, theOneOfWhetherIsHereWNow,
      theOneOfWhetherIsHereWDid, theOneOfWhetherIsHereWWill;
  
  private final ForAnyMakeIntoNounOfThing toTheOwn; 
  
  
  
  ForAnyMakeIntoNounOfDo( final ForAnyMakeIntoNounOfThing toTheOwn )
  {
    toTheNowNoun = null;
    
    theOneOfWhetherIsHereWDo = theOneOfWhetherIsHereWDoes = theOneOfWhetherIsHereWNow
        = theOneOfWhetherIsHereWDid = theOneOfWhetherIsHereWWill = false;
    
    this.toTheOwn = toTheOwn;
    
  }
  
  
  
  final String makeANounOfDo( final boolean theOneOfWhetherIsHereToWNow, final boolean theOneOfWhetherIsHereToWDid,
      final boolean theOneOfWhetherIsHereToWWill )
  {
    try
    {
      if( theOneOfWhetherIsHereToWNow && theOneOfWhetherIsHereToWDid )
      {
        throw new IllegalArgumentException();
      }
      
    }
    catch( IllegalArgumentException ex )
    {
      ex.printStackTrace();
      return null;
      
    }
    
    toTheNowNoun = theOneOfWhetherIsHereToWWill ? "will" : theOneOfWhetherIsHereToWDid ? "did"
        : toTheOwn.isItOfSet() ? "do" : "does";
    
    if(theOneOfWhetherIsHereToWNow)
    {
      toTheNowNoun += theOneOfWhetherIsHereToWWill ?
            toTheOwn.isItOfSet() ? " oneselves now to" : " oneself now to"
          : toTheSignOfAnInnerEdgeOfWords + "now";
      
    }
    
    theOneOfWhetherIsHereWNow = theOneOfWhetherIsHereToWNow;
    theOneOfWhetherIsHereWDid = theOneOfWhetherIsHereToWDid;
    theOneOfWhetherIsHereWWill = theOneOfWhetherIsHereToWWill;
    theOneOfWhetherIsHereWDoes = ! toTheOwn.isItOfSet();
    theOneOfWhetherIsHereWDo = ! ( theOneOfWhetherIsHereWDid || theOneOfWhetherIsHereWWill
        || theOneOfWhetherIsHereWDoes );
    
    for( int at = toTheIffy.nextInt( theOfEdgeNumberOfWords ); at > -1; --at )
    {
      if( ! toTheNowNoun.contains( toTheMakeIntoWord.makeIntoAWordAndWithTheIffy(false) ) )
      {
        toTheNowNoun += toTheSignOfAnInnerEdgeOfWords + toTheMakeIntoWord.give();
      }
      
    }
    
    return toTheNowNoun;
    
  }
  
  
  
  final String give()
  {
    return toTheNowNoun;
  }
  
  
  final boolean isHereWDoOrWDoesWithNoWNowOrWDidAndAnyOnlyPartAble()
  {
    return //AOneToHoldOntoShareableThings.THEoFEDGEnUMBERoFwORDS == 1 && 
        ( theOneOfWhetherIsHereWDo || theOneOfWhetherIsHereWDoes || theOneOfWhetherIsHereWDid )
        && ! theOneOfWhetherIsHereWNow;
    
  }
  
}
