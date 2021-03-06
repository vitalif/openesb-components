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
 * @(#)BindingInputImpl.java 
 *
 * Copyright 2004-2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * END_HEADER - DO NOT EDIT
 */

package com.sun.wsdl.model.impl;

import com.sun.wsdl.model.BindingInput;
import com.sun.wsdl.model.BindingInput.ATTR;
import com.sun.wsdl.model.common.model.XMLAttribute;
import com.sun.wsdl.model.common.model.XMLDocument;
import com.sun.wsdl.model.common.model.impl.XMLAttributeImpl;
import com.sun.wsdl.model.common.visitor.Visitor;
import com.sun.wsdl.model.extensions.soap.SOAPBody;
import com.sun.wsdl.model.extensions.soap.SOAPHeader;
import com.sun.wsdl.model.visitor.WSDLVisitor;


/**
 * Implements the binding &lt;input&gt; element.
 *
 * @author Sun Microsystems
 * @version 
 */
public class BindingInputImpl extends WSDLExtensibleElementImpl implements BindingInput {
    
    /** Creates a new instance of BindingInputImpl */
    public BindingInputImpl() {
        super();
        initBindingInput();
    }
    
    /** Constructor for new binding input instance.
     * @param   d   Owner document.
     */
    public BindingInputImpl(XMLDocument d) {
        super(d);
        initBindingInput();
    }
    
    /** Initializes this class.
     */
    private void initBindingInput() {
        setLocalName(BindingInput.TAG);
        xmlAttrs = new XMLAttribute[] {
            new XMLAttributeImpl(ATTR.NAME, String.class, false, null),
            new XMLAttributeImpl(ATTR.MESSAGE, String.class, true, null)
        };
        childrenTags = new String[] {SOAPBody.QTAG, SOAPHeader.QTAG};
    }
   
    /**
     * @see BindingInput#getName
     */
    public String getName() {
        return xmlAttrs[NAME].getValue();
    }
    
    /**
     * @see BindingInput#setName(String)
     */
    public void setName(String name) {
        setAttribute(NAME, name);
    }
    
    /**
     * @see BindingInput#setName(String, String)
     */
    public void setName(String qName, String name) {
        setAttribute(NAME, qName, name);
    }
    
    /**
     * @see BindingInput#getMessage
     */
    public String getMessage() {
        return xmlAttrs[MESSAGE].getValue();
    }
    
    /**
     * @see BindingInput#setMessage(String)
     */
    public void setMessage(String message) {
        setAttribute(MESSAGE, message);
    }
        
    /**
     * @see BindingInput#setMessage(String, String)
     */
    public void setMessage(String qName, String message) {
        setAttribute(MESSAGE, qName, message);
    }
    
    /**
     * @see com.sun.wsdl.model.common.model.XMLNode#accept
     */
    public boolean accept(Visitor w) {
        WSDLVisitor v = morphVisitor(w);

        if (traverseParentFirst(v)) {
            if (!v.visit(this)) {
                return false;
            }
        }

        if (!super.accept(v)) {
            return false;
        }

        if (traverseParentLast(v)) {
            if (!v.visit(this)) {
                return false;
            }
        }
        return true;
    }
}
