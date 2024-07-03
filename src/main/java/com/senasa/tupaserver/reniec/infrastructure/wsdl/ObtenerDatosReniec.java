
package com.senasa.tupaserver.reniec.infrastructure.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerDatosReniec", namespace = "http://ws.gestionpersona.senasa.gob.pe/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerDatosReniec", propOrder = { "arg0" })
public class ObtenerDatosReniec {

  protected String arg0;

  /**
   * Gets the value of the arg0 property.
   *
   * @return
   *         possible object is
   *         {@link String }
   *
   */
  public String getArg0() {
    return arg0;
  }

  /**
   * Sets the value of the arg0 property.
   *
   * @param value
   *              allowed object is
   *              {@link String }
   *
   */
  public void setArg0(String value) {
    this.arg0 = value;
  }

}
