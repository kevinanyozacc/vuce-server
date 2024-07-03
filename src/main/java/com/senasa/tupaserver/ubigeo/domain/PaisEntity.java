package com.senasa.tupaserver.ubigeo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TPAISES", schema = "SIGA")
public class PaisEntity {
  @Id
  @Column(name = "CODI_PAIS_TPA")
  private String id;

  @Column(name = "NOMB_PAIS_TPA")
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
