package com.senasa.tupaserver.person.domain;

import javax.persistence.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class PersonEntity {
  @Id
  @Column(name = "PERSONA_ID")
  private String id;

  @Column(name = "NOMBRE_RAZON_SOCIAL")
  private String nombreRazonSocial;

  @Column(name = "PERSONA_TIPO")
  private String type;

  @Column(name = "DOCUMENTO_TIPO")
  private String documentTypeId;

  @Column(name = "DOCUMENTO_NUMERO")
  private String documentNumber;

  @Column(name = "APELLIDO_PATERNO")
  private String lastName;

  @Column(name = "APELLIDO_MATERNO")
  private String secondaryName;

  @Column(name = "NOMBRES")
  private String names;

  @Column(name = "RUC")
  private String ruc;

  @Column(name = "DIRECCION")
  private String address;

  @Column(name = "DEPARTAMENTO_ID")
  private String departamentoId;

  @Column(name = "PROVINCIA_ID")
  private String provinciaId;

  @Column(name = "DISTRITO_ID")
  private String distritoId;

  @Column(name = "CENTRO_POBLADO_ID")
  private String centroPobladoId;

  @Column(name = "TELEFONO")
  private String phone;

  @Column(name = "SEXO")
  private String gender;

  @Column(name = "TELEFONO_MOVIL")
  private String cellphone;

  @Column(name = "CORREO_ELECTRONICO")
  private String email;

  @Column(name = "REFERENCIA")
  private String referen;

  @Column(name = "PAIS_ID")
  private String paisId;

  @Column(name = "FECHA_NACIMIENTO")
  private String dateOfBirth;

  @Column(name = "NOMBRE_RAZSOC_COMP")
  private String nameRazsocComp;

  @Column(name = "REFERENCIA_DIRECCION")
  private String addressReferen;

  @Column(name = "FECHA_ALTA")
  private String highDate;

  @Column(name = "FECHA_BAJA")
  private String lowDate;

  @Column(name = "NOMBRE_COMERCIAL")
  private String tradename;

  @Column(name = "ESTADO")
  private String state = "ACTIVO";

  @Column(name = "ESTADO_NATURAL")
  private String naturalState = "ACTIVO";

  @Column(name = "ESTADO_JURIDICO")
  private String legalState = "ACTIVO";

  @Column(name = "SINCRONIZACION_ESTADO")
  private String syncState = "ACTIVO";

  @Column(name = "USER_CREA", updatable = false)
  private String userCreated;

  @Column(name = "FECH_CREA", updatable = false)
  @CreatedDate
  private String createdAt;

  @Column(name = "USER_MODI")
  private String userUpdated;

  @Column(name = "FECH_MODI")
  @LastModifiedDate
  private String updatedAt;

  @Column(name = "SINCRONIZACION_FECHA")
  @LastModifiedDate
  private String syncDate;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getNombreRazonSocial() {
    return this.nombreRazonSocial;
  }

  public void setNombreRazonSocial(String value) {
    this.nombreRazonSocial = value.toUpperCase();
  }

  public String getType() {
    return this.type;
  }

  public void setType(String value) {
    this.type = value;
  }

  public String getDocumentTypeId() {
    return this.documentTypeId;
  }

  public void setDocumentTypeId(String value) {
    this.documentTypeId = value;
  }

  public String getDocumentNumber() {
    return this.documentNumber;
  }

  public void setDocumentNumber(String value) {
    this.documentNumber = value;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String value) {
    if (value != null) {
      this.lastName = value.toUpperCase();
    }
  }

  public String getSecondaryName() {
    return this.secondaryName;
  }

  public void setSecondaryName(String value) {
    if (value != null) {
      this.secondaryName = value.toUpperCase();
    }
  }

  public String getNames() {
    return this.names;
  }

  public void setNames(String value) {
    if (value != null) {
      this.names = value.toUpperCase();
    }
  }

  public String getRuc() {
    return this.ruc;
  }

  public void setRuc(String value) {
    this.ruc = value;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String value) {
    this.address = value;
  }

  public String getDepartamentoId() {
    return this.departamentoId;
  }

  public void setDepartamentoId(String value) {
    this.departamentoId = value;
  }

  public String getProvinciaId() {
    return this.provinciaId;
  }

  public void setProvinciaId(String value) {
    this.provinciaId = value;
  }

  public String getDistritoId() {
    return this.distritoId;
  }

  public void setDistritoId(String value) {
    this.distritoId = value;
  }

  public String getUbigeoId() {
    return this.departamentoId + this.provinciaId + this.distritoId;
  }

  public String getCentroPobladoId() {
    return this.centroPobladoId;
  }

  public void setCentroPobladoId(String value) {
    this.centroPobladoId = value;
  }

  public String getUbigeoCentroPobladoId() {
    if (this.getUbigeoId() == "") {
      return null;
    } else if (this.getUbigeoId() == null) {
      return null;
    } else if (this.getCentroPobladoId() == null) {
      return null;
    } else {
      return this.getUbigeoId() + this.centroPobladoId;
    }
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String value) {
    this.phone = value;
  }

  public String getCellphone() {
    return this.cellphone;
  }

  public void setCellphone(String value) {
    this.cellphone = value;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String value) {
    this.email = value;
  }

  public String getReferen() {
    return this.referen;
  }

  public void setReferen(String value) {
    this.referen = value;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
  }

  public String getPaisId() {
    return this.paisId;
  }

  public void setPaisId(String value) {
    this.paisId = value;
  }

  public String getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setDateOfBirth(String value) {
    this.dateOfBirth = value;
  }

  public String getNameRazsocComp() {
    return this.nameRazsocComp;
  }

  public void setNameRazsocComp(String value) {
    this.nameRazsocComp = value;
  }

  public String getUserCreated() {
    return this.userCreated;
  }

  public void setUserCreated(String value) {
    this.userCreated = value;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(String value) {
    this.createdAt = value;
  }

  public String getUserUpdated() {
    return this.userUpdated;
  }

  public void setUserUpdated(String value) {
    this.userUpdated = value;
  }

  public String getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(String value) {
    this.updatedAt = value;
  }

  public String getAddressReferen() {
    return this.addressReferen;
  }

  public void setAddressReferen(String value) {
    this.addressReferen = value;
  }

  public String getHighDate() {
    return this.highDate;
  }

  public void setHighDate(String value) {
    this.highDate = value;
  }

  public String getLowDate() {
    return this.lowDate;
  }

  public void setLowDate(String value) {
    this.lowDate = value;
  }

  public String getTradename() {
    return this.tradename;
  }

  public void setTradename(String value) {
    this.tradename = value;
  }

  public String getNaturalState() {
    return this.naturalState;
  }

  public void setNaturalState(String value) {
    this.naturalState = value;
  }

  public String getLegalState() {
    return this.legalState;
  }

  public void setLegalState(String value) {
    this.legalState = value;
  }

  public String getSyncState() {
    return this.syncState;
  }

  public void setSyncState(String value) {
    this.syncState = value;
  }

  public String getSyncDate() {
    return this.syncDate;
  }

  public void setSyncDate(String value) {
    this.syncDate = value;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String value) {
    this.gender = value;
  }
}
