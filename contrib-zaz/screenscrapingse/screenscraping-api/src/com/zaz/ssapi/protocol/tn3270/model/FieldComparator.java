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
 * Copyright 2007-2008 ZAZ Consulting, Inc. All Rights Reserved.
 *
 * END_HEADER - DO NOT EDIT
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaz.ssapi.protocol.tn3270.model;

import com.zaz.ssapi.protocol.tn3270.model.Field;
import java.util.Comparator;

/**
 *
 * @author tianlize
 */
public class FieldComparator implements Comparator<Field> {

    public int compare(Field field1, Field field2) {
        if (field1.getStartPos() > field2.getStartPos()) {
            return 1;
        } else if (field1.getStartPos() < field2.getStartPos()) {
            return -1;
        } else {
            return 0;
        }
    }
}
