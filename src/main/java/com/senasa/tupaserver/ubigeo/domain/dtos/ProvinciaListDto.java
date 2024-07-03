package com.senasa.tupaserver.ubigeo.domain.dtos;

public class ProvinciaListDto {
  private String id;
  private String departamentoId;

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
}
