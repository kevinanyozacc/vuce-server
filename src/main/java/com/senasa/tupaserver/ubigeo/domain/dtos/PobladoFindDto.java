package com.senasa.tupaserver.ubigeo.domain.dtos;

public class PobladoFindDto {
  private String id;
  private String departamentoId;
  private String provinciaId;
  private String distritoId;
  private String centroId;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
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

  public String getCentroId() {
    return this.centroId;
  }

  public void setCentroId(String value) {
    this.centroId = value;
  }

  @Override
  public String toString() {
    return "id=" + this.getId() + ", " +
        "departamentoId=" + this.getDepartamentoId() + ", " +
        "provinciaId=" + this.getProvinciaId() + ", " +
        "distritoId=" + this.getDistritoId() + ", " +
        "centroId=" + this.getCentroId();
  }
}
