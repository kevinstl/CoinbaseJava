package com.coinbase.java.client.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coinbase.java.client.CoinbaseClient;

@Configuration
public class SpringConfigTests {
  
  @Bean
  public CoinbaseClient coinbaseClient(){
    CoinbaseClient coinbaseClient = new CoinbaseClient();
    return coinbaseClient;
  }

}
