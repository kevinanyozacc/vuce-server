package com.senasa.tupaserver.ucm.infrastructure.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "propiedad", namespace = "http://gestiondocumento.ws.senasa.gob.pe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propiedad", propOrder = {
    "nombre",
    "valor"
})
public class Propiedad {

  protected String nombre;
  protected String valor;

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
   * Gets the value of the valor property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getValor() {
    return valor;
  }

  /**
   * Sets the value of the valor property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setValor(String value) {
    this.valor = value;
  }

}
