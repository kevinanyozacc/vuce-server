package com.senasa.tupaserver.detalle.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXPEDIENTE_CUARENTENA_DETALLE", schema = "FINALBPM")
public class DetalleEntity {
  @Id
  @Column(name = "CODIGO_CUARENTENA_DETALLE")
  private String id;

  @Column(name = "CODIGO_EXPEDIENTE")
  private String expedienteId;

  @Column(name = "CODIGO_ESTABLECIMIENTO")
  private String establishmentId;

  @Column(name = "CODIGO_TECNICO_PERSONA")
  private String technicalId;

  @Column(name = "TIPO_DETALLE")
  private String type;

  @Column(name = "NUMERO_PSI")
  private String numberPSI;

  @Column(name = "SOURCE_PAIS_ID")
  private String sourceCountryId;

  @Column(name = "TARGET_PAIS_ID")
  private String targetCountryId;

  @Column(name = "LUGAR_DETALLE")
  private String place;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

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

  @Override
  public String toString() {
    List<String> arrayAttr = new ArrayList<String>();
    arrayAttr.add("ID=" + this.id);
    arrayAttr.add("EXPEDIENTE_ID=" + this.expedienteId);
    arrayAttr.add("ESTABLISHMENT_ID=" + this.establishmentId);
    arrayAttr.add("TECHNICAL_ID=" + this.technicalId);
    arrayAttr.add("TYPE=" + this.type);
    arrayAttr.add("NUMBERPSI=" + this.numberPSI);
    arrayAttr.add("SOURCE_COUNTRY_ID=" + this.sourceCountryId);
    arrayAttr.add("TARGET_COUNTRY_ID=" + this.targetCountryId);
    arrayAttr.add("PLACE=" + this.place);
    return String.join(", ", arrayAttr);
  }
}
