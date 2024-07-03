package com.senasa.tupaserver.sede.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CENTRO_TRAMITE", schema = "FINALBPM")
public class SedeEntity {
  @Id
  @Column(name = "CODIGO_CENTRO_TRAMITE")
  private String id;

  @Column(name = "DESCRIPCION_CENTRO_TRAMITE")
  private String name;

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
}
