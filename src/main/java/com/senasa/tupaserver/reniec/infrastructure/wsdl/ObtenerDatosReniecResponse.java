
package com.senasa.tupaserver.reniec.infrastructure.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerDatosReniecResponse", namespace = "http://ws.gestionpersona.senasa.gob.pe/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerDatosReniecResponse", propOrder = { "_return" })
public class ObtenerDatosReniecResponse {

  @XmlElement(name = "return")
  protected PersonaWs _return;

  /**
   * Gets the value of the return property.
   *
   * @return
   *         possible object is
   *         {@link Persona }
   *
   */
  public PersonaWs getReturn() {
    return _return;
  }

  /**
   * Sets the value of the return property.
   *
   * @param value
   *              allowed object is
   *              {@link Persona }
   *
   */
  public void setReturn(PersonaWs value) {
    this._return = value;
  }

}
