package com.senasa.tupaserver.reniec.domain;

public class ReniecRepresentanteEntity {
  private String cargo;
  private String documentoNumero;
  private String documentoTipo;
  private String fechaCargo;
  private String nombreCompleto;
  private int orden;

  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String value) {
    this.cargo = value;
  }

  public String getDocumentoNumero() {
    return this.documentoNumero;
  }

  public void setDocumentoNumero(String value) {
    this.documentoNumero = value;
  }

  public String getDocumentoTipo() {
    return this.documentoTipo;
  }

  public void setDocumentoTipo(String value) {
    this.documentoTipo = value;
  }

  public String getFechaCargo() {
    return this.fechaCargo;
  }

  public void setFechaCargo(String value) {
    this.fechaCargo = value;
  }

  public String getNombreCompleto() {
    return this.nombreCompleto;
  }

  public void setNombreCompleto(String value) {
    this.nombreCompleto = value;
  }

  public int getOrden() {
    return this.orden;
  }

  public void setOrden(int value) {
    this.orden = value;
  }
}
