/*
 * $Id: TestSortedRowIterator.java,v 1.1 2007/11/28 10:01:26 jawed Exp $
 * =======================================================================
 * Copyright (c) 2005 Axion Development Team.  All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions 
 * are met:
 * 
 * 1. Redistributions of source code must retain the above 
 *    copyright notice, this list of conditions and the following 
 *    disclaimer. 
 *   
 * 2. Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in 
 *    the documentation and/or other materials provided with the 
 *    distribution. 
 *   
 * 3. The names "Tigris", "Axion", nor the names of its contributors may 
 *    not be used to endorse or promote products derived from this 
 *    software without specific prior written permission. 
 *  
 * 4. Products derived from this software may not be called "Axion", nor 
 *    may "Tigris" or "Axion" appear in their names without specific prior
 *    written permission.
 *   
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT 
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY 
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * =======================================================================
 */

package org.axiondb.engine.rowiterators;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.axiondb.AxionException;
import org.axiondb.ColumnIdentifier;
import org.axiondb.OrderNode;
import org.axiondb.Row;
import org.axiondb.RowIterator;
import org.axiondb.engine.rows.SimpleRow;
import org.axiondb.util.ExceptionConverter;

/**
 * @version $Revision: 1.1 $ $Date: 2007/11/28 10:01:26 $
 * @author Ahimanikya Satapathy
 */
public class TestSortedRowIterator extends TestMutableSortedRowIterator {

    //------------------------------------------------------------ Conventional

    public TestSortedRowIterator(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(TestSortedRowIterator.class);
        return suite;
    }

    protected RowIterator makeRowIterator() {
        try {
            MockRowSource source = new MockRowSource("TABLE_2345");
            OrderNode node = new OrderNode(new ColumnIdentifier(source.getTableIdentifier(), ID), false);

            ArrayList nodes = new ArrayList();
            nodes.add(node);

            RowIterator rowIter = new SortedRowIterator.MergeSort(source.getRowIterator(), nodes, source.makeRowDecorator());
            return rowIter;
        } catch (AxionException e) {
            throw ExceptionConverter.convertToRuntimeException(e);
        }
    }

    //------------------------------------------------------------------- Tests
    
    public void testMergeSort() throws Exception {
        RowIterator rows = makeRowIterator();

        assertNotNull(rows.first());
        assertNotNull(rows.next());

        try {
            rows.add(null);
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // expected
        }
        Row row = new SimpleRow(1);
        row.set(0, new Integer(20));

        try {
            rows.set(row);
            fail("Expected IllegalStateException");
        } catch (UnsupportedOperationException e) {

        }

        try {
            rows.remove();
            fail("Expected IllegalStateException");
        } catch (UnsupportedOperationException e) {

        }
    }

}