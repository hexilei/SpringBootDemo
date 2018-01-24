package org.rmbin.kafka;

import static org.junit.Assert.*;

import org.junit.Test;
import org.rmbin.kafka.consumer.Consumer;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ConsumerTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2018
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ConsumerTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\louis.he $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jan 24, 2018		louis.he		Initial.
 *  
 * </pre>
 */
public class ConsumerTest
{

	@Test
	public void receiveMsg() throws InterruptedException
	{
		Consumer.getInstance().consumeMsg("mytest-topic");
		Thread.sleep(100000);
	}

}

/*
*$Log: av-env.bat,v $
*/