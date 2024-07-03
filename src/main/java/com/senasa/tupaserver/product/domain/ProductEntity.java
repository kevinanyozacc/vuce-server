package com.senasa.tupaserver.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO", schema = "FINALBPM")
public class ProductEntity {
  @Id
  @Column(name = "CODIGO_PRODUCTO")
  private String id;

  @Column(name = "CODIGO_CLASE")
  private String type;

  @Column(name = "CODIGO_PARTIDA_ARANCELARIA")
  private String arancelariaId;

  @Column(name = "CODIGO_ESPECIE")
  private String speciesId;

  @Column(name = "NOMBRE_COMERCIAL_PRODUCTO")
  private String name;

  @Column(name = "NOMBRE_CIENTIFICO_PRODUCTO")
  private String scientificName;

  @Column(name = "ESTADO")
  private String state;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getArancelariaId() {
    return this.arancelariaId;
  }

  public void setArancelariaId(String value) {
    this.arancelariaId = value;
  }

  public String getSpeciesId() {
    return this.speciesId;
  }

  public void setSpeciesId(String value) {
    this.speciesId = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getScientificName() {
    return this.scientificName;
  }

  public void setScientificName(String value) {
    this.scientificName = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String value) {
    this.type = value;
  }
}
