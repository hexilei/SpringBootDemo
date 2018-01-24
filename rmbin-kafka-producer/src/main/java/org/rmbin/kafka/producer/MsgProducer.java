package org.rmbin.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: Producer.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2018
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Producer.java 72642 2009-01-01 20:01:57Z ACHIEVO\louis.he $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jan 23, 2018		louis.he		Initial.
 *  
 * </pre>
 */
public class MsgProducer
{
	private String topic;

	private static Properties props;
	static
	{
		props = new Properties();
		props.put("bootstrap.servers", "192.168.0.131:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	}
	
	private Producer<String,String> kfkProducer;
	
	private MsgProducer(){}
	
	static class Holder
	{
		private MsgProducer producer;
		public Holder()
		{
			producer = new MsgProducer();
			producer.kfkProducer = new KafkaProducer<String, String>(props);
		}
	}
	
	public static MsgProducer getInstance()
	{
		return new Holder().producer;
	}
	
	public String getTopic()
	{
		return topic;
	}

	public MsgProducer setTopic(String topic)
	{
		this.topic = topic;
		return this;
	}

	public void sendMsg(String msg)
	{
		this.kfkProducer.send(new ProducerRecord<String, String>(getTopic(), msg));
	}
}

/*
*$Log: av-env.bat,v $
*/