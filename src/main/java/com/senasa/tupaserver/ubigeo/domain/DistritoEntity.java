package com.senasa.tupaserver.ubigeo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tdistritos", schema = "Siga")
public class DistritoEntity {
  @Id
  @Column(name = "CODI_DIST_TDI")
  private String id;

  @Column(name = "NOMB_DIST_TDI")
  private String name;

  @Column(name = "CODI_DEPA_DPT")
  private String departamentoId;

  @Column(name = "CODI_PROV_TPR")
  private String provinciaId;

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

  public String getProvinciaId() {
    return this.provinciaId;
  }

  public void setProvinciaId(String value) {
    this.provinciaId = value;
  }
}
