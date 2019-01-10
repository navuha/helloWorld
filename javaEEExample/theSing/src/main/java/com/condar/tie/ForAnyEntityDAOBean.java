package com.condar.tie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean@ViewScoped
@Entity( name = "toTheRowWithWord" )@Table( name = "VERBS" )
public final class ForAnyEntityDAOBean implements Serializable
{
  private static final long serialVersionUID = 5361655926781330787L;

  @Id@Column( name = "WORD_ID" )
  private Integer toTheIdToWord;

  @Column( name = "WORD" )
  private String toTheWord;

  public ForAnyEntityDAOBean()
  {
  }
/*
  public ForAnyEntityDAOBean( final Integer toTheIdToWord, final String toTheWord )
  {
    this.toTheIdToWord = toTheIdToWord;
    this.toTheWord = toTheWord;

  }
*/
  public final Integer getToTheIdToWord()
  {
    return toTheIdToWord;
  }

  public final void setToTheIdToWord( final Integer toTheIdToWord )
  {
    this.toTheIdToWord = toTheIdToWord;
  }

  public final String getToTheWord()
  {
    return toTheWord;
  }

  public final void setToTheWord( final String toTheWord )
  {
    this.toTheWord = toTheWord;
  }

  @Override
  public final String toString()
  {

    return
        "The identifier = " + ( toTheIdToWord == null ? "0" : toTheIdToWord )
        + ";\nThe name = " + ( toTheWord == null ? "" : toTheIdToWord );

  }

}
