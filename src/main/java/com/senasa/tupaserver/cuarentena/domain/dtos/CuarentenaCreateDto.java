package com.senasa.tupaserver.cuarentena.domain.dtos;

public class CuarentenaCreateDto {
  private String expedienteId;
  private String productId;
  private int secuencial;
  private String weight;
  private String gender;
  private int age;
  private double amount;
  private String authorization;
  private String paisId;
  private String type;

  public String getExpedienteId() {
    return this.expedienteId;
  }

  public void setExpedienteId(String value) {
    this.expedienteId = value;
  }

  public String getProductId() {
    return this.productId;
  }

  public void setProductId(String value) {
    this.productId = value;
  }

  public String getWeight() {
    return this.weight;
  }

  public void setWeight(String value) {
    this.weight = value;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String value) {
    this.gender = value;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int value) {
    this.age = value;
  }

  public double getAmount() {
    return this.amount;
  }

  public void setAmount(double value) {
    this.amount = value;
  }

  public String getAuthorization() {
    return this.authorization;
  }

  public void setAuthorization(String value) {
    this.authorization = value;
  }

  public String getPaisId() {
    return this.paisId;
  }

  public void setPaisId(String value) {
    this.paisId = value;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String value) {
    this.type = value;
  }

  public int getSecuencial() {
    return this.secuencial;
  }

  public void setSecuencial(int value) {
    this.secuencial = value;
  }
}
