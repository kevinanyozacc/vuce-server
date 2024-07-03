package com.senasa.tupaserver.expediente.domain.dtos;

public class ExpedienteSaveResponseDto {
  private String id;
  private String requestId;
  private String paymentId;
  private String stdId;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getRequestId() {
    return this.requestId;
  }

  public void setRequestId(String value) {
    this.requestId = value;
  }

  public String getPaymentId() {
    return this.paymentId;
  }

  public void setPaymentId(String value) {
    this.paymentId = value;
  }

  public String getStdId() {
    return this.stdId;
  }

  public void setStdId(String value) {
    this.stdId = value;
  }
}
