package com.senasa.tupaserver.establishment.domain.dtos;

public class EstablishmentFindDto {
  private String id;
  private String type;
  private String name;
  private String ownerName;
  private String ownerRuc;

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
}
