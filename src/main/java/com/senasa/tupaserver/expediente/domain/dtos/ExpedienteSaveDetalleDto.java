package com.senasa.tupaserver.expediente.domain.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExpedienteSaveDetalleDto {
  @NotBlank
  private String type;

  private String numberPSI;
  private String sourceCountryId;
  private String targetCountryId;
  private String place;

  public String getType() {
    return this.type;
  }

  public void setType(String value) {
    this.type = value;
  }

  public String getNumberPSI() {
    return this.numberPSI;
  }

  public void setNumberPSI(String value) {
    this.numberPSI = value;
  }

  public String getSourceCountryId() {
    return this.sourceCountryId;
  }

  public void setSourceCountryId(String value) {
    this.sourceCountryId = value;
  }

  public String getTargetCountryId() {
    return this.targetCountryId;
  }

  public void setTargetCountryId(String value) {
    this.targetCountryId = value;
  }

  public String getPlace() {
    return this.place;
  }

  public void setPlace(String value) {
    this.place = value;
  }
}
