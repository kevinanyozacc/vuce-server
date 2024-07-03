package com.senasa.tupaserver.product.domain.dtos;

public class ProductSearchDto {
  private String type;
  private String column;
  private String value;

  public String getType() {
    return this.type;
  }

  public void setType(String value) {
    this.type = value;
  }

  public String getColumn() {
    return this.column;
  }

  public void setColumn(String value) {
    this.column = value;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
