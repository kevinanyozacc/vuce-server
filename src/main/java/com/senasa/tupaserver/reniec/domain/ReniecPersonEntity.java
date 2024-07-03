package com.senasa.tupaserver.reniec.domain;

import java.util.List;

public class ReniecPersonEntity {
  protected String apellidoMaterno;
  protected String apellidoPaterno;
  protected String centroPoblado;
  protected String correoElectronico;
  protected String direccion;
  protected String documentoNumero;
  protected String documentoTipo;
  protected String estadoJuridico;
  protected String estadoNatural;
  protected String fechaAlta;
  protected String fechaBaja;
  protected String fechaNacimiento;
  protected String id;
  protected String nombreComercial;
  protected String nombreRazonSocial;
  protected String nombres;
  protected String pais;
  protected String personaTipo;
  private String departamentoId;
  private String provinciaId;
  private String distritoId;
  protected String departamento;
  protected String provincia;
  protected String distrito;
  protected String referenciaDireccion;
  protected String ruc;
  protected String telefono;
  protected String telefonoMovil;
  private List<ReniecRepresentanteEntity> representantes;

  public String getApellidoMaterno() {
    return this.apellidoMaterno;
  }

  public void setApellidoMaterno(String value) {
    this.apellidoMaterno = value;
  }

  public String getApellidoPaterno() {
    return this.apellidoPaterno;
  }

  public void setApellidoPaterno(String value) {
    this.apellidoPaterno = value;
  }

  public String getCentroPoblado() {
    return this.centroPoblado;
  }

  public void setCentroPoblado(String value) {
    this.centroPoblado = value;
  }

  public String getCorreoElectronico() {
    return this.correoElectronico;
  }

  public void setCorreoElectronico(String value) {
    this.correoElectronico = value;
  }

  public String getDepartamento() {
    return this.departamento;
  }

  public void setDepartamento(String value) {
    this.departamento = value;
  }

  public String getDireccion() {
    return this.direccion;
  }

  public void setDireccion(String value) {
    this.direccion = value;
  }

  public String getDistrito() {
    return this.distrito;
  }

  public void setDistrito(String value) {
    this.distrito = value;
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

  public String getEstadoJuridico() {
    return this.estadoJuridico;
  }

  public void setEstadoJuridico(String value) {
    this.estadoJuridico = value;
  }

  public String getEstadoNatural() {
    return this.estadoNatural;
  }

  public void setEstadoNatural(String value) {
    this.estadoNatural = value;
  }

  public String getFechaAlta() {
    return this.fechaAlta;
  }

  public void setFechaAlta(String value) {
    this.fechaAlta = value;
  }

  public String getFechaBaja() {
    return this.fechaBaja;
  }

  public void setFechaBaja(String value) {
    this.fechaBaja = value;
  }

  public String getFechaNacimiento() {
    return this.fechaNacimiento;
  }

  public void setFechaNacimiento(String value) {
    this.fechaNacimiento = value;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String value) {
    this.id = value;
  }

  public String getNombreComercial() {
    return this.nombreComercial;
  }

  public void setNombreComercial(String value) {
    this.nombreComercial = value;
  }

  public String getNombreRazonSocial() {
    return this.nombreRazonSocial;
  }

  public void setNombreRazonSocial(String value) {
    this.nombreRazonSocial = value;
  }

  public String getNombres() {
    return this.nombres;
  }

  public void setNombres(String value) {
    this.nombres = value;
  }

  public String getPais() {
    return this.pais;
  }

  public void setPais(String value) {
    this.pais = value;
  }

  public String getPersonaTipo() {
    return this.personaTipo;
  }

  public void setPersonaTipo(String value) {
    this.personaTipo = value;
  }

  public String getProvincia() {
    return this.provincia;
  }

  public void setProvincia(String value) {
    this.provincia = value;
  }

  public String getReferenciaDireccion() {
    return this.referenciaDireccion;
  }

  public void setReferenciaDireccion(String value) {
    this.referenciaDireccion = value;
  }

  public String getRuc() {
    return this.ruc;
  }

  public void setRuc(String value) {
    this.ruc = value;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(String value) {
    this.telefono = value;
  }

  public String getTelefonoMovil() {
    return this.telefonoMovil;
  }

  public void setTelefonoMovil(String value) {
    this.telefonoMovil = value;
  }

  public List<ReniecRepresentanteEntity> getRepresentantes() {
    return this.representantes;
  }

  public void setRepresentantes(List<ReniecRepresentanteEntity> value) {
    this.representantes = value;
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
}
