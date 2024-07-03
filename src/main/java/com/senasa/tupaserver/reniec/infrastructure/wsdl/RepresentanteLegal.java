package com.senasa.tupaserver.reniec.infrastructure.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "representanteLegal", namespace = "http://ws.gestionpersona.senasa.gob.pe/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "representanteLegal", propOrder = { "cargo", "documentoNumero", "documentoTipo",
    "fechaCargo", "id", "nombreCompleto", "orden" })
public class RepresentanteLegal {

  protected String cargo;
  protected String documentoNumero;
  protected String documentoTipo;
  protected String fechaCargo;
  protected String id;
  protected String nombreCompleto;
  protected int orden;

  /**
   * Gets the value of the cargo property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getCargo() {
    return cargo;
  }

  /**
   * Sets the value of the cargo property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setCargo(String value) {
    this.cargo = value;
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
   * Gets the value of the fechaCargo property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getFechaCargo() {
    return fechaCargo;
  }

  /**
   * Sets the value of the fechaCargo property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setFechaCargo(String value) {
    this.fechaCargo = value;
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
   * Gets the value of the nombreCompleto property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  /**
   * Sets the value of the nombreCompleto property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setNombreCompleto(String value) {
    this.nombreCompleto = value;
  }

  /**
   * Gets the value of the orden property.
   *
   */
  public int getOrden() {
    return orden;
  }

  /**
   * Sets the value of the orden property.
   *
   */
  public void setOrden(int value) {
    this.orden = value;
  }
}
