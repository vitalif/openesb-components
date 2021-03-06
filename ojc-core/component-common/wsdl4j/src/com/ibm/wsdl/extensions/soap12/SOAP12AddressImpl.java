/*
 * BEGIN_HEADER - DO NOT EDIT
 * 
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://open-jbi-components.dev.java.net/public/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://open-jbi-components.dev.java.net/public/CDDLv1.0.html.
 * If applicable add the following below this CDDL HEADER,
 * with the fields enclosed by brackets "[]" replaced with
 * your own identifying information: Portions Copyright
 * [year] [name of copyright owner]
 */

/*
 * @(#)SOAP12AddressImpl.java 
 *
 * Copyright 2004-2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * END_HEADER - DO NOT EDIT
 */

package com.ibm.wsdl.extensions.soap12;

import javax.wsdl.extensions.soap12.*;
import javax.xml.namespace.*;

/**
 * Copied from com.ibm.wsdl.extensions.soap.SOAPAddressImpl
 */
public class SOAP12AddressImpl implements SOAP12Address
{
  protected QName elementType = SOAP12Constants.Q_ELEM_SOAP_ADDRESS;
  // Uses the wrapper type so we can tell if it was set or not.
  protected Boolean required = null;
  protected String locationURI = null;

  public static final long serialVersionUID = 1;

  /**
   * Set the type of this extensibility element.
   *
   * @param elementType the type
   */
  public void setElementType(QName elementType)
  {
    this.elementType = elementType;
  }

  /**
   * Get the type of this extensibility element.
   *
   * @return the extensibility element's type
   */
  public QName getElementType()
  {
    return elementType;
  }

  /**
   * Set whether or not the semantics of this extension
   * are required. Relates to the wsdl:required attribute.
   */
  public void setRequired(Boolean required)
  {
    this.required = required;
  }

  /**
   * Get whether or not the semantics of this extension
   * are required. Relates to the wsdl:required attribute.
   */
  public Boolean getRequired()
  {
    return required;
  }

  /**
   * Set the location URI for this SOAP address.
   *
   * @param locationURI the desired location URI
   */
  public void setLocationURI(String locationURI)
  {
    this.locationURI = locationURI;
  }

  /**
   * Get the location URI for this SOAP address.
   */
  public String getLocationURI()
  {
    return locationURI;
  }

  public String toString()
  {
    StringBuffer strBuf = new StringBuffer();

    strBuf.append("SOAPAddress (" + elementType + "):");
    strBuf.append("\nrequired=" + required);

    if (locationURI != null)
    {
      strBuf.append("\nlocationURI=" + locationURI);
    }

    return strBuf.toString();
  }
}
