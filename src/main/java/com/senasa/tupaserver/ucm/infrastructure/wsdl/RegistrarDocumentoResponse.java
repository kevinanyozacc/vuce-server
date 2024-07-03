package com.senasa.tupaserver.ucm.infrastructure.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "registrarDocumentoResponse", namespace = "http://gestiondocumento.ws.senasa.gob.pe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarDocumentoResponse", propOrder = {
    "_return"
})
public class RegistrarDocumentoResponse {

  @XmlElement(name = "return")
  protected String _return;

  /**
   * Gets the value of the return property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getReturn() {
    return _return;
  }

  /**
   * Sets the value of the return property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setReturn(String value) {
    this._return = value;
  }

}
