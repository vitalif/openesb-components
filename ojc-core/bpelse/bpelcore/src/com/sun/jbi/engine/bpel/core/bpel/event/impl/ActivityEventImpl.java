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
 * @(#)$Id: ActivityEventImpl.java,v 1.4 2008/02/06 21:40:38 mei_wu Exp $
 *
 * Copyright 2004-2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * END_HEADER - DO NOT EDIT
 */

package com.sun.jbi.engine.bpel.core.bpel.event.impl;

import javax.xml.namespace.QName;

import com.sun.jbi.engine.bpel.core.bpel.event.ActivityEvent;

public class ActivityEventImpl extends BPELEventImpl implements ActivityEvent {
	
	private QName mBPELName;
	
	private String mBPId;
	
	private long mActivityId;
	
	private String mActivityName;
	
	private String mXpath;

	
	ActivityEventImpl(String engineId, QName name, String id, String eventId, EventType type, long activityId, String activityName, String xpath) {
		super(engineId, eventId, type);
		mBPELName = name;
		mBPId = id;		
		mActivityId = activityId;
		mActivityName = activityName;
		mXpath = xpath;
	}
	

	public long getActivityId() {
		// TODO Auto-generated method stub
		return mActivityId;
	}

	public String getActivityName() {
		// TODO Auto-generated method stub
		return mActivityName;
	}


	public String getActivityXpath() {
		// TODO Auto-generated method stub
		return mXpath;
	}


	public QName getBPELName() {
		// TODO Auto-generated method stub
		return mBPELName;
	}

	public String getInstanceId() {
		// TODO Auto-generated method stub
		return mBPId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer ();
		buffer.append("<<<<<<<<<<<ActivityEvent:");
		buffer.append(getEventType());
		buffer.append("   ");
		buffer.append(mActivityName);
		buffer.append("<<<<<<<<<<<\n");

		buffer.append("BPELName");
		buffer.append(mBPELName);		
		buffer.append("\n");

		buffer.append("ActivityId:");
		buffer.append(mActivityId);
		buffer.append("\n");
		
		buffer.append("ActivityName:");
		buffer.append(mActivityName);
		buffer.append("\n");
		
		buffer.append("XPath:");
		buffer.append(mXpath);
		buffer.append("\n");

		buffer.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");		
		return buffer.toString();
	}

}
