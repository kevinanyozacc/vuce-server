package com.senasa.tupaserver.representante.domain.dtos;

import javax.validation.constraints.NotBlank;

public class RepresentanteCreateDto {
  @NotBlank
  private String personId;

  @NotBlank
  private String representanteId;

  @NotBlank
  private String fullname;

  @NotBlank
  private String cargo;

  @NotBlank
  private String cargoDate;

  @NotBlank
  private String order;

  @NotBlank
  private String state;

  @NotBlank
  private String user;

  public String getPersonId() {
    return this.personId;
  }

  public void setPersonId(String value) {
    this.personId = value;
  }

  public String getFullname() {
    return this.fullname;
  }

  public void setFullname(String value) {
    this.fullname = value;
  }

  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String value) {
    this.cargo = value;
  }

  public String getCargoDate() {
    return this.cargoDate;
  }

  public void setCargoDate(String value) {
    this.cargoDate = value;
  }

  public String getOrder() {
    return this.order;
  }

  public void setOrder(String value) {
    this.order = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String value) {
    this.user = value;
  }

  public String getRepresentanteId() {
    return this.representanteId;
  }

  public void setRepresentanteId(String value) {
    this.representanteId = value;
  }
}
