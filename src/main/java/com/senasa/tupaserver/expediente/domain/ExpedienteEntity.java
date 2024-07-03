package com.senasa.tupaserver.expediente.domain;

public class ExpedienteEntity {
  private String id;
  private String personId;
  private String personName;
  private String date;
  private String stdCodId;
  private String serviceId;
  private String serviceName;
  private String procedureId;
  private String procedureName;
  private String areaName;
  private String sedeId;
  private String sedeName;
  private String requestId;
  private String NumberRegArc;
  private String ucmId;
  private String ordenVuce;
  private String channel;
  private String representanteId;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getPersonId() {
    return this.personId;
  }

  public void setPersonId(String value) {
    this.personId = value;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String value) {
    this.date = value;
  }

  public String getStdCodId() {
    return this.stdCodId;
  }

  public void setStdCodId(String value) {
    this.stdCodId = value;
  }

  public String getServiceId() {
    return this.serviceId;
  }

  public void setServiceId(String value) {
    this.serviceId = value;
  }

  public String getProcedureId() {
    return this.procedureId;
  }

  public void setProcedureId(String value) {
    this.procedureId = value;
  }

  public String getSedeId() {
    return this.sedeId;
  }

  public void setSedeId(String value) {
    this.sedeId = value;
  }

  public String getSedeName() {
    return this.sedeName;
  }

  public void setSedeName(String value) {
    this.sedeName = value;
  }

  public String getAreaName() {
    return this.areaName;
  }

  public void setAreaName(String value) {
    this.areaName = value;
  }

  public String getProcedureName() {
    return this.procedureName;
  }

  public void setProcedureName(String value) {
    this.procedureName = value;
  }

  public String getServiceName() {
    return this.serviceName;
  }

  public void setServiceName(String value) {
    this.serviceName = value;
  }

  public String getPersonName() {
    return this.personName;
  }

  public void setPersonName(String value) {
    this.personName = value;
  }

  public String getRequestId() {
    return this.requestId;
  }

  public void setRequestId(String value) {
    this.requestId = value;
  }

  public String getNumberRegArc() {
    return this.NumberRegArc;
  }

  public void setNumberRegArc(String value) {
    this.NumberRegArc = value;
  }

  public String getUcmId() {
    return this.ucmId;
  }

  public void setUcmId(String value) {
    this.ucmId = value;
  }

  public String getOrdenVuce() {
    return this.ordenVuce;
  }

  public void setOrdenVuce(String value) {
    this.ordenVuce = value;
  }

  public String getChannel() {
    return this.channel;
  }

  public void setChannel(String value) {
    this.channel = value;
  }

  public String getRepresentanteId() {
    return this.representanteId;
  }

  public void setRepresentanteId(String value) {
    this.representanteId = value;
  }
}
