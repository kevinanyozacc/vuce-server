package com.senasa.tupaserver.establishment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTABLECIMIENTO", schema = "FINALBPM")
public class EstablishmentEntity {
  @Id
  @Column(name = "ID")
  private String id;

  @Column(name = "TIPO")
  private String type;

  @Column(name = "NOMBRE_ESTABLECIMIENTO")
  private String name;

  @Column(name = "DIRECCION_ESTABLECIMIENTO")
  private String address;

  @Column(name = "NOMBRE_PROPIETARIO")
  private String ownerName;

  @Column(name = "RUC_PROPIETARIO")
  private String ownerRuc;

  @Column(name = "DEPARTAMENTO_ID")
  private String departamentoId;

  @Column(name = "PROVINCIA_ID")
  private String provinciaId;

  @Column(name = "DISTRITO_ID")
  private String distritoId;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String value) {
    this.type = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String value) {
    this.address = value;
  }

  public String getOwnerName() {
    return this.ownerName;
  }

  public void setOwnerName(String value) {
    this.ownerName = value;
  }

  public String getOwnerRuc() {
    return this.ownerRuc;
  }

  public void setOwnerRuc(String value) {
    this.ownerRuc = value;
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
