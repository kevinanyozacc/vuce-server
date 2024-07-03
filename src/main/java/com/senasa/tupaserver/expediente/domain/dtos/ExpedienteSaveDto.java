package com.senasa.tupaserver.expediente.domain.dtos;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExpedienteSaveDto {
  private String id;

  @NotBlank
  private String sedeId;

  @NotBlank
  private String procedureId;

  @NotBlank
  private String channel = "BPM";

  @NotBlank
  private String personId;

  @NotBlank
  private String establishmentId;

  @NotBlank
  private String technicalId;

  @NotBlank
  private String otherPersonId;

  @NotBlank
  private String userId;

  @NotBlank
  private String requestPersonId;

  @NotBlank
  private String representanteId;

  @NotBlank
  private List<ExpedienteSaveServiceDto> services = new ArrayList<ExpedienteSaveServiceDto>();

  @NotBlank
  private List<ExpedienteSavePaymentDto> payments = new ArrayList<ExpedienteSavePaymentDto>();

  @NotBlank
  private List<ExpedienteSaveProductDto> products = new ArrayList<ExpedienteSaveProductDto>();

  @NotBlank
  private ExpedienteSaveDetalleDto detalle;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getSedeId() {
    return this.sedeId;
  }

  public void setSedeId(String value) {
    this.sedeId = value;
  }

  public String getProcedureId() {
    return this.procedureId;
  }

  public void setProcedureId(String value) {
    this.procedureId = value;
  }

  public String getChannel() {
    return this.channel;
  }

  public void setChannel(String value) {
    this.channel = value;
  }

  public String getPersonId() {
    return this.personId;
  }

  public void setPersonId(String value) {
    this.personId = value;
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

  public String getOtherPersonId() {
    return this.otherPersonId;
  }

  public void setOtherPersonId(String value) {
    this.otherPersonId = value;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String value) {
    this.userId = value;
  }

  public String getRequestPersonId() {
    return this.requestPersonId;
  }

  public void setRequestPersonId(String value) {
    this.requestPersonId = value;
  }

  public String getRepresentanteId() {
    return this.representanteId;
  }

  public void setRepresentanteId(String value) {
    this.representanteId = value;
  }

  public List<ExpedienteSaveServiceDto> getServices() {
    return this.services;
  }

  public void setServices(List<ExpedienteSaveServiceDto> value) {
    this.services = value;
  }

  public List<ExpedienteSavePaymentDto> getPayments() {
    return this.payments;
  }

  public void setPayments(List<ExpedienteSavePaymentDto> value) {
    this.payments = value;
  }

  public List<ExpedienteSaveProductDto> getProducts() {
    return this.products;
  }

  public void setProducts(List<ExpedienteSaveProductDto> value) {
    this.products = value;
  }

  public ExpedienteSaveDetalleDto getDetalle() {
    return this.detalle;
  }

  public void setDetalle(ExpedienteSaveDetalleDto value) {
    this.detalle = value;
  }
}
