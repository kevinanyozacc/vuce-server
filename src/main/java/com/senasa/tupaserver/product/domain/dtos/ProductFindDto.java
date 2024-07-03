package com.senasa.tupaserver.product.domain.dtos;

public class ProductFindDto {
  private String type;
  private String name;
  private String arancelariaId;
  private String scientificName;

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

  public String getScientificName() {
    return this.scientificName;
  }

  public void setScientificName(String value) {
    this.scientificName = value;
  }

  public String getArancelariaId() {
    return this.arancelariaId;
  }

  public void setArancelariaId(String value) {
    this.arancelariaId = value;
  }
}
