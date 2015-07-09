package com.oriental.springdata.model.util.components;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.util.SerializationHelper;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
@Embeddable
public class Fab5 extends BasicDAOComponent implements Cloneable {

  private static final long serialVersionUID = 5664480533354914315L;

  private String lastUpdateProgram = "SPRINGDATA";

  private Integer lastUpdateJobNumber = new Integer(0);

  private String lastUpdateJob = "SPRINGDATA";

  private Calendar lastUpdateTimestamp = Calendar.getInstance();

  private String lastUpdateUser = "SPRINGDATA";

  /**
   *
   */
  public Fab5() {
  }

  /**
   * @param userName
   */
  public void stamp(String userName) {
    setLastUpdateUser(userName);
    stamp();
  }

  /**
   *
   */
  public void stamp() {
    setLastUpdateTimestamp(Calendar.getInstance());
    setLastUpdateJob("SPRINGDATA");
    setLastUpdateProgram("SPRINGDATA");
    setLastUpdateJobNumber(0);
  }

  /**
   * @return
   */
  @Column(name = "LSTUPDPGM", columnDefinition = "char(10)")
  @NotNull
  public String getLastUpdateProgram() {
    return lastUpdateProgram;
  }

  /**
   * @param lastUpdatedProgram
   */
  public void setLastUpdateProgram(String lastUpdatedProgram) {
    this.lastUpdateProgram = lastUpdatedProgram;
  }

  /**
   * @return
   */
  @Column(name = "LSTUPDNBR", columnDefinition = "numeric(6)")
  @NotNull
  public Integer getLastUpdateJobNumber() {
    return lastUpdateJobNumber;
  }

  /**
   * @param lastUpdateJobNumber
   */
  public void setLastUpdateJobNumber(Integer lastUpdateJobNumber) {
    this.lastUpdateJobNumber = lastUpdateJobNumber;
  }

  /**
   * @return
   */
  @Column(name = "LSTUPDJOB", columnDefinition = "char(10)")
  @NotNull
  public String getLastUpdateJob() {
    return lastUpdateJob;
  }

  /**
   * @param lastUpdateJob
   */
  public void setLastUpdateJob(String lastUpdateJob) {
    this.lastUpdateJob = lastUpdateJob;
  }

  /**
   * @return
   */
  @Column(name = "LSTUPDTSP", columnDefinition = "timestamp")
  @Temporal(TemporalType.TIMESTAMP)
  @NotNull
  public Calendar getLastUpdateTimestamp() {
    return lastUpdateTimestamp;
  }

  /**
   * @param lastUpdateTimestamp
   */
  public void setLastUpdateTimestamp(Calendar lastUpdateTimestamp) {
    this.lastUpdateTimestamp = lastUpdateTimestamp;
  }

  /**
   * @return
   */
  @Column(name = "LSTUPDUSR", columnDefinition = "char(10)")
  @NotNull
  public String getLastUpdateUser() {
    return lastUpdateUser;
  }

  /**
   * @param lastUpdateUser
   */
  public void setLastUpdateUser(String lastUpdateUser) {
    if (lastUpdateUser != null && lastUpdateUser.length() > 10)
      lastUpdateUser = lastUpdateUser.substring(0, 10);
    this.lastUpdateUser = lastUpdateUser;
  }

  @Override
  public Object clone() {
    return SerializationHelper.clone(this);
  }
}
