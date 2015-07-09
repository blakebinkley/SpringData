package com.oriental.springdata.model.entity;

import javax.persistence.Transient;

public interface Stampable {

  /**
   *
   */
  public void stamp();

  /**
   * @param userID
   */
  public void stamp(String userID);

  /**
   * @return
   */
  @Transient
  public String[] getStampedPropertyNames();

  /**
   * @return
   */
  @Transient
  public Object[] getStampedValues();
}
