package com.senasa.tupaserver.establishment.domain.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EstablishmentCreateDto {
  @NotBlank
  private String type;

  @NotBlank
  private String name;

  @NotBlank
  private String address;

  @NotBlank
  private String ownerName;

  @NotBlank
  private String ownerRuc;

  @NotBlank
  private String departamentoId;

  @NotBlank
  private String provinciaId;

  @NotBlank
  private String distritoId;

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
