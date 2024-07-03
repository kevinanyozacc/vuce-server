package com.senasa.tupaserver.methodPayment.domain.dtos;

public class AccountListDto {
  private String bankId;

  public String getBankId() {
    return this.bankId;
  }

  public void setBankId(String value) {
    this.bankId = value;
  }
}
