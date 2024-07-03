package com.senasa.tupaserver.documentType.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_DOCUMENTO", schema = "FINALBPM")
public class DocumentTypeEntity {
  @Id
  @Column(name = "CODIGO_DOCUMENTO")
  private String id;

  @Column(name = "DESCRIPCION_TIPO_DOCUMENTO")
  private String name;

  @Column(name = "DESCRIPCION_COMPLETA")
  private String description;

  @Column(name = "ESTADO")
  private String state;

  @Column(name = "USER_CREA")
  private String userCreatedAt;

  @Column(name = "USER_MODI")
  private String userUpdatedAt;

  @Column(name = "FECH_CREA")
  private String createdAt;

  @Column(name = "FECH_MODI")
  private String updateAt;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String value) {
    this.description = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }

  public String getUserCreatedAt() {
    return this.userCreatedAt;
  }

  public void setUserCreatedAt(String value) {
    this.userCreatedAt = value;
  }

  public String getUserUpdatedAt() {
    return this.userUpdatedAt;
  }

  public void setUserUpdatedAt(String value) {
    this.userUpdatedAt = value;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(String value) {
    this.createdAt = value;
  }

  public String getUpdateAt() {
    return this.updateAt;
  }

  public void setUpdateAt(String value) {
    this.updateAt = value;
  }
}
