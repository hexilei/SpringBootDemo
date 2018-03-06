package org.rmbin.kafka.stream;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;

/**
 * <pre>
 * 
 *  Accela Automation
 *  File: KfkStream.java
 * 
 *  Accela, Inc.
 *  Copyright (C): 2018
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: KfkStream.java 72642 2009-01-01 20:01:57Z ACHIEVO\louis.he $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jan 24, 2018		louis.he		Initial.
 *  
 * </pre>
 */
public class KfkStream
{
	
	private static Map<String,Object> props;
	
	private KafkaStreams streams;
	
	static
	{
		props = new HashMap<String,Object>();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "my-stream-processing-application");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
	}
	
	private KfkStream(){}
	
	class Holder
	{
		
		public Holder()
		{
			StreamsBuilder builder = new StreamsBuilder();
		}
	}

}

/*
*$Log: av-env.bat,v $
*/