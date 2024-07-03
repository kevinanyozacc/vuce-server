
package com.senasa.tupaserver.ucm.infrastructure.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "registrarDocumento", namespace = "http://gestiondocumento.ws.senasa.gob.pe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registrarDocumento", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4",
    "arg5",
    "arg6",
    "arg7",
    "arg8"
})
public class RegistrarDocumento {

  protected String arg0;
  protected String arg1;
  protected String arg2;
  protected String arg3;
  protected String arg4;
  protected String arg5;
  protected String arg6;
  protected byte[] arg7;
  protected List<Propiedad> arg8;

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

  /**
   * Gets the value of the arg1 property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getArg1() {
    return arg1;
  }

  /**
   * Sets the value of the arg1 property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setArg1(String value) {
    this.arg1 = value;
  }

  /**
   * Gets the value of the arg2 property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getArg2() {
    return arg2;
  }

  /**
   * Sets the value of the arg2 property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setArg2(String value) {
    this.arg2 = value;
  }

  /**
   * Gets the value of the arg3 property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getArg3() {
    return arg3;
  }

  /**
   * Sets the value of the arg3 property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setArg3(String value) {
    this.arg3 = value;
  }

  /**
   * Gets the value of the arg4 property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getArg4() {
    return arg4;
  }

  /**
   * Sets the value of the arg4 property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setArg4(String value) {
    this.arg4 = value;
  }

  /**
   * Gets the value of the arg5 property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getArg5() {
    return arg5;
  }

  /**
   * Sets the value of the arg5 property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setArg5(String value) {
    this.arg5 = value;
  }

  /**
   * Gets the value of the arg6 property.
   * 
   * @return
   *         possible object is
   *         {@link String }
   * 
   */
  public String getArg6() {
    return arg6;
  }

  /**
   * Sets the value of the arg6 property.
   * 
   * @param value
   *              allowed object is
   *              {@link String }
   * 
   */
  public void setArg6(String value) {
    this.arg6 = value;
  }

  /**
   * Gets the value of the arg7 property.
   * 
   * @return
   *         possible object is
   *         byte[]
   */
  public byte[] getArg7() {
    return arg7;
  }

  /**
   * Sets the value of the arg7 property.
   * 
   * @param value
   *              allowed object is
   *              byte[]
   */
  public void setArg7(byte[] value) {
    this.arg7 = ((byte[]) value);
  }

  /**
   * Gets the value of the arg8 property.
   * 
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the arg8 property.
   * 
   * <p>
   * For example, to add a new item, do as follows:
   * 
   * <pre>
   * getArg8().add(newItem);
   * </pre>
   * 
   * 
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link Propiedad }
   * 
   * @return
   * 
   * 
   */
  public List<Propiedad> getArg8() {
    if (arg8 == null) {
      arg8 = new ArrayList<Propiedad>();
    }
    return this.arg8;
  }

}
