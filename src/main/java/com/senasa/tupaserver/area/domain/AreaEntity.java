package com.senasa.tupaserver.area.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AREA_GESTION", schema = "FINALBPM")
public class AreaEntity {
  @Id
  @Column(name = "CODIGO_AREA_GESTION")
  private String id;

  @Column(name = "DESCRIPCION_AREA_GESTION")
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
