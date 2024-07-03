package com.senasa.tupaserver.methodPayment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANCO_CTA_CTE", schema = "FINALBPM")
public class AccountEntity {
  @Id
  @Column(name = "CODIGO_CTA_CTE")
  private String id;

  @Column(name = "CODIGO_BANCO")
  private String bankId;

  @Column(name = "NUMERO_CTA")
  private String number;

  @Column(name = "ESTADO")
  private String state;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getBankId() {
    return this.bankId;
  }

  public void setBankId(String value) {
    this.bankId = value;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String value) {
    this.number = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }
}
