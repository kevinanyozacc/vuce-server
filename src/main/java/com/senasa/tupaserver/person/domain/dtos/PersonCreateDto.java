package com.senasa.tupaserver.person.domain.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonCreateDto {
  @NotEmpty
  private String nombreRazonSocial;

  @NotNull
  private String type;

  @NotEmpty
  private String documentTypeId;

  @NotEmpty
  private String documentNumber;

  private String lastName;

  private String secondaryName;

  private String names;

  private String ruc;

  private String gender;

  private String address;

  @NotEmpty
  private String departamentoId;

  @NotEmpty
  private String provinciaId;

  @NotEmpty
  private String distritoId;

  private String centroPobladoId;

  private String phone;

  private String cellphone;

  private String email;

  private String referen;

  public String getNombreRazonSocial() {
    return this.nombreRazonSocial;
  }

  public void setNombreRazonSocial(String value) {
    this.nombreRazonSocial = value;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String value) {
    this.type = value;
  }

  public String getDocumentTypeId() {
    return this.documentTypeId;
  }

  public void setDocumentTypeId(String value) {
    this.documentTypeId = value;
  }

  public String getDocumentNumber() {
    return this.documentNumber;
  }

  public void setDocumentNumber(String value) {
    this.documentNumber = value;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String value) {
    this.lastName = value;
  }

  public String getSecondaryName() {
    return this.secondaryName;
  }

  public void setSecondaryName(String value) {
    this.secondaryName = value;
  }

  public String getNames() {
    return this.names;
  }

  public void setNames(String value) {
    this.names = value;
  }

  public String getRuc() {
    return this.ruc;
  }

  public void setRuc(String value) {
    this.ruc = value;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String value) {
    this.address = value;
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

  public String getCentroPobladoId() {
    return this.centroPobladoId;
  }

  public void setCentroPobladoId(String value) {
    this.centroPobladoId = value;
  }

  public String getCellphone() {
    return this.cellphone;
  }

  public void setCellphone(String value) {
    this.cellphone = value;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String value) {
    this.email = value;
  }

  public String getReferen() {
    return this.referen;
  }

  public void setReferen(String value) {
    this.referen = value;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String value) {
    this.gender = value;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String value) {
    this.phone = value;
  }
}
