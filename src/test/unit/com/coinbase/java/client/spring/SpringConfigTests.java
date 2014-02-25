package com.coinbase.java.client.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coinbase.java.client.CoinbaseClient;
import com.coinbase.java.client.CoinbaseClient;

@Configuration
public class SpringConfigTests {
  
  private @Value("${apiKey}") String apiKey;
  
  @Bean
  public CoinbaseClient coinbaseClient(){
    CoinbaseClient coinbaseClient = new CoinbaseClient(apiKey);
    return coinbaseClient;
  }

}
