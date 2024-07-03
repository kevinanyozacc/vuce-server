package com.senasa.tupaserver.expediente.domain.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExpedienteSaveServiceDto {
  @NotBlank
  private String serviceId;

  @NotBlank
  private int amount;

  @NotBlank
  private double price;

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

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double value) {
    this.price = value;
  }
}
