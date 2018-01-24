package org.rmbin.kafka.producer;

import net.bytebuddy.asm.Advice.This;

import org.junit.Test;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: ProducerTest.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2018
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ProducerTest.java 72642 2009-01-01 20:01:57Z ACHIEVO\louis.he $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jan 24, 2018		louis.he		Initial.
 *  
 * </pre>
 */
public class ProducerTest
{
	@Test
	public void sendMsg() throws InterruptedException
	{
		MsgProducer.getInstance().setTopic("mytest-topic").sendMsg("This is the first message from topic mytest-topic.");
		Thread.sleep(10000);
	}

}

/*
*$Log: av-env.bat,v $
*/