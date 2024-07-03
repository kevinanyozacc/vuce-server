package com.senasa.tupaserver.procedure.domain.dtos;

public class ProcedureCalcTarifaDto {
  private String serviceId;
  private int amount;

  public String getServiceId() {
    return this.serviceId;
  }

  public void setServiceId(String value) {
    this.serviceId = value;
  }

  public int getAmount() {
    return this.amount;
  }

  public void setAmount(int value) {
    this.amount = value;
  }
}
