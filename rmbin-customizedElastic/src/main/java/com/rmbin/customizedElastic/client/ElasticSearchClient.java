package com.rmbin.customizedElastic.client;
import java.net.InetAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchClient implements FactoryBean<TransportClient>,InitializingBean,DisposableBean{
	
	private static final Log logger = LogFactory.getLog(ElasticSearchClient.class);
	
	@Value("${my_elasticsearch.clustername}")
	private String cluserName;
	
	@Value("${my_elasticsearch.port}")
	private int port;
	
	@Value("${my_elasticsearch.hostName}")
	private String hostName;
	
	private TransportClient transClient;

	@Override
	public void destroy() throws Exception {
		if(transClient != null)
		{
			transClient.close();
		}
	}

	@Override
	public TransportClient getObject() throws Exception {
		// TODO Auto-generated method stub
		return transClient;
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return TransportClient.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterPropertiesSet(){
		try
		{
			buildClient();
		}
		catch(Exception ex)
		{
			logger.error(ex);
		}
	}
	
	protected void buildClient() throws Exception
	{
		Settings settings = Settings.builder().put("cluster.name", cluserName).put("client.transport.sniff",true).build();
		PreBuiltTransportClient preBuiltTransportClient  = new PreBuiltTransportClient(settings);
		transClient = preBuiltTransportClient.addTransportAddress(new TransportAddress(InetAddress.getByName(hostName),port));
		
	}

}
