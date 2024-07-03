package com.senasa.tupaserver.cuarentena.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRO_CUARENTENA_PRODUCTO", schema = "FINALBPM")
public class CuarentenaEntity {
  @Id
  @Column(name = "CODIGO_CUARENTENA_PRODUCTO")
  private String id;

  @Column(name = "SECUENCIAL_PRODUCTO")
  private int secuencia;

  @Column(name = "CODIGO_EXPEDIENTE")
  private String expedienteId;

  @Column(name = "CODIGO_PRODUCTO")
  private String productId;

  @Column(name = "PESO_PRODUCTO")
  private String weight;

  @Column(name = "SEXO_PRODUCTO")
  private String gender;

  @Column(name = "EDAD_PRODUCTO")
  private int age;

  @Column(name = "CANTIDAD_PRODUCTO")
  private double amount;

  @Column(name = "AUTORIZACION_PRODUCTO")
  private String authorization;

  @Column(name = "PAIS_ID")
  private String paisId;

  @Column(name = "TIPO_PRODUCTO")
  private String type;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public int getSecuencia() {
    return this.secuencia;
  }

  public void setSecuencia(int value) {
    this.secuencia = value;
  }

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
}
