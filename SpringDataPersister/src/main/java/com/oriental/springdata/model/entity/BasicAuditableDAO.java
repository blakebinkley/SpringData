package com.oriental.springdata.model.entity;

public abstract class BasicAuditableDAO extends BasicDAO implements Auditable {

  private static final long serialVersionUID = 6984330244125304707L;

  /**
   *
   */
  public BasicAuditableDAO() {
    super();
  }

  /**
   *
   */
  public void stamp() {
    getFab5().stamp();
  }

  /**
   * @param userID
   */
  @Override
  public void stamp(String userID) {
    getFab5().stamp();
    getFab5().setLastUpdateUser(userID);
  }

  static String[] propNames = new String[]{"fab5"};

  /**
   * @return
   */
  public String[] getStampedPropertyNames() {
    return propNames;
  }

  /**
   * @return
   */
  public Object[] getStampedValues() {
    return new Object[]{getFab5()};
  }
}
