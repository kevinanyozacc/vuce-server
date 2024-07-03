package com.senasa.tupaserver.ubigeo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tprovincias", schema = "Siga")
public class ProvinciaEntity {
  @Id
  @Column(name = "CODI_PROV_TPR")
  private String id;

  @Column(name = "NOMB_PROV_TPR")
  private String name;

  @Column(name = "CODI_DEPA_DPT")
  private String departamentoId;

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

  public String getDepartamentoId() {
    return this.departamentoId;
  }

  public void setDepartamentoId(String value) {
    this.departamentoId = value;
  }
}
