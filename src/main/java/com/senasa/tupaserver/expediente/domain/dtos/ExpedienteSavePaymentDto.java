package com.senasa.tupaserver.expediente.domain.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ExpedienteSavePaymentDto {
  @NotBlank
  private String typeId;

  @NotBlank
  private double amount;

  @NotBlank
  private String accountId;

  @NotBlank
  private String date;

  @NotBlank
  private String number;

  public String getTypeId() {
    return this.typeId;
  }

  public void setTypeId(String value) {
    this.typeId = value;
  }

  public double getAmount() {
    return this.amount;
  }

  public void setAmount(double value) {
    this.amount = value;
  }

  public String getAccountId() {
    return this.accountId;
  }

  public void setAccountId(String value) {
    this.accountId = value;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String value) {
    this.date = value;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String value) {
    this.number = value;
  }
}
