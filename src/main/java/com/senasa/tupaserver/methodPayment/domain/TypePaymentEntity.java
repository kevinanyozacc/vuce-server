package com.senasa.tupaserver.methodPayment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_PAGO", schema = "FINALBPM")
public class TypePaymentEntity {
  @Id
  @Column(name = "CODIGO_TIPO_PAGO")
  private String id;

  @Column(name = "DESCRIPCION_TIPO_PAGO")
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
