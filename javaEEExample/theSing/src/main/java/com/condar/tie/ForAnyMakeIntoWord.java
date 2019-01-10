package com.condar.tie;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import javax.persistence.Query;
import javax.persistence.NoResultException;

import java.util.StringTokenizer;

import java.util.List;
import java.util.ArrayList;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import java.util.Random;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

final class ForAnyMakeIntoWord
{
  private String toTheNowWord;
  
  private boolean theOneOfWhetherIsItAWordOfSetOrOfDieOfS;
  
  private static Query toOneToSearchingInTheVERBS, toOneToSelectingFromTheVERBS,
      toOneToSelectingFromTheVERBSAndWithADielyPartOfWord;
  
  private static final int theWhollyCountOfVerbs = makeIntoAWhollyCountOfVerbs();
  
  //private 
  static final List<String> toTheStartlySetOfWords = new ArrayList<String>(8);
  
  static final Random toTheIffy = new Random();
  
  private static final int theEdgeOfChoose = 3,
      theToedgeNumberToCuttingADyingOfString = 2;
  
  private static final Set<String> toTheSetOfDiesOfWords = new HashSet<String>( 5, 1.0f );
  static
  {
    toTheSetOfDiesOfWords.addAll( Arrays.asList( "o", "ss", "sh", "ch", "x" ) );
  }
  
  
  
  //static 
  final void doMakeAnyTheseQueries( final EntityManagerFactory toTheEntityManagerFactory )
  {
    EntityManager toTheEntityManager = toTheEntityManagerFactory.createEntityManager();
    
    toOneToSearchingInTheVERBS = toTheEntityManager.createQuery(
        "SELECT COUNT(r) FROM toTheRowWithWord r WHERE r.toTheWord = ?1");//:?"),
    toOneToSelectingFromTheVERBS = toTheEntityManager.createQuery(
        "SELECT r.toTheWord FROM toTheRowWithWord r WHERE r.toTheIdToWord = ?1");
    toOneToSelectingFromTheVERBSAndWithADielyPartOfWord
        = toTheEntityManager.createNativeQuery(//or DataSource or that downwardly
            "SELECT word FROM ( SELECT word FROM verbs WHERE word != ?1 AND word LIKE ?2"
              + " ORDER BY DBMS_RANDOM.VALUE ) WHERE ROWNUM = 1" );
    
  }
  
  
  private static final int makeIntoAWhollyCountOfVerbs()//!for the constr. level!
  {
    Connection toTheCon;
    try
    {
      OracleDataSource toTheDBSource = new OracleDataSource();
      toTheDBSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
      
      toTheCon = toTheDBSource.getConnection( "myWords", "1" );
      
    }
    catch( SQLException ex )
    {
      ex.printStackTrace();
      toTheCon = null;
      
    }
    
    int theOneToBeingAReturning;
    
    Statement toCount = null;
    try
    {
      toCount = toTheCon.createStatement();
      theOneToBeingAReturning = toCount.executeQuery("SELECT MAX(word_id) FROM verbs").next() ?
          toCount.getResultSet().getInt(1) : -1;
    }
    catch( IllegalStateException ex )
    {
      ex.printStackTrace();
      theOneToBeingAReturning = -1;
      
    }
    catch( SQLException ex )
    {
      ex.printStackTrace();
      theOneToBeingAReturning = -1;
      
    }
    finally
    {
      try
      {
        if( toCount != null )
        {
          toCount.close();
        }
        
      }
      catch( SQLException ex )
      {
        ex.printStackTrace();
        theOneToBeingAReturning = -1;
        
      }
      
    }
    
    try
    {
      toTheCon.close();
    }
    catch( SQLException ex )
    {
      ex.printStackTrace();
      theOneToBeingAReturning = -1;
      
    }
    
    if( theOneToBeingAReturning == -1 )
    {
      throw new IllegalStateException( "The unwork is at querying the count of verbs!".toUpperCase() );
    }
    
    return theOneToBeingAReturning;
    
  }
  
  
  //static 
  final void makeIntoAnOfstartingSetOfWords( final String toTheOfstartingString )
  {
    final StringTokenizer toTheCutOntoAString = new StringTokenizer( toTheOfstartingString, " -\u2014,;:.!?\n\r\f\t" );//" -\uE28094,;:.!?" );
    
    String toTheOne;
    while( toTheCutOntoAString.hasMoreTokens() )
    {
      toTheOne = toTheCutOntoAString.nextToken();
      
      toOneToSearchingInTheVERBS.setParameter( 1, toTheOne );
      
      if( (Long) toOneToSearchingInTheVERBS.getSingleResult() == 1 )
      {
        toTheStartlySetOfWords.add(toTheOne);
      }
      
    }
    
  }
  
  
  
  ForAnyMakeIntoWord()
  {
    toTheNowWord = null;
    
    theOneOfWhetherIsItAWordOfSetOrOfDieOfS = false;
    
    toOneToSearchingInTheVERBS = toOneToSelectingFromTheVERBS
        = toOneToSelectingFromTheVERBSAndWithADielyPartOfWord = null;
    
  }
  
  
  
  private final void makeIntoAWordOfSet( final boolean theOneOfDoNoGiveAReturnbeenValueInAnyCase )
  {
    final String toTheEnd = toTheNowWord.substring( toTheNowWord.length() - 2 );
    if( toTheEnd.endsWith("y") )
    {
      toTheNowWord = toTheNowWord.substring( 0, toTheNowWord.length() - 1 ) + "ies";
    }
    else if( toTheSetOfDiesOfWords.contains(toTheEnd)
        || toTheSetOfDiesOfWords.contains(
            String.valueOf( toTheEnd.charAt( toTheEnd.length() - 1) ) ) )
    {
      toTheNowWord += "es";
    }
    else
    {
      toTheNowWord += "s";
    }
    
  }
  
  final String makeIntoAWordOfSet()
  {
    makeIntoAWordOfSet(true);
    
    return toTheNowWord;
    
  }
  
  static final String makeIntoASetWordOfSet( String toTheSetWord )
  {
    
    final String toTheEnd = toTheSetWord.substring( toTheSetWord.length() - 2 );
    if( toTheEnd.endsWith("y") )
    {
      toTheSetWord = toTheSetWord.substring( 0, toTheSetWord.length() - 1 ) + "ies";
    }
    else if( toTheSetOfDiesOfWords.contains(toTheEnd)
        || toTheSetOfDiesOfWords.contains(
            String.valueOf( toTheEnd.charAt( toTheEnd.length() - 1) ) ) )
    {
      toTheSetWord += "es";
    }
    else
    {
      toTheSetWord += "s";
    }
    
    return toTheSetWord;
    
  }
  
  private final void doAlongThePartOfTheWisesWithTheNameOfMakeIntoAWordAndWithTheIffy()
  {
    if( ! toTheStartlySetOfWords.isEmpty() && toTheIffy.nextInt(theEdgeOfChoose) == 0 )
    {
      toTheNowWord = toTheStartlySetOfWords.get( toTheIffy
          .nextInt( toTheStartlySetOfWords.size() ) );
      
    }
    else
    {
      toOneToSelectingFromTheVERBS.setParameter( 1, toTheIffy.nextInt(theWhollyCountOfVerbs) + 1 );
      
      try
      {
        toTheNowWord = (String) toOneToSelectingFromTheVERBS.getSingleResult();
      }
      catch( NoResultException ex )
      {
        ex.printStackTrace();
        toTheNowWord = null;
        
      }
      
    }
    
    if( toTheNowWord == null )
    {
      throw new NullPointerException("There is no a now word!");
    }
    
  }
  
  final void makeIntoAWordAndWithTheIffy( final boolean theOneOfDoNoGiveAReturnbeenValueInAnyCase,
      final boolean theOneOfWhetherDoYouNowNeedAWordOfSet )
  {
    doAlongThePartOfTheWisesWithTheNameOfMakeIntoAWordAndWithTheIffy();
    
    if(theOneOfWhetherDoYouNowNeedAWordOfSet)
    {
      makeIntoAWordOfSet(true);
    }
    
    theOneOfWhetherIsItAWordOfSetOrOfDieOfS = theOneOfWhetherDoYouNowNeedAWordOfSet;
    
  }
  
  final String makeIntoAWordAndWithTheIffy( final boolean theOneOfWhetherDoYouNowNeedAWordOfSet )
  {
    doAlongThePartOfTheWisesWithTheNameOfMakeIntoAWordAndWithTheIffy();
    
    if(theOneOfWhetherDoYouNowNeedAWordOfSet)
    {
      makeIntoAWordOfSet(true);
    }
    
    theOneOfWhetherIsItAWordOfSetOrOfDieOfS = theOneOfWhetherDoYouNowNeedAWordOfSet;
    
    return toTheNowWord;
    
  }
  
  final String makeIntoAWordAndWithTheIffy( final boolean theOneOfWhetherDoYouNowNeedAWordOfSet,
      final String toTheDyingWordWithTheOfneedingDie )
  {
    if(theOneOfWhetherDoYouNowNeedAWordOfSet)
    {
      makeIntoAWordAndWithTheIffy( true, theOneOfWhetherDoYouNowNeedAWordOfSet );
    }
    else
    {
      toOneToSelectingFromTheVERBSAndWithADielyPartOfWord.setParameter( 1, toTheDyingWordWithTheOfneedingDie );
      toOneToSelectingFromTheVERBSAndWithADielyPartOfWord.setParameter( 2, "%" + toTheDyingWordWithTheOfneedingDie
          .substring( toTheDyingWordWithTheOfneedingDie.length() - theToedgeNumberToCuttingADyingOfString ) );
      
      @SuppressWarnings("rawtypes")
      final List toTheOntomakebeenList = toOneToSelectingFromTheVERBSAndWithADielyPartOfWord.getResultList();
      toTheNowWord = toTheOntomakebeenList.isEmpty() ? toTheDyingWordWithTheOfneedingDie
          : (String) toTheOntomakebeenList.get(0);
      
    }
    
    if( toTheNowWord == null )
    {
      throw new NullPointerException("There is no a now word!");
    }
    
    theOneOfWhetherIsItAWordOfSetOrOfDieOfS = theOneOfWhetherDoYouNowNeedAWordOfSet;
    
    return toTheNowWord;
    
  }
  
  
  
  final String give()
  {
    return toTheNowWord;
  }
  
  final boolean isItOfSet()
  {
    return theOneOfWhetherIsItAWordOfSetOrOfDieOfS;
  }
  
}
