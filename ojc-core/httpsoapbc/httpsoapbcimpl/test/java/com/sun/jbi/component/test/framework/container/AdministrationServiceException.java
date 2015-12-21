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
 * @(#)AdministrationServiceException.java 
 *
 * Copyright 2004-2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * END_HEADER - DO NOT EDIT
 */

package com.sun.jbi.component.test.framework.container;

/**
 *
 * Errors relating to administration service in general (e.g., getting to an administration service).
 */
public class AdministrationServiceException extends Exception {
    public AdministrationServiceException () {
        super ();
    }
    
    public AdministrationServiceException (String msg) {
        super (msg);
    }
    
    public AdministrationServiceException (Throwable cause) {
        super (cause);
    }
    
    public AdministrationServiceException (String msg, Throwable cause) {
        super (msg, cause);
    } 

}