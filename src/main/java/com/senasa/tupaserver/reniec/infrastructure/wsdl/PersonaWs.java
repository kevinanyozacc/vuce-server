package com.senasa.tupaserver.reniec.infrastructure.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "persona", namespace = "http://ws.gestionpersona.senasa.gob.pe/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persona", propOrder = { "apellidoMaterno", "apellidoPaterno", "centroPoblado",
    "correoElectronico", "departamento", "direccion",
    "distrito", "documentoNumero", "documentoTipo",
    "estadoJuridico", "estadoNatural", "fechaAlta",
    "fechaBaja", "fechaNacimiento", "id", "nombreComercial",
    "nombreRazonSocial", "nombres", "pais", "personaTipo",
    "provincia", "referenciaDireccion", "representantes",
    "ruc", "telefono", "telefonoMovil" })
public class PersonaWs {

  protected String apellidoMaterno;
  protected String apellidoPaterno;
  protected String centroPoblado;
  protected String correoElectronico;
  protected String departamento;
  protected String direccion;
  protected String distrito;
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
  protected String provincia;
  protected String referenciaDireccion;
  @XmlElement(nillable = true)
  protected List<RepresentanteLegal> representantes;
  protected String ruc;
  protected String telefono;
  protected String telefonoMovil;

  /**
   * Gets the value of the apellidoMaterno property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  /**
   * Sets the value of the apellidoMaterno property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setApellidoMaterno(String value) {
    this.apellidoMaterno = value;
  }

  /**
   * Gets the value of the apellidoPaterno property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  /**
   * Sets the value of the apellidoPaterno property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setApellidoPaterno(String value) {
    this.apellidoPaterno = value;
  }

  /**
   * Gets the value of the centroPoblado property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getCentroPoblado() {
    return centroPoblado;
  }

  /**
   * Sets the value of the centroPoblado property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setCentroPoblado(String value) {
    this.centroPoblado = value;
  }

  /**
   * Gets the value of the correoElectronico property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getCorreoElectronico() {
    return correoElectronico;
  }

  /**
   * Sets the value of the correoElectronico property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setCorreoElectronico(String value) {
    this.correoElectronico = value;
  }

  /**
   * Gets the value of the departamento property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getDepartamento() {
    return departamento;
  }

  /**
   * Sets the value of the departamento property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setDepartamento(String value) {
    this.departamento = value;
  }

  /**
   * Gets the value of the direccion property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * Sets the value of the direccion property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setDireccion(String value) {
    this.direccion = value;
  }

  /**
   * Gets the value of the distrito property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getDistrito() {
    return distrito;
  }

  /**
   * Sets the value of the distrito property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setDistrito(String value) {
    this.distrito = value;
  }

  /**
   * Gets the value of the documentoNumero property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getDocumentoNumero() {
    return documentoNumero;
  }

  /**
   * Sets the value of the documentoNumero property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setDocumentoNumero(String value) {
    this.documentoNumero = value;
  }

  /**
   * Gets the value of the documentoTipo property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getDocumentoTipo() {
    return documentoTipo;
  }

  /**
   * Sets the value of the documentoTipo property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setDocumentoTipo(String value) {
    this.documentoTipo = value;
  }

  /**
   * Gets the value of the estadoJuridico property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getEstadoJuridico() {
    return estadoJuridico;
  }

  /**
   * Sets the value of the estadoJuridico property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setEstadoJuridico(String value) {
    this.estadoJuridico = value;
  }

  /**
   * Gets the value of the estadoNatural property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getEstadoNatural() {
    return estadoNatural;
  }

  /**
   * Sets the value of the estadoNatural property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setEstadoNatural(String value) {
    this.estadoNatural = value;
  }

  /**
   * Gets the value of the fechaAlta property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getFechaAlta() {
    return fechaAlta;
  }

  /**
   * Sets the value of the fechaAlta property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setFechaAlta(String value) {
    this.fechaAlta = value;
  }

  /**
   * Gets the value of the fechaBaja property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getFechaBaja() {
    return fechaBaja;
  }

  /**
   * Sets the value of the fechaBaja property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setFechaBaja(String value) {
    this.fechaBaja = value;
  }

  /**
   * Gets the value of the fechaNacimiento property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  /**
   * Sets the value of the fechaNacimiento property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setFechaNacimiento(String value) {
    this.fechaNacimiento = value;
  }

  /**
   * Gets the value of the id property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * Gets the value of the nombreComercial property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getNombreComercial() {
    return nombreComercial;
  }

  /**
   * Sets the value of the nombreComercial property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setNombreComercial(String value) {
    this.nombreComercial = value;
  }

  /**
   * Gets the value of the nombreRazonSocial property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getNombreRazonSocial() {
    return nombreRazonSocial;
  }

  /**
   * Sets the value of the nombreRazonSocial property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setNombreRazonSocial(String value) {
    this.nombreRazonSocial = value;
  }

  /**
   * Gets the value of the nombres property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getNombres() {
    return nombres;
  }

  /**
   * Sets the value of the nombres property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setNombres(String value) {
    this.nombres = value;
  }

  /**
   * Gets the value of the pais property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getPais() {
    return pais;
  }

  /**
   * Sets the value of the pais property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setPais(String value) {
    this.pais = value;
  }

  /**
   * Gets the value of the personaTipo property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getPersonaTipo() {
    return personaTipo;
  }

  /**
   * Sets the value of the personaTipo property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setPersonaTipo(String value) {
    this.personaTipo = value;
  }

  /**
   * Gets the value of the provincia property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getProvincia() {
    return provincia;
  }

  /**
   * Sets the value of the provincia property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setProvincia(String value) {
    this.provincia = value;
  }

  /**
   * Gets the value of the referenciaDireccion property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getReferenciaDireccion() {
    return referenciaDireccion;
  }

  /**
   * Sets the value of the referenciaDireccion property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setReferenciaDireccion(String value) {
    this.referenciaDireccion = value;
  }

  /**
   * Gets the value of the representantes property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the representantes
   * property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getRepresentantes().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link RepresentanteLegal }
   *
   *
   */
  public List<RepresentanteLegal> getRepresentantes() {
    if (representantes == null) {
      representantes = new ArrayList<RepresentanteLegal>();
    }
    return this.representantes;
  }

  /**
   * Gets the value of the ruc property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getRuc() {
    return ruc;
  }

  /**
   * Sets the value of the ruc property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setRuc(String value) {
    this.ruc = value;
  }

  /**
   * Gets the value of the telefono property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * Sets the value of the telefono property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setTelefono(String value) {
    this.telefono = value;
  }

  /**
   * Gets the value of the telefonoMovil property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getTelefonoMovil() {
    return telefonoMovil;
  }

  /**
   * Sets the value of the telefonoMovil property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setTelefonoMovil(String value) {
    this.telefonoMovil = value;
  }

}
