
package com.senasa.tupaserver.ucm.infrastructure.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "documento", namespace = "http://gestiondocumento.ws.senasa.gob.pe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documento", propOrder = {
    "confidencial",
    "id",
    "nombre",
    "url",
    "versiones"
})
public class Documento {

  protected String confidencial;
  protected String id;
  protected String nombre;
  protected String url;
  @XmlElement(nillable = true)
  protected List<Version> versiones;

  /**
   * Gets the value of the confidencial property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getConfidencial() {
    return confidencial;
  }

  /**
   * Sets the value of the confidencial property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setConfidencial(String value) {
    this.confidencial = value;
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
   * Gets the value of the nombre property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Sets the value of the nombre property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setNombre(String value) {
    this.nombre = value;
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

  /**
   * Gets the value of the versiones property.
   * 
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the versiones
   * property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getVersiones().add(newItem);
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link Version }
   * 
   * 
   */
  public List<Version> getVersiones() {
    if (versiones == null) {
      versiones = new ArrayList<Version>();
    }
    return this.versiones;
  }

}
