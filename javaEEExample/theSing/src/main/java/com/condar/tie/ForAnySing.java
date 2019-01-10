package com.condar.tie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;

@ManagedBean( name = "toTheSing" )@ViewScoped
public final class ForAnySing implements ForAnyOneForShareable, Serializable//!and non with last;to ws.public is a need
{
  private static final long serialVersionUID = 6779652717215694524L;
  
  private String toTheStringForStart;
  
  private String toTheWordsToSing;
  
  private final ForAnyMakeIntoString toTheMakeIntoString = new ForAnyMakeIntoString(this);
  
  @PersistenceUnit
  private EntityManagerFactory toTheEntityManagerFactory;
  
  
  
  public final String getToTheStringForStart()
  {
    return toTheStringForStart;
  }
  
  public final void setToTheStringForStart( String toTheStringForStart )
  {
    this.toTheStringForStart = toTheStringForStart;
  }
  
  
  public final void setToTheWordsToSing( String toTheWordsToSing )
  {
    this.toTheWordsToSing = toTheWordsToSing;
  }
  
  public final String getToTheWordsToSing()
  {
    return toTheWordsToSing;
  }
  
  
  public final EntityManagerFactory getToTheEntityManagerFactory()
  {
    return toTheEntityManagerFactory;
  }
  
  public final void setToTheEntityManagerFactory( final EntityManagerFactory toTheEntityManagerFactory )
  {
    this.toTheEntityManagerFactory = toTheEntityManagerFactory;
  }
  
  
  
  public ForAnySing()
  {
    toTheStringForStart = null;
    
    toTheWordsToSing = null;
    
  }
  
  private final void doIntoWith( final String toTheStringForStart )
  {
    //this.toTheStringForStart = 
    toTheWordsToSing = "";
    
    toTheMakeIntoWord.doMakeAnyTheseQueries(toTheEntityManagerFactory);
    
    toTheMakeIntoWord.makeIntoAnOfstartingSetOfWords(toTheStringForStart);
    
    toTheMakeIntoString.doAlongThePartOfConstructor();
    
  }
  
  private final void doOver()
  {
    for( int at = 0; at < 4; ++at )
    {
      toTheWordsToSing += toTheMakeIntoString.makeAString() + "\n";//"&lt;br/&gt;";//"\n";//"<br/>";//"\r\n";//"\n";
    }
    
  }
  
  public final void doAll()
  {
    doIntoWith(toTheStringForStart);
    
    doOver();
    
  }
  
}