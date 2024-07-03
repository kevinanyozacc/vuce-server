package com.senasa.tupaserver.ubigeo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CENTROS_POBLADOS", schema = "Siga")
public class PobladoEntity {
  @Id
  @Column(name = "CODI_CCPP_TCP")
  private String centroId;

  @Column(name = "NOMB_CCPP_TCP")
  private String name;

  @Column(name = "CODI_DEPA_DPT")
  private String departamentoId;

  @Column(name = "CODI_PROV_TPR")
  private String provinciaId;

  @Column(name = "CODI_DIST_TDI")
  private String distritoId;

  public PobladoEntity() {
  }

  public PobladoEntity(String departamentoId, String provinciaId, String distritoId, String centroId) {
    this.departamentoId = departamentoId;
    this.provinciaId = provinciaId;
    this.distritoId = distritoId;
    this.centroId = centroId;
  }

  public String getId() {
    return this.departamentoId + this.provinciaId + this.distritoId + this.centroId;
  }

  public String getCentroId() {
    return this.centroId;
  }

  public void setCentroId(String value) {
    this.centroId = value;
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

  public String getDistritoId() {
    return this.distritoId;
  }

  public void setDistritoId(String value) {
    this.distritoId = value;
  }
}
