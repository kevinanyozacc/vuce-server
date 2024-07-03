package com.senasa.tupaserver.ubigeo.domain.dtos;

public class UbigeoFindDto {
  private String id;
  private String departamentoId;
  private String provinciaId;
  private String distritoId;

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

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }
}
