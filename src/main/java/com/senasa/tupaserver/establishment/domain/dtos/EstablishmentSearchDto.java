package com.senasa.tupaserver.establishment.domain.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EstablishmentSearchDto {
  @NotBlank
  private String value;

  @NotBlank
  private String column;

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getColumn() {
    return this.column;
  }

  public void setColumn(String value) {
    this.column = value;
  }
}
