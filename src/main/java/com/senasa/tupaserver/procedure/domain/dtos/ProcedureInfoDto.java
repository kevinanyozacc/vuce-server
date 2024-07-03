package com.senasa.tupaserver.procedure.domain.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProcedureInfoDto {
  @NotBlank
  private String procedureId;

  @NotBlank
  private String serviceId;

  public String getProcedureId() {
    return this.procedureId;
  }

  public void setProcedureId(String value) {
    this.procedureId = value;
  }

  public String getServiceId() {
    return this.serviceId;
  }

  public void setServiceId(String value) {
    this.serviceId = value;
  }
}
