package com.senasa.tupaserver.representante.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA_REPRESENTANTE_LEGAL")
public class RepresentanteEntity {
  @Id
  @Column(name = "REPRESENTANTE_ID")
  private String id;

  @Column(name = "PERSONA_ID")
  private String personId;

  @Column(name = "NOMBRE_COMPLETO")
  private String fullname;

  @Column(name = "CARGO")
  private String cargo;

  @Column(name = "FECHA_CARGO")
  private String cargoDate;

  @Column(name = "ORDEN_REPRESENTANTE")
  private String ordenRepresentante;

  @Column(name = "ESTADO")
  private String state;

  @Column(name = "USER_CREA")
  private String userCreatedAt;

  @Column(name = "USER_MODI")
  private String userUpdatedAt;

  @Column(name = "FECH_CREA")
  private String createdAt;

  @Column(name = "FECH_MODI")
  private String updatedAt;

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

  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String value) {
    this.cargo = value;
  }

  public String getFullname() {
    return this.fullname;
  }

  public void setFullname(String value) {
    this.fullname = value;
  }

  public String getCargoDate() {
    return this.cargoDate;
  }

  public void setCargoDate(String value) {
    this.cargoDate = value;
  }

  public String getOrdenRepresentante() {
    return this.ordenRepresentante;
  }

  public void setOrdenRepresentante(String value) {
    this.ordenRepresentante = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }

  public String getUserCreatedAt() {
    return this.userCreatedAt;
  }

  public void setUserCreatedAt(String value) {
    this.userCreatedAt = value;
  }

  public String getUserUpdatedAt() {
    return this.userUpdatedAt;
  }

  public void setUserUpdatedAt(String value) {
    this.userUpdatedAt = value;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(String value) {
    this.createdAt = value;
  }

  public String getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(String value) {
    this.updatedAt = value;
  }
}
