package com.senasa.tupaserver.detalle.domain.dtos;

public class DetalleCreateDto {
  private String expedienteId;
  private String establishmentId;
  private String technicalId;
  private String type;
  private String numberPSI;
  private String sourceCountryId;
  private String targetCountryId;
  private String place;

  public String getExpedienteId() {
    return this.expedienteId;
  }

  public void setExpedienteId(String value) {
    this.expedienteId = value;
  }

  public String getEstablishmentId() {
    return this.establishmentId;
  }

  public void setEstablishmentId(String value) {
    this.establishmentId = value;
  }

  public String getTechnicalId() {
    return this.technicalId;
  }

  public void setTechnicalId(String value) {
    this.technicalId = value;
  }

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
