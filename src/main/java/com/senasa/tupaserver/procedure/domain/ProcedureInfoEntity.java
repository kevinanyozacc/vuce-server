package com.senasa.tupaserver.procedure.domain;

public class ProcedureInfoEntity {
  private String areaId;
  private String areaName;
  private String procedureId;
  private String procedureName;
  private String serviceId;
  private String serviceName;

  public String getAreaId() {
    return this.areaId;
  }

  public void setAreaId(String value) {
    this.areaId = value;
  }

  public String getAreaName() {
    return this.areaName;
  }

  public void setAreaName(String value) {
    this.areaName = value;
  }

  public String getProcedureId() {
    return this.procedureId;
  }

  public void setProcedureId(String value) {
    this.procedureId = value;
  }

  public String getProcedureName() {
    return this.procedureName;
  }

  public void setProcedureName(String value) {
    this.procedureName = value;
  }

  public String getServiceId() {
    return this.serviceId;
  }

  public void setServiceId(String value) {
    this.serviceId = value;
  }

  public String getServiceName() {
    return this.serviceName;
  }

  public void setServiceName(String value) {
    this.serviceName = value;
  }
}
