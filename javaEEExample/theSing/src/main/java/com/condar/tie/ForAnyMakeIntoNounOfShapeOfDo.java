package com.condar.tie;

import java.util.List;
import java.util.Arrays;

final class ForAnyMakeIntoNounOfShapeOfDo implements ForAnyOneForShareable
{
  private String toTheNowNoun;
  
  private boolean theOneOfWhetherIsItOfSet;
  
  private final ForAnyMakeIntoNounOfThing toTheOwn;
  
  private static final List<String> toTheSetOfTheOfstartSignsOfShapeOfDo
      = Arrays.asList(
          "of", "off", "from", "out-of",// "outward", "outwards", "outside",// "out",
          "to",// "toward", "towards", 
          "till", "untill",// "inward", "inwards",// "inway",//-wise--method!
          "unto",// "backward", 
          "backwards",
          "at", "on",// "onward", "onwards", 
          "upon",// "onto", 
          "into", "in",
          "under",// "inside", "within", 
          "with",// "with no", 
          "without", "for", "fore",//afore, among...
          //https://www.native-english.ru/grammar/prepositions-list
          //across, along, against, amid, amidst, around, aside, athwart,
          //atop, next, ...ing, as far as...,...
          "by",
          //"per", "pro", "fro", "since",
          //"via",
          //"than",
          "through",// "thro", "thru", "throughout", "though",
          //"near",// "nigh", --verb!as tie[taay]/tuy...
          //"neath",
          //"wherewith", "therewith",
          //"foreward", "forewards", "forward", "forwards", "yester",
          "inter", "after",// "afterward", "afterwards",
          //"up",// "upward", "upwards",
          "over",
          "above", "about",// "but", 
          "beneath", "below", "before", "beside",// "besides",// "infra"
          //"because",//!iiz!// "because of",//even as an adverb...
          "behind", "belike", "between", "beyond",
          "as", "like",// "so", "such",//!--!!sic=so
          "instead-of",//, "instead"
          //cum=with,?=com,but ''speerma
          "away", "cum"
      );
  
  
  
  ForAnyMakeIntoNounOfShapeOfDo( final ForAnyMakeIntoNounOfThing toTheOwn )
  {
    toTheNowNoun = null;
    
    theOneOfWhetherIsItOfSet = false;
    
    this.toTheOwn = toTheOwn;
    
  }
  
  
  
  final String makeAnyNounOfShapeOfDo()
  {
    toTheNowNoun = toTheSetOfTheOfstartSignsOfShapeOfDo
        .get( toTheIffy.nextInt( toTheSetOfTheOfstartSignsOfShapeOfDo.size() ) );
    
    final boolean theKey;
    toTheNowNoun += toTheSignOfAnInnerEdgeOfWords + toTheOwn
        .makeIntoNounOfThing( ( theKey = toTheIffy.nextBoolean() ) ? "any" : "the",
            theKey ? false : toTheIffy.nextBoolean() );
    theOneOfWhetherIsItOfSet = toTheOwn.isItOfSet();
    
    return toTheNowNoun;
    
  }
  
  final String makeAnyNounOfShapeOfDo( final String toTheOfstartSign )
  {
    toTheNowNoun = toTheOfstartSign;
    
    final boolean theKey;
    toTheNowNoun += toTheSignOfAnInnerEdgeOfWords + toTheOwn
        .makeIntoNounOfThing( ( theKey = toTheIffy.nextBoolean() ) ? "any" : "the",
            theKey ? false : toTheIffy.nextBoolean() );
    theOneOfWhetherIsItOfSet = toTheOwn.isItOfSet();
    
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
  
}
