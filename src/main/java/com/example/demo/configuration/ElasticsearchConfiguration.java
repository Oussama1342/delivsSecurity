
  package com.example.demo.configuration;
  
  import java.net.InetAddress; import java.net.InetSocketAddress; import
  java.net.UnknownHostException;
  
  import javax.annotation.Resource; import
  javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder.
  NodeBuilderCustomizableContext;
  
  import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import
  org.elasticsearch.client.transport.TransportClient; import
  org.elasticsearch.common.settings.Settings; import
  org.elasticsearch.common.transport.TransportAddress; import
  org.elasticsearch.env.Environment; import
  org.elasticsearch.transport.client.PreBuiltTransportClient; import
  org.springframework.beans.factory.annotation.Value; import
  org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration; import
  org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import
  org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import
  org.springframework.data.elasticsearch.core.ElasticsearchTemplate; import
  org.springframework.data.elasticsearch.repository.config.
  EnableElasticsearchRepositories;
  
  
  
  
  
  // @PropertySource(value = "classpath:/application.properties")
  @Configuration
  @EnableElasticsearchRepositories(basePackages = "com.example.demo.DAO")
  public class ElasticsearchConfiguration {
  
  
  
  //@Value("${elasticsearch.host}") private String EsHost;
  
 //@Value("${elasticsearch.port}") private int EsPort;
  
  @Bean
  public RestHighLevelClient client() {
      ClientConfiguration clientConfiguration 
          = ClientConfiguration.builder()
              .connectedTo("elasticsearch:9200")
              .build();

      return RestClients.create(clientConfiguration).rest();
  }
  
  
  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
      return new ElasticsearchRestTemplate(client());
  }
  
  
  
	/*
	 * @Bean public Client client() throws UnknownHostException { Settings settings
	 * = Settings.builder() .put("client.transport.sniff", true)
	 * .put("cluster.name", "elasticsearch").build();
	 * 
	 * @SuppressWarnings("resource") TransportClient client = new
	 * PreBuiltTransportClient(settings) .addTransportAddress(new
	 * TransportAddress(InetAddress.getByName(EsHost), EsPort)); return client; }
	 */
  
	/*
	 * @Bean public ElasticsearchOperations elasticsearchTemplate() throws Exception
	 * { return new ElasticsearchTemplate(client()); }
	 */
  

  
  }
 