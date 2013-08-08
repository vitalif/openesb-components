#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * BEGIN_HEADER - DO NOT EDIT
 * 
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://${package}.dev.java.net/public/CDDLv1.0.html.
 * See the License for the specific language governing
 * p]ermissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://${package}.dev.java.net/public/CDDLv1.0.html.
 * If applicable add the following below this CDDL HEADER,
 * with the fields enclosed by brackets "[]" replaced with
 * your own identifying information: Portions Copyright
 * [year] [name of copyright owner]
 */

/*
 * @(${symbol_pound})FileBindingLifeCycleTest.java 
 *
 * Copyright 2004-2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * END_HEADER - DO NOT EDIT
 */
package com.sun.jbi.filebc;

import junit.framework.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.jbi.component.ComponentContext;
import javax.jbi.component.ComponentLifeCycle;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.servicedesc.ServiceEndpoint;
import javax.xml.namespace.QName;
import org.w3c.dom.Document;
import org.jmock.*;

/**
 *
 * @author sweng
 */
public class FileBindingLifeCycleTest extends org.jmock.cglib.MockObjectTestCase {

    FileBindingLifeCycle instance = null;
    Mock jbiContext = mock(ComponentContext.class);
    Mock deliveryChannel = mock(DeliveryChannel.class);

    public FileBindingLifeCycleTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        instance = new FileBindingLifeCycle();
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(FileBindingLifeCycleTest.class);

        return suite;
    }

    /**
     * Test of getLifeCycle method, of class com.sun.jbi.filebc.FileBindingLifeCycle.
     */
    public void testGetLifeCycle() {
        System.out.println("Testing getLifeCycle");

        ComponentLifeCycle result = instance.getLifeCycle();
        assertEquals(instance, result);
    }

    /**
     * Test of init method, of class com.sun.jbi.filebc.FileBindingLifeCycle.
     */
    /* public void testInit() throws Exception {
    System.out.println("Testing init");
    

    // 1. testing the success scenario
    Mock mbServer = mock(MBeanServer.class);
    Mock mBeanNames = mock(MBeanNames.class);
    Mock on = mock(ObjectName.class, new Class[]{String.class},
    new Object[]
    {"com.sun.jbi:ComponentName=sun-file-binding,ComponentType=Installed,ControlType=Custom,CustomControlName=Statistics,InstalledType=Binding,JbiName=server"});

    Mock mStatusProviderHelper = mock(StatusProviderHelper.class,
    new Class[] {String.class, ObjectName.class, MBeanServer.class},
    new Object[] {"A", on.proxy(), mbServer.proxy()});



    jbiContext.expects(atLeastOnce()).method("getLogger").with(eq(FileBindingLifeCycle.class.getName()),eq("com.sun.jbi.filebc.messages.Bundle")).will(returnValue(Logger.getLogger(FileBindingLifeCycle.class.getName(), "com.sun.jbi.filebc.messages.Bundle")));
    jbiContext.expects(atLeastOnce()).method("getLogger").with(eq("com.sun.jbi.filebc.FileBindingDeployer"), eq("com.sun.jbi.filebc.messages.Bundle")).will(returnValue(Logger.getLogger("com.sun.jbi.filebc.FileBindingDeployer", "com.sun.jbi.filebc.messages.Bundle")));
    jbiContext.expects(atLeastOnce()).method("getLogger").with(eq("com.sun.jbi.filebc.RuntimeConfiguration"), eq("com.sun.jbi.filebc.messages.Bundle")).will(returnValue(Logger.getLogger("com.sun.jbi.filebc.RuntimeConfiguration", "com.sun.jbi.filebc.messages.Bundle")));
    //jbiContext.expects(atLeastOnce()).method("getLogger").with(eq("com.sun.jbi.filebc.InboundMessageProcessor"), eq("com.sun.jbi.filebc.messages.Bundle")).will(returnValue(Logger.getLogger("com.sun.jbi.filebc.InboundMessageProcessor", "com.sun.jbi.filebc.messages.Bundle")));
    //jbiContext.expects(atLeastOnce()).method("getLogger").with(eq("com.sun.jbi.filebc.OutboundMessageProcessor"), eq("com.sun.jbi.filebc.messages.Bundle")).will(returnValue(Logger.getLogger("com.sun.jbi.filebc.OutboundMessageProcessor", "com.sun.jbi.filebc.messages.Bundle")));
    jbiContext.expects(atLeastOnce()).method("getMBeanServer").will(returnValue(mbServer.proxy()));
    jbiContext.expects(atLeastOnce()).method("getMBeanNames").will(returnValue(mBeanNames.proxy()));
    mbServer.expects(atLeastOnce()).method("isRegistered").will(returnValue(true));
    jbiContext.expects(atLeastOnce()).method("getComponentName").will(returnValue("someComponentName"));
    jbiContext.expects(atLeastOnce()).method("getWorkspaceRoot").will(returnValue("test/com/sun/jbi/filebc/testDir"));
    jbiContext.expects(atLeastOnce()).method("getDeliveryChannel").will(returnValue(deliveryChannel.proxy()));
    //deliveryChannel.expects(atLeastOnce()).method("accept").will(returnValue((MessageExchange) mock(MessageExchange.class).proxy()));
    jbiContext.expects(atLeastOnce()).method("getInstallRoot").will(returnValue("test/com/sun/jbi/filebc/testDir"));

    jbiContext.expects(atLeastOnce()).method("getLogger").with(eq(MessagingChannel.class.getName()), eq(null)).will(returnValue(Logger.getLogger(MessagingChannel.class.getName(), null)));
    jbiContext.expects(atLeastOnce()).method("activateEndpoint");
    //mBeanNames.expects(atLeastOnce()).method("createCustomComponentMBeanName").with(eq("Statistics")).will(returnValue(new ObjectName("com.sun.jbi:ComponentName=sun-file-binding,ComponentType=Installed,ControlType=Custom,CustomControlName=Statistics,InstalledType=Binding,JbiName=server")));
    mBeanNames.expects(atLeastOnce()).method("createCustomComponentMBeanName").will(returnValue(on.proxy()));
    mStatusProviderHelper.expects(atLeastOnce()).method("registerMBean");


    try {

    // instance.init((ComponentContext)jbiContext.proxy());
    System.out.println("Successfully tested init for the scenario where no exception is expected.");
    } catch (Exception e) {
    fail("Failed to test init due to: " + e.getMessage());
    }
    jbiContext.verify();

    // 2. testing the failure scenario
    jbiContext.expects(once()).method("getDeliveryChannel").will(throwException(new MessagingException("someException")));

    try {
    instance.init((ComponentContext)jbiContext.proxy());
    fail("Failed to test init when an exception should be caught - a MessagingException is raised for failure to get Delivery Channel.");
    } catch (Exception e) {
    System.out.println("Successfully tested init when an exception is raised.");
    }
    jbiContext.verify();
    }*/
    /**
     * Test of shutDown method, of class com.sun.jbi.filebc.FileBindingLifeCycle.
     */
//    public void testShutDown() throws Exception {
//        System.out.println("Testing shutDown");
//        
//        // 1. testing the success scenario
//        deliveryChannel.expects(once()).method("close");
//        try {
//            instance.shutDown();
//            System.out.println("Successfully tested shutDown");
//        } catch (Exception e) {
//            fail("Failed to test shutDown due to: " + e.getMessage());
//        }
//        
//        // 2. testing the failure scenario
//        deliveryChannel.expects(once()).method("close").will(throwException (new MessagingException("someException")));
//        try {
//            instance.shutDown();
//            fail("Failed to test shutDown when an exception should be caught - a MessagingException should be raised for failure to close Delivery Channel.");
//        } catch (Exception e) {
//            System.out.println("Successfully tested shutDown when an exception is raised.");
//        }
//    }
    /** 
     * Test of getServiceDescription method, of class com.sun.jbi.filebc.FileBindingLifeCycle.
     */
    public void testgetServiceDescription() throws Exception {
        System.out.println("Testing getServiceDescription");

        QName serviceName = new QName("testServiceName");
        String endpointName = "testEndpointName";
        HashMap serviceUnits = new HashMap();
        List endpoints = new ArrayList();
        Endpoint endpoint = new EndpointImpl();
        Document theDoc;

        Mock serviceUnit = mock(ServiceUnit.class);
        Mock serviceEndpoint = mock(ServiceEndpoint.class);
        Mock document = mock(Document.class);
        Mock deployer = mock(FileBindingDeployer.class,
                new Class[]{ComponentContext.class, FileBindingLifeCycle.class},
                new Object[]{(ComponentContext) jbiContext.proxy(), instance});

        theDoc = (Document) document.proxy();
        serviceEndpoint.expects(atLeastOnce()).method("getServiceName").will(returnValue(serviceName));
        serviceEndpoint.expects(atLeastOnce()).method("getEndpointName").will(returnValue(endpointName));

        // 1. testing the scenario where there is a match
        endpoint.setServiceName(serviceName);
        endpoint.setEndpointName(endpointName);
        endpoint.setServiceDescription(theDoc);
        endpoint.setEndpointType(Endpoint.EndpointType.OUTBOUND);
        endpoints.add(endpoint);
        serviceUnit.expects(atLeastOnce()).method("getEndpoints").will(returnValue(endpoints));
        serviceUnits.put("someKey", (ServiceUnit) serviceUnit.proxy());

        deployer.expects(atLeastOnce()).method("getServiceUnits").will(returnValue(serviceUnits));
        instance.setServiceUnitManager((FileBindingDeployer) deployer.proxy());

        Document result = instance.getServiceDescription((ServiceEndpoint) serviceEndpoint.proxy());
        assertEquals(theDoc, result);

        // 2. testing the scenario where there is no match
        serviceEndpoint.expects(atLeastOnce()).method("getServiceName").will(returnValue(serviceName));
        serviceEndpoint.expects(atLeastOnce()).method("getEndpointName").will(returnValue("noMatchingEndpoint"));
        result = instance.getServiceDescription((ServiceEndpoint) serviceEndpoint.proxy());
        assertNull(result);

    }
}
