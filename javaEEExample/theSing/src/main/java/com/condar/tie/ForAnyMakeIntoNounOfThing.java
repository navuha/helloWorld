package com.condar.tie;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

final class ForAnyMakeIntoNounOfThing implements ForAnyOneForShareable
{
  private String toTheNowNoun;
  
  private boolean theOneOfWhetherIsItOfSet;
  
  private final ForAnyMakeIntoNounOfDo toTheMakeIntoNounOfDo = new ForAnyMakeIntoNounOfDo(this);
  
  private final ForAnyMakeIntoNounOfShapeOfDo toTheMakeIntoNounOfShapeOfDo = new ForAnyMakeIntoNounOfShapeOfDo(this);
  
  private final ForAnyMakeIntoNounOfIsOrAre toTheMakeIntoNounOfIsOrAre = new ForAnyMakeIntoNounOfIsOrAre(this);
  
  private static final Set<String> toTheSetOfTheOfstartSignsOfThing = new HashSet<String>( 2, 1.0f );
  static
  {
    toTheSetOfTheOfstartSignsOfThing.addAll(
        Arrays.asList( "any", "the" ) );
  }
  
  
  
  ForAnyMakeIntoNounOfThing()
  {
    toTheNowNoun = null;
    
    theOneOfWhetherIsItOfSet = false;
    
  }
  
  
  
  final String makeIntoNounOfThing( final String toTheOfstartSignOfThing,
      final boolean theOneOfWhetherIsItOfSet )
  {
    if( ! toTheSetOfTheOfstartSignsOfThing.contains(toTheOfstartSignOfThing) )
    {
      throw new IllegalArgumentException("The Or An! An with no True!");
    }
    
    this.theOneOfWhetherIsItOfSet = theOneOfWhetherIsItOfSet;
    
    toTheNowNoun = toTheOfstartSignOfThing;
    
    for( int at = toTheIffy.nextInt( theOfEdgeNumberOfWords ); at > 0; --at )
    {
      if( ! toTheNowNoun.contains( toTheMakeIntoWord.makeIntoAWordAndWithTheIffy(false) ) )
      {
        toTheNowNoun += toTheSignOfAnInnerEdgeOfWords + toTheMakeIntoWord.give();
      }
      
    }
    
    if( ! toTheNowNoun.contains( toTheMakeIntoWord.makeIntoAWordAndWithTheIffy(false) ) )
    {
      toTheNowNoun += toTheSignOfAnInnerEdgeOfWords
          + ( theOneOfWhetherIsItOfSet ? toTheMakeIntoWord.makeIntoAWordOfSet() : toTheMakeIntoWord.give() );
    }
    else if(theOneOfWhetherIsItOfSet)
    {
      toTheNowNoun = ForAnyMakeIntoWord.makeIntoASetWordOfSet(toTheNowNoun);
    }
    
    return toTheNowNoun;
    
  }
  
  
  
  final String give()
  {
    return toTheNowNoun;
  }
  
  
  final boolean isItOfSet()
  {
    return theOneOfWhetherIsItOfSet;
  }
  
  
  
  final ForAnyMakeIntoNounOfThing doForceSetTheOneOfWhetherIsItOfSet( final boolean theValue )
  {
    theOneOfWhetherIsItOfSet = theValue;
    return this;
    
  }
  
  
  
  final String doAny( final boolean theOneOfWhetherIsThereWDid )
  {
    return toTheMakeIntoNounOfDo.makeANounOfDo( false, theOneOfWhetherIsThereWDid, false );
  }
  final String doNowAny()
  {
    return toTheMakeIntoNounOfDo.makeANounOfDo( true, false, false );
  }
  final String willAny()
  {
    return toTheMakeIntoNounOfDo.makeANounOfDo( true, false, true );
  }
  
  
  
  final String giveTheNowNounOfDo()
  {
    return toTheMakeIntoNounOfDo.give();
  }
  
  final ForAnyMakeIntoNounOfDo giveTheMakeIntoNounOfDo()
  {
    return toTheMakeIntoNounOfDo;
  }
  
  
  
  final String isOrAreAnyWDo( final boolean theOneOfWhetherIsThereWWasOrWWere )
  {
    return toTheMakeIntoNounOfIsOrAre.makeANounOfIsOrAre(
        false, theOneOfWhetherIsThereWWasOrWWere, false, false, false, false );
  }
  final String isOrAreAnyWAble( final boolean theOneOfWhetherIsThereWWasOrWWere )
  {
    return toTheMakeIntoNounOfIsOrAre.makeANounOfIsOrAre(
        false, theOneOfWhetherIsThereWWasOrWWere, true, false, false, false );
  }
  final String isOrAreAnyWDoing( final boolean theOneOfWhetherIsThereWWasOrWWere )
  {
    return toTheMakeIntoNounOfIsOrAre.makeANounOfIsOrAre(
        false, theOneOfWhetherIsThereWWasOrWWere, false, true, false, false );
  }
  final String isOrAreAnyWDone( final boolean theOneOfWhetherIsThereWWasOrWWere )
  {
    return toTheMakeIntoNounOfIsOrAre.makeANounOfIsOrAre(
        false, theOneOfWhetherIsThereWWasOrWWere, false, false, false, true );
  }
  final String isOrAreBeenOntoAnyWDoing( final boolean theOneOfWhetherIsThereWWasOrWWere )
  {
    return toTheMakeIntoNounOfIsOrAre.makeANounOfIsOrAre(
        false, theOneOfWhetherIsThereWWasOrWWere, false, true, true, false );
  }
  final String isOrAreBe_Any_WDone( final boolean theOneOfWhetherIsThereWWasOrWWere )
  {
    return toTheMakeIntoNounOfIsOrAre.makeANounOfIsOrAre(
        true, theOneOfWhetherIsThereWWasOrWWere, false, false, false, true );
  }
  
  
  
  final ForAnyMakeIntoNounOfIsOrAre
      giveTheMakeIntoNounOfIsOrAre()
  {
    return toTheMakeIntoNounOfIsOrAre;
  }
  
  
  
  final String makeAJustanyWDo( int theKey )
  {
    if( theKey > 8 || theKey < 0 )
    {
      throw new IllegalArgumentException();
    }
    
    return
        theKey == 0 ? doAny( toTheIffy.nextBoolean() )
        : theKey == 1 ? doNowAny()
        : theKey == 2 ? isOrAreAnyWDo( toTheIffy.nextBoolean() )
        : theKey == 3 ? isOrAreAnyWAble( toTheIffy.nextBoolean() )
        : theKey == 4 ? isOrAreAnyWDoing( toTheIffy.nextBoolean() )
        : theKey == 5 ? isOrAreAnyWDone( toTheIffy.nextBoolean() )
        : theKey == 6 ? isOrAreBeenOntoAnyWDoing( toTheIffy.nextBoolean() )
        : theKey == 7 ? isOrAreBe_Any_WDone( toTheIffy.nextBoolean() )
        : willAny();
    
  }
  
  
  
  final String makeAnyNounOfShapeOfDo()
  {
    return toTheMakeIntoNounOfShapeOfDo.makeAnyNounOfShapeOfDo();
  }
  
  final ForAnyMakeIntoNounOfShapeOfDo
      giveTheMakeIntoNounOfShapeOfDo()
  {
    return toTheMakeIntoNounOfShapeOfDo;
  }
  
}
