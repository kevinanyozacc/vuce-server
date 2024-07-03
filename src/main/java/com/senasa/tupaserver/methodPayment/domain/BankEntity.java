package com.senasa.tupaserver.methodPayment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANCO", schema = "FINALBPM")
public class BankEntity {
  @Id
  @Column(name = "CODIGO_BANCO")
  private String id;

  @Column(name = "NOMBRE_BANCO")
  private String name;

  @Column(name = "ESTADO")
  private String state;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }
}
