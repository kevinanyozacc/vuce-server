package com.senasa.tupaserver.ucm.infrastructure.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "version", namespace = "http://gestiondocumento.ws.senasa.gob.pe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "version", propOrder = {
    "etiqueta",
    "fecha",
    "id",
    "url"
})
public class Version {

  protected String etiqueta;
  protected String fecha;
  protected String id;
  protected String url;

  /**
   * Gets the value of the etiqueta property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getEtiqueta() {
    return etiqueta;
  }

  /**
   * Sets the value of the etiqueta property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setEtiqueta(String value) {
    this.etiqueta = value;
  }

  /**
   * Gets the value of the fecha property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * Sets the value of the fecha property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setFecha(String value) {
    this.fecha = value;
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
   * Gets the value of the url property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the value of the url property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setUrl(String value) {
    this.url = value;
  }

}
