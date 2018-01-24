package org.rmbin.kafka.consumer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: KfkConsumer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2018
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: KfkConsumer.java 72642 2009-01-01 20:01:57Z ACHIEVO\louis.he $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jan 23, 2018		louis.he		Initial.
 *  
 * </pre>
 */
public class Consumer
{
	
	private static Properties props;
	
	private KafkaConsumer<String,String> consumer;
	
	static
	{
		props = new Properties();
		props.put("bootstrap.servers", "192.168.0.131:9092");
	    props.put("group.id", "mymsg");
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	}
	
	private Consumer(){}
	
	static class Holder
	{
		private Consumer instance;
		
		public Holder()
		{
			instance = new Consumer();
			instance.consumer = new KafkaConsumer<String,String>(props);
			
		}
	}
	
	public static Consumer getInstance()
	{
		return new Holder().instance;
	}
	
	public void consumeMsg(String topic)
	{
		consumer.subscribe(Arrays.asList(topic));
		while(true)
		{
			ConsumerRecords<String,String> msgs = consumer.poll(500);
			Iterable<ConsumerRecord<String,String>> ites= msgs.records(topic);
			Iterator<ConsumerRecord<String,String>> ite = ites.iterator();
			while(ite.hasNext())
			{
				ConsumerRecord<String,String> msg = ite.next();
				System.err.print("This message: "+msg.value() + " comes from "+topic);
			}
		}
	}

}

/*
*$Log: av-env.bat,v $
*/