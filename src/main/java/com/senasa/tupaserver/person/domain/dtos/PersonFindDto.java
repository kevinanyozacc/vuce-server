package com.senasa.tupaserver.person.domain.dtos;

public class PersonFindDto {
  private String id;
  private String documentNumber;
  private String documentTypeId;

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getDocumentNumber() {
    return this.documentNumber;
  }

  public void setDocumentNumber(String value) {
    this.documentNumber = value;
  }

  public String getDocumentTypeId() {
    return this.documentTypeId;
  }

  public void setDocumentTypeId(String value) {
    this.documentTypeId = value;
  }
}
