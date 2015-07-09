package com.oriental.springdata.model.entity;

import javax.persistence.Embedded;

import com.oriental.springdata.model.util.components.Fab5;

public interface Auditable extends Stampable {

  /**
   * @return
   */
  @Embedded
  public Fab5 getFab5();

  /**
   * @param fab5
   */
  public void setFab5(Fab5 fab5);
}
