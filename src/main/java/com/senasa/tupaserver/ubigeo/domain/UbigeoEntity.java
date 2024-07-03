package com.senasa.tupaserver.ubigeo.domain;

public class UbigeoEntity {
  String id;
  String name;
  private String departamentoId;
  private String provinciaId;
  private String distritoId;
  private String departamentoName;
  private String provinciaName;
  private String distritoName;

  public UbigeoEntity() {
  }

  public UbigeoEntity(String id) {
    this.id = id;
  }

  public UbigeoEntity(String departamentoId, String provinciaId, String distritoId) {
    this.departamentoId = departamentoId;
    this.provinciaId = provinciaId;
    this.distritoId = distritoId;
  }

  public String getUbigeoId() {
    return this.departamentoId + this.provinciaId + this.distritoId;
  }

  public String getId() {
    return this.id;
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

  public String getName() {
    String name = this.departamentoName;
    name += " / ";
    name += this.provinciaName;
    name += " / ";
    name += this.distritoName;
    return name;
  }

  public String getDepartamentoName() {
    return this.departamentoName;
  }

  public void setDepartamentoName(String value) {
    this.departamentoName = value;
  }

  public String getProvinciaName() {
    return this.provinciaName;
  }

  public void setProvinciaName(String value) {
    this.provinciaName = value;
  }

  public String getDistritoName() {
    return this.distritoName;
  }

  public void setDistritoName(String value) {
    this.distritoName = value;
  }
}
