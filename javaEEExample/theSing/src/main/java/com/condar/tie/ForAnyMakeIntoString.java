package com.condar.tie;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ForAnyMakeIntoString implements ForAnyOneForShareable
{
  private String toTheForaskWordOfThirdString, toTheForaskWordOfFirstString,
      toTheFirstWordOfThirdString, toTheLastWordOfThirdString,
      toTheFirstWordOfFirstString, toTheLastWordOfFirstString;
  
  private static final int theOfedgeNumberOfTheThingsOfSing = 5,
      theOfedgeNumberForMakingAWordOfAskAndMore = 4;
  
  private static final List<String> toTheSetOfTheOfstartNounsOfAsk = new ArrayList<String>(11);
  static
  {
    toTheSetOfTheOfstartNounsOfAsk.addAll(
        Arrays.asList( "whether", "what", "how", "why",//! "who", "whom",
            "which", "whose", "when", "where", "where-from",
            "how-much", "how-many" ) );
    
  }
  
  private ForAnyMakeIntoNounOfThing toTheMakeIntoNounOfThing = new ForAnyMakeIntoNounOfThing();
  
  private static final List<String> toTheSetOfNounsOnTheThingsOfSing
  = new ArrayList<String>(theOfedgeNumberOfTheThingsOfSing);
  
  private static final List<Boolean> toTheSetOfOnesOnWhetherIsTheThingOfSet
    = new ArrayList<Boolean>(theOfedgeNumberOfTheThingsOfSing);
  
  private static boolean// theOneOfWhetherIsTheFirstWordOfFirstStringBeenOntoDieAsSet,//false in any
      theOneOfWhetherIsTheLastWordOfFirstStringBeenOntoDieAsSet = false,
      //theOneOfWhetherIsTheFirstWordOfThirdStringBeenOntoDieAsSet,
      theOneOfWhetherIsTheLastWordOfThirdStringBeenOntoDieAsSet = false;
  
  private static final String toTheSignOfAnAddInnerEdgeOfWords = " ";
  
  private static boolean theTiming = true,
      theInnerTiming = true;
  
  private static int theCountToStrings = 0;
  
  private final String[] toTheString = new String[2];
  
  private int theLengthToWLa, theLengthOfFirstHalfOfString, theLengthOfSecondHalfOfString;
  private String toTheLaes;
  
  private final ForAnySing toTheOwn;
  
  
  
  final void doAlongThePartOfConstructor()
  {
    for( int at = theOfedgeNumberOfTheThingsOfSing; at > 0; --at )
    {
      toTheSetOfNounsOnTheThingsOfSing.add( toTheMakeIntoNounOfThing
          .makeIntoNounOfThing( "the", toTheIffy.nextBoolean() ) );
      toTheSetOfOnesOnWhetherIsTheThingOfSet.add( toTheMakeIntoNounOfThing.isItOfSet() );
      
    }
    
  }
  
  ForAnyMakeIntoString( final ForAnySing toTheOwn )
  {
    toTheForaskWordOfThirdString = toTheForaskWordOfFirstString
        = toTheFirstWordOfThirdString = toTheLastWordOfThirdString
        = toTheFirstWordOfFirstString = toTheLastWordOfFirstString = null;
    
    theLengthToWLa = theLengthOfFirstHalfOfString = theLengthOfSecondHalfOfString = 0;
    toTheLaes = "";
    
    this.toTheOwn = toTheOwn;
    
  }
  
  private final void reconstruct()//!or re-make an object of this class
  {
    toTheForaskWordOfThirdString = toTheForaskWordOfFirstString
        = toTheFirstWordOfThirdString = toTheLastWordOfThirdString
        = toTheFirstWordOfFirstString = toTheLastWordOfFirstString = null;
    
    ForAnyMakeIntoWord.toTheStartlySetOfWords.clear();
    
    toTheSetOfNounsOnTheThingsOfSing.clear();
    
    toTheSetOfOnesOnWhetherIsTheThingOfSet.clear();
    
    //doAlongThePartOfConstructor();//!in doIntoWith(String)...
    
    theOneOfWhetherIsTheLastWordOfFirstStringBeenOntoDieAsSet
        = theOneOfWhetherIsTheLastWordOfThirdStringBeenOntoDieAsSet = false;
    
    theTiming = theInnerTiming = true;
    
    theCountToStrings = 0;
    
    theLengthToWLa = theLengthOfFirstHalfOfString = theLengthOfSecondHalfOfString = 0;
    toTheLaes = "";
    
    toTheMakeIntoWord.makeIntoAnOfstartingSetOfWords( toTheOwn.getToTheStringForStart() );
    
  }
  
  
  
  private final void makeAnAsking()
  {
    String toTheOfstartOddWord;
    final String toTheOddWordWithSpaces
        = toTheString[0].contains( toTheOfstartOddWord = " do" + toTheSignOfAnInnerEdgeOfWords ) ? " do "
        : toTheString[0].contains( toTheOfstartOddWord = " does" + toTheSignOfAnInnerEdgeOfWords ) ? " does "
        : toTheString[0].contains( toTheOfstartOddWord = " is" + toTheSignOfAnAddInnerEdgeOfWords ) ? " is "
            : toTheString[0]
                .contains( toTheOfstartOddWord = " are" + toTheSignOfAnAddInnerEdgeOfWords ) ? " are "
        : toTheString[0].contains( toTheOfstartOddWord = " did" + toTheSignOfAnInnerEdgeOfWords ) ? " did "
        : toTheString[0].contains( toTheOfstartOddWord = " was" + toTheSignOfAnAddInnerEdgeOfWords ) ? " was "
            : toTheString[0]
                .contains( toTheOfstartOddWord = " were" + toTheSignOfAnAddInnerEdgeOfWords ) ? " were "
        : toTheString[0].contains(" will ") ? 
          ( toTheOfstartOddWord = " will " )
        : ( toTheOfstartOddWord = null );
    if( toTheOfstartOddWord == null )
    {
      throw new NullPointerException("There is no such/this the of-start odd word");
    }
    
    toTheString[0] = toTheSetOfTheOfstartNounsOfAsk.get( toTheIffy.nextInt( toTheSetOfTheOfstartNounsOfAsk.size() ) )
        + toTheOddWordWithSpaces + toTheString[0].substring( 0, toTheString[0].indexOf(toTheOfstartOddWord) )
        + " " + toTheString[0].substring( toTheString[0].indexOf(toTheOfstartOddWord)
            + toTheOfstartOddWord.length() );
    
  }
  
  private final void makeAnAsking( final String toTheAskWord )
  {
    String toTheOfstartOddWord;
    final String toTheOddWordWithSpaces
        = toTheString[0].contains( toTheOfstartOddWord = " do" + toTheSignOfAnInnerEdgeOfWords ) ? " do "
        : toTheString[0].contains( toTheOfstartOddWord = " does" + toTheSignOfAnInnerEdgeOfWords ) ? " does "
        : toTheString[0].contains( toTheOfstartOddWord = " is" + toTheSignOfAnAddInnerEdgeOfWords ) ? " is "
            : toTheString[0]
                .contains( toTheOfstartOddWord = " are" + toTheSignOfAnAddInnerEdgeOfWords ) ? " are "
        : toTheString[0].contains( toTheOfstartOddWord = " did" + toTheSignOfAnInnerEdgeOfWords ) ? " did "
        : toTheString[0].contains( toTheOfstartOddWord = " was" + toTheSignOfAnAddInnerEdgeOfWords ) ? " was "
            : toTheString[0]
                .contains( toTheOfstartOddWord = " were" + toTheSignOfAnAddInnerEdgeOfWords ) ? " were "
        : toTheString[0].contains(" will ") ? 
          ( toTheOfstartOddWord = " will " )
        : ( toTheOfstartOddWord = null );
    if( toTheOfstartOddWord == null )
    {
      throw new NullPointerException("There is no such/this the of-start odd word");
    }
    
    toTheString[0] = toTheAskWord
        + toTheOddWordWithSpaces + toTheString[0].substring( 0, toTheString[0].indexOf(toTheOfstartOddWord) )
        + " " + toTheString[0].substring( toTheString[0].indexOf(toTheOfstartOddWord)
            + toTheOfstartOddWord.length() );
    
  }
  
  
  private final String makeABejustdiedString( final String toTheString, 
      final String toTheDyingWord )
  {
    final boolean theOneOfWhetherIsHereOfSet = theTiming ? theInnerTiming ?
                false///theOneOfWhetherIsTheFirstWordOfFirstStringBeenOntoDieAsSet
            : theOneOfWhetherIsTheLastWordOfFirstStringBeenOntoDieAsSet
        : theInnerTiming ? false///theOneOfWhetherIsTheFirstWordOfThirdStringBeenOntoDieAsSet
            : theOneOfWhetherIsTheLastWordOfThirdStringBeenOntoDieAsSet;//only to the string with the adverb of preposition
    
    return
        toTheString.substring( 0, toTheString
            .lastIndexOf
            (
              theInnerTiming && ( toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfIsOrAre()//!!
                      .isHereWIsOrWAreOrWWasOrWWereAndAnyOnlyPartAble()
                  || toTheForaskWordOfFirstString != null && toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfDo()
                      .isHereWDoOrWDoesWithNoWNowOrWDidAndAnyOnlyPartAble() ) ? " "
              : toTheSignOfAnInnerEdgeOfWords
            ) + 1
        ) + toTheMakeIntoWord
            .makeIntoAWordAndWithTheIffy( theOneOfWhetherIsHereOfSet,
                toTheDyingWord );
  }
  
  private final void makeASimpleString()
  {
    final int oneAt = toTheIffy.nextInt(theOfedgeNumberOfTheThingsOfSing);
    
    toTheString[0] = toTheSetOfNounsOnTheThingsOfSing.get(oneAt)
        + " " + toTheMakeIntoNounOfThing.doForceSetTheOneOfWhetherIsItOfSet(
            toTheSetOfOnesOnWhetherIsTheThingOfSet.get(oneAt) ).makeAJustanyWDo
            (
              theCountToStrings == 1 || theCountToStrings == 3 ? toTheIffy.nextInt(9)
              : toTheIffy.nextInt(8) == 7 ? 8
                : toTheIffy.nextInt(7)
            );
    
    final ForAnyMakeIntoNounOfIsOrAre toTheMakeIntoNounOfIsOrAre
        = toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfIsOrAre();
    toTheString[1] =
    (
      toTheMakeIntoNounOfIsOrAre.isHereToAnyOutstandDieWord() ?
        toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfShapeOfDo().makeAnyNounOfShapeOfDo
        (
          toTheMakeIntoNounOfIsOrAre.isHereToW_WithOrWByBothAfterAll() ?
            toTheIffy.nextBoolean() ? "with" : "by"
          : toTheMakeIntoNounOfIsOrAre.isHereToW_ToAfterAll() ? "to" : "of"
        )
      :
      (
        toTheIffy.nextInt(3) != 0 ? toTheSetOfNounsOnTheThingsOfSing
            .get( toTheIffy.nextInt(theOfedgeNumberOfTheThingsOfSing) )
        : toTheMakeIntoNounOfThing.isItOfSet() ? "oneselves" : "oneself"
      ) + " " + toTheMakeIntoNounOfThing.makeAnyNounOfShapeOfDo()
      
    );
    
  }
  
  
  private final void doByThePartOfTheMakeIntoSomeLa( final int theNumberToString,
      final int theNumberForUnset )
  {
    theLengthToWLa = ( theNumberToString == 0 ? theLengthOfFirstHalfOfString
        : theLengthOfSecondHalfOfString ) - toTheString[theNumberToString].length();
    if( theLengthToWLa >= theNumberForUnset )
    {
      toTheLaes += "la";
      theLengthToWLa -= theNumberForUnset;
      
      while( theLengthToWLa >= theNumberForUnset )
      {
        toTheLaes += "-la";
        
        theLengthToWLa -= theNumberForUnset;
        
      }
      
    }
    
    if( ! toTheLaes.isEmpty() )
    {
      toTheString[theNumberToString] = toTheLaes + " " + toTheString[theNumberToString];
      toTheLaes = "";
      
    }
    
  }
  
  private final void makeIntoSomeLa()
  {
    doByThePartOfTheMakeIntoSomeLa( 0, 4 );
    doByThePartOfTheMakeIntoSomeLa( 1, 4 );
    
  }
  
  
  final String makeAString()
  {
    ++theCountToStrings;
    
    makeASimpleString();
    
    if( theCountToStrings == 1 || theCountToStrings == 3 )
    {
      if( toTheIffy.nextInt(theOfedgeNumberForMakingAWordOfAskAndMore) == 0 )
      {
        makeAnAsking();
        
        if( theCountToStrings == 1 )
        {
          toTheForaskWordOfFirstString = toTheString[0]
              .substring( 0, toTheString[0].indexOf(" ") );
        }
        else
        {
          toTheForaskWordOfThirdString = toTheString[0]
              .substring( 0, toTheString[0].indexOf(" ") );
        }
        
      }
      
      if( theCountToStrings == 1 )
      {
        toTheFirstWordOfFirstString = toTheString[0]
            .substring( toTheString[0]
                .lastIndexOf
                (
                  toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfIsOrAre()
                          .isHereWIsOrWAreOrWWasOrWWereAndAnyOnlyPartAble()
                      || toTheForaskWordOfFirstString != null && toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfDo()
                          .isHereWDoOrWDoesWithNoWNowOrWDidAndAnyOnlyPartAble() ? " "
                  : toTheSignOfAnInnerEdgeOfWords
                ) + 1
            );
        
        toTheLastWordOfFirstString = toTheString[1]
            .substring( toTheString[1].lastIndexOf(toTheSignOfAnInnerEdgeOfWords) + 1 );
        
        theOneOfWhetherIsTheLastWordOfFirstStringBeenOntoDieAsSet = toTheMakeIntoNounOfThing
            .giveTheMakeIntoNounOfShapeOfDo().isItOfSet();
        
      }
      else
      {
        toTheFirstWordOfThirdString = toTheString[0]
            .substring( toTheString[0]
                .lastIndexOf
                (
                  toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfIsOrAre()
                          .isHereWIsOrWAreOrWWasOrWWereAndAnyOnlyPartAble()
                      || toTheForaskWordOfFirstString != null && toTheMakeIntoNounOfThing.giveTheMakeIntoNounOfDo()
                          .isHereWDoOrWDoesWithNoWNowOrWDidAndAnyOnlyPartAble() ? " "
                  : toTheSignOfAnInnerEdgeOfWords
                ) + 1
            );
        
        toTheLastWordOfThirdString = toTheString[1]
            .substring( toTheString[1].lastIndexOf(toTheSignOfAnInnerEdgeOfWords) + 1 );
        
        theOneOfWhetherIsTheLastWordOfThirdStringBeenOntoDieAsSet = toTheMakeIntoNounOfThing
            .giveTheMakeIntoNounOfShapeOfDo().isItOfSet();
        
      }
      
      theLengthOfFirstHalfOfString = toTheString[0].length();
      theLengthOfSecondHalfOfString = toTheString[1].length();
      
    }
    else
    {
      final String toTheFirstWordOfOldString = theTiming ? toTheFirstWordOfFirstString : toTheFirstWordOfThirdString,
          toTheLastWordOfOldString = theTiming ? toTheLastWordOfFirstString : toTheLastWordOfThirdString,
          toTheForaskWordOfOldString = theTiming ? toTheForaskWordOfFirstString : toTheForaskWordOfThirdString;
      
      if( toTheForaskWordOfOldString != null )
      {
        makeAnAsking( toTheForaskWordOfOldString );
      }
      
      toTheString[0] = makeABejustdiedString( toTheString[0], toTheFirstWordOfOldString );
      theInnerTiming = ! theInnerTiming;
      toTheString[1] = makeABejustdiedString( toTheString[1], toTheLastWordOfOldString );
      theInnerTiming = ! theInnerTiming;
      
      theTiming = ! theTiming;
      
      makeIntoSomeLa();
      
      if( theCountToStrings == 4 )
      {
        //theCountToStrings = 0;
        reconstruct();
        
      }
      
    }
    
    return toTheString[0] + "\n  " + toTheString[1];
    
  }
  
  
  
  final ForAnyMakeIntoNounOfThing give()
  {
    return toTheMakeIntoNounOfThing;
  }
  
}
