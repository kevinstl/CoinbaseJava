package com.coinbase.java.client.spring;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  
  @Bean
  public HttpClient coinbaseApacheHttpClient(){
    HttpClient httpClient = new DefaultHttpClient();
    return httpClient;
  }
  
}
