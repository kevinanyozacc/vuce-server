package com.senasa.tupaserver.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOGO_ESPECIE_SINONIMO", schema = "SIGSVE")
public class SpeciesEntity {
  @Id
  @Column(name = "CODIGO_ESPECIE")
  private String id;

  @Column(name = "NOMB_SINO_SIN")
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
