package com.senasa.tupaserver.procedure.domain;

public class ProcedureServiceEntity {
  private String id;
  private String name;
  private String typeId;
  private String typeName;

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

  public String getTypeId() {
    return this.typeId;
  }

  public void setTypeId(String value) {
    this.typeId = value;
  }

  public String getTypeName() {
    return this.typeName;
  }

  public void setTypeName(String value) {
    this.typeName = value;
  }
}
