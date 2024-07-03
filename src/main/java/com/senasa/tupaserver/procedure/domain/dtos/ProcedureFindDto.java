package com.senasa.tupaserver.procedure.domain.dtos;

public class ProcedureFindDto {
  private String id;
  private String areaId;

  public String getAreaId() {
    return this.areaId;
  }

  public void setAreaId(String value) {
    this.areaId = value;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }
}
