package com.senasa.tupaserver.person.domain.serializers;

import com.senasa.tupaserver.documentType.domain.DocumentTypeEntity;
import com.senasa.tupaserver.representante.domain.RepresentanteEntity;
import com.senasa.tupaserver.ubigeo.domain.PobladoEntity;
import com.senasa.tupaserver.ubigeo.domain.UbigeoEntity;

public class PersonFindSerialize {
  private String id;
  private String nombreRazonSocial;
  private String type;
  private String documentTypeId;
  private String documentNumber;
  private String lastName;
  private String secondaryName;
  private String names;
  private String ruc;
  private String address;
  private String departamentoId;
  private String provinciaId;
  private String distritoId;
  private String centroPobladoId;
  private String phone;
  private String gender;
  private String cellphone;
  private String email;
  private String referen;
  private String paisId;
  private String dateOfBirth;
  private String nameRazsocComp;
  private String addressReferen;
  private String highDate;
  private String lowDate;
  private String tradename;
  private String state = "ACTIVO";
  private String naturalState = "ACTIVO";
  private String legalState = "ACTIVO";
  private String syncState = "ACTIVO";
  private String userCreated;
  private String createdAt;
  private String userUpdated;
  private String updatedAt;
  private String syncDate;
  private UbigeoEntity ubigeo;
  private PobladoEntity poblado;
  private DocumentTypeEntity documentType;
  private RepresentanteEntity representante;

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
    this.nombreRazonSocial = value;
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
    this.lastName = value;
  }

  public String getSecondaryName() {
    return this.secondaryName;
  }

  public void setSecondaryName(String value) {
    this.secondaryName = value;
  }

  public String getNames() {
    return this.names;
  }

  public void setNames(String value) {
    this.names = value;
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
    return this.getDepartamentoId() + this.getProvinciaId() + this.getDistritoId();
  }

  public String getCentroPobladoId() {
    return this.centroPobladoId;
  }

  public void setCentroPobladoId(String value) {
    this.centroPobladoId = value;
  }

  public String getUbigeoPobladoId() {
    if (this.getUbigeoId() == null) {
      return null;
    } else if (this.getCentroPobladoId() == null) {
      return null;
    } else {
      return this.getUbigeoId() + this.getCentroPobladoId();
    }
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String value) {
    this.phone = value;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String value) {
    this.gender = value;
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

  public String getState() {
    return this.state;
  }

  public void setState(String value) {
    this.state = value;
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

  public String getSyncDate() {
    return this.syncDate;
  }

  public void setSyncDate(String value) {
    this.syncDate = value;
  }

  public UbigeoEntity getUbigeo() {
    return this.ubigeo;
  }

  public void setUbigeo(UbigeoEntity value) {
    this.ubigeo = value;
  }

  public PobladoEntity getPoblado() {
    return this.poblado;
  }

  public void setPoblado(PobladoEntity value) {
    this.poblado = value;
  }

  public DocumentTypeEntity getDocumentType() {
    return this.documentType;
  }

  public void setDocumentType(DocumentTypeEntity value) {
    this.documentType = value;
  }

  public RepresentanteEntity getRepresentante() {
    return this.representante;
  }

  public void setRepresentante(RepresentanteEntity value) {
    this.representante = value;
  }
}
