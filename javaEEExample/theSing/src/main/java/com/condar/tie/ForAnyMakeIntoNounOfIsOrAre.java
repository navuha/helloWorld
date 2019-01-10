package com.condar.tie;

final class ForAnyMakeIntoNounOfIsOrAre implements ForAnyOneForShareable
{
  private String toTheNowNoun;
  
  private boolean theOneOfWhetherIsHereWIs, theOneOfWhetherIsHereWAre,
      theOneOfWhetherIsHereWWas, theOneOfWhetherIsHereWWere,
      theOneOfWhetherIsHereWAble, theOneOfWhetherIsHereWDoing,
      theOneOfWhetherIsHereWBe, theOneOfWhetherIsHereWBeen,
      theOneOfWhetherIsHereWDone;
  
  private final ForAnyMakeIntoNounOfThing toTheOwn;
  
  private static final String toTheSignOfAnAddInnerEdgeOfWords = " ";
  
  
  
  ForAnyMakeIntoNounOfIsOrAre( final ForAnyMakeIntoNounOfThing toTheOwn )
  {
    toTheNowNoun = null;
    
    theOneOfWhetherIsHereWIs = theOneOfWhetherIsHereWAre
        = theOneOfWhetherIsHereWWas = theOneOfWhetherIsHereWWere
        = theOneOfWhetherIsHereWAble = theOneOfWhetherIsHereWDoing
        = theOneOfWhetherIsHereWBe = theOneOfWhetherIsHereWBeen
        = theOneOfWhetherIsHereWDone = false;
    
    this.toTheOwn = toTheOwn;
    
  }
  
  
  
  final String makeANounOfIsOrAre( final boolean theOneOfWhetherIsHereToWBe,
      final boolean theOneOfWhetherIsHereToWWasOrWWere,
      final boolean theOneOfWhetherIsHereToWAble, final boolean theOneOfWhetherIsHereToWDoing,
      final boolean theOneOfWhetherIsHereToWBeen, final boolean theOneOfWhetherIsHereToWDone )
  {
    if( theOneOfWhetherIsHereToWBeen && theOneOfWhetherIsHereToWDone
        || theOneOfWhetherIsHereToWBe && ! theOneOfWhetherIsHereToWDone
        || theOneOfWhetherIsHereToWBe && theOneOfWhetherIsHereToWBeen
        || theOneOfWhetherIsHereToWBeen && ! theOneOfWhetherIsHereToWDoing
        || theOneOfWhetherIsHereToWAble && ( theOneOfWhetherIsHereToWDone || theOneOfWhetherIsHereToWBeen ) )
    {
      throw new IllegalArgumentException();
    }
    
    toTheNowNoun = theOneOfWhetherIsHereToWWasOrWWere ? ( toTheOwn.isItOfSet() ? "were" : "was" )
        : ( toTheOwn.isItOfSet() ? "are" : "is" );
    
    if(theOneOfWhetherIsHereToWAble)
    {
      toTheNowNoun += " able to";
    }
    
    if( theOneOfWhetherIsHereToWBeen )
    {
      toTheNowNoun += " been onto";
    }
    
    if( theOneOfWhetherIsHereToWBe )
    {
      toTheNowNoun += " be";
    }
    
    if( theOneOfWhetherIsHereToWDone && ! theOneOfWhetherIsHereToWBe )
    {
      toTheNowNoun += " done";
    }
    
    if(theOneOfWhetherIsHereToWDoing)
    {
      toTheNowNoun += " doing";
    }
    
    for( int at = toTheIffy.nextInt( theOfEdgeNumberOfWords ); at > -1; --at )
    {
      if( ! toTheNowNoun.contains( toTheMakeIntoWord.makeIntoAWordAndWithTheIffy(false) ) )
      {
        toTheNowNoun += ( theOneOfWhetherIsHereToWAble || theOneOfWhetherIsHereToWDoing
                || theOneOfWhetherIsHereToWBeen || theOneOfWhetherIsHereToWDone ?
                    toTheSignOfAnInnerEdgeOfWords : toTheSignOfAnAddInnerEdgeOfWords )
            + toTheMakeIntoWord.give();
        
      }
      
    }
    
    if( theOneOfWhetherIsHereToWDone && theOneOfWhetherIsHereToWBe )
    {
      toTheNowNoun += toTheSignOfAnInnerEdgeOfWords + "done";
    }
    
    final boolean theOneOfWhetherIsThatOfSet = toTheOwn.isItOfSet();
    theOneOfWhetherIsHereWAble = theOneOfWhetherIsHereToWAble;
    theOneOfWhetherIsHereWDoing = theOneOfWhetherIsHereToWDoing;
    theOneOfWhetherIsHereWBe = theOneOfWhetherIsHereToWBe;
    theOneOfWhetherIsHereWBeen = theOneOfWhetherIsHereToWBeen;
    theOneOfWhetherIsHereWDone = theOneOfWhetherIsHereToWDone;
    theOneOfWhetherIsHereWWas = theOneOfWhetherIsHereToWWasOrWWere && ! theOneOfWhetherIsThatOfSet;
    theOneOfWhetherIsHereWWere = theOneOfWhetherIsHereToWWasOrWWere && theOneOfWhetherIsThatOfSet;
    theOneOfWhetherIsHereWAre = ! theOneOfWhetherIsHereToWWasOrWWere && theOneOfWhetherIsThatOfSet;
    theOneOfWhetherIsHereWIs = ! theOneOfWhetherIsHereToWWasOrWWere && ! theOneOfWhetherIsThatOfSet;
    
    return toTheNowNoun;
    
  }
  
  
  
  final boolean isHereToW_ToAfterAll()
  {
    return ( theOneOfWhetherIsHereWIs || theOneOfWhetherIsHereWAre
        || theOneOfWhetherIsHereWWas || theOneOfWhetherIsHereWWere )
        && ! ( theOneOfWhetherIsHereWAble || theOneOfWhetherIsHereWBe
            || theOneOfWhetherIsHereWBeen || theOneOfWhetherIsHereWDoing
            || theOneOfWhetherIsHereWDone );
    
  }
  
  final boolean isHereToW_OfAfterAll()
  {
    return theOneOfWhetherIsHereWBeen && theOneOfWhetherIsHereWDoing;
  }
  
  final boolean isHereToW_WithOrWByBothAfterAll()
  {
    return theOneOfWhetherIsHereWDone && theOneOfWhetherIsHereWBe;
  }
  
  
  
  final boolean isHereWIsOrWAreOrWWasOrWWereAndAnyOnlyPartAble()
  {
    return //AOneToHoldOntoShareableThings.THEoFEDGEnUMBERoFwORDS == 1 && 
        ( theOneOfWhetherIsHereWIs || theOneOfWhetherIsHereWAre
        || theOneOfWhetherIsHereWWas || theOneOfWhetherIsHereWWere )
        && ! ( theOneOfWhetherIsHereWAble || theOneOfWhetherIsHereWBe
            || theOneOfWhetherIsHereWBeen || theOneOfWhetherIsHereWDoing
            || theOneOfWhetherIsHereWDone );
    
  }
  
  final boolean isHereToAnyOutstandDieWord()
  {
    return isHereWIsOrWAreOrWWasOrWWereAndAnyOnlyPartAble()
        || theOneOfWhetherIsHereWBeen && theOneOfWhetherIsHereWDoing
        || theOneOfWhetherIsHereWDone && theOneOfWhetherIsHereWBe;
    
  }
  
  
  
  final String give()
  {
    return toTheNowNoun;
  }
  
}
