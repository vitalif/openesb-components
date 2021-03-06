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
 * @(#)PropertyImm.java 
 *
 * Copyright 2004-2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * END_HEADER - DO NOT EDIT
 */

package com.sun.wsdl.model.immutable.extensions;

import javax.xml.namespace.QName;
import com.sun.wsdl.model.immutable.WSDLElementImm;

/**
 * Describes the &lt;property&gt; element.
 *
 * @author Sun Microsystems
 * @version 
 */
public interface PropertyImm extends WSDLElementImm {
      
    /** Getter for name attribute.
     * @return  Value of name attribute.
     */
    String getName();
    
    /** Getter for type attribute.
     * @return  Value of type attribute.
     */
    QName getType();  
}
