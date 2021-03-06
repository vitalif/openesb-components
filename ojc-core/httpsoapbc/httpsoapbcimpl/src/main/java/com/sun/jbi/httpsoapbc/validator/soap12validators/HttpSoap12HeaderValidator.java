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
 * @(#)HttpSoapHeaderValidator.java 
 *
 * Copyright 2004-2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * END_HEADER - DO NOT EDIT
 */

package com.sun.jbi.httpsoapbc.validator.soap12validators;

import java.util.LinkedList;
import java.util.List;

import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.soap12.SOAP12Header;
import javax.wsdl.extensions.soap12.SOAP12HeaderFault;
import javax.xml.namespace.QName;

import com.sun.jbi.httpsoapbc.validator.Visitable;
import com.sun.jbi.httpsoapbc.validator.Visitor;
import com.sun.jbi.internationalization.Messages;
import com.sun.jbi.wsdlvalidator.ValidationException;
import com.sun.jbi.wsdlvalidator.Validator;

public class HttpSoap12HeaderValidator implements
            Validator,
            ValidatorObserver,
            Visitable,
            Visitor {

    private static final Messages mMessages =
        Messages.getMessages(HttpSoap12HeaderValidator.class);
    
    private final List<ValidatorObserver> mObservers =
            new LinkedList<ValidatorObserver>();
    
    private final HttpSoap12HeaderFaultValidator mHeaderFaultValidator;
    private MessagePart mPart;

    public HttpSoap12HeaderValidator() {
        mHeaderFaultValidator = new HttpSoap12HeaderFaultValidator();
        mHeaderFaultValidator.attachObserver(this);
        attachObserver(mHeaderFaultValidator);
    }
    
    public void validate(ExtensibilityElement element)
        throws ValidationException {

        mPart = null;
        SOAP12Header header = (SOAP12Header)element;

        QName message = header.getMessage();
        if (message == null) {
            throw new ValidationException(mMessages.getString("HTTPBC-E00287.Message_missing", "<soap:header>"));
        }

        String part = header.getPart();
        if (part == null || "".equals(part)) {
            throw new ValidationException(mMessages.getString("HTTPBC-E00288.Part_missing", "<soap:header>"));
        } else {
            synchronized (this) {
                mPart = new MessagePart(header.getMessage(), part);
            }
            notifyObservers();
        }

        String use = header.getUse();
        if (use == null) {
            throw new ValidationException(mMessages.getString("HTTPBC-E00289.Use_missing", "<soap:header>"));
        } else if (!use.equals("literal") && !use.equals("encoded")) {
            throw new ValidationException(mMessages.getString("HTTPBC-E00284.Unsupported_use_attribute",
                    new Object[] { "<soap:header>", use } ));
        }
                


        
        List<SOAP12HeaderFault> faults = header.getSOAP12HeaderFaults();
        for (SOAP12HeaderFault fault: faults) {
            mHeaderFaultValidator.validate(fault);
        }
    }
    
    public HttpSoap12HeaderFaultValidator getHeaderFaultValidator() {
        return mHeaderFaultValidator;
    }
    
    public void attachObserver(ValidatorObserver observer) {
        if (observer != null) {
            synchronized (mObservers) {
                mObservers.remove(observer);
                mObservers.add(observer);
            }
        }
    }
    
    public void notify(Object subject) throws ValidationException {
        if (subject instanceof Visitable) {
            ((Visitable) subject).accept(this);
        }
    }
    
    MessagePart getPart() {
        synchronized (this) {
            return mPart;
        }
    }
    
    private void notifyObservers() throws ValidationException {
        synchronized (mObservers) {
            for (ValidatorObserver o : mObservers) {
                o.notify(this);
            }
        }
    }

    private void checkPart(MessagePart part, String subject) throws ValidationException {
        if (part != null) {
            MessagePart aPart;
            synchronized (this) {
                aPart = mPart;
            }
            if (part.equals(aPart)) {
                throw new ValidationException(
                        mMessages.getString(
                            "HTTPBC-E00285.Part_in_use",
                            new Object[] { part.getPartName(), "<soap:header>", subject } ));
            }
        }
    }
    
    private void checkParts(List<MessagePart> parts, String subject) throws ValidationException {
        MessagePart aPart;
        synchronized (this) {
            aPart = mPart;
        }
        if (aPart == null) {
            return;
        }
        // A SOAP Body with an empty parts list is taken to mean
        // that ALL parts are in use.  In such a case, then,
        // there is a conflict automatically.
        if (parts.isEmpty()) {
            throw new ValidationException(
                    mMessages.getString(
                        "HttpSoapHeaderFaultValidator.Part_in_use",
                        new Object[] { aPart.getPartName(), subject } ));
        }
        for (MessagePart part : parts) {
            if (part != null && part.getPartName().equals(aPart.getPartName())) {
                throw new ValidationException(
                        mMessages.getString(
                            "HTTPBC-E00285.Part_in_use",
                            new Object[] { part.getPartName(), "<soap:header>", subject } ));
            }
        }
    }

    public void accept(Visitor visitor) throws ValidationException {
        visitor.visit(this);
    }

    public void visit(Validator subject) throws ValidationException {
        if (subject instanceof HttpSoap12HeaderFaultValidator) {
            HttpSoap12HeaderFaultValidator validator = (HttpSoap12HeaderFaultValidator) subject;
            String subjectName = "<soap:headerfault>";
            checkPart(validator.getPart(), subjectName);
            
        } else if (subject instanceof HttpSoap12BodyValidator) {
            HttpSoap12BodyValidator validator = (HttpSoap12BodyValidator) subject;
            String subjectName = "<soap:body>";
            checkParts(validator.getParts(), subjectName);
        }
    }
}
